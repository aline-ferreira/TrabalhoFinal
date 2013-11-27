/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.AtestadoMedico;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Aline
 */
public class AvaliacaoDAO extends Dao {

    public boolean Salvar(Avaliacao obj, Pessoa pessoa) {

        if (obj.getCodigo() == 0) {
            try {

                PreparedStatement sql = getConexao().prepareStatement("insert into Avaliacao(IMC,pesoIdeal,"
                        + "altura,peso,cintura,quadril,gorduraAbdominal,"
                        + "bicepsDireito,bicepsEsquerdo,torax,coxaDireita,"
                        + " coxaEsquerda,panturrilhaDireita,panturrilhaEsquerda,idPessoa,data,vencimento)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                sql.setDouble(1,obj.getIMC());
                sql.setDouble(2,obj.getPesoIdeal());
                sql.setDouble(3,obj.getAltura());
                sql.setDouble(4,obj.getPeso());
                sql.setDouble(5,obj.getCintura());
                sql.setDouble(6,obj.getQuadril());
                sql.setDouble(7,obj.getGorduraAbdominal());
                sql.setDouble(8,obj.getBicepsDireito());
                sql.setDouble(9,obj.getBicepsEsquerdo());
                sql.setDouble(10,obj.getTorax());
                sql.setDouble(11,obj.getCoxaDireita());
                sql.setDouble(12,obj.getCoxaEsquerda());
                sql.setDouble(13,obj.getPanturrilhaDireita());
                sql.setDouble(14,obj.getPanturrilhaEsquerda());
                sql.setDouble(15,pessoa.getCodigo());
                sql.setDate(16, new java.sql.Date(obj.getData().getTime()));
                sql.setDate(17, new java.sql.Date(obj.getVencimento().getTime()));

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
                        + " coxaEsquerda=?,panturrilhaDireita=?,panturrilhaEsquerda=?,idPessoa=?,data=?,vencimento=? where idAvaliacao=?");
                sqlUpdate.setDouble(1,obj.getIMC());
                sqlUpdate.setDouble(2,obj.getPesoIdeal());
                sqlUpdate.setDouble(3,obj.getAltura());
                sqlUpdate.setDouble(4,obj.getPeso());
                sqlUpdate.setDouble(5,obj.getCintura());
                sqlUpdate.setDouble(6,obj.getQuadril());
                sqlUpdate.setDouble(7,obj.getGorduraAbdominal());
                sqlUpdate.setDouble(8,obj.getBicepsDireito());
                sqlUpdate.setDouble(9,obj.getBicepsEsquerdo());
                sqlUpdate.setDouble(10,obj.getTorax());
                sqlUpdate.setDouble(11,obj.getCoxaDireita());
                sqlUpdate.setDouble(12,obj.getCoxaEsquerda());
                sqlUpdate.setDouble(13,obj.getPanturrilhaDireita());
                sqlUpdate.setDouble(14,obj.getPanturrilhaEsquerda());
                sqlUpdate.setDouble(15, pessoa.getCodigo());
                sqlUpdate.setDate(16, new java.sql.Date(obj.getData().getTime()));
                sqlUpdate.setDate(17, new java.sql.Date(obj.getVencimento().getTime()));
                sqlUpdate.setInt(18,obj.getCodigo());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }

    }
    
    
    public boolean SalvarAtestadoMedico(AtestadoMedico atestado, Avaliacao avaliacao){
        
        return false;
        
    }
}
