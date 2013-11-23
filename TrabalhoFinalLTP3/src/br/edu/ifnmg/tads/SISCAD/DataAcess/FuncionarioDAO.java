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
                PreparedStatement sql = getConexao().prepareStatement("insert into Funcionario(idFuncionario, idcargo) values(?,?)");
                sql.setInt(1, obj.getPessoa().getCodigo());
                sql.setInt(2, obj.getCargo().getCodigo());
                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select idFuncionario from Funcionario where  idCargo = ? ");
                sql2.setInt(1, obj.getCargo().getCodigo());
                sql2.executeUpdate();
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idFuncionario"));
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;

            }

        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Funcionario set  idCargo=?"
                        + "  where idFuncionario=?");
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
