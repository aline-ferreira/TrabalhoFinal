/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Cargo;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aline
 */
public class CargoDAO extends Dao {

    public boolean Salvar(Cargo obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Cargo(Nome,funcao) values(?,?)");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getFuncao());

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select idCargo from pessoa where nome = ? and funcao= ? ");
                sql2.setString(1, obj.getNome());
                sql2.setString(2, obj.getFuncao());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idPessoa"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }

        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Cargo set nome=?, Funcao=? where idCargo=?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getFuncao());
                sql.setInt(6, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
        
         

    public Cargo Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Cargo where idCargo=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
               Cargo obj = new Cargo();

                obj.setCodigo(resultado.getInt("IdCargo"));
                obj.setNome(resultado.getString("Nome"));
                obj.setNome(resultado.getString("Funacao"));
                
                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}


