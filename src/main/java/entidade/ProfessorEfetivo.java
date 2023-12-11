package entidade;
public class ProfessorEfetivo extends Professor{
    protected int experiencia_empresarial;
    protected boolean envolvido_pesquisa;

    public ProfessorEfetivo(int experiencia_empresarial, boolean envolvido_pesquisa, String nome, String cpf, String titulação, String email, char sexo) {
        super(nome, cpf, titulação, email, sexo);
        this.experiencia_empresarial = experiencia_empresarial;
        this.envolvido_pesquisa = envolvido_pesquisa;
    }

    public void setExperiencia_empresarial(int experiencia_empresarial) {
        this.experiencia_empresarial = experiencia_empresarial;
    }

    public void setEnvolvido_pesquisa(boolean envolvido_pesquisa) {
        this.envolvido_pesquisa = envolvido_pesquisa;
    }

    public int getExperiencia_empresarial() {
        return experiencia_empresarial;
    }

    public boolean isEnvolvido_pesquisa() {
        return envolvido_pesquisa;
    }
}
