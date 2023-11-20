package controle;

import entidade.Faculdade;
import interfaces.JanelaCadastroFaculdades;


public class ControladorCadastroFaculdades {

    public ControladorCadastroFaculdades() {
        new JanelaCadastroFaculdades(this).setVisible(true);
    }
    
    public static String inserirFaculdade(Faculdade faculdade){
        if (!Faculdade.existeFaculdadeMesmosAtributos(faculdade)) return Faculdade.inserirFaculdade(faculdade);
        else return "Já existe uma Faculdade com os mesmos atributos";
    }
    
    public static String alterarFaculdade(Faculdade faculdade){
        Faculdade faculdade1 = Faculdade.buscarFaculdade(faculdade.getSequencial());
        if (faculdade1 != null) return Faculdade.alterarFaculdade(faculdade);
        else return "Sigla da Faculdade não Cadastrada";
    }
    
    public static String removerFaculdade(int sequencial){
        Faculdade faculdade1 = Faculdade.buscarFaculdade(sequencial);
        if (faculdade1 != null) return Faculdade.removerFaculdade(sequencial);
        else return "Sigla da Faculdade não Cadastrada";
    }
}
