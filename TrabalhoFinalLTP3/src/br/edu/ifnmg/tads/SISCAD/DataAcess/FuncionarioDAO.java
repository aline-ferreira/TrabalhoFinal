/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aline
 */
public class FuncionarioDAO extends Dao {

    public FuncionarioDAO() {
        super();
    }

    public boolean Salvar(Funcionario obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Funcionario(idFuncionario,idCargo, ativo) values(?,?,?)");
                sql.setInt(1, obj.getPessoa().getCodigo());
                sql.setInt(2, obj.getCargo().getCodigo());
                sql.setInt(3, obj.getAtivo());
                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select idFuncionario from funcionario where idCargo=? ativo= ? ");
                sql2.setInt(2, obj.getCargo().getCodigo());
                sql2.setInt(2, obj.getAtivo());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idFuncionario"));
                }

               return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } 
        return false;
        
            
    }
    
     public boolean Apagar(int cod){
        try {
            PreparedStatement sql = getConexao().
                    prepareStatement("update cliente set ativo = 0 where IdCliente = ?");
           sql.setInt(1, cod);
          sql.executeUpdate();
            return true;
        } catch (SQLException ex) {
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
    }
