/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aline
 */
 public class FornecedorDAO extends PessoaDAO<Fornecedor>  {
     public FornecedorDAO() {
        super();
    }

    public boolean Salvar(Fornecedor obj) {

        if (obj.getCodigo() == 0) {
            super.Salvar(obj);
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Fornecedor(IdFornecedor,cnpj,ativo) values(?,?,?)");
                sql.setInt(1,obj.getCodigo());
                sql.setString(2,obj.getCnpj());
                sql.setInt(3, obj.getAtivo());
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
                PreparedStatement sqlUpdate = con.prepareStatement("update Fornecedor set cnpj=?,ativo=? where idFornecedor=?");
                sqlUpdate.setString(1,obj.getCnpj());
                sqlUpdate.setInt(2, obj.getAtivo());
                sqlUpdate.setInt(3,obj.getCodigo());
                sqlUpdate.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }

    }
    
  public Fornecedor AbrirFornecedor(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select* from Fornecedor where IdFornecedor=?");
            sql.setInt(1, id);
            
            ResultSet resultado = sql.executeQuery();
            Fornecedor fornecedor= new Fornecedor();
            super.AbrirPessoa(fornecedor, id);
             
            if (resultado.next()) {
              
              fornecedor.setCnpj(resultado.getString("cnpj"));
              fornecedor.setAtivo(resultado.getInt("ativo"));
              

            } 
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            
        }
         return null;
    }
  
  public List<Fornecedor> ListarFuncionarios(){
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa P join Fornecedor F"
                                                                  + " on P.IdPessoa = F.IdFornecedor where F.ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Fornecedor> lista = new ArrayList<Fornecedor>();

            while (resultado.next()) {
                Fornecedor obj = new Fornecedor();

                super.CarregaObjetoPessoa(obj, resultado);

              obj.setCnpj(resultado.getString("cnpj"));
              obj.setAtivo(resultado.getInt("ativo"));
                
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
  
    public boolean Apagar(int cod) {
        try {
            PreparedStatement sql = getConexao().
                    prepareStatement("update Fornecedor set ativo = 0 where IdFornecedor = ?");
            sql.setInt(1, cod);
            sql.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public List<Fornecedor> buscar(Fornecedor filtro) {
         try {
            String sql = "select * from Pessoa P join Fornecedor F on P.IdPessoa = F.IdFornecedor where F.ativo = 1";
            String where = "";

            if (filtro.getNome() != null) {
                if (filtro.getNome().length() > 0) {
                    where = " P.nome like '%" + filtro.getNome() + "%' ";
                }
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " F.IdFornecedor = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);


            List<Fornecedor> lista = new ArrayList<Fornecedor>();

            while (resultado.next()) {
                Fornecedor obj = new Fornecedor();

                CarregaObjetoPessoa(obj, resultado);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }



    
}
