/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aline
 */
public class Funcionario extends Pessoa {

    
    private int codigo;
    private Cargo cargo;
    private Pessoa pessoa;
    private int ativo;
    private List<Horario> horarios;
    
    public Funcionario(List<Horario> horarios) {
        
        horarios= new ArrayList<Horario>();
    }

    public Funcionario() {
        horarios= new ArrayList<Horario>();
    }
    

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
     public void addHorario(Horario horario) {
        if (!horarios.contains(horario)) {
            horarios.add(horario);
        }
    }

    public void removeHorario(Horario horario) {
        if (horarios.contains(horario)) {
            horarios.remove(horario);
        }
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.cargo);
        hash = 29 * hash + Objects.hashCode(this.pessoa);
        hash = 29 * hash + this.ativo;
        hash = 29 * hash + Objects.hashCode(this.horarios);
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
        final Funcionario other = (Funcionario) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.horarios, other.horarios)) {
            return false;
        }
        return true;
    }


  
    
}
