/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Hibernate;

/**
 *
 * @author lukas
 */
public class GenericDao<T> {
   private EntityManager conexao;
    
    public GenericDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uP");
        EntityManager em = emf.createEntityManager();   
       this.conexao = em;
    }
    
    public void Salvar(T objeto){
        conexao.getTransaction().begin();
        conexao.persist(objeto);
        conexao.getTransaction().commit();
        conexao.close();
    
    }
    
    
}
