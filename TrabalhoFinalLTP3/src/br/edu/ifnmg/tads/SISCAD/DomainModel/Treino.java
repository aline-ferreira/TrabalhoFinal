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
public class Treino {
    private int codigo;
    private int repetições;
    private int serie;
    private double duração;
    private double carga;
    private String tipo;
    private Exercicio exercicio;

    public Treino() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getRepetições() {
        return repetições;
    }

    public void setRepetições(int repetições) {
        this.repetições = repetições;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public double getDuração() {
        return duração;
    }

    public void setDuração(double duração) {
        this.duração = duração;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
    
}
