package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateful
public class Usuario implements UsuarioInterfazLocal, UsuarioInterfazRemota {

    private String nombre;
    private String correoElectronico;

    @EJB
    private CarritoInterfazLocal carrito;

    public Usuario(String nombre, String correoElectronico, Carrito carrito) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.carrito = carrito;
    }

    public Usuario() {//Crea el carrito para si mismo
        InitialContext ic;
        try {
            ic = new InitialContext();
            this.carrito = (CarritoInterfazLocal) ic.lookup("java:comp/env/carrito");
        } catch (NamingException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public CarritoInterfazLocal getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoInterfazLocal carrito) {
        this.carrito = carrito;
    }

}
