/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
//import java.sql.Date;

/**
 *
 * @author Aline
 */
public class Mensalidade {

    private int codigo;
    private double valor;
    private Date dataVencimento;
    private double desconto;
    private String status;
    private Double debito;

   
    public Mensalidade() {
      
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) throws Exception {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(dataVencimento)) {
            this.dataVencimento = dataVencimento;
        } else {
            throw new Exception("Valor passado para o campo 'Data' é invalido!");
        }
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {

        this.desconto = desconto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == "1") {
            if (this.dataVencimento.before(new Date())) {
                this.status = "vencida";
            }
            if (this.dataVencimento.after(new Date())) {
                this.status = "em aberto";
            }

        }
        if (((this.dataVencimento.after(new Date())) || (this.dataVencimento.before(new Date()))) && (status == "0")) {
            this.status = "pg";
        }

        if ((status != "0") && (status != "1")) {

            this.status = status;
        }

    }

    public double getDebito() {

        if (this.status == "vencida") {
            return this.debito + this.valor;
        }

        return this.debito;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.dataVencimento);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.desconto) ^ (Double.doubleToLongBits(this.desconto) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.status);
        hash = 29 * hash + Objects.hashCode(this.debito);
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
        final Mensalidade other = (Mensalidade) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        if (Double.doubleToLongBits(this.desconto) != Double.doubleToLongBits(other.desconto)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.debito, other.debito)) {
            return false;
        }
        return true;
    }

}
