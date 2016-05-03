<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Musica para DAA - Realizando Pago</title>
        <link rel="stylesheet" type="text/css" href="resources/style/tiendaSimple.css">
    </head>
    <body bgcolor="#FDF5E6">

        <h1 class="titulo"><font face="Times New Roman,Times" size="+3">Música para DAA</font></h1>

        <hr>
    <center>
        <form action="Controlador" method="POST" >   
            <input type="hidden" name="action" value="insertarDatosPedido">
            <table>
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Autor</th>
                        <th scope="col">País</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Precio Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="lc" items="${requestScope.carrito.lineasCarrito}">
                        <tr>
                            <td>${lc.producto.nombre}</td>
                            <td>${lc.producto.autor}</td>
                            <td>${lc.producto.pais}</td>
                            <td><fmt:formatNumber type="currency" scope="page" var="valorPrecio" value="${lc.producto.precio}"/>${pageScope.valorPrecio}</td>
                            <td>${lc.cantidad}</td>
                            <td><fmt:formatNumber type="currency" scope="page" var="valorPrecioTotal" value="${lc.precioLinea}"/>${pageScope.valorPrecioTotal}</td>

                        </tr>  
                    </c:forEach>
                </tbody>
            </table>
            <p>Precio Total: <fmt:formatNumber type="currency" scope="page" var="valorPrecioFinal" value="${requestScope.carrito.precioTotal}"/>${pageScope.valorPrecioFinal}</p>
            <br>
            <label for="nombreDeUsuario">Nombre de usuario</label>
            <input type="text" id="nombreDeUsuario" name="nombreDeUsuario" required autofocus pattern="^[a-zA-Z0-9_-]{3,16}$">
            <br><br>
            <label for="email">Correo electrónico</label>
            <input type="email" id="email" name="email" required autofocus pattern="^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$">
            <br><br>
            <input type="submit" value="Insertar datos">
            <br>
        </form>
        <center>
            <hr>
            <center>
                <form action="Controlador" method="POST" >
                    <input type="hidden" name="action" value="irAPrincipal">
                    <input type="submit" value="Volver a la tienda">
                </form>
            </center>
            <hr>

            </body>
            </html>
