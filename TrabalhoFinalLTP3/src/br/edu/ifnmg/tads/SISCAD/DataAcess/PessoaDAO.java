/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Email;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Endereco;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Pessoa;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUNO
 */
public class PessoaDAO<T extends Pessoa> extends Dao {

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

                // Salva o email
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
                }
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

    protected void AbrirPessoa(T obj, int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa"
                    + " where idPessoa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                // Pessoa obj = new Pessoa();

                CarregaObjetoPessoa(obj, resultado);

                AbrirTelefones(obj);
                AbrirEmails(obj);
                AbrirEnderecos(obj);


            } 
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            
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
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where idPessoa=?");
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

    private void SalvarEmail(Pessoa pessoa, Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into emails(idPessoa,email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update emails set idPessoa = ?, email = ? where idEmail= ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void SalvarEndereco(Pessoa pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into enderecos(idPessoa,numero,"
                        + "rua,bairro,cidade,cep) values(?,?,?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getCep());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update enderecos set idPessoa=?," + "numero=?, "
                        + "rua=?, bairro=?,cidade=?, cep=? where idEndereco = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getCep());

                sql.setInt(6, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void SalvarTelefone(Pessoa pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into telefones(idPessoa,dd,telefone) values(?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDd());
                sql.setInt(3, obj.getTelefone());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update telefones set idPessoa = ?,dd=?, telefone = ? where idTelefone=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDd());
                sql.setInt(3, obj.getTelefone());
                sql.setInt(4, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public void AbrirTelefones(Pessoa pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from telefones where idPessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addTelefone(AbreTelefone(resultado));


            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Telefone AbreTelefone(ResultSet resultado) {
        Telefone tel = new Telefone();
        try {
            tel.setCodigo(resultado.getInt("codTelefone"));
            tel.setDd(resultado.getByte("DD"));
            tel.setTelefone(resultado.getInt("telefone"));
            return tel;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void AbrirEnderecos(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from enderecos where idPessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addEndereco(AbreEndereco(resultado));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());

        }
    }

    private Endereco AbreEndereco(ResultSet resultado) {
        Endereco end = new Endereco();
        try {
            end.setCodigo(resultado.getInt("idEndereco"));
            end.setCep(resultado.getString("cep"));
            end.setCidade(resultado.getString("cidade"));
            end.setBairro(resultado.getString("bairro"));
            end.setRua(resultado.getString("rua"));
            end.setNumero(resultado.getInt("numero"));
           
            return end;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    private Email AbreEmail(ResultSet resultado) {
        Email email = new Email();
        try {
            email.setCodigo(resultado.getInt("idEmail"));
            email.setEmail(resultado.getString("Email"));
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return email;

    }

    public void AbrirEmails(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from emails where idpessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addEmail(AbreEmail(resultado));

            }
        } catch (Exception ex) {
        }
    }

    protected void CarregaObjetoPessoa(T obj, ResultSet resultado) throws Exception {
        obj.setCodigo(resultado.getInt("codPessoa"));
        obj.setNome(resultado.getString("Nome"));
        obj.setDataNascimento(resultado.getDate("DataNascimento"));
        obj.setCpf(resultado.getString("CPF"));
        obj.setRg(resultado.getString("RG"));


    }
}//fim    

