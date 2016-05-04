/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gladi
 */

@Stateless
public class DAOPedidos {
    
    @PersistenceContext(unitName = "pu1")
    protected EntityManager em;
    
    public void insertarPedido(VOPedido pedido){
    
        em.persist(pedido);
    }
    
}
