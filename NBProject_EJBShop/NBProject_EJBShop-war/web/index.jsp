<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Musica para DAA</title>
        <link rel="stylesheet" type="text/css" href="resources/style/tiendaSimple.css">
    </head>
    <body bgcolor="#FDF5E6">

        <h1 class="titulo"><font face="Times New Roman,Times" size="+3">Música para DAA</font></h1>

        <hr>
        <p>
    <center>
        <form action="Controlador" method="POST" >
            <input type="hidden" name="action" value="anadirItem">
            <b>CD:</b> 
            <select name="producto">
                <c:forEach var="p" items="${requestScope.tienda.productosDisponibles}">
                    <option value="${p.ID}">${p.nombre}</option>
                </c:forEach>
            </select>
            <b>Cantidad:</b>
            <input name="cantidad" type="number" min="1"  value="1">
            <p>
            <center>
                <input type="submit" value="Selecciona Producto">
            </center>
        </form>
    </center>
    <hr>
    <center>
        <form action="Controlador" method="POST" >
            <input type="hidden" name="action" value="irAlCarrito">
            <input type="submit" value="Ir al carrito">
        </form>
    </center>
    <hr>
</body>
</html>