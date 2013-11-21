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
public class Medidas {
    private int codigo;
    private double altura;
    private double peso;
    private double cintura;
    private double quadril;
    private double gorduraAbdominal;
    private double bicepsDireito;
    private double bicepsEsquerdo;
    private double coxaDireita;
    private double coxaEsquerda;
    private double torax;
    private double percentualGordura;
    private double panturrilhaDireita;
    private double panturrilhaEsquerda;

    //Construtor
    public Medidas() {
        
    }

    //Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getGorduraAbdominal() {
        return gorduraAbdominal;
    }

    public void setGorduraAbdominal(double gorduraAbdominal) {
        this.gorduraAbdominal = gorduraAbdominal;
    }

    public double getBicepsDireito() {
        return bicepsDireito;
    }

    public void setBicepsDireito(double bicepsDireito) {
        this.bicepsDireito = bicepsDireito;
    }

    public double getBicepsEsquerdo() {
        return bicepsEsquerdo;
    }

    public void setBicepsEsquerdo(double bicepsEsquerdo) {
        this.bicepsEsquerdo = bicepsEsquerdo;
    }

    public double getCoxaDireita() {
        return coxaDireita;
    }

    public void setCoxaDireita(double coxaDireita) {
        this.coxaDireita = coxaDireita;
    }

    public double getCoxaEsquerda() {
        return coxaEsquerda;
    }

    public void setCoxaEsquerda(double coxaEsquerda) {
        this.coxaEsquerda = coxaEsquerda;
    }

    public double getTorax() {
        return torax;
    }

    public void setTorax(double torax) {
        this.torax = torax;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public double getPanturrilhaDireita() {
        return panturrilhaDireita;
    }

    public void setPanturrilhaDireita(double panturrilhaDireita) {
        this.panturrilhaDireita = panturrilhaDireita;
    }

    public double getPanturrilhaEsquerda() {
        return panturrilhaEsquerda;
    }

    public void setPanturrilhaEsquerda(double panturrilhaEsquerda) {
        this.panturrilhaEsquerda = panturrilhaEsquerda;
    }

    //Equals   
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medidas other = (Medidas) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cintura) != Double.doubleToLongBits(other.cintura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quadril) != Double.doubleToLongBits(other.quadril)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gorduraAbdominal) != Double.doubleToLongBits(other.gorduraAbdominal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bicepsDireito) != Double.doubleToLongBits(other.bicepsDireito)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bicepsEsquerdo) != Double.doubleToLongBits(other.bicepsEsquerdo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.coxaDireita) != Double.doubleToLongBits(other.coxaDireita)) {
            return false;
        }
        if (Double.doubleToLongBits(this.coxaEsquerda) != Double.doubleToLongBits(other.coxaEsquerda)) {
            return false;
        }
        if (Double.doubleToLongBits(this.torax) != Double.doubleToLongBits(other.torax)) {
            return false;
        }
        if (Double.doubleToLongBits(this.percentualGordura) != Double.doubleToLongBits(other.percentualGordura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.panturrilhaDireita) != Double.doubleToLongBits(other.panturrilhaDireita)) {
            return false;
        }
        if (Double.doubleToLongBits(this.panturrilhaEsquerda) != Double.doubleToLongBits(other.panturrilhaEsquerda)) {
            return false;
        }
        return true;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.cintura) ^ (Double.doubleToLongBits(this.cintura) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.quadril) ^ (Double.doubleToLongBits(this.quadril) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.gorduraAbdominal) ^ (Double.doubleToLongBits(this.gorduraAbdominal) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.bicepsDireito) ^ (Double.doubleToLongBits(this.bicepsDireito) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.bicepsEsquerdo) ^ (Double.doubleToLongBits(this.bicepsEsquerdo) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.coxaDireita) ^ (Double.doubleToLongBits(this.coxaDireita) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.coxaEsquerda) ^ (Double.doubleToLongBits(this.coxaEsquerda) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.torax) ^ (Double.doubleToLongBits(this.torax) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.percentualGordura) ^ (Double.doubleToLongBits(this.percentualGordura) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.panturrilhaDireita) ^ (Double.doubleToLongBits(this.panturrilhaDireita) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.panturrilhaEsquerda) ^ (Double.doubleToLongBits(this.panturrilhaEsquerda) >>> 32));
        return hash;
    }
    
    
    
    
    
}
