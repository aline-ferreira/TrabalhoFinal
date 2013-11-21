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
public class Email {
     private int codigo;
    private String Email;

    public Email() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.codigo;
        hash = 17 * hash + Objects.hashCode(this.Email);
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
        final Email other = (Email) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return true;
    }
    
    
    
}
