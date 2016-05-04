package controlador.PaqueteHelperPago;

import modelo.Carrito;
import modelo.TiendaAuxiliarArchivo;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;

public class HelperMostrarVentanaDePago implements controlador.Helper {

    private UsuarioInterfazLocal usuario;

    public HelperMostrarVentanaDePago(UsuarioInterfazLocal usuario) {
        this.usuario = usuario;
    }

    public void ejecutar() {

        Carrito carrito = usuario.getCarrito();
        carrito.actualizar(new TiendaAuxiliarArchivo(controlador.Controlador.path));

    }

}
