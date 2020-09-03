
import dao.ClienteDao;
import dao.EnderecoDao;
import model.Cliente;
import model.Endereco;
import org.junit.Test;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukas
 */

public class TestClass {
    
    public void testeSaveEndereco(){
    
        EnderecoDao con = new EnderecoDao();
        Endereco endereco = new Endereco(null, "112", "joana marques", "passo fundo", "rs");
        
        con.salvar(endereco);
        
        con.getConexao().close();
        
    }
    @Test
    public void testeClienteEndereco(){
        ClienteDao con = new ClienteDao();
        Cliente cliente = new Cliente(6, "ana", "ana@hotmail.com", new Endereco(null, "112", "joana marques", "paso fundo", "rs"));
        con.salvar(cliente);
        con.getConexao().close();
    }
    
}
