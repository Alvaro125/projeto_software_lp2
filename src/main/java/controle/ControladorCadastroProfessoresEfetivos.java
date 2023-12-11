package controle;

import entidade.Professor;
import interfaces.JanelaCadastroProfessores;
import interfaces.PainelProfessorConvidado;


public class ControladorCadastroProfessoresEfetivos {

    public ControladorCadastroProfessoresEfetivos() {
        new JanelaCadastroProfessores(this).setVisible(true);
    }
    
    public static String inserirProfessor(Professor professor){
        Professor professorEfetivado = Professor.buscarProfessor(professor.getCpf());
        if (professorEfetivado == null) return Professor.inserirProfessor(professor);
        else return "CPF do Professor já Cadastrado";
    }
    
    public static String alterarProfessorEfetivo(Professor professor){
        Professor professorEfetivado = Professor.buscarProfessor(professor.getCpf());
        if (professorEfetivado != null) return Professor.alterarProfessorEfetivo(professor);
        else return "CPF do Professor não Cadastrado";
    }
    
    public static String removerProfessorEfetivo(String cpf){
        Professor professorEfetivado = Professor.buscarProfessor(cpf);
        if (professorEfetivado != null) return Professor.removerProfessorEfetivo(cpf);
        else return "CPF do Professor não Cadastrado";
    }
}
