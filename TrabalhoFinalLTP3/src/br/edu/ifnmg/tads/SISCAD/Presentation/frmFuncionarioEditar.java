/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.Presentation;

import br.edu.ifnmg.tads.SISCAD.DataAcess.CargoDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.FuncionarioDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.UsuarioDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Cargo;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Email;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Endereco;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Horario;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Telefone;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Usuario;
import java.sql.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aline
 */
public class frmFuncionarioEditar extends javax.swing.JInternalFrame {

    Funcionario funcionario;
    FuncionarioDAO dao;
    CargoDAO cargoDAO;

    /**
     * Creates new form frmFuncionarioEditar
     */
    public frmFuncionarioEditar(Funcionario f, FuncionarioDAO dao) {
        initComponents();
        cargoDAO = new CargoDAO();
        carregaCargos();
        this.funcionario = f;
        this.dao = dao;
        if (f.getCodigo() > 0) {
            carregaCampos();
            List<Telefone> telefones = funcionario.getTelefones();
            atualizarTabelaTelefones(telefones);
            List<Email> emails = funcionario.getEmails();
            atualizarTabelaEmails(emails);
            List<Endereco> enderecos = funcionario.getEnderecos();
            atualizarTabelaEnderecos(enderecos);
            List<Horario> horarios = funcionario.getHorarios();
            atualizarTabelaHorarios(horarios);
        } else {

        }

    }

    private void carregaCampos() {
        //lblId.setText(Integer.toString(cliente.getCodigo()));
        txtNome.setText(funcionario.getNome());
        txtDataNascimento.setText(String.valueOf(funcionario.getDataNascimento()));
        txtCPF.setText(funcionario.getCpf());
        txtRG.setText(funcionario.getRg());

    }

