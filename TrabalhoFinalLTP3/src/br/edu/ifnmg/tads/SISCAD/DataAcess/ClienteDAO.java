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
import br.edu.ifnmg.tads.SISCAD.DomainModel.Mensalidade;
import br.edu.ifnmg.tads.SISCAD.DomainModel.TesteCarga;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Treino;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
/**
 *
 * @author ALUNO
 */
public class ClienteDAO extends PessoaDAO<Cliente>{
   private AvaliacaoDAO avaliacao;
   private TesteDeCargaDAO testeCarga;
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
                
              /*
               for (Avaliacao a : obj.getAvaliacoes()) {
                    avaliacao.Salvar(a, obj);
                }
               
                for (TesteCarga t : obj.getTesteCarga()) {
                    testeCarga.SalvarTesteDeCarga(t, obj);
                }*/
                for (Mensalidade m : obj.getMensalidade()) {
                    SalvarMensalidade(obj,m);
                }
                for (Treino t : obj.getTreino()) {
                    SalvarTreino(obj,t);
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                //super.Salvar(obj);
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Cliente set ativo= ? where idCliente=?");
                sqlUpdate.setInt(1, obj.getAtivo());
                sqlUpdate.setInt(2, obj.getCodigo());
                sqlUpdate.executeUpdate();
               for (Mensalidade m : obj.getMensalidade()) {
                    SalvarMensalidade(obj,m);
                }
               for (Treino t : obj.getTreino()) {
                    SalvarTreino(obj,t);
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    
    public void SalvarMensalidade(Cliente cliente,Mensalidade obj){
        if(obj.getCodigo()==0){
        try{
            PreparedStatement sql= getConexao().prepareStatement("insert into Mensalidades(valor,desconto,vencimento,status,IdCliente) values(?,?,?,?,?)");
            sql.setDouble(1, obj.getValor());
            sql.setDouble(2, obj.getDesconto());
            sql.setDate(3, new java.sql.Date(obj.getDataVencimento().getTime()));
            sql.setString(4, obj.getStatus());
            sql.setInt(5,cliente.getCodigo());
            sql.executeUpdate();
          } catch(Exception ex){
               System.err.println(ex.getMessage());
          }
        
       }else{
           try{
           PreparedStatement sql= getConexao().prepareStatement("update Mensalidades set valor=?,desconto=?,vencimento=?,status=?,IdCliente=? where IdMensalidade=?");
            sql.setDouble(1, obj.getValor());
            sql.setDouble(2, obj.getDesconto());
            sql.setDate(3, new java.sql.Date(obj.getDataVencimento().getTime()));
            sql.setString(4, obj.getStatus());
            sql.setInt(5,cliente.getCodigo());
            sql.setInt(6,obj.getCodigo());
            sql.executeQuery();
           }catch(Exception ex){
               
           }
       }
        
    }
    
 private  Mensalidade AbreMensalidade(ResultSet resultado){
     try{  
       Mensalidade mensalidade = new Mensalidade();
       mensalidade.setCodigo(resultado.getInt("IdMensalidade"));
       mensalidade.setDataVencimento(resultado.getDate("vencimento"));
       mensalidade.setDesconto(resultado.getDouble("desconto"));
       mensalidade.setStatus(resultado.getString("status"));
       mensalidade.setValor(resultado.getDouble("valor"));
      
       return mensalidade;
        
        
      }catch(Exception ex){
         System.err.println(ex.getMessage());
         return null; 
      }
     
  }
 
 public void AbrirMensalidades(Cliente cliente){
        
        try{
            PreparedStatement sql= getConexao().prepareStatement("select*from Mensalidades where IdCliente=?");
            sql.setInt(1, cliente.getCodigo());
            
            ResultSet resultado= sql.executeQuery();
             while(resultado.next()){
                 cliente.addMensalidade(AbreMensalidade(resultado));
             }
        }catch(Exception ex){
           System.err.println(ex.getMessage()); 
        }
        
        
    }
    
   public Mensalidade AbrirMensalidade(int id){
        
        try{
            PreparedStatement sql= getConexao().prepareStatement("select*from Mensalidades where IdMensalidade=?");
            sql.setInt(1, id);
            
            ResultSet resultado= sql.executeQuery();
             
       Mensalidade mensalidade = new Mensalidade();
       mensalidade.setCodigo(resultado.getInt("IdMensalidade"));
       mensalidade.setDataVencimento(resultado.getDate("vencimento"));
       mensalidade.setDesconto(resultado.getDouble("desconto"));
       mensalidade.setStatus(resultado.getString("status"));
       mensalidade.setValor(resultado.getDouble("valor"));
      
       return mensalidade;
        
            
        }catch(Exception ex){
           System.err.println(ex.getMessage()); 
           return null;
        }
       
        
        
    }
    
     public boolean Apagar(int cod) {
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
    
 public List<Cliente> Listar(){
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa P join Cliente C on P.IdPessoa = C.IdCliente  where C.ativo=1");

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
 

    public Cliente AbrirCliente(int id) {
        try {
           Cliente cliente = new Cliente();

            super.AbrirPessoa(cliente,id);

            AvaliacaoDAO avaliacao= new AvaliacaoDAO();
            TesteDeCargaDAO teste = new TesteDeCargaDAO();
            

            PreparedStatement sql = getConexao().prepareStatement("select * from Cliente where idCliente=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                cliente.setCodigo(resultado.getInt("IdCliente"));
                avaliacao.AbrirAvaliações(cliente);
                //teste.AbrirTestesCarga(cliente);
                AbrirMensalidades(cliente);
                AbrirTreinos(cliente);
                
                return cliente;
                
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
      
    }
    
    
      public void SalvarTreino(Cliente cliente,Treino obj){
        if(obj.getCodigo()==0){
        try{
            PreparedStatement sql= getConexao().prepareStatement("insert into Treino(repeticoes,duracao,IdExercicio,"
                                                                  + "IdCliente,carga,serie) values(?,?,?,?,?,?)");
            sql.setDouble(1, obj.getRepetições());
            sql.setDouble(2, obj.getDuração());
            sql.setInt(3, obj.getExercicio().getCodigo());
            sql.setInt(4,cliente.getCodigo());
            sql.setDouble(5,obj.getCarga());
            sql.setInt(6,obj.getSerie());
            sql.executeUpdate();
          } catch(Exception ex){
               System.err.println(ex.getMessage());
          }
        
       }else{
           try{
            PreparedStatement sql= getConexao().prepareStatement("update Treino set repeticoes=?,duracao=?,IdExercicio=?,"
                                                                   + "idCliente=?,carga=?,serie=? where IdTreino=?");
            sql.setDouble(1, obj.getRepetições());
            sql.setDouble(2, obj.getDuração());
            sql.setInt(3, obj.getExercicio().getCodigo());
            sql.setInt(4,cliente.getCodigo());
            sql.setDouble(5,obj.getCarga());
             sql.setInt(6,obj.getSerie());
            sql.setInt(7,obj.getCodigo());
            
            sql.executeUpdate();
           
            sql.executeQuery();
           }catch(Exception ex){
               
           }
       }
        
    }
      
      
  private  Treino AbreTreino(ResultSet resultado){
      ExercicioDAO exercicio= new ExercicioDAO();
     try{  
      Treino treino = new Treino();
      treino.setCodigo(resultado.getInt("IdTreino"));
      treino.setDuração(resultado.getDouble("duracao"));
      treino.setRepetições(resultado.getInt("repeticoes"));
      treino.setCarga(resultado.getDouble("carga"));
      treino.setExercicio(exercicio.AbrirExercicio(resultado.getInt("IdExercicio")));
      treino.setSerie(resultado.getInt("serie"));
       
      
       return treino;
        
        
      }catch(Exception ex){
         System.err.println(ex.getMessage());
         return null; 
      }
     
  }
    
   public void AbrirTreinos(Cliente cliente){
        
        try{
            PreparedStatement sql= getConexao().prepareStatement("select*from Treino where IdCliente=?");
            sql.setInt(1, cliente.getCodigo());
            
            ResultSet resultado= sql.executeQuery();
             while(resultado.next()){
                 cliente.addTreino(AbreTreino(resultado));
             }
        }catch(Exception ex){
           System.err.println(ex.getMessage()); 
        }
        
        
    }
    
    
}
