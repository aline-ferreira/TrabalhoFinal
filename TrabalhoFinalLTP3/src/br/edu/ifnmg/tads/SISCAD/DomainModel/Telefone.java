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
public class Telefone {
    private int codigo;
    private int dd;
    private int telefone;

    //construtor
    public Telefone() {
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + this.dd;
        hash = 41 * hash + this.telefone;
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
        final Telefone other = (Telefone) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.dd != other.dd) {
            return false;
        }
        if (this.telefone != other.telefone) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "codigo=" + codigo + ", dd=" + dd + ", telefone=" + telefone + '}';
    }
    
    
    
}
