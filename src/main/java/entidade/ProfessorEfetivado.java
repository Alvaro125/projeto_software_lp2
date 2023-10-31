package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;

public class ProfessorEfetivado {

    protected String nome;
    protected String cpf;
    protected String titulação;
    protected String email;

    public ProfessorEfetivado(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public ProfessorEfetivado(String nome, String cpf, String titulação, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.titulação = titulação;
        this.email = email;
    }

    public static ProfessorEfetivado buscarProfessorEfetivado(String cpf) {

        String sql = "SELECT * FROM Professores WHERE CPF = ?";

        ResultSet lista_resultados = null;

        ProfessorEfetivado professorEfetivado = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, cpf);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                professorEfetivado = new ProfessorEfetivado(
                        lista_resultados.getString("Nome"),
                        cpf,
                        lista_resultados.getString("Titulação"),
                        lista_resultados.getString("Email")
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            professorEfetivado = null;
        }
        return professorEfetivado;
    }

    public static String inserirProfessorEfetivo(ProfessorEfetivado professor) {
        try {
            String sql = "INSERT INTO Professores (Nome,CPF,Email,Titulação)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, professor.getNome());
            comando.setString(2, professor.getCpf());
            comando.setString(3, professor.getEmail());
            comando.setString(4, professor.getTitulação());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção do Professor no DB";
        }
    }

    public static String alterarProfessorEfetivo(ProfessorEfetivado professor) {
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

    public static ProfessorEfetivado[] getVisões() {
        String sql = "SELECT Nome,CPF FROM Professores";
        ResultSet lista_resultados = null;
        ArrayList<ProfessorEfetivado> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                String cpf = lista_resultados.getString("CPF");
                visões.add(new ProfessorEfetivado(nome, cpf));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new ProfessorEfetivado[visões.size()]);
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

    public String toString() {
        return String.format("%s [%s]", cpf, nome);
    }

}
