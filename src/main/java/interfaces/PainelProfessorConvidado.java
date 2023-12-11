/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import entidade.ProfessorConvidado.Ministra;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 04950754181
 */
public class PainelProfessorConvidado extends javax.swing.JPanel {

    /**
     * Creates new form PainelProfessorEfetivo
     */
    public PainelProfessorConvidado() {
        initComponents();
    }

    public String getMinistra(){
        String ministra = ministraComboBox.getSelectedItem().toString();
        if(ministra.isEmpty()) return null;
        else return ministra;
    }
    public void setMinistra(Ministra ministra){
        ministraComboBox.setSelectedItem(ministra);
    }

    public String getUniversidade_origem(){
        String universidade_origem = universidade_origemTextField.getText();
        if(universidade_origem.isEmpty()) return null;
        else return universidade_origem;
    }
    public void setUniversidade_origem(String universidade_origem){
        universidade_origemTextField.setText(universidade_origem);
    }
    
    public void limparCampos(){
        universidade_origemTextField.setText("");
        ministraComboBox.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        universidade_origemLabel = new javax.swing.JLabel();
        universidade_origemTextField = new javax.swing.JTextField();
        ministraComboBox = new javax.swing.JComboBox<>();
        ministraLabel = new javax.swing.JLabel();

        universidade_origemLabel.setText("Faculdade de Origem");

        universidade_origemTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                universidade_origemTextFieldActionPerformed(evt);
            }
        });

        ministraComboBox.setModel(new DefaultComboBoxModel(Ministra.values()));

        ministraLabel.setText("Ministra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(universidade_origemLabel)
                    .addComponent(ministraLabel))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ministraComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(universidade_origemTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ministraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ministraLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(universidade_origemLabel)
                    .addComponent(universidade_origemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void universidade_origemTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_universidade_origemTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_universidade_origemTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ministraComboBox;
    private javax.swing.JLabel ministraLabel;
    private javax.swing.JLabel universidade_origemLabel;
    private javax.swing.JTextField universidade_origemTextField;
    // End of variables declaration//GEN-END:variables
}
