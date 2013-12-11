/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.Presentation;

import br.edu.ifnmg.tads.SISCAD.DataAcess.ExercicioDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.GrupoMuscularDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Cargo;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Exercicio;
import br.edu.ifnmg.tads.SISCAD.DomainModel.GrupoMuscular;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aline
 */
public class frmExercicioEditar extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmExercicioEditar
     */
    ExercicioDAO dao;
    Exercicio exercicio;
    GrupoMuscularDAO grupoDAO;
    public frmExercicioEditar(Exercicio e, ExercicioDAO dao) {
        this.exercicio= e;
        this.dao= dao;
        
        initComponents();
        grupoDAO= new GrupoMuscularDAO();
        carregaGrupos();
        
        
    }

   
    
     private void carregaGrupos() {
        List<GrupoMuscular> grupos = grupoDAO.ListarTodos();
        cbxGrupoMuscular.removeAllItems();
        for (GrupoMuscular g : grupos) {
            cbxGrupoMuscular.addItem(g);
        }
    }

        private void carregaCampos() {
        //lblId.setText(Integer.toString(cliente.getCodigo()));
        txtNome.setText(exercicio.getNome());
        

    }
 private void carregaObjeto() {
        try {

         exercicio.setNome(txtNome.getText());
         exercicio.setGrupoMuscular((GrupoMuscular) cbxGrupoMuscular.getSelectedItem());
         if (btnMusculacao.isSelected()){
            exercicio.setTipo("musculacao");
         }else{
             exercicio.setTipo("aerobico");
         }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,ex);
            System.err.print(ex);

        }

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        txtNome = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        cbxGrupoMuscular = new javax.swing.JComboBox();
        label2 = new java.awt.Label();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        label3 = new java.awt.Label();
        btnMusculacao = new javax.swing.JRadioButton();
        btnAerobico = new javax.swing.JRadioButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        label1.setText("Nome:");

        label2.setText("Grupo Muscular:");

        btnCancelar.setText("Cancelar");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        label3.setText("Tipo:");

        buttonGroup1.add(btnMusculacao);
        btnMusculacao.setSelected(true);
        btnMusculacao.setText("Musculação");
        btnMusculacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusculacaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnAerobico);
        btnAerobico.setText("Aeróbico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(221, 221, 221))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMusculacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnAerobico))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxGrupoMuscular, 0, 168, Short.MAX_VALUE)
                        .addComponent(txtNome)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxGrupoMuscular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMusculacao)
                        .addComponent(btnAerobico)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Salvar?") == 0) {

                carregaObjeto();
                

                if (dao.Salvar(exercicio)) {
                    JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
                    this.dispose();
                }
                  

            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!!" + ex);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnMusculacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusculacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMusculacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAerobico;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnMusculacao;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cbxGrupoMuscular;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
