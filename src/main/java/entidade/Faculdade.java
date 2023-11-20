package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;

public class Faculdade {
    public enum ÁreaConhecimento{
        Ciências_Exatas_e_da_Terra,
        Ciências_Biológicas,
        Engenharias,
        Ciências_da_Saúde,
        Ciências_Agrárias,
        Linguística_Letras_e_Artes,
        Ciências_Sociais_Aplicadas,
        Ciências_Humanas
    }
    
    protected int sequencial;
    protected String sigla;
    protected String nomeCompleto;
    protected ÁreaConhecimento áreaConhecimento;
    protected int anoCriação;

    public Faculdade(int sequencial, String sigla, String nomeCompleto, ÁreaConhecimento áreaConhecimento, int anoCriação) {
        this.sequencial = sequencial;
        this.sigla = sigla;
        this.nomeCompleto = nomeCompleto;
        this.áreaConhecimento = áreaConhecimento;
        this.anoCriação = anoCriação;
    }
    
    public Faculdade(String sigla, String nomeCompleto, ÁreaConhecimento áreaConhecimento, int anoCriação) {
        this.sigla = sigla;
        this.nomeCompleto = nomeCompleto;
        this.áreaConhecimento = áreaConhecimento;
        this.anoCriação = anoCriação;
    }
    
    public Faculdade(int sequencial, String sigla, String nomeCompleto) {
        this.sequencial = sequencial;
        this.sigla = sigla;
        this.nomeCompleto = nomeCompleto;
    }

    public static Faculdade[] getVisões() {
        String sql = "SELECT Sequencial,Sigla,NomeCompleto FROM Faculdades";
        ResultSet lista_resultados = null;
        ArrayList<Faculdade> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nomeCompleto = lista_resultados.getString("NomeCompleto");
                String sigla = lista_resultados.getString("Sigla");
                int sequencial = lista_resultados.getInt("Sequencial");
                visões.add(new Faculdade(sequencial, sigla, nomeCompleto));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Faculdade[visões.size()]);
    }
    
    public static Faculdade buscarFaculdade(int sequencial) {

        String sql = "SELECT * FROM Faculdades WHERE Sequencial = ?";

        ResultSet lista_resultados = null;

        Faculdade faculdade = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                faculdade = new Faculdade(
                        sequencial,
                        lista_resultados.getString("Sigla"),
                        lista_resultados.getString("NomeCompleto"),
                        ÁreaConhecimento.values()[lista_resultados.getInt("ÁreaConhecimento")],
                        lista_resultados.getInt("AnoCriação")
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            faculdade = null;
        }
        return faculdade;
    }

    public static String inserirFaculdade(Faculdade faculdade) {
        try {
            String sql = "INSERT INTO Faculdades (Sigla,NomeCompleto,ÁreaConhecimento,AnoCriação)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, faculdade.getSigla());
            comando.setString(2, faculdade.getNomeCompleto());
            comando.setInt(3,faculdade.getÁreaConhecimento().ordinal());
            comando.setInt(4, faculdade.getAnoCriação());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção da Faculdade no DB";
        }
    }

    public static boolean existeFaculdadeMesmosAtributos(Faculdade faculdade) {
        String sql = "SELECT COUNT(Sigla) FROM Faculdades WHERE Sigla = ? AND NomeCompleto = ? AND ÁreaConhecimento = ? AND AnoCriação = ?";
        ResultSet lista_resultados = null;
        int n_faculdades_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, faculdade.getSigla());
            comando.setString(2, faculdade.getNomeCompleto());
            comando.setInt(3,faculdade.getÁreaConhecimento().ordinal());
            comando.setInt(4, faculdade.getAnoCriação());
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                n_faculdades_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (n_faculdades_mesmos_atributos>0) return true;
        else return false;
    }

    public static String removerFaculdade(int sequencial) {
        try {
            String sql = "DELETE FROM Faculdades WHERE Sequencial = ?";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção da Faculdade no DB";
        }
    }

    public static String alterarFaculdade(Faculdade faculdade) {
        try {
            String sql = "UPDATE Faculdades SET AnoCriação = ?, NomeCompleto = ? ,ÁreaConhecimento = ?, Sigla = ?"
                    + " WHERE Sequencial = ?";
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, faculdade.getAnoCriação());
            comando.setString(2, faculdade.getNomeCompleto());
            comando.setInt(3,faculdade.getÁreaConhecimento().ordinal());
            comando.setString(4, faculdade.getSigla());
            comando.setInt(5, faculdade.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração da Faculdade no DB";
        }
    }

    public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial) FROM Faculdades";
        ResultSet lista_resultados = null;
        int sequencial = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return sequencial;
    }

    public Faculdade getVisão(){
        return new Faculdade(sequencial,sigla, nomeCompleto);
    }

    public String getSigla() {
        return sigla;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public ÁreaConhecimento getÁreaConhecimento() {
        return áreaConhecimento;
    }

    public int getAnoCriação() {
        return anoCriação;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setÁreaConhecimento(ÁreaConhecimento áreaConhecimento) {
        this.áreaConhecimento = áreaConhecimento;
    }

    public void setAnoCriação(int anoCriação) {
        this.anoCriação = anoCriação;
    }

    @Override
    public String toString() {
        return sequencial+" - ["+sigla+"] "+nomeCompleto;
    }

    
}
