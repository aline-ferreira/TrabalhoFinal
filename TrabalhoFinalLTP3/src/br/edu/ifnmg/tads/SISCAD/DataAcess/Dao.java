/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SISCAD.DataAcess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ALUNO
 */
public class Dao {
    
    private Connection conexao;
    
    public Dao() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
            
        } catch (Exception ex) {

            System.err.print(ex.getMessage());
        }
    }

    public java.sql.Connection getConexao() {

        return conexao;


    }
    
}
