/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Aline
 */
public class AtestadoMedico {
 
    private int codigo;
    private Date dataEmissao;
    private String Medico;
    private String observacao;
    
    //construtor
    public AtestadoMedico() {
    }

    //getters setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getMedico() {
        return Medico;
    }

    public void setMedico(String Medico) {
        this.Medico = Medico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    //hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.dataEmissao);
        hash = 47 * hash + Objects.hashCode(this.Medico);
        hash = 47 * hash + Objects.hashCode(this.observacao);
        return hash;
    }
    
//equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtestadoMedico other = (AtestadoMedico) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.dataEmissao, other.dataEmissao)) {
            return false;
        }
        if (!Objects.equals(this.Medico, other.Medico)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        return true;
    }
    
    
    
}
