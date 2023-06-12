package model;


public class UsuarioVO {
    private int IdUsuario;
    private int Cedula;
    private String Contrasena;
    private int Telefono;
    private String Nombre;
    private String Apellido;

// Creación método constructor vacío
    public UsuarioVO(){
// Creación método constructor con parámetros
    }

    

    public UsuarioVO(int idUsuario, int cedula, String contrasena, int telefono, String nombre, String apellido) {
        IdUsuario = idUsuario;
        Cedula = cedula;
        Contrasena = contrasena;
        Telefono = telefono;
        Nombre = nombre;
        Apellido = apellido;
    }



    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

}

    