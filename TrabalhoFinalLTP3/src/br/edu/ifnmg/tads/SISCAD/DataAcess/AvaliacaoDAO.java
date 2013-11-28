/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Anamnese;
import br.edu.ifnmg.tads.SISCAD.DomainModel.AtestadoMedico;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aline
 */
public class AvaliacaoDAO extends Dao {

    
    //Salvar avaliacao
    public boolean Salvar(Avaliacao obj, Cliente cliente) {

        if (obj.getCodigo() == 0) {
            try {

                PreparedStatement sql = getConexao().prepareStatement("insert into Avaliacao(IMC,pesoIdeal,"
                                                                      + "altura,peso,cintura,quadril,gorduraAbdominal,"
                                                                      + "bicepsDireito,bicepsEsquerdo,torax,coxaDireita,"
                                                                      + " coxaEsquerda,panturrilhaDireita,panturrilhaEsquerda,"
                                                                      + "idCliente,data,vencimento)"
                                                                      + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                sql.setDouble(1, obj.getIMC());
                sql.setDouble(2, obj.getPesoIdeal());
                sql.setDouble(3, obj.getAltura());
                sql.setDouble(4, obj.getPeso());
                sql.setDouble(5, obj.getCintura());
                sql.setDouble(6, obj.getQuadril());
                sql.setDouble(7, obj.getGorduraAbdominal());
                sql.setDouble(8, obj.getBicepsDireito());
                sql.setDouble(9, obj.getBicepsEsquerdo());
                sql.setDouble(10, obj.getTorax());
                sql.setDouble(11, obj.getCoxaDireita());
                sql.setDouble(12, obj.getCoxaEsquerda());
                sql.setDouble(13, obj.getPanturrilhaDireita());
                sql.setDouble(14, obj.getPanturrilhaEsquerda());
                sql.setDouble(15, cliente.getCodigo());
                sql.setDate(16, new java.sql.Date(obj.getData().getTime()));
                sql.setDate(17, new java.sql.Date(obj.getVencimento().getTime()));
                sql.executeUpdate();
                
                PreparedStatement sql2 = getConexao().prepareStatement("select idAvaliacao from Avaliacao where IMC=? and pesoIdeal=? and "
                                                                      + "altura=? and peso=? and cintura=? and quadril=? and gorduraAbdominal=?and "
                                                                      + "bicepsDireito=? and bicepsEsquerdo=? and torax=? and coxaDireita=? and "
                                                                      + " coxaEsquerda=? and panturrilhaDireita=? and panturrilhaEsquerda=? and "
                                                                      + "idCliente=? and data=? and vencimento=?");
                sql2.setDouble(1, obj.getIMC());
                sql2.setDouble(2, obj.getPesoIdeal());
                sql2.setDouble(3, obj.getAltura());
                sql2.setDouble(4, obj.getPeso());
                sql2.setDouble(5, obj.getCintura());
                sql2.setDouble(6, obj.getQuadril());
                sql2.setDouble(7, obj.getGorduraAbdominal());
                sql2.setDouble(8, obj.getBicepsDireito());
                sql2.setDouble(9, obj.getBicepsEsquerdo());
                sql2.setDouble(10, obj.getTorax());
                sql2.setDouble(11, obj.getCoxaDireita());
                sql2.setDouble(12, obj.getCoxaEsquerda());
                sql2.setDouble(13, obj.getPanturrilhaDireita());
                sql2.setDouble(14, obj.getPanturrilhaEsquerda());
                sql2.setDouble(15, cliente.getCodigo());
                sql2.setDate(16, new java.sql.Date(obj.getData().getTime()));
                sql2.setDate(17, new java.sql.Date(obj.getVencimento().getTime()));
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idAvaliacao"));
                }
                
                
                
                
                sql.executeUpdate();
                
                       
               return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {

                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Avaliacao set IMC=?,pesoIdeal=?,"
                                                                   + "altura=?,peso=?,cintura=?,quadril=?,gorduraAbdominal=?,"
                                                                   + "bicepsDireito=?,bicepsEsquerdo=?,torax=?,coxaDireita=?,"
                                                                   + " coxaEsquerda=?,panturrilhaDireita=?,panturrilhaEsquerda=?,"
                                                                   + "idCliente=?,data=?,vencimento=? where idAvaliacao=?");
                sqlUpdate.setDouble(1, obj.getIMC());
                sqlUpdate.setDouble(2, obj.getPesoIdeal());
                sqlUpdate.setDouble(3, obj.getAltura());
                sqlUpdate.setDouble(4, obj.getPeso());
                sqlUpdate.setDouble(5, obj.getCintura());
                sqlUpdate.setDouble(6, obj.getQuadril());
                sqlUpdate.setDouble(7, obj.getGorduraAbdominal());
                sqlUpdate.setDouble(8, obj.getBicepsDireito());
                sqlUpdate.setDouble(9, obj.getBicepsEsquerdo());
                sqlUpdate.setDouble(10, obj.getTorax());
                sqlUpdate.setDouble(11, obj.getCoxaDireita());
                sqlUpdate.setDouble(12, obj.getCoxaEsquerda());
                sqlUpdate.setDouble(13, obj.getPanturrilhaDireita());
                sqlUpdate.setDouble(14, obj.getPanturrilhaEsquerda());
                sqlUpdate.setDouble(15, cliente.getCodigo());
                sqlUpdate.setDate(16, new java.sql.Date(obj.getData().getTime()));
                sqlUpdate.setDate(17, new java.sql.Date(obj.getVencimento().getTime()));
                sqlUpdate.setInt(18, obj.getCodigo());
                
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }

    }
    
    //Salvar Atestado
    public boolean SalvarAtestadoMedico(AtestadoMedico obj, Avaliacao avaliacao) {

        if (obj.getCodigo() == 0) {
            try {

                PreparedStatement sql = getConexao().prepareStatement("insert into AtestadoMedico(DataEmissao,Medico,observacao,"
                                                                      + "idAvaliacao) values(?,?,?,?)");
                sql.setDate(1, new java.sql.Date(obj.getDataEmissao().getTime()));
                sql.setString(2, obj.getMedico());
                sql.setString(3, obj.getObservacao());
                sql.setInt(4, avaliacao.getCodigo());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {

                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Avaliacao set DataEmissao=?,medico=?,observacao=?,"
                                                                    + "idAvaliacao=? where idAtestado=?");
                sqlUpdate.setDate(1, new java.sql.Date(obj.getDataEmissao().getTime()));
                sqlUpdate.setString(2, obj.getMedico());
                sqlUpdate.setString(3, obj.getObservacao());
                sqlUpdate.setInt(4, avaliacao.getCodigo());
                sqlUpdate.setInt(5, obj.getCodigo());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    

    //Salvar Anamnese
    public boolean SalvarAnamnese(Anamnese obj, Avaliacao avaliacao) {

        if (obj.getCodigo() == 0) {
            try {

                PreparedStatement sql = getConexao().prepareStatement("insert into Anamnese(alergia, doenca,remedio, "
                                                                      + "idAvaliacao) values(?,?,?,?)");

                sql.setString(1, obj.getAlergia());
                sql.setString(2, obj.getDoenca());
                sql.setString(3, obj.getRemedio());
                sql.setInt(4, avaliacao.getCodigo());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {

                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Anamnese set alergia=?,doenca=?,remedio=?,idAvaliacao=? where idAtestado=?");
                sqlUpdate.setString(1, obj.getAlergia());
                sqlUpdate.setString(2, obj.getDoenca());
                sqlUpdate.setString(3, obj.getRemedio());
                sqlUpdate.setInt(4, avaliacao.getCodigo());
                sqlUpdate.setInt(5, obj.getCodigo());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
 
  }
    
    
    

}
