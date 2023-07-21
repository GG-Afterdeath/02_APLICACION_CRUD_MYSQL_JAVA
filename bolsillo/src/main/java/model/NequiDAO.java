package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NequiDAO {
    
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int rws;

   public int saldoRecargar(NequiVO nVO) throws SQLException {
        sql = "UPDATE nequi set Saldo = Saldo + ? where Telefono = ?";

        try {
            con = Conectora.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nVO.getSaldo());
            ps.setInt(2, nVO.getTelefono());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("La recarga de nequifue exitosa");
        }
        catch (Exception e) {
            System.out.println("Error al recargar nequi " + e.getMessage().toString());
        }
        finally {
            con.close();
        }
        return rws;
    }

    public int saldoRetirar(NequiVO nVO) throws SQLException {
        sql = "update nequi set Saldo = Saldo - ? where Telefono = ?";

        try {
            con = Conectora.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nVO.getSaldo());
            ps.setInt(2, nVO.getTelefono());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se retiro de nequi exitosamente");
        }
        catch (Exception e) {
            System.out.println("error al retirar nequi vehiculo " + e.getMessage().toString());
        }
        finally {
            con.close();
        }
        return rws;
    }

    public int registrarNequi(NequiVO nVO)throws SQLException{
        sql ="INSERT INTO nequi (Telefono) VALUES (?)";
        try {
            con = Conectora.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nVO.getTelefono());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro telefono de nequi exitosamente");
        }
        catch (Exception e) {
            System.out.println("error al registrar telefono en nequi" + e.getMessage().toString());
        }
        finally {
            con.close();
        }
        return rws;
    }

}
