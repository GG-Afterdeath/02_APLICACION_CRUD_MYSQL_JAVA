<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="verificar.css">
    <title>Validación</title>
</head>
<body>
    <article class="contenedor">
        <div class="info">

            <div class="texti">
                <h1>Inicio de sesión</h1><br>
            <p>Para acceder a tus cuentas. Verifíca tu documento de identidad y tu contraseña personal dando click en el botón oscuro. Nuestro sistema verificará tus datos y te permitirá el acceso si son correctos. </p>
            </div><br>

            <div class="textr">
                <h1>Registrar mis datos</h1>
            <p>Para crear tus cuentas en nuestro sistema necesitaremos tratar algunos datos personales. Dando click en el botón "Regístrame", encontrarás un formulario mediante el cual podrás enviarnos tu información de manera confidencial y privada.</p>
            </div>
        </div>

    <!--  Botones on click   -->
        <div class="validacion">

       <header class="btns"> 
            <button onclick="cambioForm('logeo', 'registro')" id="ing">Ingrésame</button>
            <button onclick="cambioForm('registro', 'logeo')" id="reg">Regístrame</button>
        </header>


            <form id="logeo" action="usuario" method="post">
                <h1>Iniciar sesión</h1>
                <label for="usuario"></label> <br>
                <input type="text" id="usuario"  placeholder="Dígite cédula"><br>

                <label for="password"></label>
                <input type="password" id="password"  placeholder="Contraseña"> <br>
                
                <button type="submit" id="boton">Ingresar</button>
            </form>

            <form id="registro" action="usuario" method="post">
                <h1>Registrarme</h1>
                <label for="cedula"></label>
                <input type="text" name="cedula" id="cedula" required name="usuario" placeholder=" cédula"><br>

                <label for="password"></label>
                <input type="password" name="contrasena" id="clave"  placeholder="Contraseña"> <br>
                
                <input type="number" id="telefono" name="telephono"  placeholder="Teléfono"> <br>

                <input type="text" id="nombre" name="nombrer" placeholder="Nombre"> <br>

                <input type="text" id="apellido" name="apellido"  placeholder="Apellido"> <br>

                <button name="accionU" type="submit" value="registro" id="boton">Registrar</button>
            </form>
        </div>
    </article>

    <script src="verificar.js"></script>
</body>
</html>