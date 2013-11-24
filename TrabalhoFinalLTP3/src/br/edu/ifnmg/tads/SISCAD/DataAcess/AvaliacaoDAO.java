/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao;
import java.sql.PreparedStatement;

/**
 *
 * @author Aline
 */
public class AvaliacaoDAO extends Dao{

    public AvaliacaoDAO() {
    
        super();
    }
    
  public boolean Salvar(Avaliacao obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Avaliacao(Data,Vencimento,observacao,idaluno, idfuncionario) values(?,?,?,?,?)");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                 sql.setDate(2, new java.sql.Date(obj.getVencimento().getTime()));
                sql.setString(3, obj.getObservacao());
               
                sql.setString(5, obj.getSexo());

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select idPessoa from pessoa where nome = ? and Rg = ? and Cpf=? and dataNascimento=? and sexo=?");
                sql2.setString(1, obj.getNome());
                sql2.setString(2, obj.getRg());
                sql2.setString(3, obj.getCpf());
                sql2.setDate(4, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql2.setString(5, obj.getSexo());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idPessoa"));
                }

                 // Salva o email
                 for (Email e : obj.getEmails()) {
                 SalvarEmail(obj, e);
                 }
                 //Salva o Endereco 
                 for (Endereco e : obj.getEnderecos()) {
                 SalvarEndereco(obj, e);
                 }
                 // Salva o Telefone 
                 for (Telefone e : obj.getTelefones()) {
                 SalvarTelefone(obj, e);
                 }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa set nome=?, Rg=?, cpf=?,"
                                                             + " dataNascimento=?,sexo=? where idPessoa=?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getRg());
                sql.setString(3, obj.getCpf());
                sql.setDate(4, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.setString(5, obj.getSexo());
                sql.setInt(6, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    
    
}
