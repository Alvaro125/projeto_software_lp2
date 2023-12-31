package interfaces;

import controle.ControladorCadastroProfessoresEfetivos;
import entidade.Professor;
import entidade.ProfessorConvidado;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class JanelaCadastroProfessores extends javax.swing.JFrame {

    ControladorCadastroProfessoresEfetivos controlador;
    Professor[] professores_cadastrados;
    PainelProfessorConvidado professor_convidadoPainel;
    PainelProfessorEfetivo professor_efetivoPainel;
    PainelProfessorSubstituto professor_substitutoPainel;


    public JanelaCadastroProfessores(ControladorCadastroProfessoresEfetivos controlador) {
    this.controlador = controlador;
    professores_cadastrados = Professor.getVisões();
    initComponents();
    professor_efetivoPainel = new PainelProfessorEfetivo();
    professor_convidadoPainel = new PainelProfessorConvidado();
    professor_substitutoPainel = new PainelProfessorSubstituto();
    especialização_professorTabbedPane.add("Professor Efetivo", professor_efetivoPainel);
    especialização_professorTabbedPane.add("Professor Substituto", professor_substitutoPainel);
    especialização_professorTabbedPane.add("Professor Convidado", professor_convidadoPainel);
    limparCampos();
}

    private void limparCampos(){
        nomeTextField.setText("");
        cpfTextField.setText("");
        emailTextField.setText("");
        titulaçãoTextField.setText("");
        professor_convidadoPainel.limparCampos();
    }
    
    private Professor obterProfessorInformado(){
        String cpf = cpfTextField.getText();
        if (cpf.isEmpty()) return null;
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) return null;
        String titulação = titulaçãoTextField.getText();
        if (titulação.isEmpty()) return null;
        String email = emailTextField.getText();
        if (email.isEmpty()) return null;
        char sexo = 'X';
        if (sexoButtonGroup.getSelection() != null)
            sexo = (char) sexoButtonGroup.getSelection().getMnemonic();
        else return null;
        
        Professor professor = null;
        int indice_aba_selecionada = especialização_professorTabbedPane.getSelectedIndex();
        System.out.println(indice_aba_selecionada);
        switch (indice_aba_selecionada) {
            case 2:
                ProfessorConvidado.Ministra ministra = ProfessorConvidado.Ministra
                        .valueOf(professor_convidadoPainel.getMinistra());
                String universidade_origem = professor_convidadoPainel.getUniversidade_origem();
                professor = new ProfessorConvidado(
                        ministra, universidade_origem, nome, cpf, titulação, email, sexo);
                break;
        }
        
        return professor;
    }

    private JanelaCadastroProfessores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        sexoButtonGroup = new javax.swing.ButtonGroup();
        professores_cadastradosLabel = new javax.swing.JLabel();
        professores_cadastradosComboBox = new javax.swing.JComboBox<>();
        nomeTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        cpfTextField = new javax.swing.JTextField();
        titulaçãoLabel = new javax.swing.JLabel();
        titulaçãoTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        sexoLabel = new javax.swing.JLabel();
        sexoPanel = new javax.swing.JPanel();
        masculinoRadioButton = new javax.swing.JRadioButton();
        femininoRadioButton = new javax.swing.JRadioButton();
        especialização_professorTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Professores Efetivos");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        professores_cadastradosLabel.setText("Professores Cadastrados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(19, 10, 0, 0);
        getContentPane().add(professores_cadastradosLabel, gridBagConstraints);

        professores_cadastradosComboBox.setModel(new DefaultComboBoxModel(professores_cadastrados));
        professores_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professores_cadastradosComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 0, 0);
        getContentPane().add(professores_cadastradosComboBox, gridBagConstraints);

        nomeTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 332;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 0, 0, 6);
        getContentPane().add(nomeTextField, gridBagConstraints);

        nomeLabel.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 39, 0, 0);
        getContentPane().add(nomeLabel, gridBagConstraints);

        cpfLabel.setText("CPF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 39, 0, 0);
        getContentPane().add(cpfLabel, gridBagConstraints);

        cpfTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 133;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        getContentPane().add(cpfTextField, gridBagConstraints);

        titulaçãoLabel.setText("Titulação");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 38, 0, 0);
        getContentPane().add(titulaçãoLabel, gridBagConstraints);

        titulaçãoTextField.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        getContentPane().add(titulaçãoTextField, gridBagConstraints);

        emailTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 336;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 6);
        getContentPane().add(emailTextField, gridBagConstraints);

        emailLabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 39, 0, 0);
        getContentPane().add(emailLabel, gridBagConstraints);

        comandosPanel.setMinimumSize(new java.awt.Dimension(200, 35));
        comandosPanel.setPreferredSize(new java.awt.Dimension(200, 35));
        comandosPanel.setLayout(new java.awt.GridBagLayout());

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirProfessorEfetivado(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        comandosPanel.add(inserirButton, gridBagConstraints);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparPainel(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comandosPanel.add(limparButton, gridBagConstraints);

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarProfessorEfetivado(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        comandosPanel.add(consultarButton, gridBagConstraints);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarProfessorEfetivado(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comandosPanel.add(alterarButton, gridBagConstraints);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerProfessorEfetivado(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        comandosPanel.add(removerButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 14, 45, 6);
        getContentPane().add(comandosPanel, gridBagConstraints);

        sexoLabel.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 32);
        getContentPane().add(sexoLabel, gridBagConstraints);

        sexoPanel.setLayout(new java.awt.GridBagLayout());

        sexoButtonGroup.add(masculinoRadioButton);
        masculinoRadioButton.setMnemonic('M');
        masculinoRadioButton.setText("masculino");
        masculinoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculinoRadioButtonActionPerformed(evt);
            }
        });
        sexoPanel.add(masculinoRadioButton, new java.awt.GridBagConstraints());

        sexoButtonGroup.add(femininoRadioButton);
        femininoRadioButton.setMnemonic('F');
        femininoRadioButton.setText("feminino");
        femininoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femininoRadioButtonActionPerformed(evt);
            }
        });
        sexoPanel.add(femininoRadioButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(sexoPanel, gridBagConstraints);

        especialização_professorTabbedPane.setMinimumSize(new java.awt.Dimension(400, 200));
        especialização_professorTabbedPane.setPreferredSize(new java.awt.Dimension(600, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(especialização_professorTabbedPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirProfessorEfetivado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirProfessorEfetivado
        Professor professor = obterProfessorInformado();
        String mensagem_erro = null;
        if (professor != null) mensagem_erro = controlador.inserirProfessor(professor);
        else mensagem_erro = "Algum atributo do professor não foi informado";
        if (mensagem_erro == null) {
            Professor visão = professor.getVisão();
            professores_cadastradosComboBox.addItem(visão);
            professores_cadastradosComboBox.setSelectedItem(visão);
//            informarSucesso("Inserção bem sucedida");
        }
        else informarErro(mensagem_erro);
    }//GEN-LAST:event_inserirProfessorEfetivado

    private void consultarProfessorEfetivado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarProfessorEfetivado
        Professor visão =(Professor) professores_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;
        Professor professorEfetivado = null;
        if (visão != null){
            professorEfetivado = Professor.buscarProfessor(visão.getCpf());
            if (professorEfetivado == null) mensagem_erro="Professor não Cadastrado";
        } else mensagem_erro = "Nenhum Professor Selecionado";
        if (mensagem_erro == null){
            nomeTextField.setText(professorEfetivado.getNome());
            emailTextField.setText(professorEfetivado.getEmail());
            cpfTextField.setText(professorEfetivado.getCpf());
            titulaçãoTextField.setText(professorEfetivado.getTitulação());
        } else informarErro(mensagem_erro);
    }//GEN-LAST:event_consultarProfessorEfetivado

    private Professor getVisãoAlterada(String cpf) {
        for (Professor visão : professores_cadastrados) {
            if(visão.getCpf().equals(cpf)) return visão;
        }
        return null;
    }

    private void selecionarSexoRadioButton(char sexo){
        switch (sexo) {
            case 'F':femininoRadioButton.setSelected(true);break;
            case 'M':masculinoRadioButton.setSelected(true);break;
        }
    }

    private void limparPainel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparPainel
        limparCampos();
    }//GEN-LAST:event_limparPainel

    private void alterarProfessorEfetivado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarProfessorEfetivado
        Professor professorEfetivado = obterProfessorInformado();
        String mensagem_erro = null;
        if (professorEfetivado != null) mensagem_erro = controlador.alterarProfessorEfetivo(professorEfetivado);
        else mensagem_erro = "CPF do professor não informado";
        if (mensagem_erro == null){
            Professor visão =getVisãoAlterada(professorEfetivado.getCpf());
            if(visão != null){
                visão.setNome(professorEfetivado.getNome());
                professores_cadastradosComboBox.updateUI();
                professores_cadastradosComboBox.setSelectedItem(visão);
            }
//            informarSucesso("Alteração bem sucedida");
        } 
        else informarErro(mensagem_erro);
    }//GEN-LAST:event_alterarProfessorEfetivado

    private void removerProfessorEfetivado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerProfessorEfetivado
        Professor visão =(Professor) professores_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;
        if (visão != null) mensagem_erro = controlador.removerProfessorEfetivo(visão.getCpf());
        else mensagem_erro = "Nenhum professor selecionado";
        if (mensagem_erro == null){
            professores_cadastradosComboBox.removeItem(visão);
            if (professores_cadastrados.length >= 1) professores_cadastradosComboBox.setSelectedIndex(0);
            else professores_cadastradosComboBox.setSelectedIndex(-1);
//            informarSucesso("Remoção bem sucedida");
        }
        else informarErro(mensagem_erro);
    }//GEN-LAST:event_removerProfessorEfetivado

    private void professores_cadastradosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professores_cadastradosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_professores_cadastradosComboBoxActionPerformed

    private void masculinoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculinoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masculinoRadioButtonActionPerformed

    private void femininoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femininoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femininoRadioButtonActionPerformed

    private void informarErro(String mensagem){
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastroProfessores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTabbedPane especialização_professorTabbedPane;
    private javax.swing.JRadioButton femininoRadioButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JButton limparButton;
    private javax.swing.JRadioButton masculinoRadioButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JComboBox<entidade.Professor> professores_cadastradosComboBox;
    private javax.swing.JLabel professores_cadastradosLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.ButtonGroup sexoButtonGroup;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JPanel sexoPanel;
    private javax.swing.JLabel titulaçãoLabel;
    private javax.swing.JTextField titulaçãoTextField;
    // End of variables declaration//GEN-END:variables

}
