package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaviplataDAO {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int rws;

     public int saldoRecargard(DaviplataVO dVO) throws SQLException {
        sql = "UPDATE daviplata set Saldo = Saldo + ? where Telefono = ?";

        try {
            con = Conectora.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dVO.getSaldo());
            ps.setInt(2, dVO.getTelefono());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("La recarga de davi fue exitosa");
        }
        catch (Exception e) {
            System.out.println("Error al recargar davi " + e.getMessage().toString());
        }
        finally {
            con.close();
        }
        return rws;
    }

    public int saldoRetirard(DaviplataVO dVO) throws SQLException {
        sql = "update daviplata set Saldo = Saldo - ? where Telefono = ?";

        try {
            con = Conectora.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dVO.getSaldo());
            ps.setInt(2, dVO.getTelefono());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se retiro de davi exitosamente");
        }
        catch (Exception e) {
            System.out.println("error al retirar davi vehiculo " + e.getMessage().toString());
        }
        finally {
            con.close();
        }
        return rws;
    }

    public int registrarDavi(DaviplataVO dVO)throws SQLException{
        sql ="INSERT INTO daviplata (Telefono) VALUES (?)";
        try {
            con = Conectora.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dVO.getTelefono());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro telefono de davi exitosamente");
        }
        catch (Exception e) {
            System.out.println("error al registrar telefono en davi" + e.getMessage().toString());
        }
        finally {
            con.close();
        }
        return rws;
    }
}
