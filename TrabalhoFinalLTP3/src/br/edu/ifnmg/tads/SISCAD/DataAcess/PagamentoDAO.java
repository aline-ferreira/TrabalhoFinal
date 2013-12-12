/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aline
 */
public class PagamentoDAO extends Dao {
    
    public boolean Salvar(Pagamento obj){
        if(obj.getCodigo()==0){
            try {
              
                PreparedStatement sql = getConexao().prepareStatement("insert into Pagamento(data,IdMensalidade,formaPagamento,valor,IdCliente) values(?,?,?,?,?)");

                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setInt(2,obj.getMensalidade().getCodigo());
                sql.setString(3, obj.getFormaPagamento());
                sql.setDouble(4, obj.getValor());
                sql.setInt(5, obj.getCliente().getCodigo());
                sql.executeUpdate();


                PreparedStatement sql2 = getConexao().prepareStatement("select IdPagamento from Pagamento where data=?and IdMensalidade= ? and formaPagamento= ?"
                                                                         + " and valor=? and IdCliente=? ");
                sql2.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql2.setInt(2,obj.getMensalidade().getCodigo());
                sql2.setString(3, obj.getFormaPagamento());
                sql2.setDouble(4, obj.getValor());
                sql2.setInt(5, obj.getCliente().getCodigo());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("IdPagamento"));
                }
                
                  return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                // Salvar(obj.getPessoa());
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pagamentoset data=? ,IdMensalidade=?,formaPagamento=?, valor=?, IdCliente=? where IdPagamento=?");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setInt(2,obj.getMensalidade().getCodigo());
                sql.setString(3, obj.getFormaPagamento());
                sql.setDouble(4, obj.getValor());
                sql.setInt(5, obj.getCliente().getCodigo());
                sql.setInt(6, obj.getCodigo());
                sql.executeUpdate();


                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        }
        
        
        
    
    
}
