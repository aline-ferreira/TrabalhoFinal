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
    private String observacao;
    private Medidas medidas;
    private AtestadoMedico atestado;
    private Date vencimento;
    private Funcionario funcionario;//codFuncionario
    private Aluno aluno;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

  
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.observacao);
        hash = 53 * hash + Objects.hashCode(this.medidas);
        hash = 53 * hash + Objects.hashCode(this.atestado);
        hash = 53 * hash + Objects.hashCode(this.vencimento);
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
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.medidas, other.medidas)) {
            return false;
        }
        if (!Objects.equals(this.atestado, other.atestado)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }
    
       
}
