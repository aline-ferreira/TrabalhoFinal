/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhofinalltp3;

import br.edu.ifnmg.tads.SISCAD.DataAcess.AvaliacaoDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.CargoDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.ClienteDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.FuncionarioDAO;
import br.edu.ifnmg.tads.SISCAD.DataAcess.PessoaDAO;
import br.edu.ifnmg.tads.SISCAD.DomainModel.AtestadoMedico;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Avaliacao;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Cargo;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Cliente;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Email;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Endereco;
import br.edu.ifnmg.tads.SISCAD.DomainModel.Funcionario;
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
        Pessoa pessoa= new Pessoa();
        Telefone tel=new Telefone();
        Email email= new Email();
        Endereco endereco= new Endereco();
        Funcionario func= new Funcionario();
        FuncionarioDAO dao2=new FuncionarioDAO();
        CargoDAO dao3= new CargoDAO();
        PessoaDAO dao= new PessoaDAO();
        Avaliacao ava= new Avaliacao();
        
        AvaliacaoDAO dao4= new AvaliacaoDAO();
        Cliente cli = new Cliente();
        ClienteDAO dao5 = new ClienteDAO();
        AtestadoMedico at= new AtestadoMedico();
        
        
        Cargo cargo = new Cargo();
        
        
       
        
        cli.setNome("joao");
        cli.setRg("12345");
        cli.setCpf("999.999.999-00");
        cli.setSexo("M");
        cli.setDataNascimento(new Date());
  
        tel.setDd(12);
        tel.setTelefone(123456);
        email.setEmail("aline@abc.com");
        
        endereco.setBairro("abc");
        endereco.setCep("39480-000");
        endereco.setCidade("janu");
        endereco.setNumero(375);
        endereco.setRua("d");
        
        cli.addEmail(email);
        cli.addEndereco(endereco);
        cli.addTelefone(tel);
       
        
        
        //dao.Salvar(pessoa);
       ava.setAltura(3);
       ava.setBicepsDireito(2);
       ava.setBicepsEsquerdo(8);
       ava.setCintura(1);
       ava.setCoxaDireita(1);
       ava.setCoxaEsquerda(1);
       ava.setGorduraAbdominal(10);
       ava.setIMC(43);
       ava.setPanturrilhaDireita(1);
       ava.setPanturrilhaEsquerda(2);
       ava.setPercentualGordura(3);
       ava.setPeso(78);
       ava.setPesoIdeal(8);
       ava.setQuadril(2);
       ava.setTorax(2);
       ava.setVencimento(new Date());
       ava.setData(new Date());
       cli.setAtivo(1);
       
       dao5.Salvar(cli);
       at.setDataEmissao(new Date());
       at.setMedico("joao");
       at.setObservacao("abcdefghijklmnop");
       dao4.Salvar(ava, cli);
      // dao4.SalvarAtestadoMedico(at, ava);
     //  dao4.AbrirAtestado(ava);
          
       /* func.setPessoa(pessoa);
        func.setCargo(cargo);
        func.setAtivo(1);
        
        
      
        dao2.Salvar(func);
        GrupoMuscular grupo= new GrupoMuscular();
        GrupoMuscularDAO dao= new GrupoMuscularDAO();
        grupo.setNome("peitoral");
        dao.Salvar(grupo);*/
        
    }
    
}
