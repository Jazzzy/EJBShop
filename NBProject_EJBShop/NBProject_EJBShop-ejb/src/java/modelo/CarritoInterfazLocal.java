/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author gladi
 */
@Local
public interface CarritoInterfazLocal {

    public boolean insertarLinea(LineaCarrito lc);

    /*Esta función si es necesaria en carrito pues vamos a 
     estar cambiando con frecuencia sus lineas y no queremos que
     cada vez que se cambie una línea se acceda a donde estén guardados
     los productos para actualizar todos los objetos Producto de 
     las lineas*/
    public boolean actualizarPrecioTotal();

    /*Usaremos esta función para actualizar el carrito siempre
     que accedamos a el, lo que se hace es actualizar el objeto producto
     que se encuentra en cada linea de carrito para así tener sus datos
     al día, sobre todo el precio, que se recalculará a nivel de linea
     y tambien a nivel de carrito una vez que tengamos todas las
     líneas actualizadas*/
    public boolean actualizar(Tienda tienda);

    public boolean eliminarLineaById(int id);

    public boolean eliminarLineaByObj(LineaCarrito lc);

    public ArrayList<LineaCarrito> getLineasCarrito();

    public float getPrecioTotal();

    public void vaciarCarrito();
    
}
