/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;

/**
 *
 * @author lukas
 */
public class ClienteDao {

    private EntityManager conexao;

    public ClienteDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uP");
        EntityManager em = emf.createEntityManager();
        this.conexao = em;
    }

    public void salvar(Cliente cliente) {
        conexao.getTransaction().begin();
        conexao.persist(cliente);
        conexao.getTransaction().commit();

    }

    public Cliente buscar(Cliente cliente) {
        return conexao.find(Cliente.class, cliente.id);

    }

    public void atualizar(Cliente cliente) {
        conexao.getTransaction().begin();
        conexao.merge(cliente);
        conexao.getTransaction().commit();
    }

    public void deletar(Cliente cliente) {
        conexao.getTransaction().begin();
        conexao.createNativeQuery("DELETE FROM cliente WHERE id = " + cliente.id).executeUpdate();//sempre fazer uma buscar antes de deletar, se não o delete não funciona
        conexao.getTransaction().commit();
    }

    public List<Cliente> buscarTodos() {
        List<Cliente> list = new ArrayList();
        conexao.getTransaction().begin();
        list = conexao.createNativeQuery("SELECT * FROM cliente", Cliente.class).getResultList();
        conexao.getTransaction().commit();
        return list;
    }
    
    public List<Cliente> buscarPersonalizado(String sql) {
        List<Cliente> list = new ArrayList();
        conexao.getTransaction().begin();
        list = conexao.createNativeQuery(sql, Cliente.class).getResultList();
        conexao.getTransaction().commit();
        return list;
    }
    
   

    public EntityManager getConexao() {
        return conexao;
    }

}
