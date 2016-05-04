package controlador.PaqueteHelperCarrito;

import modelo.Carrito;
import modelo.TiendaAuxiliarArchivo;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;


public class HelperMostrarCarrito implements controlador.Helper {

    private UsuarioInterfazLocal usuario;

    public HelperMostrarCarrito(UsuarioInterfazLocal usuario) {
        this.usuario = usuario;
    }

    public void ejecutar() {

        Carrito carrito = usuario.getCarrito();
        carrito.actualizar(new TiendaAuxiliarArchivo(controlador.Controlador.path));
        
    }

}
