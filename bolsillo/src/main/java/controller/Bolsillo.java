package controller;
import java.io.IOException;

import javax.crypto.SealedObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bolsillo_digital.Nequi;
import Bolsillo_digital.Daviplata;

public class Bolsillo extends HttpServlet {
// Declaración variables e instancias de las clases de manera fija
Daviplata da = new Daviplata();
Nequi ne = new Nequi();





// Para la navegabilidad, se evalua en una variable los posibles valores del parámetro
// El nombre de la variable, se aconseja que sea el mismo del parámetro a evaluar

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       

       String accionesB = req.getParameter("accionesB");
    

       switch(accionesB){   
// req.getRequestDispatcher Para acceder a los bolsillos


        case "nequi":
            req.getRequestDispatcher("nequi.jsp").forward(req, resp);
        break;

        case "daviplata":
            req.getRequestDispatcher("daviplata.jsp").forward(req, resp);
        break;
        

// Casos de Daviplata
        case "recarga":
            req.getRequestDispatcher("recarga.jsp").forward(req, resp);
            System.out.println("Dirigiendo a la vista recarga.  Terminado...");
            break;

        case "retiro":
            req.getRequestDispatcher("retiro.jsp").forward(req, resp);
            System.out.println("Dirigiendo a la vista retiro.  Terminado...");
            break;
// Se guarda el valor de un atributo en una variable. a la cual settearemos en un objeto para imprimir
        case "consulta":
            double dConsultado = da.saldoConsultar();
            req.setAttribute("valorCn", da.saldoConsultar());
            req.getRequestDispatcher("consulta.jsp").forward(req, resp);
            System.out.println("Dirigiendo a la vista consulta.  Terminado...");
                System.out.println("El saldo se ha consultado Terminado...");
            break;
            
        case "regreso":
            req.getRequestDispatcher("daviplata.jsp").forward(req, resp);
        break;

    }
}


    
    
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// Declaramos variables para tomar el valor de los parámetros    

// Declaración variables para manejar el capital
    double mRecarga;

    
    String manejo = req.getParameter("manejo");
            System.out.println(manejo);
        
        double mRetiro;
        switch (manejo){
            case "recargar":
// Geteamos los datos enviados mediante el parámetro y los guardamos en una variable
                mRecarga =Double.parseDouble(req.getParameter("masplata"));
                da.saldoRecargar(mRecarga);
// Impresión de consola pra verificar el correcto funcionamiento
                System.out.println("Recarga de " + mRecarga + " en Daviplata exitosa.  Terminado...");
                req.setAttribute("valorRg", mRecarga);
                req.getRequestDispatcher("r_resultado.jsp").forward(req, resp);
            break;

            case "retirar":
                mRetiro = Double.parseDouble((req.getParameter("menplata")));
                da.saldoRetirar(mRetiro);
                System.out.println("Retiro de " + mRetiro + " en Daviplata exitoso.   Terminado...");
                req.setAttribute("valorRt", mRetiro);
                req.getRequestDispatcher("ret_resul.jsp").forward(req, resp);
            break;
            
          /*   case "consultar":
                double dConsultado = da.saldoConsultar();
                System.out.println("El total de su Davisaldo es de: " + da.saldoConsultar() + "   Terminado...");
                req.setAttribute("valorCn", dConsultado);
            break; */

            case "recargad":
                mRecarga = Double.parseDouble(req.getParameter("moreplata"));
                ne.saldoRecargar(mRecarga);
                System.out.println("Ha recargado " + mRecarga + " en tu cuenta Nequi.   Terminado...");
                req.setAttribute("nequiTl", ne.saldoConsultar());
                req.getRequestDispatcher("nequi.jsp").forward(req, resp);
            break;

            case "retirad":
                mRetiro = Double.parseDouble((req.getParameter("lessplata")));
                ne.saldoRetirar(mRetiro);
                req.setAttribute("nequiTl", ne.saldoConsultar());
                req.getRequestDispatcher("nequi.jsp").forward(req, resp);
            break;
        }


}
}