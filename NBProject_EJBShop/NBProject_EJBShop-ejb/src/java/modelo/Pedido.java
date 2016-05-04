package modelo;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Pedido {

    private ArrayList<LineaPedido> lineasPedido;
    private UsuarioInterfazLocal usuario;

    //To be mapped into database

    private float precioTotal;


    public Pedido(Tienda tienda, UsuarioInterfazLocal usuario) {

        this.usuario = usuario;
        CarritoInterfazLocal carrito = usuario.getCarrito();
        /*Antes de crear el pedido actualizamos todos los datos
         del carrito para tener información correcta*/
        carrito.actualizar(tienda);

        this.lineasPedido = new ArrayList<>();

        ArrayList<LineaCarrito> lineasCarrito = carrito.getLineasCarrito();

        /*Para todas las lineas de carrito, instanciamos
         una linea de pedido y la anadimos a la lista*/
        for (LineaCarrito lc : lineasCarrito) {
            this.lineasPedido.add(new LineaPedido(lc));
        }

        this.precioTotal = carrito.getPrecioTotal();
        
    }

    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public UsuarioInterfazLocal getUsuario() {
        return usuario;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }
    
    

}
