/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gladi
 */
@Stateless
public class DAOPedidos implements DAOPedidosInterfazLocal, DAOPedidosInterfazRemota {

    //@PersistenceContext(unitName = "pu1")
    //protected EntityManager em;

    @Override
    public void insertarPedido(VOPedido pedido) {

        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("pu1");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

}
