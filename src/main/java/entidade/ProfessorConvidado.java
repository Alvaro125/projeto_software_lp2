package entidade;

public class ProfessorConvidado extends Professor{

    public enum Ministra {
        aulas, palestras, workshops, projetos, orientação
    }
    
    protected Ministra ministra;
    protected String universidade_origem;

    public ProfessorConvidado(Ministra ministra, String universidade_origem, String nome, String cpf, String titulação, String email, char sexo) {
        super(nome, cpf, titulação, email, sexo);
        this.ministra = ministra;
        this.universidade_origem = universidade_origem;
    }

    public Ministra getMinistra() {
        return ministra;
    }

    public void setMinistra(Ministra ministra) {
        this.ministra = ministra;
    }

    public String getUniversidade_origem() {
        return universidade_origem;
    }

    public void setUniversidade_origem(String universidade_origem) {
        this.universidade_origem = universidade_origem;
    }
    
    public String toString() {
        return cpf+" ["+nome+"]-Conviado";
    }
}
