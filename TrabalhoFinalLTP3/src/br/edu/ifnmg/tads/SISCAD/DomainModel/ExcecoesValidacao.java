/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DomainModel;

/**
 *
 * @author Aline
 */
public class ExcecoesValidacao extends Exception {

    String campo;
    
    public ExcecoesValidacao(String msg, String cmp){
        super(msg);
        setCampo(cmp);
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
    

    
}
