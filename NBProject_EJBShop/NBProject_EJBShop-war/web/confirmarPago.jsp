<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Musica para DAA - Confirmar Pago</title>
        <link rel="stylesheet" type="text/css" href="resources/style/tiendaSimple.css">
    </head>
    <body bgcolor="#FDF5E6">

        <h1 class="titulo"><font face="Times New Roman,Times" size="+3">Música para DAA</font></h1>

        <hr>
    <center>

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
                <c:forEach var="lp" items="${sessionScope.pedido.lineasPedido}">
                    <tr>
                        <td>${lp.producto.nombre}</td>
                        <td>${lp.producto.autor}</td>
                        <td>${lp.producto.pais}</td>
                        <td><fmt:formatNumber type="currency" scope="page" var="valorPrecio" value="${lp.producto.precio}"/>${pageScope.valorPrecio}</td>
                        <td>${lp.cantidad}</td>
                        <td><fmt:formatNumber type="currency" scope="page" var="valorPrecioTotal" value="${lp.precioLinea}"/>${pageScope.valorPrecioTotal}</td>
                    </tr>  
                </c:forEach>
            </tbody>
        </table>
        <p>Precio Total: <fmt:formatNumber type="currency" scope="page" var="valorPrecioFinal" value="${sessionScope.pedido.precioTotal}"/>${pageScope.valorPrecioFinal}</p>
        <p>Nombre: ${sessionScope.pedido.usuario.nombre}</p>
        <p>Correo Electrónico: ${sessionScope.pedido.usuario.correoElectronico}</p>


        <form action="Controlador" method="POST" >
            <input type="hidden" name="action" value="confirmarPago">
            <input type="submit" value="Confirmar el pago">
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
