package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaviplataVO {
    
    private int idDavi;
    private int saldo;
    private int telefono;
    
    public DaviplataVO() {
    }

    public DaviplataVO(int idDavi, int saldo, int telefono) {
        this.idDavi = idDavi;
        this.saldo = saldo;
        this.telefono = telefono;
    }

    public int getIdDavi() {
        return idDavi;
    }

    public void setIdDavi(int idDavi) {
        this.idDavi = idDavi;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


}
