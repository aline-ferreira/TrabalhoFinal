/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aline
 */
public class Cliente extends Pessoa {

    private int codigo;
    private Date dataIngresso;
    private int ativo;
    private List<Avaliacao> avaliacoes;
    private List<TesteCarga> testesCarga;
    private Pessoa responsavel;
    private List<Mensalidade> mensalidades;

    public Cliente(List<Avaliacao> avaliacoes, List<TesteCarga> testesCarga, List<Mensalidade> mensalidades) {
        avaliacoes = new ArrayList<Avaliacao>();
        mensalidades = new ArrayList<Mensalidade>();
        testesCarga = new ArrayList<TesteCarga>();
    }

    public Cliente() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void addTesteCarga(TesteCarga teste) {
        if (!testesCarga.contains(teste)) {
            testesCarga.add(teste);
        }
    }

    public void removeTesteCarga(TesteCarga teste) {
        if (testesCarga.contains(teste)) {
            testesCarga.remove(teste);
        }
    }

    public List<TesteCarga> getTesteCarga() {
        return testesCarga;
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        if (!avaliacoes.contains(avaliacao)) {
            avaliacoes.add(avaliacao);
        }
    }

    public void removeTesteCarga(Avaliacao avaliacao) {
        if (avaliacoes.contains(avaliacao)) {
            avaliacoes.remove(avaliacao);
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    
     public void addMensalidade(Mensalidade mensalidade) {
        if (!mensalidades.contains(mensalidade)) {
            mensalidades.add(mensalidade);
        }
    }

    public void removeMensalidade(Mensalidade mensalidade) {
        if (mensalidades.contains(mensalidade)) {
            mensalidades.remove(mensalidade);
        }
    }

    public List<Mensalidade> getMensalidade() {
        return mensalidades;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.dataIngresso);
        hash = 59 * hash + this.ativo;
        hash = 59 * hash + Objects.hashCode(this.avaliacoes);
        hash = 59 * hash + Objects.hashCode(this.testesCarga);
        hash = 59 * hash + Objects.hashCode(this.responsavel);
        hash = 59 * hash + Objects.hashCode(this.mensalidades);
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
        final Cliente other = (Cliente) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.dataIngresso, other.dataIngresso)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.avaliacoes, other.avaliacoes)) {
            return false;
        }
        if (!Objects.equals(this.testesCarga, other.testesCarga)) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        if (!Objects.equals(this.mensalidades, other.mensalidades)) {
            return false;
        }
        return true;
    }

}
