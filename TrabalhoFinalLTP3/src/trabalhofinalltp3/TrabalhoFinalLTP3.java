/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhofinalltp3;

import br.edu.ifnmg.tads.SISCAD.DataAcess.PessoaDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Email;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Endereco;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Pessoa;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Telefone;
import java.util.Date;

/**
 *
 * @author Aline
 */
public class TrabalhoFinalLTP3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Pessoa pessoa =new Pessoa();
        Telefone tel=new Telefone();
        Email email= new Email();
        Endereco endereco= new Endereco();
        PessoaDAO dao= new PessoaDAO();
        
        pessoa.setNome("Aline");
        pessoa.setRg("12345");
        pessoa.setCpf("999.999.999-00");
        pessoa.setSexo("F");
        pessoa.setDataNascimento(new Date());
  
        tel.setDd(12);
        tel.setTelefone(123456);
        email.setEmail("aline@abc.com");
        
        endereco.setBairro("abc");
        endereco.setCep("39480-000");
        endereco.setCidade("janu");
        endereco.setNumero(375);
        endereco.setRua("d");
        
        pessoa.addEmail(email);
        pessoa.addEndereco(endereco);
        pessoa.addTelefone(tel);
        
        dao.Salvar(pessoa);
        
    }
    
}
