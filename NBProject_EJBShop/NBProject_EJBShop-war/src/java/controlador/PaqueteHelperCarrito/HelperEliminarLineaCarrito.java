package controlador.PaqueteHelperCarrito;

import modelo.Carrito;
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
        Carrito carrito = usuario.getCarrito();
        carrito.eliminarLineaById(idProducto);
        carrito.actualizar(new TiendaAuxiliarArchivo(controlador.Controlador.path));
    }

}
