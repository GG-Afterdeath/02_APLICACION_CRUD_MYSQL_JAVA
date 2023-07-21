<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/listar.css">
    <link rel="icon" href="source/ventana.png">
    <title>Consultas</title>
</head>
<body>
    <header class="logot">
        <a href="estacion?accion=home"><img src="assets/img/logoterp.png"></a>
        <h1>| Consulta estacion |</h1>
    </header>
    <div class="salir">
        <a href="shady.html"><img src="source/salir.ico"></a>
    </div>
    <article class="contenedor">
    
        <div class="subCont">
            <table class="tabla">
            <thead>
                <tr id="cabecera">
                    <th>Cedula</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Telefono</th>
                </tr>
            </thead>
            <c:forEach var="usuario" items="${usuarios}">
                <tbody>
                    <tr id="campo">
                        <td>${usuario.getCedula()}</td>
                        <td>${usuario.getNombre()}</td>
                        <td>${usuario.getApellido()}</td>
                        <td>${usuario.getTelefono()}</td>
                        <td><a href="estacion?accion=formmodifica">Modificar</a>
                    </tr> 
                </tbody>
            </c:forEach>
            </table>
        </div>
    </article>

</body>
</html>