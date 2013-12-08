/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Exercicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aline
 */
public class ExercicioDAO extends Dao{
     public boolean Salvar( Exercicio obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Exercicio(Nome, IdGrupoMuscular) values(?,?)");
                sql.setString(1, obj.getNome());
                sql.setInt(2, obj.getGrupoMuscular().getCodigo());
              //  sql.setString(5, obj.getSexo());

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select IdExercicio from Exercicio where nome = ? and IdGrupoMuscular = ? ");
                sql2.setString(1, obj.getNome());
                sql2.setInt(2, obj.getGrupoMuscular().getCodigo());
                
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idExercicio"));
                }
                
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Exercicio set nome=?,IdGrupoMuscular=? where idExercicio=?");
                sql.setString(1, obj.getNome());
                sql.setInt(2, obj.getGrupoMuscular().getCodigo());
                sql.setInt(5, obj.getCodigo());
                sql.executeUpdate();
                
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
     
    public Exercicio AbrirExercicio(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Exercicio"
                    + " where idExercicio=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                 Exercicio obj = new Exercicio();
                 GrupoMuscularDAO dao= new GrupoMuscularDAO();
                 obj.setCodigo(resultado.getInt("IdExercicio"));
                 obj.setGrupoMuscular(dao.Abrir(resultado.getInt("IdGrupoMuscular")));
                 obj.setNome(resultado.getString("Nome"));
                 return obj;

              } else{
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
             return null;
        }
        
    }
    
     public List<Exercicio> Listar() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Exercicio");

            ResultSet resultado = sql.executeQuery();

            List<Exercicio> lista = new ArrayList<Exercicio>();

            while (resultado.next()) {
                Exercicio obj = new Exercicio();
                GrupoMuscularDAO dao= new GrupoMuscularDAO();
                obj.setCodigo(resultado.getInt("IdExercicio"));
                obj.setGrupoMuscular(dao.Abrir(resultado.getInt("IdGrupoMuscular")));
                obj.setNome(resultado.getString("Nome"));
                
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
     
     public List<Exercicio> buscar(Exercicio filtro) {
         try {
            String sql = "select * from Exercicio E join GrupoMuscular G on E.IdExercicio = G.IdGrupoMuscular";
            String where = "";

            if (filtro.getNome() != null) {
                if (filtro.getNome().length() > 0) {
                    where = " E.nome like '%" + filtro.getNome() + "%' ";
                }
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " E.IdExercicio = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);


            List<Exercicio> lista = new ArrayList<Exercicio>();

            while (resultado.next()) {
              Exercicio obj = new Exercicio();
               GrupoMuscularDAO dao= new GrupoMuscularDAO();
               obj.setCodigo(resultado.getInt("IdExercicio"));
               obj.setGrupoMuscular(dao.Abrir(resultado.getInt("IdGrupoMuscular")));
               obj.setNome(resultado.getString("Nome"));
               lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
     }
}
