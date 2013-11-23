/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Aline
 */
public class Endereco {
    private int codigo;
    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private int numero;
   // private String UF;

    public Endereco() {
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

    public String getRua() {

        return rua;

    }

    public void setRua(String rua) throws Exception {
        //Pattern patternRua;
        //patternRua = Pattern.compile("[\\w\\s]");
        //Matcher verifica = patternRua.matcher(rua);
        //if (verifica.matches()) {
            this.rua = rua;
       // } else {
       //     throw new Exception("nome inválido!");
       // }
    }

    public String getCidade() {

        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        //Pattern patternCidade;
        //patternCidade = Pattern.compile("[\\w\\s]");
        //Matcher verifica = patternCidade.matcher(cidade);
        //if (verifica.matches()) {
            this.cidade = cidade;
        //} else {
          //  throw new Exception("nome inválido!");
        //}
    }

    public String getBairro() {

        return bairro;
    }

    public void setBairro(String bairro) throws Exception {
        //Pattern patternBairro;
        //patternBairro = Pattern.compile("[\\w\\s]");
        //Matcher verifica = patternBairro.matcher(bairro);
        //if (verifica.matches()) {
            this.bairro = bairro;
        //} else {
            //throw new Exception("nome inválido!");
        //}
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws Exception {
       Pattern padraoCep = Pattern.compile("\\d{5}-\\d{3}");
        Matcher verifica = padraoCep.matcher(cep);
        if (verifica.matches()) {
            this.cep = cep;
        } else {
            throw new Exception("Formato de CEP Invalido!");
        }

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new Exception("Numero Inválido!(Somente são aceitos inteiros positivos)");
        }
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.rua);
        hash = 67 * hash + Objects.hashCode(this.cidade);
        hash = 67 * hash + Objects.hashCode(this.bairro);
        hash = 67 * hash + Objects.hashCode(this.cep);
        hash = 67 * hash + this.numero;
       // hash = 67 * hash + Objects.hashCode(this.UF);
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
        final Endereco other = (Endereco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
      //  if (!Objects.equals(this.UF, other.UF)) {
            //return false;
        //}
        return true;
    }
}
