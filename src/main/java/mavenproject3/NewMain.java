/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mavenproject3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;

/**
 *
 * @author lukas
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uP");
        EntityManager em = emf.createEntityManager();
        
        Cliente cliente = new Cliente(1, "joao", "joao@hotmail");
        Cliente cliente2 = new Cliente(2, "Maria", "Maria@hotmail");
        Cliente cliente3 = new Cliente(3, "Paulo", "Paulo@hotmail");
        em.getTransaction().begin();
        em.persist(cliente);
        em.persist(cliente2);
        em.persist(cliente3);
        em.getTransaction().commit();
        System.out.println("Adicionado!");
        }
        catch(RuntimeException e){
            e.printStackTrace();
        
        }
        
    }
    
}
