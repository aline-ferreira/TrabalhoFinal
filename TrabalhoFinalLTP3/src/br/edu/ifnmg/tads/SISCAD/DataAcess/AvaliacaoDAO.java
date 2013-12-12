/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Anamnese;
import br.edu.ifnmg.tads.SISCAD.DomainModel.AtestadoMedico;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao; 
import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aline
 */
public class AvaliacaoDAO<T extends Avaliacao> extends Dao {

    //Salvar avaliacao
    public boolean Salvar(Avaliacao obj, Cliente cliente) {

        if (obj.getCodigo() == 0) {
            try {

                PreparedStatement sql = getConexao().prepareStatement("insert into Avaliacao(IMC,pesoIdeal,"
                        + "altura,peso,cintura,quadril,gorduraAbdominal,"
                        + "bicepsDireito,bicepsEsquerdo,torax,coxaDireita,"
                        + " coxaEsquerda,panturrilhaDireita,panturrilhaEsquerda,"
                        + "idCliente,data,vencimento,IdFuncionario)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
                sql.setInt(18,obj.getFuncionario().getCodigo());
                sql.executeUpdate();
                
               

                //Pega o ID do objeto
                PreparedStatement sql2 = getConexao().prepareStatement("select idAvaliacao from Avaliacao where IMC=? and pesoIdeal=? and "
                        + "altura=? and peso=? and cintura=? and quadril=? and gorduraAbdominal=?and "
                        + "bicepsDireito=? and bicepsEsquerdo=? and torax=? and coxaDireita=? and "
                        + " coxaEsquerda=? and panturrilhaDireita=? and panturrilhaEsquerda=? and "
                        + "idCliente=? and data=? and vencimento=? and IdFuncionario=?" );
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
                sql2.setInt(18,obj.getFuncionario().getCodigo());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idAvaliacao"));
                }
                
               SalvarAtestadoMedico( obj.getAtestado(),obj);
               SalvarAnamnese(obj.getAnamnese(),obj);

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {

                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Avaliacao set  IMC=?,pesoIdeal=?,"
                        + "altura=?,peso=?,cintura=?,quadril=?,gorduraAbdominal=?,"
                        + "bicepsDireito=?,bicepsEsquerdo=?,torax=?,coxaDireita=?,"
                        + " coxaEsquerda=?,panturrilhaDireita=?,panturrilhaEsquerda=?,"
                        + "idCliente=?,data=?,vencimento=?, IdFuncionario=? where idAvaliacao=?");
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
                sqlUpdate.setInt(18,obj.getFuncionario().getCodigo());
                sqlUpdate.setInt(19, obj.getCodigo());
                
                SalvarAtestadoMedico(obj.getAtestado(),obj);
                SalvarAnamnese(obj.getAnamnese(),obj);

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
                PreparedStatement sqlUpdate = con.prepareStatement("update Anamnese set alergia=?,doenca=?,remedio=?,idAvaliacao=? where idAnamnese=?");
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

    public AtestadoMedico AbrirAtestado(int Id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from AtestadoMedico where idAvaliacao=?");
            sql.setInt(1, Id);

            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                AtestadoMedico obj = new AtestadoMedico();
                obj.setCodigo(resultado.getInt("idAtestadoMedico"));
                obj.setDataEmissao(resultado.getDate("DataEmissao"));
                obj.setMedico(resultado.getString("Medico"));
                obj.setObservacao(resultado.getString("observacao"));
                return obj;
                  //  avaliacao.setAtestado(obj);
            }else{
                return null; 
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
             return null;
        }
       
    }

    public  Anamnese AbrirAnamnese(int Id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Anamnese where idAvaliacao=?");
            sql.setInt(1,Id);

            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                Anamnese obj = new Anamnese();
                obj.setCodigo(resultado.getInt("idAnamnese"));
                obj.setAlergia(resultado.getString("Alergia"));
                obj.setDoenca(resultado.getString("Doenca"));
                obj.setRemedio(resultado.getString("remedio"));
                return obj;

               // avaliacao.setAnamnese(obj);
            }else{
                return null;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
 public Avaliacao AbreAvaliacao(ResultSet resultado) {
        Avaliacao avaliacao = new Avaliacao();
        FuncionarioDAO  funcionario = new FuncionarioDAO();
        try {
            avaliacao.setCodigo(resultado.getInt("IdAvaliacao"));
            avaliacao.setAltura(resultado.getDouble("Altura"));
            avaliacao.setBicepsDireito(resultado.getDouble("BicepsDireito"));
            avaliacao.setBicepsEsquerdo(resultado.getDouble("BicepsEsquerdo"));
            avaliacao.setCintura(resultado.getDouble("cintura"));
            avaliacao.setCoxaDireita(resultado.getDouble("coxaDireita"));
            avaliacao.setCoxaEsquerda(resultado.getDouble("coxaEsquerda"));
            avaliacao.setGorduraAbdominal(resultado.getDouble("gorduraAbdominal"));
            avaliacao.setAltura(resultado.getDouble("altura"));
            avaliacao.setPanturrilhaDireita(resultado.getDouble("panturrilhaDireita"));
            avaliacao.setPanturrilhaEsquerda(resultado.getDouble("panturrilhaEsquerda"));
            avaliacao.setIMC(resultado.getDouble("IMC"));
            avaliacao.setTorax(resultado.getDouble("torax"));
            avaliacao.setPeso(resultado.getDouble("peso"));
            avaliacao.setPesoIdeal(resultado.getDouble("PesoIdeal"));
            avaliacao.setData(resultado.getDate("data"));
            avaliacao.setVencimento(resultado.getDate("vencimento"));
            avaliacao.setAtestado(AbrirAtestado(resultado.getInt("IdAvaliacao")));
            avaliacao.setAnamnese(AbrirAnamnese(resultado.getInt("IdAvaliacao")));
            avaliacao.setFuncionario(funcionario.AbrirFuncionario(resultado.getInt("IdFuncionario")));
            
            return avaliacao;
            
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
 }
 public void AbrirAvaliações(Cliente cliente) {
      
     try {
            PreparedStatement sql = getConexao().prepareStatement("select*from Avaliacao where idCliente=?");
            sql.setInt(1, cliente.getCodigo());

            ResultSet resultado = sql.executeQuery();
            

            while (resultado.next()) {
                cliente.addAvaliacao(AbreAvaliacao(resultado));

            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
 
 public Avaliacao AbrirAvaliacaoRecente(Cliente cliente){
     
    Avaliacao avaliacao = new Avaliacao();
    FuncionarioDAO  funcionario = new FuncionarioDAO();
    
     try{ 
         PreparedStatement sql= getConexao().prepareStatement("select max(IdAvaliacao)from Avaliacao where IdCliente=?");
         sql.setInt(1, cliente.getCodigo());
      
         
         ResultSet result = sql.executeQuery();
            avaliacao.setCodigo(result.getInt("IdAvaliacao"));
            
         PreparedStatement sql2= getConexao().prepareStatement("select * avaliacao from where IdAvaliacao=?");
         sql2.setInt(1, avaliacao.getCodigo());
      
         
         ResultSet resultado = sql.executeQuery();
            
         if(resultado.next()){
            avaliacao.setCodigo(resultado.getInt("IdAvaliacao"));
            avaliacao.setAltura(resultado.getDouble("Altura"));
            avaliacao.setBicepsDireito(resultado.getDouble("BicepsDireito"));
            avaliacao.setBicepsEsquerdo(resultado.getDouble("BicepsEsquerdo"));
            avaliacao.setCintura(resultado.getDouble("cintura"));
            avaliacao.setCoxaDireita(resultado.getDouble("coxaDireita"));
            avaliacao.setCoxaEsquerda(resultado.getDouble("coxaEsquerda"));
            avaliacao.setGorduraAbdominal(resultado.getDouble("gorduraAbdominal"));
            avaliacao.setAltura(resultado.getDouble("altura"));
            avaliacao.setPanturrilhaDireita(resultado.getDouble("panturrilhaDireita"));
            avaliacao.setPanturrilhaEsquerda(resultado.getDouble("panturrilhaEsquerda"));
            avaliacao.setIMC(resultado.getDouble("IMC"));
            avaliacao.setTorax(resultado.getDouble("torax"));
            avaliacao.setPeso(resultado.getDouble("peso"));
            avaliacao.setPesoIdeal(resultado.getDouble("PesoIdeal"));
            avaliacao.setData(resultado.getDate("data"));
            avaliacao.setVencimento(resultado.getDate("vencimento"));
            avaliacao.setAtestado(AbrirAtestado(resultado.getInt("IdAvaliacao")));
            avaliacao.setAnamnese(AbrirAnamnese(resultado.getInt("IdAvaliacao")));
            avaliacao.setFuncionario(funcionario.AbrirFuncionario(resultado.getInt("IdFuncionario")));
            
            return avaliacao;
         }else{
             return null;
         }
         
      } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
          
     
 }
 

    
}//fim

