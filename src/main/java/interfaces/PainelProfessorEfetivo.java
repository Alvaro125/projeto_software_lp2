/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

/**
 *
 * @author 04950754181
 */
public class PainelProfessorEfetivo extends javax.swing.JPanel {

    /**
     * Creates new form PainelProfessorEfetivo
     */
    public PainelProfessorEfetivo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        experiencia_empresarialLabel = new javax.swing.JLabel();
        experiencia_empresarialTextField = new javax.swing.JTextField();
        envolvido_pesquisaCheckBox = new javax.swing.JCheckBox();

        experiencia_empresarialLabel.setText("Tempo de Experiencia Empresarial");

        experiencia_empresarialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experiencia_empresarialTextFieldActionPerformed(evt);
            }
        });

        envolvido_pesquisaCheckBox.setText("Envolvido com pesquisas");
        envolvido_pesquisaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envolvido_pesquisaCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(experiencia_empresarialLabel)
                        .addGap(26, 26, 26)
                        .addComponent(experiencia_empresarialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(envolvido_pesquisaCheckBox)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(envolvido_pesquisaCheckBox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(experiencia_empresarialLabel)
                    .addComponent(experiencia_empresarialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void experiencia_empresarialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experiencia_empresarialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_experiencia_empresarialTextFieldActionPerformed

    private void envolvido_pesquisaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envolvido_pesquisaCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_envolvido_pesquisaCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox envolvido_pesquisaCheckBox;
    private javax.swing.JLabel experiencia_empresarialLabel;
    private javax.swing.JTextField experiencia_empresarialTextField;
    // End of variables declaration//GEN-END:variables
}
