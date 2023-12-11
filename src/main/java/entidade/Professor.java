package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;

public class Professor {
    

    protected String nome;
    protected String cpf;
    protected String titulação;
    protected String email;
    protected char sexo;

    public Professor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Professor(String nome, String cpf, String titulação, String email, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.titulação = titulação;
        this.email = email;
        this.sexo = sexo;
    }
    

    public static Professor buscarProfessor(String cpf) {

        String sql = null;
        ResultSet lista_resultados = null;
        sql = "SELECT * FROM Professores WHERE CPF = ?";
        String nome = null;
        String titulação = null;
        String email = null;
        char sexo = 'X';

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, cpf);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                nome = lista_resultados.getString("Nome");
                titulação = lista_resultados.getString("Titulação");
                email = lista_resultados.getString("Email");
                sexo = lista_resultados.getString("Sexo").charAt(0);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }
        if (nome==null) return null;
        sql = "SELECT Ministra,Universidade_origem FROM professoresconvidados WHERE CPF=?";
        lista_resultados = null;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, cpf);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new ProfessorConvidado(
                        ProfessorConvidado.Ministra.values()[lista_resultados.getInt("Ministra")],
                        lista_resultados.getString("Universidade_origem"),
                        nome, cpf, titulação, email, sexo
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace(); }
        return null;
    }

    public static String inserirProfessor(Professor professor) {
        String sql = "INSERT INTO Professores (Nome,CPF,Email,Titulação,Sexo)"
            + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, professor.getNome());
            comando.setString(2, professor.getCpf());
            comando.setString(3, professor.getEmail());
            comando.setString(4, professor.getTitulação());
            comando.setString(5, String.valueOf(professor.getSexo()));

            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção do Professor no DB";
        }

        String cpf = professor.getCpf();
        if(professor instanceof ProfessorConvidado){
            ProfessorConvidado professor_convidado = (ProfessorConvidado) professor;
            sql = "INSERT INTO Professoresconvidados (Ministra,Universidade_origem,CPF)"
                + " VALUES (?,?,?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, professor_convidado.getMinistra().ordinal());
                comando.setString(2, professor_convidado.getUniversidade_origem());
                comando.setString(3, professor_convidado.getCpf());

                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Professor no DB";
            }
        }
        return null;
    }

    public static String alterarProfessorEfetivo(Professor professor) {
        try {
            String sql = "UPDATE Professores SET Nome = ?, Email = ? ,Titulação = ?"
                    + " WHERE CPF = ?";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, professor.getNome());
            comando.setString(2, professor.getEmail());
            comando.setString(3, professor.getTitulação());
            comando.setString(4, professor.getCpf());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração do Professor no DB";
        }
    }

    public static String removerProfessorEfetivo(String cpf) {
        try {
            String sql = "DELETE FROM Professores WHERE CPF = ?";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, cpf);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção do Professor no DB";
        }
    }

    public static Professor[] getVisões() {
        String sql = "SELECT Nome,CPF FROM Professores";
        ResultSet lista_resultados = null;
        ArrayList<Professor> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String cpf = lista_resultados.getString("CPF");
                visões.add(buscarProfessor(cpf));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Professor[visões.size()]);
    }
    
    public Professor getVisão(){
        return new Professor(nome, cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTitulação() {
        return titulação;
    }

    public char getSexo() {
        return sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTitulação(String titulação) {
        this.titulação = titulação;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String toString() {
        return cpf+" ["+nome+"]";
    }

}
