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
import java.util.ArrayList;
import java.util.List;
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

    
    
}
