/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Local;

/**
 *
 * @author gladi
 */
@Local
public interface DAOPedidosInterfazLocal {
    public void insertarPedido(VOPedido pedido); 
}
