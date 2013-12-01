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

    public void setIMC(double IMC) {
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

    public Object getCargo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
       
}
