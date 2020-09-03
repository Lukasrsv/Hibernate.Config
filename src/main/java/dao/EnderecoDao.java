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
import model.Endereco;

/**
 *
 * @author lukas
 */
public class EnderecoDao {

    private EntityManager conexao;

    public EnderecoDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uP");
        EntityManager em = emf.createEntityManager();
        this.conexao = em;
    }

    public void salvar(Endereco endereco) {
        conexao.getTransaction().begin();
        conexao.persist(endereco);
        conexao.getTransaction().commit();

    }

    public Endereco buscar(Endereco endereco) {
        return conexao.find(Endereco.class, endereco.getId());

    }

    public void atualizar(Endereco endereco) {
        conexao.getTransaction().begin();
        conexao.merge(endereco);
        conexao.getTransaction().commit();
    }

    public void deletar(Endereco endereco) {
        conexao.getTransaction().begin();
        conexao.createNativeQuery("DELETE FROM endereco WHERE id = " + endereco.getId()).executeUpdate();//sempre fazer uma buscar antes de deletar, se não o delete não funciona
        conexao.getTransaction().commit();
    }

    public List<Endereco> buscarTodos() {
        List<Endereco> list = new ArrayList();
        conexao.getTransaction().begin();
        list = conexao.createNativeQuery("SELECT * FROM endereco", Endereco.class).getResultList();
        conexao.getTransaction().commit();
        return list;
    }
    
    public List<Endereco> buscarPersonalizado(String sql) {
        List<Endereco> list = new ArrayList();
        conexao.getTransaction().begin();
        list = conexao.createNativeQuery(sql, Endereco.class).getResultList();
        conexao.getTransaction().commit();
        return list;
    }
    
   

    public EntityManager getConexao() {
        return conexao;
    }

}
