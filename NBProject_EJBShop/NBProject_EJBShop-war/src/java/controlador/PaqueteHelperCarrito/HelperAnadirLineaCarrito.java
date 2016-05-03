package controlador.PaqueteHelperCarrito;

import modelo.Carrito;
import modelo.CarritoInterfazLocal;
import modelo.LineaCarrito;
import modelo.Producto;
import modelo.Tienda;
import modelo.TiendaAuxiliarArchivo;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;

public class HelperAnadirLineaCarrito implements controlador.Helper {

    private UsuarioInterfazLocal usuario;
    private int idProducto;
    private int cantidad;

    public HelperAnadirLineaCarrito(UsuarioInterfazLocal usuario, int idProducto, int cantidad) {
        this.usuario = usuario;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public void ejecutar() {

        Tienda tienda = new TiendaAuxiliarArchivo(controlador.Controlador.path);
        Producto producto = tienda.getProductoById(idProducto);

        if (producto != null) {
            CarritoInterfazLocal carrito = usuario.getCarrito();
            carrito.insertarLinea(new LineaCarrito(producto, cantidad));
        }

    }

}
