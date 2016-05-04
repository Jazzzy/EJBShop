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
public interface UsuarioInterfazLocal {

    public String getNombre();

    public void setNombre(String nombre);

    public String getCorreoElectronico();

    public void setCorreoElectronico(String correoElectronico);

    public Carrito getCarrito();

    public void setCarrito(Carrito carrito); //TODO meter interfaz local de carrito

}
