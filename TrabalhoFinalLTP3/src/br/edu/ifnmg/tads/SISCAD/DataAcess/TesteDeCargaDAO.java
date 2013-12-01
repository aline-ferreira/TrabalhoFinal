/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Cliente;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
import br.edu.ifnmg.tads.SISCAD.DomainModel.TesteCarga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aline
 */
public class TesteDeCargaDAO extends Dao {
    
    public boolean SalvarTesteDeCarga(TesteCarga obj, Cliente cliente ){
       
        if(obj.getCodigo()==0){
             try {
                
                PreparedStatement sql = getConexao().prepareStatement("insert into TesteCarga(idCliente,cargaSupraMaxima,data,"
                                                                      + "repeticoesMaximas,idAparelho, idFuncionario) values(?,?,?,?,?,?)");
                sql.setInt(1,cliente.getCodigo());
                sql.setDouble(2,obj.getCargaSupramaxima());
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                sql.setInt(4,obj.getRepeticoesMaximas());
                sql.setInt(5,obj.getAparelho().getCodigo());
                sql.setInt(6, obj.getFuncionario().getCodigo());
                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select idTesteCarga from TesteCarga where idCliente=? and "
                                                                       + "cargaSupraMaxima=? and data=? and repeticoesMaximas=? and idaparelho =?"
                                                                       + " and idFuncionario=?");
                sql2.setInt(1,cliente.getCodigo());
                sql2.setDouble(2,obj.getCargaSupramaxima());
                sql2.setDate(3, new java.sql.Date(obj.getData().getTime()));
                sql2.setInt(4,obj.getRepeticoesMaximas());
                sql2.setInt(5,obj.getAparelho().getCodigo());
                sql2.setInt(6, obj.getFuncionario().getCodigo());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idTesteCarga"));
                }
               
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("Update TesteCarga set idCliente=? , "
                                                             + "cargaSupraMaxima=? , data=?,repeticoesMaximas=?,"
                                                             + "idaparelho =?, idFuncionario=?");
                sql.setInt(1,cliente.getCodigo());
                sql.setDouble(2,obj.getCargaSupramaxima());
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                sql.setInt(4,obj.getRepeticoesMaximas());
                sql.setInt(5,obj.getAparelho().getCodigo());
                sql.setInt(6, obj.getFuncionario().getCodigo());
                sql.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
     }
    
    
     public void AbrirTestesCarga(Cliente cliente) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from TesteCarga where idAvaliacao=?");
            sql.setInt(1, cliente.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                cliente.addTesteCarga(AbreTesteCarga(resultado));


            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private TesteCarga AbreTesteCarga (ResultSet resultado) {
        TesteCarga teste = new TesteCarga();
        try {
            teste.setCodigo(resultado.getInt("idTesteCarga"));
            teste.setCargaSupramaxima(resultado.getDouble("CargaSupraMaxima"));
            teste.setData(resultado.getDate("Data"));
            teste.setRepeticoesMaximas(resultado.getInt("RepeticoesMaximas"));
            //AbrirFuncionario
            //AbrirAparelho
           
            return teste;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}//fim
    

