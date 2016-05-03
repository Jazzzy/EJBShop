package controlador.PaqueteHelperPago;

import javax.servlet.http.HttpSession;
import modelo.Pedido;
import modelo.TiendaAuxiliarArchivo;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;


public class HelperRealizarPago implements controlador.Helper {

    private UsuarioInterfazLocal usuario;
    private String nombre;
    private String email;
    private HttpSession sesion;

    public HelperRealizarPago(HttpSession sesion,UsuarioInterfazLocal usuario, String nombre, String email) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.sesion=sesion;
    }

    public void ejecutar() {

        usuario.setNombre(nombre);
        usuario.setCorreoElectronico(email);
        
        Pedido pedido=new Pedido(new TiendaAuxiliarArchivo(controlador.Controlador.path),usuario);
        sesion.setAttribute("pedido", pedido);
        
        
    }

}
