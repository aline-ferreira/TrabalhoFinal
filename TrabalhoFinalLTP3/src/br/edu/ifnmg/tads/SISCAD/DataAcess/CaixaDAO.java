/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DataAcess;

import br.edu.ifnmg.tads.SISCAD.DomainModel.Caixa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aline
 */
class CaixaDAO extends Dao{
     public CaixaDAO() {
        super();
    }
    
    //Método Salvar
    
    
    
    //Método Remover
    
    
    //Método Abrir Caixa
    public Caixa AbrirCaixa(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from caixa where codCaixa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {                
                Caixa caixa = new Caixa();

                caixa.setCodigo(resultado.getInt("codCaixa"));
                caixa.setSaldo(resultado.getFloat("saldo"));
                
                return caixa;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }    
    
}
