/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.GrupoMuscular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aline
 */
public class GrupoMuscularDAO extends Dao {

    //Salvar
    public boolean Salvar(GrupoMuscular obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into GrupoMuscular(Nome) values(?)");
                sql.setString(1, obj.getNome());

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select idGrupoMuscular from GrupoMuscular where nome = ? ");
                sql2.setString(1, obj.getNome());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idGrupoMuscular"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update GrupoMuscular set nome=? where idGrupoMuscular=?");
                sql.setString(1, obj.getNome());
                sql.setInt(3, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Abrir
    public GrupoMuscular Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from GrupoMuscular where idGrupoMuscular=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                GrupoMuscular obj = new GrupoMuscular();

                obj.setCodigo(resultado.getInt("idGrupoMuscular"));
                obj.setNome(resultado.getString("Nome"));
                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    // Listar 
    public List<GrupoMuscular> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from GrupoMuscular");

            ResultSet resultado = sql.executeQuery();

            List<GrupoMuscular> lista = new ArrayList<GrupoMuscular>();

            while (resultado.next()) {
                GrupoMuscular obj = new GrupoMuscular();

                obj.setCodigo(resultado.getInt("idGrupoMuscular"));
                obj.setNome(resultado.getString("Nome"));
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Buscar
    public List<GrupoMuscular> buscar(GrupoMuscular filtro) throws Exception {
        try {

            String sql = "select * from GrupoMuscular";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }

                     
            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                    where = where + " idGrupoMuscular = " + filtro.getCodigo();
                }
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<GrupoMuscular> grupos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                GrupoMuscular tmp = new GrupoMuscular();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setCodigo(resultado.getInt("idGrupoMuscular"));
                tmp.setNome(resultado.getString("nome"));
               
                    //tmp.setValor(resultado.getDouble("valor"));
                // Pega o objeto e coloca na lista
                grupos.add(tmp);
            }
            return grupos;
        } catch (SQLException ex) {
            Logger.getLogger(GrupoMuscular.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
