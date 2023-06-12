package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Usuario;

public class UsuarioDAO {

// ATRIBUTOS para operar sobre la base de datos.

    Connection con; //Objeto de conexión. Mismo que el de la calse conexión.
    PreparedStatement ps; //Objeto para escribir los comandos de la DB.
    ResultSet rs; //Objeto que va a grabar las sentencias en la BD.
    String sql=null;
    int rws; //Cantidad de filas que devuelve la sentencia

// En los () se instancia la clase VO
    public int registrar(UsuarioVO uvo) throws SQLException{
// Se prepara la sentencia a registrar 
        sql="INSERT INTO usuario(Cedula, Contrasena, Telefono, Nombre, Apellido) values(?,?,?,?,?)";
// Proceso para registrar a la base de datos ⬇⬇
        try{
            con=Conectora.conectar(); // 1. Conectar con la base de datos mediante la instancia de CONECTORA y su método
            ps=con.prepareStatement(sql); // 2. Asignar al atributo los valores mediante el método prepareStatement del objeto de la clase conectora.
        System.out.println("Registro preparado.     Listo para salir...");
            ps.setInt(1, uvo.getCedula());
            ps.setString(2, uvo.getContrasena());
            ps.setInt(3, uvo.getTelefono());
            ps.setString(4, uvo.getNombre());
            ps.setString(5, uvo.getApellido());
            ps.executeUpdate(); // 3. Ejecutar la sentencia.
            ps.close(); // 4. Cerrar esta sentencia. !!!!! 
            System.out.println("Registro en Marte exitoso.    Terminado...");
        }catch(Exception e){// Se instancia excepción.
            System.out.println("Hubo un error en el registro.   Volver a intentar....");
        }finally{
            con.close(); //Cerrar conexión con la base de datos !!!!
        } 
         return rws;  // Cantidad de filas devueltas por la operación.  Se declaró al inicio
        }

        public List<UsuarioVO> listar() throws SQLException {
            List<UsuarioVO> uvo = new ArrayList<>();
            sql = "SELECT * FROM Usuario";
            try {
                con = Conectora.conectar(); // Conectarse con la base de datos mediante una instancia que invoca el método
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery(); // No es necesario pasar "sql" nuevamente aquí, ya que se estableció previamente en el PreparedStatement
                
                while (rs.next()) {
                    UsuarioVO uvor = new UsuarioVO();
                    
                    // Establecer los valores encontrados en el objeto UsuarioVO
                    uvor.setCedula(rs.getInt("Cedula"));
                    uvor.setContrasena(rs.getString("Contrasena"));
                    uvor.setTelefono(rs.getInt("Telefono"));
                    uvor.setNombre(rs.getString("Nombre"));
                    uvor.setApellido(rs.getString("Apellido"));
                    uvo.add(uvor);
                }
            } catch (SQLException e) {
                // Manejar la excepción si ocurre algún error durante la ejecución de la consulta
                e.printStackTrace();
            } finally {
                // Asegurarse de cerrar las conexiones y liberar los recursos
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            
            return uvo;
        }
        
    

    public int editar(UsuarioVO vom) throws SQLException{
        sql = "UPDATE contrasena =? FROM Usuario WHERE cedula= ?";
        try {
            con=Conectora.conectar(); 
            ps=con.prepareStatement(sql);
            ps.setInt(1, vom.getCedula());
            ps.setString(2, vom.getContrasena());
            System.out.println(ps + " Registrados.   Terminado...");
            ps.close();
            System.out.println(ps + " Modificación.   Terminado...");
        } catch (Exception e) {
            System.out.println("La modificación no puede ser ejecutada porque..  " + e.getMessage().toString());
        } finally{
            con.close(); //Cerrar conexión con la base de datos !!!!
        } 
         return rws;  
        
    }
}

