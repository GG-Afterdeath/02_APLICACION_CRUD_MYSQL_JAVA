package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.crypto.SealedObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bolsillo_digital.Nequi;
import model.Conectora;
import model.DaviplataDAO;
import model.DaviplataVO;
import model.NequiDAO;
import model.NequiVO;
import Bolsillo_digital.Daviplata;

public class Bolsillo extends HttpServlet {
// Declaración variables e instancias de las clases de manera fija

NequiDAO nDAO = new NequiDAO();
NequiVO nVO = new NequiVO();

DaviplataDAO dDAO = new DaviplataDAO();
DaviplataVO DVO = new DaviplataVO();

// Para la navegabilidad, se evalua en una variable los posibles valores del parámetro
// El nombre de la variable, se aconseja que sea el mismo del parámetro a evaluar

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
       String accionesB = req.getParameter("accionesB");
       switch(accionesB){   
        case "nequi":
            req.getRequestDispatcher("view/nequi.jsp").forward(req, resp);
        break;

        case "daviplata":
            req.getRequestDispatcher("view/daviplata.jsp").forward(req, resp);
        break;
            
        case "recargaD":
            req.getRequestDispatcher("view/recarga.jsp").forward(req, resp);
        break;

        case "retiroD":
            req.getRequestDispatcher("view/retiro.jsp").forward(req, resp);
        break;

        case "consultaD":
            req.getRequestDispatcher("view/consulta.jsp").forward(req, resp);
        break;

        case "regreso":
            req.getRequestDispatcher("daviplata.jsp").forward(req, resp);
        break;

    }
}





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String accionesB = req.getParameter("accionesB");
        switch(accionesB){
            case "recargaN":
                saldoRecargar(req, resp);
            break;

            case "retiro":
                saldoRetirar(req, resp);
            break;
            case "recargarDa":
                saldoRecargard(req, resp);
            break;
            case "retirarDa":
                saldoRetirard(req, resp);
            break;
        }
    
}



int total = 0;
    private void saldoRecargar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("telephono") != null) {
            nVO.setTelefono(Integer.parseInt(req.getParameter("telephono")));
        }

        if(req.getParameter("cantidadRCN") != null) {
            nVO.setSaldo(Integer.parseInt(req.getParameter("cantidadRCN")));
            String saldo = req.getParameter("cantidadRCN");
            nVO.setSaldo(Integer.parseInt(saldo));
            total = total + Integer.parseInt(saldo);
            req.getSession().setAttribute("saldo", total);
            System.out.println("Se recargo el saldo con exito éxito");
            
        }

        try {
            nDAO.saldoRecargar(nVO);
            System.out.println("con la recarga, del nequi totales son "+total);
            req.getRequestDispatcher("view/nequi.jsp").forward(req, resp);
        }
        catch(Exception e) {
            System.out.println("Error al recargar estación " +e.getMessage().toString());
        }
    
    }

    int totald = 0;
    private void saldoRecargard(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("telephono") != null) {
            DVO.setTelefono(Integer.parseInt(req.getParameter("telephono")));
        }

        if(req.getParameter("masplata") != null) {
            DVO.setTelefono(Integer.parseInt("masplata"));
            String saldod = req.getParameter("masplata");
            DVO.setSaldo(Integer.parseInt(saldod));
            totald = totald + Integer.parseInt(saldod);
            req.getSession().setAttribute("saldod", totald);
            System.out.println("Se recargo el saldo con exito éxito");
            
        }

        try {
            dDAO.saldoRecargard(DVO);
            System.out.println("con la recarga, del davi totales son "+total);
            req.getRequestDispatcher("view/r_resultado.jsp").forward(req, resp);
        }
        catch(Exception e) {
            System.out.println("Error al recargar daviplata " +e.getMessage().toString());
        }
    
    }

     private void saldoRetirard(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("telephono") != null) {
            DVO.setTelefono(Integer.parseInt(req.getParameter("telephono")));
        }

        if(req.getParameter("menplata") != null) {
            DVO.setSaldo(Integer.parseInt(req.getParameter("menplata")));
            String saldod = req.getParameter("menplata");
            DVO.setSaldo (Integer.parseInt(saldod));
            totald = totald - Integer.parseInt(saldod);
            req.getSession().setAttribute("saldod", totald);
            System.out.println("Retiro de davi con éxito");
        }

        try {
            dDAO.saldoRetirard(DVO);
            System.out.println("Se retiro del davi");
            // Despues de realizar la operación que redirija al home.jsp
            req.getRequestDispatcher("view/ret_resul.jsp").forward(req, resp);
        }
        catch (Exception e) {
            System.out.println("Error al retirar de davi "+e.getMessage().toString());
        }

}
    
    private void saldoRetirar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("telephono") != null) {
            nVO.setTelefono(Integer.parseInt(req.getParameter("telephono")));
        }

        if(req.getParameter("cantidadRTN") != null) {
            nVO.setSaldo(Integer.parseInt(req.getParameter("cantidadRTN")));
            String saldo = req.getParameter("cantidadRTN");
            nVO.setSaldo (Integer.parseInt(saldo));
            total = total - Integer.parseInt(saldo);
            req.getSession().setAttribute("saldo", total);
            System.out.println("Retiro de nequi con éxito");
        }

        try {
            nDAO.saldoRetirar(nVO);
            System.out.println("Se retiro de nequi");
            // Despues de realizar la operación que redirija al home.jsp
            req.getRequestDispatcher("view/nequi.jsp").forward(req, resp);
        }
        catch (Exception e) {
            System.out.println("Error al retirar galones "+e.getMessage().toString());
        }

}
}