    private void carregaObjeto() {
        try {

            funcionario.setNome(txtNome.getText());
            funcionario.setDataNascimento(Date.valueOf(txtDataNascimento.getText()));
            funcionario.setCpf(txtCPF.getText());
            funcionario.setRg(txtRG.getText());
            funcionario.setCargo((Cargo) cbxCargo.getSelectedItem());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);

        }

    }

    private void carregaCargos() {
        List<Cargo> cargos = cargoDAO.ListarCargos();
        cbxCargo.removeAllItems();
        for (Cargo c : cargos) {
            cbxCargo.addItem(c);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlDadosGerais = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        txtNome = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        txtRG = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        cbxCargo = new javax.swing.JComboBox();
        label8 = new java.awt.Label();
        label19 = new java.awt.Label();
        label20 = new java.awt.Label();
        txtLogin = new javax.swing.JTextField();
        ptxtSenha = new javax.swing.JPasswordField();
        pnlTelefones = new javax.swing.JPanel();
        txtDDD = new javax.swing.JTextField();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        txtTelefone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefones = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label15 = new java.awt.Label();
        txtEmail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmails = new javax.swing.JTable();
        btnAdicionarEmail = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        label16 = new java.awt.Label();
        label17 = new java.awt.Label();
        label18 = new java.awt.Label();
        txtDia = new javax.swing.JTextField();
        txtHoraEntrada = new javax.swing.JTextField();
        txtHoraSaida = new javax.swing.JTextField();
        btnAdicionarHorario = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHorarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        label9 = new java.awt.Label();
        txtRua = new javax.swing.JTextField();
        label10 = new java.awt.Label();
        txtBairro = new javax.swing.JTextField();
        label11 = new java.awt.Label();
        label12 = new java.awt.Label();
        txtCEP = new javax.swing.JTextField();
        label13 = new java.awt.Label();
        txtCidade = new javax.swing.JTextField();
        label14 = new java.awt.Label();
        txtNumero = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnderecos = new javax.swing.JTable();
        btnAdicionarEndereco = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setClosable(true);
        setForeground(java.awt.Color.white);
        setMaximizable(true);
        setTitle("Cadastro Funcionario");
        setVisible(true);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        label1.setText("Nome: ");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        label2.setText("RG: ");

        label3.setText("CPF: ");

        label4.setText("D/N: ");

        cbxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCargoActionPerformed(evt);
            }
        });

        label8.setText("Cargo:");

        label19.setText("Login:");

        label20.setText("Senha:");

        javax.swing.GroupLayout pnlDadosGeraisLayout = new javax.swing.GroupLayout(pnlDadosGerais);
        pnlDadosGerais.setLayout(pnlDadosGeraisLayout);
        pnlDadosGeraisLayout.setHorizontalGroup(
            pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                                    .addGap(316, 316, 316)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCPF))
                                .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDataNascimento)
                                        .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                                    .addGap(35, 35, 35)
                                    .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                                            .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ptxtSenha))
                                        .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxCargo, 0, 209, Short.MAX_VALUE))))))
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(246, 246, 246))
            .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosGeraisLayout.setVerticalGroup(
            pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDadosGeraisLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDadosGeraisLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnlDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ptxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados Gerais", pnlDadosGerais);

        pnlTelefones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDDDActionPerformed(evt);
            }
        });
        pnlTelefones.add(txtDDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 80, 20));

        label6.setText("DDD:");
        pnlTelefones.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        label7.setText("Telefone: ");
        pnlTelefones.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));
        pnlTelefones.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 210, -1));

        tblTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTelefones);

        pnlTelefones.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 610, 280));

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        pnlTelefones.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 150, -1));

        jTabbedPane1.addTab("Telefones", pnlTelefones);

        label15.setText("E-Mail:");

        tblEmails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblEmails);

        btnAdicionarEmail.setText("Adicionar");
        btnAdicionarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdicionarEmail))
                    .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("E-Mails", jPanel4);

        label16.setText("Dia:");

        label17.setText("Hora Entrada:");

        label18.setText("Hora Saida:");

        btnAdicionarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/tads/SISCAD/Imagens/7183_32x32.png"))); // NOI18N
        btnAdicionarHorario.setText("Adicionar");
        btnAdicionarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarHorarioActionPerformed(evt);
            }
        });

        tblHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblHorarios);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoraSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(btnAdicionarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHoraSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAdicionarHorario))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Horarios", jPanel5);

        label9.setText("Rua:");

        label10.setText("Bairro:");

        label11.setText("CEP:");
        label11.setVisible(false);

        label12.setText("CEP:");

        label13.setText("Cidade:");

        label14.setName(""); // NOI18N
        label14.setText("Número:");

        tblEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblEnderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEnderecosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEnderecos);

        btnAdicionarEndereco.setText("Adicionar");
        btnAdicionarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEnderecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRua)
                                    .addComponent(txtCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBairro)
                            .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnAdicionarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarEndereco))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Enderecos", jPanel3);

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed

    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtDDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDDDActionPerformed

    }//GEN-LAST:event_txtDDDActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente Cancelar?") == 0) {
            this.setVisible(false);
            frmFuncionarioListar janela = new frmFuncionarioListar();
            this.getParent().add(janela);
            janela.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            Usuario usuario = new Usuario();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Salvar?") == 0) {

                carregaObjeto();
                funcionario.setAtivo(1);

                

               

                if (dao.Salvar(funcionario)) {
                    usuario.setFuncionario(funcionario);
                usuario.setLogin(txtLogin.getText());
                usuario.setSenha(ptxtSenha.getText());
                     usuarioDAO.Salvar(usuario);
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

    private void tblEnderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEnderecosMouseClicked

    }//GEN-LAST:event_tblEnderecosMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Telefone t = new Telefone();
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Adicionar o telefone? ") == 0) {
                t.setTelefone(Integer.parseInt(txtDDD.getText()));
                t.setTelefone(Integer.parseInt(txtTelefone.getText()));
                funcionario.addTelefone(t);
                atualizarTabelaTelefones(funcionario.getTelefones());
                JOptionPane.showMessageDialog(rootPane, "Telefone salvo com sucesso! ");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada pelo usuário!");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!" + ex);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAdicionarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEmailActionPerformed
        Email email = new Email();
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Adicionar o Email? ") == 0) {
                email.setEmail(txtEmail.getText());
                funcionario.addEmail(email);
                atualizarTabelaEmails(funcionario.getEmails());
                JOptionPane.showMessageDialog(rootPane, "Email salvo com sucesso! ");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada pelo usuário!");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!" + ex);
        }
    }//GEN-LAST:event_btnAdicionarEmailActionPerformed

    private void btnAdicionarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEnderecoActionPerformed

        Endereco endereco = new Endereco();
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Adicionar o Email? ") == 0) {
                endereco.setCep(txtCEP.getText());
                endereco.setRua(txtRua.getText());
                endereco.setBairro(txtBairro.getText());
                endereco.setCidade(txtCidade.getText());
                endereco.setNumero(Integer.parseInt(txtNumero.getText()));

                funcionario.addEndereco(endereco);
                atualizarTabelaEnderecos(funcionario.getEnderecos());
                JOptionPane.showMessageDialog(rootPane, "Endereco salvo com sucesso! ");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada pelo usuário!");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!" + ex);
        }
    }//GEN-LAST:event_btnAdicionarEnderecoActionPerformed

    private void btnAdicionarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarHorarioActionPerformed
        Horario horario = new Horario();
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Adicionar este horario de trabalho? ") == 0) {
                horario.setDia(txtDia.getText());
                horario.setHoraEntrada(txtHoraEntrada.getText());
                horario.setHoraSaida(txtHoraSaida.getText());
                funcionario.addHorario(horario);
                atualizarTabelaHorarios(funcionario.getHorarios());
                JOptionPane.showMessageDialog(rootPane, "Horario salvo com sucesso! ");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada pelo usuário!");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar!" + ex);
        }
    }//GEN-LAST:event_btnAdicionarHorarioActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        carregaObjeto();
        dao.Apagar(funcionario.getCodigo());
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?") == 0) {
            try {

                JOptionPane.showMessageDialog(rootPane, "Operação realizada com sucesso! ");
                this.setVisible(false);
                frmFuncionarioListar janela = new frmFuncionarioListar();
                this.getParent().add(janela);
                janela.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao excluir! " + ex);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Operação cancelada pelo usuario! ");
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void cbxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCargoActionPerformed

    private void atualizarTabelaTelefones(List<Telefone> telefones) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DDD");
        model.addColumn("Telefone");

        for (Telefone t : telefones) {
            Vector valores = new Vector();
            valores.add(0, t.getDd());
            valores.add(1, t.getTelefone());
            model.addRow(valores);
        }
        tblTelefones.setModel(model);
        tblTelefones.repaint();

    }

    private void atualizarTabelaEmails(List<Email> emails) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Emails");

        for (Email e : emails) {
            Vector valores = new Vector();
            valores.add(0, e.getEmail());
            model.addRow(valores);
        }
        tblEmails.setModel(model);
        tblEmails.repaint();

    }

    private void atualizarTabelaEnderecos(List<Endereco> enderecos) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("CEP");
        model.addColumn("Cidade");
        model.addColumn("Bairro");
        model.addColumn("Rua");
        model.addColumn("Numero");

        for (Endereco e : enderecos) {
            Vector valores = new Vector();
            valores.add(0, e.getCep());
            valores.add(1, e.getCidade());
            valores.add(2, e.getBairro());
            valores.add(3, e.getRua());
            valores.add(4, e.getNumero());
            model.addRow(valores);
        }
        tblEnderecos.setModel(model);
        tblEnderecos.repaint();

    }

    private void atualizarTabelaHorarios(List<Horario> horarios) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Dia");
        model.addColumn("Hora Entrada");
        model.addColumn("Hora Saida");

        for (Horario h : horarios) {
            Vector valores = new Vector();
            valores.add(0, h.getCodigo());
            valores.add(1, h.getDia());
            valores.add(2, h.getHoraEntrada());
            valores.add(3, h.getHoraSaida());

            model.addRow(valores);
        }
        tblHorarios.setModel(model);
        tblHorarios.repaint();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAdicionarEmail;
    private javax.swing.JButton btnAdicionarEndereco;
    private javax.swing.JButton btnAdicionarHorario;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbxCargo;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label2;
    private java.awt.Label label20;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JPanel pnlDadosGerais;
    private javax.swing.JPanel pnlTelefones;
    private javax.swing.JPasswordField ptxtSenha;
    private javax.swing.JTable tblEmails;
    private javax.swing.JTable tblEnderecos;
    private javax.swing.JTable tblHorarios;
    private javax.swing.JTable tblTelefones;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtDDD;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoraEntrada;
    private javax.swing.JTextField txtHoraSaida;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
