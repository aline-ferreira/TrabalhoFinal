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
public class Avaliacao {
    
    private int codigo;
    private Date data;
    private String observação;
    private Medidas medidas;
    private AtestadoMedico atestado;
    private Date validade;
    private Funcionario funcionario;//codFuncionario

    public Avaliacao() {
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservação() {
        return observação;
    }

    public void setObservação(String observação) {
        this.observação = observação;
    }

    public Medidas getMedidas() {
        return medidas;
    }

    public void setMedidas(Medidas medidas) {
        this.medidas = medidas;
    }

    public AtestadoMedico getAtestado() {
        return atestado;
    }

    public void setAtestado(AtestadoMedico atestado) {
        this.atestado = atestado;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.observação);
        hash = 53 * hash + Objects.hashCode(this.medidas);
        hash = 53 * hash + Objects.hashCode(this.atestado);
        hash = 53 * hash + Objects.hashCode(this.validade);
        hash = 53 * hash + Objects.hashCode(this.funcionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.observação, other.observação)) {
            return false;
        }
        if (!Objects.equals(this.medidas, other.medidas)) {
            return false;
        }
        if (!Objects.equals(this.atestado, other.atestado)) {
            return false;
        }
        if (!Objects.equals(this.validade, other.validade)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }
    
       
}
