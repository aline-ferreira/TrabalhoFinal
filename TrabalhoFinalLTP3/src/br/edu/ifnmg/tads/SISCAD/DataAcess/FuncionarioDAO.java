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
                sql2.setInt(1, obj.getCargo().getCodigo());
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
  
    public List<Funcionario> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Funcionario where ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Funcionario> lista = new ArrayList<Funcionario>();

            while (resultado.next()) {
                Funcionario obj = new Funcionario();

                obj.setCodigo(resultado.getInt("idFuncionario"));
                obj.setNome(resultado.getString("idCargo"));
                
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
     public List<Funcionario> buscar(Funcionario filtro) {
        try {

            String sql = "select * from pessoa p join Funcionario f on p.IdPessoa = f.IdFuncionario where ativo = 1 ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " Idpessoa = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + where;
            }

            Statement comando = getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);

            // Cria uma lista de produtos vazia
            List<Funcionario> clientes = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
              Funcionario tmp = new Funcionario();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {
                    tmp.setCodigo(resultado.getInt("IdFuncionario"));
                    tmp.setAtivo(resultado.getInt("Ativo"));
                    //tmp.setCargo(resultado.getInt(""));
                } catch (Exception ex) {
                    Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                clientes.add(tmp);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    }
