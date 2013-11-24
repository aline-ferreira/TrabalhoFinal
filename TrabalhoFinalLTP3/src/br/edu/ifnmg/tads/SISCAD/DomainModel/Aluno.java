/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aline
 */
public class Aluno {

    private int codigo;
    private Date dataIngresso;
    private int ativo;
    private List<Avaliacao> avaliacoes;
    private List<TesteCarga> testesCarga;
    private Pessoa responsavel;
    private List<Mensalidade> mensalidades;

    public Aluno(List<Avaliacao> avaliacoes, List<TesteCarga> testesCarga, List<Mensalidade> mensalidades) {
        avaliacoes = new ArrayList<Avaliacao>();
        mensalidades = new ArrayList<Mensalidade>();
        testesCarga = new ArrayList<TesteCarga>();
    }

}
