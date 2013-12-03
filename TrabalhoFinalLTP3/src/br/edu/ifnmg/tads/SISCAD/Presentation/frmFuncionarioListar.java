/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.Presentation;

import br.edu.ifnmg.tads.SISCAD.DataAcess.ClienteDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.FuncionarioDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUNO
 */
public class frmFuncionarioListar extends javax.swing.JInternalFrame {

    FuncionarioDAO dao;
     /* Creates new form frmFuncionarioListar
     */
    public frmFuncionarioListar() {
        initComponents();
       dao= new FuncionarioDAO();

        List<Funcionario> funcionarios = dao.ListarFuncionarios();

        preencheTabela(funcionarios);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarFuncionarios = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listagem de Funcionarios");

        jLabel1.setText("Nome:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblListarFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListarFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListarFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListarFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      Funcionario funcionario = new Funcionario();
          //  pessoa.setNome(txtNome.getText());
            try {
                if (txtNome.getText().length() == 0) {
                    List<Funcionario> lista = dao.ListarFuncionarios();
                    preencheTabela(lista);
                } else {
                    funcionario.setNome(txtNome.getText());
                    List<Funcionario> lista = dao.buscar(funcionario);
                    preencheTabela(lista);

                }
         } catch (Exception ex) {
              
                System.err.print(ex);
            }

      

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       //Passagem de parametros nulos  
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO daoNulo= new FuncionarioDAO();
        frmFuncionarioEditar janela = new frmFuncionarioEditar(funcionario, daoNulo);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblListarFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListarFuncionariosMouseClicked
        Object valor = tblListarFuncionarios.getValueAt(tblListarFuncionarios.getSelectedRow(), 0);
        Funcionario f = dao.AbrirFuncionario((int) valor);
        frmFuncionarioEditar janela = new frmFuncionarioEditar(f, dao);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tblListarFuncionariosMouseClicked
  private void preencheTabela(List<Funcionario> lista) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IdFuncionario");
        model.addColumn("Nome");
        model.addColumn("DataNascimento");
        model.addColumn("sexo");

        for (Funcionario f : lista) {
            Vector valores = new Vector();
            valores.add(0, f.getCodigo());
            valores.add(1, f.getNome());
            valores.add(2, f.getDataNascimento());
            valores.add(3, f.getSexo());
            model.addRow(valores);
        }
        tblListarFuncionarios.setModel(model);
        tblListarFuncionarios.repaint();


    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListarFuncionarios;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
