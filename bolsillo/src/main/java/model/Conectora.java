package model;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;


public class Conectora {
    // Declara atributos para la conexión con la base de datos
    private static final String bbdd="jdbc:mysql://localhost:3306/marte";
    private static final String usuario="root";
    private static final String clave="titi";
    public static Connection con;

// Declarar método de conexión
    public static Connection conectar(){

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");  
        con=DriverManager.getConnection(bbdd, usuario, clave); // Credenciales para conectar a la BD
        System.out.println("Conexión con Base de Datos exitosa.   Terminado...");
    }catch(Exception e) {
        System.out.println("Error de conexión a la base de datos " + e.getMessage().toString() + "    Terminado...");
        }
    return con;
    }

    public static void main (String[] args){
        Conectora.conectar();
    }
}

