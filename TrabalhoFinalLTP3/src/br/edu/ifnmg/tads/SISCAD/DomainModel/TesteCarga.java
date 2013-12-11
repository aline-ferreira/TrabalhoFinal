/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.Date;

/**
 *
 * @author Aline
 */
public class TesteCarga {
    private int codigo;
    private double cargaSupramaxima;
    private int repeticoesMaximas;
    private Date data;
    private Funcionario funcionario;
    private Aparelho aparelho;
    
    public TesteCarga() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    
    public double getCargaSupramaxima() {
        return cargaSupramaxima;
    }

    public void setCargaSupramaxima(double cargaSupramaxima) {
        this.cargaSupramaxima = cargaSupramaxima;
    }

    public int getRepeticoesMaximas() {
        return repeticoesMaximas;
    }

    public void setRepeticoesMaximas(int repeticoesMaximas) {
        this.repeticoesMaximas = repeticoesMaximas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
       
}
