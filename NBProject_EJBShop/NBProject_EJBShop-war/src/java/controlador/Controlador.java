package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.PaqueteHelperCarrito.*;
import controlador.PaqueteHelperPago.*;
import controlador.PaqueteHelperPrincipal.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import modelo.DAOPedidos;
import modelo.Usuario;
import modelo.UsuarioInterfazLocal;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * TODO
     *
     * crear ejb carrito e acceder a usuario desde aqui ca turbo injection esta
     *
     *
     *
     *
     */
    
    @EJB
    DAOPedidos daopedidos;
    
    private Helper helper;

    public static String path;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Ruta del archivo de los datos para que sea accesible desde cualquier sitio
        path = request.getServletContext().getRealPath("/WEB-INF/classes/resources/productos.txt");

        /*Miramos si tanto la sesión como nuestro usuario están creados
         Ya que en esta aplicación suponemos que el usuario ya está registrado
         */
        HttpSession sesion = request.getSession(false);
        if (sesion == null) {
            sesion = request.getSession(true);
        }

        if (sesion.getAttribute("usuario") == null) {
            UsuarioInterfazLocal usuario = null;

            InitialContext ic;
            try {
                ic = new InitialContext();
                usuario = (UsuarioInterfazLocal) ic.lookup("java:comp/env/usuario");
            } catch (NamingException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            request.getSession().setAttribute("usuario", usuario);
        }

        /*Por lo tanto esta parte de arriba es susceptible a cambios*/
        String action = request.getParameter("action");
        if (action == null) {

            helper = new HelperMostrarPrincipal(request);
            helper.ejecutar();
            goToPage("/index.jsp", request, response);

        } else {

            switch (action) {
                case ("anadirItem"):

                    helper = new HelperAnadirLineaCarrito((UsuarioInterfazLocal) sesion.getAttribute("usuario"), Integer.parseInt(request.getParameter("producto")), Integer.parseInt(request.getParameter("cantidad")));
                    helper.ejecutar();
                    goToPage("/carrito.jsp", request, response);
                    break;

                case ("eliminarLinea"):

                    helper = new HelperEliminarLineaCarrito((UsuarioInterfazLocal) sesion.getAttribute("usuario"), Integer.parseInt(request.getParameter("idEliminar")));
                    helper.ejecutar();
                    goToPage("/carrito.jsp", request, response);
                    break;

                case ("irAlCarrito"):

                    helper = new HelperMostrarCarrito((UsuarioInterfazLocal) sesion.getAttribute("usuario"));
                    helper.ejecutar();
                    goToPage("/carrito.jsp", request, response);
                    break;

                case ("irAPrincipal"):

                    helper = new HelperMostrarPrincipal(request);
                    helper.ejecutar();
                    goToPage("/index.jsp", request, response);
                    break;

                case ("mostrarVentanaDePago"):
                    UsuarioInterfazLocal usuario = (UsuarioInterfazLocal) sesion.getAttribute("usuario");
                    if (usuario.getCarrito().getLineasCarrito().size() > 0) {
                        helper = new HelperMostrarVentanaDePago((UsuarioInterfazLocal) sesion.getAttribute("usuario"));
                        helper.ejecutar();
                        goToPage("/pagando.jsp", request, response);
                    } else {
                        helper = new HelperMostrarPrincipal(request);
                        helper.ejecutar();
                        goToPage("/index.jsp", request, response);
                    }
                    break;

                case ("insertarDatosPedido"):

                    helper = new HelperRealizarPago(request.getSession(), (UsuarioInterfazLocal) sesion.getAttribute("usuario"), request.getParameter("nombreDeUsuario"), request.getParameter("email"));
                    helper.ejecutar();
                    goToPage("/confirmarPago.jsp", request, response);
                    break;//confirmarPago    

                case ("confirmarPago"):

                    helper = new HelperConfirmarPago(daopedidos,request.getSession(), request);
                    helper.ejecutar();
                    goToPage("/exitoEnElPago.jsp", request, response);
                    break;

                default:
                    helper = new HelperMostrarPrincipal(request);
                    helper.ejecutar();
                    goToPage("/index.jsp", request, response);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador de la aplicación de nuestra tienda simple";
    }

    private void goToPage(String direccion, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(direccion);
        rd.forward(request, response);
    }

}
