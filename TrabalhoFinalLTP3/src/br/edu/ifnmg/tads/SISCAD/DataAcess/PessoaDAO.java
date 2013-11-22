/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO
 */
public class PessoaDAO extends Dao {

    public PessoaDAO() {
        super();
    }

    //Salvar
    public boolean Salvar(Pessoa obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into pessoa(Nome,Rg,Cpf,dataNascimento,sexo) values(?,?,?,?,?)");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getRg());
                sql.setString(3, obj.getCpf());
                sql.setDate(4, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.setString(5, obj.getSexo());

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select idPessoa from pessoa where nome = ? and Rg = ? and Cpf=? and dataNascimento=? and sexo=?");
                sql2.setString(1, obj.getNome());
                sql2.setString(2, obj.getRg());
                sql2.setString(3, obj.getCpf());
                sql2.setDate(4, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql2.setString(5, obj.getSexo());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idPessoa"));
                }

                /*              // Salva o email
                 for (Email e : obj.getEmails()) {
                 SalvarEmail(obj, e);
                 }
                 //Salva o Endereco 
                 for (Endereco e : obj.getEnderecos()) {
                 SalvarEndereco(obj, e);
                 }
                 // Salva o Telefone 
                 for (Telefone e : obj.getTelefones()) {
                 SalvarTelefone(obj, e);
                 }*/
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa set nome=?, Rg=?, cpf=?,"
                                                             + " dataNascimento=?,sexo=? where idPessoa=?");
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

    public Pessoa Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa"
                                                                  + " where idPessoa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("idPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setRg("Rg");
                obj.setCpf("Cpf");
                obj.setDataNascimento(resultado.getDate("DataNascimento"));
                obj.setSexo("sexo");
                //AbrirTelefones(obj);
                // AbrirEmails(obj);
                //  AbrirEnderecos(obj);

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
     public List<Pessoa> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa");

            ResultSet resultado = sql.executeQuery();

            List<Pessoa> lista = new ArrayList<Pessoa>();

            while (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("idPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setRg(resultado.getString("Rg"));
                obj.setCpf(resultado.getString("Cpf"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));
                obj.setSexo(resultado.getString("Sexo"));
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
     
     public boolean Remover(Pessoa obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where codPessoa=?");
                sql.setInt(1, obj.getCodigo());
                //sql.setDate(2, new java.sql.Date( obj.getDataNascimento().getTime() ));
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
    
    

}
