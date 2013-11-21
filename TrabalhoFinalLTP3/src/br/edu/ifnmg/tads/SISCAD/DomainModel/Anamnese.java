/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.Objects;

/**
 *
 * @author Aline
 */
public class Anamnese {
     private int codigo;
    private String Alergia;
    private String doenca;
    private String cardiopatia;
    private String remedio;

    //construtor
    public Anamnese() {
        
    }
    
    //Getters Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAlergia() {
        return Alergia;
    }

    public void setAlergia(String Alergia) {
        this.Alergia = Alergia;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getCardiopatia() {
        return cardiopatia;
    }

    public void setCardiopatia(String cardiopatia) {
        this.cardiopatia = cardiopatia;
    }

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }
    
    //hashCodealeg
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.Alergia);
        hash = 29 * hash + Objects.hashCode(this.doenca);
        hash = 29 * hash + Objects.hashCode(this.cardiopatia);
        hash = 29 * hash + Objects.hashCode(this.remedio);
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anamnese other = (Anamnese) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.Alergia, other.Alergia)) {
            return false;
        }
        if (!Objects.equals(this.doenca, other.doenca)) {
            return false;
        }
        if (!Objects.equals(this.cardiopatia, other.cardiopatia)) {
            return false;
        }
        if (!Objects.equals(this.remedio, other.remedio)) {
            return false;
        }
        return true;
    }
    
    
    
}
