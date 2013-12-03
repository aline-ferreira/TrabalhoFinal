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
public class Horario {
    private int codigo;
    private String dia;
    private String horaEntrada;
    private String horaSaida;
    private Funcionario funcionario;

    public Horario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codigo;
        hash = 89 * hash + Objects.hashCode(this.dia);
      //  hash = 89 * hash + (int) (.doubleToLongBits(this.horaEntrada) ^ (Double.doubleToLongBits(this.horaEntrada) >>> 32));
      //  hash = 89 * hash + (int) (Double.doubleToLongBits(this.horaSaida) ^ (Double.doubleToLongBits(this.horaSaida) >>> 32));
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
        final Horario other = (Horario) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        /*if (Double.doubleToLongBits(this.horaEntrada) != Double.doubleToLongBits(other.horaEntrada)) {
            return false;
        }*/
      /*  if (Double.doubleToLongBits(this.horaSaida) != Double.doubleToLongBits(other.horaSaida)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "codigo=" + codigo + ", dia=" + dia + ", horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida + '}';
    }
    
    
    
}
