/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.Presentation;

import br.edu.ifnmg.tads.SISCAD.DataAcess.FornecedorDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Fornecedor;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aline
 */
public class frmFornecedorListar extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmFornecedorListar
     */
    public frmFornecedorListar() {
        initComponents();
        
        List<Fornecedor> fornecedores = dao.ListarFuncionarios();
        preencheTabela(fornecedores);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarFuncionarios = new javax.swing.JTable();

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

        jLabel1.setText("Nome:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    FornecedorDAO dao = new FornecedorDAO();
    Fornecedor fornecedor = new Fornecedor();
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      
        //  pessoa.setNome(txtNome.getText());
        try {
            if (txtNome.getText().length() == 0) {
                List<Fornecedor> lista = dao.ListarFuncionarios();
                preencheTabela(lista);
            } else {
                fornecedor.setNome(txtNome.getText());
                List<Fornecedor> lista = dao.buscar(fornecedor);
                preencheTabela(lista);

            }
        } catch (Exception ex) {
            System.err.print(ex);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Fornecedor funcionario = new Fornecedor ();
        FornecedorDAO daoNulo= new FornecedorDAO();
        frmFornecedorEditar janela = new frmFornecedorEditar( fornecedor,daoNulo);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblListarFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListarFuncionariosMouseClicked
        Object valor = tblListarFuncionarios.getValueAt(tblListarFuncionarios.getSelectedRow(), 0);
         Fornecedor f = dao.AbrirFornecedor((int) valor);
        frmFornecedorEditar janela = new frmFornecedorEditar(f, dao);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tblListarFuncionariosMouseClicked

 private void preencheTabela(List<Fornecedor> lista) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IdFornecedor");
        model.addColumn("Nome");
        model.addColumn("CNPJ");
       

        for (Fornecedor f : lista) {
            Vector valores = new Vector();
            valores.add(0, f.getCodigo());
            valores.add(1, f.getNome());
            valores.add(2, f.getCnpj());
           
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
