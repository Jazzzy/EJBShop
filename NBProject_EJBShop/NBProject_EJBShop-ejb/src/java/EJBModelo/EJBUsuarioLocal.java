/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBModelo;

import javax.ejb.Local;

/**
 *
 * @author gladi
 */
@Local
public interface EJBUsuarioLocal {

    public void setCorreoElectronico(String correoElectronico);

    public void setNombre(String nombre);
    
    public String getNombre();
    
    public String getCorreoElectronico();

}
