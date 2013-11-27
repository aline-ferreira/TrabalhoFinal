/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.edu.ifnmg.tads.SISCAD.DataAcess.PessoaDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
/**
 *
 * @author ALUNO
 */
public class ClienteDAO extends PessoaDAO<Cliente>{
   public ClienteDAO() {
        super();
    }
   
    public boolean Salvar(Cliente obj) {

        if (obj.getCodigo() == 0) {
           super.Salvar(obj);
            try {
                
                PreparedStatement sql = getConexao().prepareStatement("insert into Cliente(idCliente, ativo) values(?,?)");
                sql.setInt(1, obj.getCodigo());
                sql.setInt(2, obj.getAtivo());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.Salvar(obj);
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Cliente set ativo= ? where idCliente=?");
                sqlUpdate.setInt(1, obj.getAtivo());
                sqlUpdate.setInt(2, obj.getCodigo());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    
    
}
