package controlador.PaqueteHelperCarrito;

import modelo.Carrito;
import modelo.CarritoInterfazLocal;
import modelo.TiendaAuxiliarArchivo;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;


public class HelperMostrarCarrito implements controlador.Helper {

    private UsuarioInterfazLocal usuario;

    public HelperMostrarCarrito(UsuarioInterfazLocal usuario) {
        this.usuario = usuario;
    }

    public void ejecutar() {

        CarritoInterfazLocal carrito = usuario.getCarrito();
        carrito.actualizar(new TiendaAuxiliarArchivo(controlador.Controlador.path));
        
    }

}
