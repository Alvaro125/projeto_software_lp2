package entidade;

public class ProfessorSubstituto extends Professor{
    protected int horas;
    protected boolean experiencia;

    public ProfessorSubstituto(int horas, boolean experiencia, String nome, String cpf, String titulação, String email, char sexo) {
        super(nome, cpf, titulação, email, sexo);
        this.horas = horas;
        this.experiencia = experiencia;
    }

    public int getHoras() {
        return horas;
    }

    public boolean getExperiencia(){
        return experiencia;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isExperiencia() {
        return experiencia;
    }
}
