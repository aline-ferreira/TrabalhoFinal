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
    private AtestadoMedico atestado;
    private Date vencimento;
    private Funcionario funcionario;//codFuncionario
    private double IMC;
    private double pesoIdeal;
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
    private Anamnese anamnese;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Avaliacao() {
    }

    public int getCodigo() {
        return codigo;
    }

      public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo Inválido!");
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
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

    
    public double getIMC() {
        return IMC;
    }

    public void setIMC(Double IMC) {
       
           this.IMC = IMC; 
          
    }

    public double getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigo;
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.atestado);
        hash = 79 * hash + Objects.hashCode(this.vencimento);
        hash = 79 * hash + Objects.hashCode(this.funcionario);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.IMC) ^ (Double.doubleToLongBits(this.IMC) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.pesoIdeal) ^ (Double.doubleToLongBits(this.pesoIdeal) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.cintura) ^ (Double.doubleToLongBits(this.cintura) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.quadril) ^ (Double.doubleToLongBits(this.quadril) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.gorduraAbdominal) ^ (Double.doubleToLongBits(this.gorduraAbdominal) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.bicepsDireito) ^ (Double.doubleToLongBits(this.bicepsDireito) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.bicepsEsquerdo) ^ (Double.doubleToLongBits(this.bicepsEsquerdo) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.coxaDireita) ^ (Double.doubleToLongBits(this.coxaDireita) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.coxaEsquerda) ^ (Double.doubleToLongBits(this.coxaEsquerda) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.torax) ^ (Double.doubleToLongBits(this.torax) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.percentualGordura) ^ (Double.doubleToLongBits(this.percentualGordura) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.panturrilhaDireita) ^ (Double.doubleToLongBits(this.panturrilhaDireita) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.panturrilhaEsquerda) ^ (Double.doubleToLongBits(this.panturrilhaEsquerda) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.anamnese);
        hash = 79 * hash + Objects.hashCode(this.status);
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
        if (!Objects.equals(this.atestado, other.atestado)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (Double.doubleToLongBits(this.IMC) != Double.doubleToLongBits(other.IMC)) {
            return false;
        }
        if (Double.doubleToLongBits(this.pesoIdeal) != Double.doubleToLongBits(other.pesoIdeal)) {
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
        if (!Objects.equals(this.anamnese, other.anamnese)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

   

 
    

   
       
}
