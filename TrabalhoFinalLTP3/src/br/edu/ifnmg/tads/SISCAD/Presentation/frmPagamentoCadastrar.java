/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.Presentation;

import br.edu.ifnmg.tads.SISCAD.DataAcess.ClienteDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.PagamentoDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Cliente;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Mensalidade;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Pagamento;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aline
 */
public class frmPagamentoCadastrar extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPagamentoCadastrar
     */
    ClienteDAO clienteDAO;
    List<Mensalidade> mensalidades;
    Cliente cliente = new Cliente();
    Pagamento pagamento;
    PagamentoDAO pagamentoDAO;
    Mensalidade mensalidade;

    public frmPagamentoCadastrar() {

        initComponents();
        mensalidade= new Mensalidade();
        clienteDAO = new ClienteDAO();
        carregaClientes();
        pagamentoDAO = new PagamentoDAO();
        pagamento = new Pagamento();
        Cliente clienteSelecionado = (Cliente) cbxClientes.getSelectedItem();
        cliente = clienteDAO.AbrirCliente(clienteSelecionado.getCodigo());
        mensalidades = new ArrayList();
        mensalidades = cliente.getMensalidade();
        atualizarTabelaMensalidades(mensalidades);
    }

    private void carregaClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes = clienteDAO.Listar();

        cbxClientes.removeAllItems();
        for (Cliente c : clientes) {
            cbxClientes.addItem(c);
        }
    }

    public void carregaObjeto() {
        try {
            pagamento.setCliente(cliente);
            pagamento.setData(new Date());
            pagamento.setMensalidade(mensalidade);
            pagamento.setValor(Double.parseDouble(txtValorPagar.getText()));

            if (btnDinheiro.isSelected()) {
                pagamento.setFormaPagamento("Dinheiro");
            }
            if (btnCheque.isSelected()) {
                pagamento.setFormaPagamento("cheque");
            }

            if (btnCartao.isSelected()) {
                pagamento.setFormaPagamento("cartao");
            }

        } catch (Exception ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        cbxClientes = new javax.swing.JComboBox();
        label2 = new java.awt.Label();
        btnDinheiro = new javax.swing.JRadioButton();
        btnCheque = new javax.swing.JRadioButton();
        btnCartao = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMensalidades = new javax.swing.JTable();
        Valor = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        txtValor = new javax.swing.JTextField();
        txtDesconto = new javax.swing.JTextField();
        txtValorPagar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Pagamento");

        label1.setText("Cliente:");

        cbxClientes.setMaximumRowCount(100);
        cbxClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxClientesMouseClicked(evt);
            }
        });
        cbxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClientesActionPerformed(evt);
            }
        });

        label2.setText("Forma de  Pagamento:");

        buttonGroup1.add(btnDinheiro);
        btnDinheiro.setText("Dinheiro");

        buttonGroup1.add(btnCheque);
        btnCheque.setText("Cheque");

        buttonGroup1.add(btnCartao);
        btnCartao.setText("Cartão de Crédito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDinheiro)
                            .addComponent(btnCheque)
                            .addComponent(btnCartao))))
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDinheiro))
                .addGap(18, 18, 18)
                .addComponent(btnCheque)
                .addGap(18, 18, 18)
                .addComponent(btnCartao)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Gerais", jPanel1);

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        tblMensalidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblMensalidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMensalidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMensalidades);

        Valor.setText("Valor:");

        label3.setText("Desconto:");

        label4.setText("Valor a pagar:");

        txtValor.setEditable(false);

        txtDesconto.setEditable(false);

        txtValorPagar.setEditable(false);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");

        jButton2.setText("Abrir Mensalidade");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor)
                                    .addComponent(txtDesconto))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(120, 120, 120))
        );

        jTabbedPane1.addTab("Mensalidade", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClientesActionPerformed

    private void cbxClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxClientesMouseClicked
        Cliente clienteSelecionado = (Cliente) cbxClientes.getSelectedItem();
        mensalidades = clienteSelecionado.getMensalidade();
        atualizarTabelaMensalidades(mensalidades);
    }//GEN-LAST:event_cbxClientesMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Cliente clienteSelecionado = (Cliente) cbxClientes.getSelectedItem();
        cliente = clienteDAO.AbrirCliente(clienteSelecionado.getCodigo());
        //mensalidades= new ArrayList();
        mensalidades = cliente.getMensalidade();
        atualizarTabelaMensalidades(mensalidades);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblMensalidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMensalidadesMouseClicked
        Object valor = tblMensalidades.getValueAt(tblMensalidades.getSelectedRow(), 0);
        Double pagar;
        mensalidade = new Mensalidade();
        mensalidade = clienteDAO.AbrirMensalidade((int) valor);
        txtValor.setText(String.valueOf(mensalidade.getValor()));
        txtDesconto.setText(String.valueOf(mensalidade.getDesconto()));
        pagar = mensalidade.getValor() - mensalidade.getDesconto();
        txtValorPagar.setText(String.valueOf(pagar));


    }//GEN-LAST:event_tblMensalidadesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Salvar?") == 0) {

                carregaObjeto();

                if (pagamentoDAO.Salvar(pagamento)) {
                    mensalidade.setStatus("pg");
                    cliente.addMensalidade(mensalidade);
                    clienteDAO.Salvar(cliente);
                    mensalidades = cliente.getMensalidade();
                    atualizarTabelaMensalidades(mensalidades);
                    JOptionPane.showMessageDialog(rootPane, "Pagamento efetuado com sucesso!!");
                    this.dispose();

                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!!" + ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabPanelStateChanged(javax.swing.event.ChangeEvent evt) {

    }

    private void atualizarTabelaMensalidades(List<Mensalidade> mensalidades) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Valor");
        model.addColumn("Vencimento");
        model.addColumn("Desconto");
        model.addColumn("Status");

        for (Mensalidade m : mensalidades) {
            Vector valores = new Vector();
            if (!"pg".equals(m.getStatus())) {
                valores.add(0, m.getCodigo());
                valores.add(1, m.getValor());
                valores.add(2, m.getDataVencimento());
                valores.add(3, m.getDesconto());
                valores.add(4, m.getStatus());
                model.addRow(valores);
            }
        }
        tblMensalidades.setModel(model);
        tblMensalidades.repaint();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Valor;
    private javax.swing.JRadioButton btnCartao;
    private javax.swing.JRadioButton btnCheque;
    private javax.swing.JRadioButton btnDinheiro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTable tblMensalidades;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorPagar;
    // End of variables declaration//GEN-END:variables
}
