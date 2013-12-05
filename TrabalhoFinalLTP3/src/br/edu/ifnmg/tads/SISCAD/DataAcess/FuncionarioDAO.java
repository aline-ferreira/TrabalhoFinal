/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Horario;
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
public class FuncionarioDAO extends PessoaDAO<Funcionario> {

    public FuncionarioDAO() {
        super();
    }

    public boolean Salvar(Funcionario obj) {

        if (obj.getCodigo() == 0) {
            super.Salvar(obj);
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Funcionario(idCargo,idFuncionario,ativo) values(?,?,?)");
                sql.setInt(1, obj.getCargo().getCodigo());
                sql.setInt(2, obj.getCodigo());
                sql.setInt(3, obj.getAtivo());
                sql.executeUpdate();
                
               for (Horario h : obj.getHorarios()) {
                    SalvarHorarios(obj, h);
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.Salvar(obj);
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Funcionario set idCargo=?, ativo= ? where idFuncionario=?");
                sqlUpdate.setInt(1, obj.getCargo().getCodigo());
                sqlUpdate.setInt(2, 1);
                sqlUpdate.setInt(3, obj.getCodigo());
                sqlUpdate.executeUpdate();
                for (Horario h : obj.getHorarios()) {
                    SalvarHorarios(obj, h);
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }

    }

    public boolean Apagar(int cod) {
        try {
            PreparedStatement sql = getConexao().
                    prepareStatement("update Funcionario set ativo = 0 where IdCliente = ?");
            sql.setInt(1, cod);
            sql.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

 public List<Funcionario> ListarFuncionarios(){
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa P join Funcionario F"
                                                                  + " on P.IdPessoa = F.IdFuncionario where F.ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Funcionario> lista = new ArrayList<Funcionario>();

            while (resultado.next()) {
                Funcionario obj = new Funcionario();

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

    public List<Funcionario> buscar(Funcionario filtro) {
         try {
            String sql = "select * from Pessoa P join Funcionario F on P.IdPessoa = F.IdFuncionario where F.ativo = 1";
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
                where = where + " F.IdFuncionario = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);


            List<Funcionario> lista = new ArrayList<Funcionario>();

            while (resultado.next()) {
                Funcionario obj = new Funcionario();

                CarregaObjetoPessoa(obj, resultado);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public Funcionario AbrirFuncionario(int id) {
        try {
            Funcionario funcionario = new Funcionario();

            super.AbrirPessoa(funcionario,id);

            CargoDAO cargoDAO = new CargoDAO();

            PreparedStatement sql = getConexao().prepareStatement("select * from Funcionario where idFuncionario=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                
                funcionario.setCargo(cargoDAO.Abrir(resultado.getInt("idCargo")));
                AbrirHorarios(funcionario);
                return funcionario;
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public void SalvarHorarios(Funcionario funcionario, Horario obj){
       if(obj.getCodigo()==0){
        try{
            PreparedStatement sql= getConexao().prepareStatement("insert into Horarios(dia,horaEntrada,horaSaida,IdFuncionario) values(?,?,?,?)");
            sql.setString(1, obj.getDia());
            sql.setString(2, obj.getHoraEntrada());
            sql.setString(3, obj.getHoraSaida());
            sql.setInt(4, obj.getFuncionario().getCodigo());
            sql.executeUpdate();
          } catch(Exception ex){               
              System.err.println(ex.getMessage());
          }
        
       }else{
           try{
           PreparedStatement sql= getConexao().prepareStatement("update Horarios set dia=?,horaEntrada=?,horaSaida=?,IdFuncionario=? where IdHorario=?");
            sql.setString(1, obj.getDia());
            sql.setString(2, obj.getHoraEntrada());
            sql.setString(3, obj.getHoraSaida());
            sql.setInt(4, obj.getFuncionario().getCodigo());
            sql.setInt(5,obj.getCodigo());
            sql.executeQuery();
           }catch(Exception ex){
               
           }
       }
        
    }
    
 private  Horario AbreHorario(ResultSet resultado){
     try{  
        Horario horario = new Horario();
        horario.setCodigo(resultado.getInt("IdHorario"));
        horario.setDia(resultado.getString("dia"));
        horario.setHoraEntrada(resultado.getString("horaEntrada"));
        horario.setHoraSaida(resultado.getString("horaSaida"));
        return horario;
        
      }catch(Exception ex){
         System.err.println(ex.getMessage());
         return null; 
      }
     
  }
    
    public void AbrirHorarios(Funcionario funcionario){
        
        try{
            PreparedStatement sql= getConexao().prepareStatement("select * from Horarios where IdFuncionario=?");
            sql.setInt(1, funcionario.getCodigo());
            
            ResultSet resultado= sql.executeQuery();
             while(resultado.next()){
                 funcionario.addHorario(AbreHorario(resultado));
             }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
        
    }
}
