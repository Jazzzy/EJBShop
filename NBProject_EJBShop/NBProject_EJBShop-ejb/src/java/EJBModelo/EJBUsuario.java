/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBModelo;

import javax.ejb.Stateful;
import modelo.Carrito;

/**
 *
 * @author gladi
 */
@Stateful
public class EJBUsuario implements EJBUsuarioLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String nombre;
    private String correoElectronico;

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    @Override
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
}
