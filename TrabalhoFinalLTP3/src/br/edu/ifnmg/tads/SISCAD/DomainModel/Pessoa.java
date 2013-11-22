/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Aline
 */
public class Pessoa {
    
    private int codigo;
    private String nome;
    private String Rg;
    private String Cpf;
    private Date DataNascimento;
    private String sexo;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    public Pessoa() {
        codigo = 0;
        emails = new ArrayList<Email>();
        enderecos = new ArrayList<Endereco>();
        telefones = new ArrayList<Telefone>();
    }

    public int getCodigo() {
        return codigo;
    }
    
       public void addEmail(Email email) {
        if (!emails.contains(email)) {
            emails.add(email);
        }
    }

    public void removeEmail(Email email) {
        if (emails.contains(email)) {
            emails.remove(email);
        }
    }

    public List<Email> getEmails() {
        return emails;
    }
    
    

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo Inválido!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        Pattern patternNome;
        patternNome = Pattern.compile("[\\w\\s],{3,}");
        Matcher verifica = patternNome.matcher(nome);
        if (verifica.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Codigo Inválido!(Somente são aceitos nomes com"
                    + "no minimo 3 caracters e inicial maiuscula)");
        }

    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) throws Exception {
        Pattern padraoCpf = Pattern.compile("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
        Matcher verifica = padraoCpf.matcher(Cpf);
        if (verifica.matches()) {
            this.Cpf = Cpf;
        } else {
            throw new Exception("CPF Invalido!(formato: 999.999.999-99)");
        }
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(DataNascimento)) {
            this.DataNascimento = DataNascimento;
        }
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.Rg);
        hash = 41 * hash + Objects.hashCode(this.Cpf);
        hash = 41 * hash + Objects.hashCode(this.DataNascimento);
       // hash = 41 * hash + this.sexo;
        hash = 41 * hash + Objects.hashCode(this.emails);
        hash = 41 * hash + Objects.hashCode(this.enderecos);
        hash = 41 * hash + Objects.hashCode(this.telefones);
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
        final Pessoa other = (Pessoa) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.Rg, other.Rg)) {
            return false;
        }
        if (!Objects.equals(this.Cpf, other.Cpf)) {
            return false;
        }
        if (!Objects.equals(this.DataNascimento, other.DataNascimento)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        return true;
    }

    public void getDataNascimento(String dataNascimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }







}


