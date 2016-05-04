/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.PaqueteHelperPago;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelo.Carrito;
import modelo.DAOPedidos;
import modelo.Pedido;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;
import modelo.VOPedido;

/**
 *
 * @author gladi
 */
public class HelperConfirmarPago implements controlador.Helper {

    private HttpSession sesion;
    private HttpServletRequest request;
    private DAOPedidos daop;

    public HelperConfirmarPago(DAOPedidos daop, HttpSession sesion, HttpServletRequest request) {
        this.sesion = sesion;
        this.request = request;
        this.daop = daop;
    }

    @Override
    public void ejecutar() {

        Pedido pedido = (Pedido) sesion.getAttribute("pedido");

        VOPedido vopedido = new VOPedido(pedido.getPrecioTotal(), pedido.getUsuario().getNombre());

        daop.insertarPedido(vopedido);

        request.setAttribute("mensaje", "Se envia el correo a: " + pedido.getUsuario().getCorreoElectronico());

        //Borramos el pedido de la sesión y reseteamos el carrito al usuario
        sesion.removeAttribute("pedido");
        UsuarioInterfazLocal usuario = (UsuarioInterfazLocal) sesion.getAttribute("usuario");
        usuario.getCarrito().vaciarCarrito();

    }

}
