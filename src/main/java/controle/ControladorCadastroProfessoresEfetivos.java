package controle;

import entidade.ProfessorEfetivado;
import interfaces.JanelaCadastroProfessoresEfetivados;


public class ControladorCadastroProfessoresEfetivos {

    public ControladorCadastroProfessoresEfetivos() {
        new JanelaCadastroProfessoresEfetivados(this).setVisible(true);
    }
    
    public static String inserirProfessorEfetivo(ProfessorEfetivado professor){
        ProfessorEfetivado professorEfetivado = ProfessorEfetivado.buscarProfessorEfetivado(professor.getCpf());
        if (professorEfetivado == null) return ProfessorEfetivado.inserirProfessorEfetivo(professor);
        else return "CPF do Professor já Cadastrado";
    }
    
    public static String alterarProfessorEfetivo(ProfessorEfetivado professor){
        ProfessorEfetivado professorEfetivado = ProfessorEfetivado.buscarProfessorEfetivado(professor.getCpf());
        if (professorEfetivado != null) return ProfessorEfetivado.alterarProfessorEfetivo(professor);
        else return "CPF do Professor não Cadastrado";
    }
    
    public static String removerProfessorEfetivo(String cpf){
        ProfessorEfetivado professorEfetivado = ProfessorEfetivado.buscarProfessorEfetivado(cpf);
        if (professorEfetivado != null) return ProfessorEfetivado.removerProfessorEfetivo(cpf);
        else return "CPF do Professor não Cadastrado";
    }
}
