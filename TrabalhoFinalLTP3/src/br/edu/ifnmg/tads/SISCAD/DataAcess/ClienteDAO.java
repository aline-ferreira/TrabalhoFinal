/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.edu.ifnmg.tads.SISCAD.DataAcess.PessoaDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.AvaliacaoDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
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
    
    public List<Cliente> ListarFuncionarios(){
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa P join Cliente C on P.IdPessoa = C.IdCliente  where C.ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Cliente> lista = new ArrayList<Cliente>();

            while (resultado.next()) {
               Cliente obj = new Cliente();

                super.CarregaObjetoPessoa(obj, resultado);

                obj.setCodigo(resultado.getInt("IdPessoa"));
                obj.setAtivo(resultado.getInt("ativo"));
                
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
 public List<Cliente> buscar(Cliente filtro) {
        try {

            String sql = "select * from pessoa p join cliente c on p.IdPessoa = c.IdPessoa where ativo = 1 ";
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

            List<Cliente> clientes = new LinkedList<>();
            while (resultado.next()) {
               
                Cliente tmp = new Cliente();
               

                try {
                    tmp.setCodigo(resultado.getInt("IdPessoa"));
                    tmp.setAtivo(resultado.getInt("Ativo"));
                   
                } catch (Exception ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                clientes.add(tmp);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
