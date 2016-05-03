package controlador.PaqueteHelperPago;

import modelo.Carrito;
import modelo.CarritoInterfazLocal;
import modelo.TiendaAuxiliarArchivo;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;

public class HelperMostrarVentanaDePago implements controlador.Helper {

    private UsuarioInterfazLocal usuario;

    public HelperMostrarVentanaDePago(UsuarioInterfazLocal usuario) {
        this.usuario = usuario;
    }

    public void ejecutar() {

        CarritoInterfazLocal carrito = usuario.getCarrito();
        carrito.actualizar(new TiendaAuxiliarArchivo(controlador.Controlador.path));

    }

}
