<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Musica para DAA - Exito en el pago</title>
        <link rel="stylesheet" type="text/css" href="resources/style/tiendaSimple.css">
    </head>
    <body bgcolor="#FDF5E6">

        <h1 class="titulo"><font face="Times New Roman,Times" size="+3">Música para DAA</font></h1>

        <hr>
    <center>

        <p>El pago ha sido realizado con exito</p>
        <p>${requestScope.mensaje}</p>



        <form action="Controlador" method="POST" >
            <input type="hidden" name="action" value="irAPrincipal">
            <input type="submit" value="Volver a la tienda">
        </form>

        <center>
            <hr>


            </body>
            </html>
