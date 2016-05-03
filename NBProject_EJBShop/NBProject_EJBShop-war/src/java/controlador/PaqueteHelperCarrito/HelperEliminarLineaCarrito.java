package controlador.PaqueteHelperCarrito;

import modelo.Carrito;
import modelo.CarritoInterfazLocal;
import modelo.TiendaAuxiliarArchivo;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;

public class HelperEliminarLineaCarrito implements controlador.Helper {

    private UsuarioInterfazLocal usuario;
    private int idProducto;

    public HelperEliminarLineaCarrito(UsuarioInterfazLocal usuario, int idProducto) {
        this.usuario = usuario;
        this.idProducto = idProducto;
    }

    public void ejecutar() {
        CarritoInterfazLocal carrito = usuario.getCarrito();
        carrito.eliminarLineaById(idProducto);
        carrito.actualizar(new TiendaAuxiliarArchivo(controlador.Controlador.path));
    }

}
