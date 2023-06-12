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

import model.UsuarioDAO;
import model.UsuarioVO;

public class Usuario extends HttpServlet {

    UsuarioDAO UD = new UsuarioDAO();
    UsuarioVO UV = new UsuarioVO();

    


                                                                                                                            @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("CONTROLADOR, doGet Inicializado...");

    


    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String accionU = req.getParameter("accionU");
        System.out.println(accionU);

// Método de registro

    switch(accionU){
        case "registro":  
        System.out.println("Registrar iniciado");
            registrar(req, resp);
        resp.sendRedirect("neda.jsp");
            break;
    }
    }

    private void registrar(HttpServletRequest req, HttpServletResponse resp){
    
        if (req.getParameter("cedula") != null && !req.getParameter("cedula").isEmpty()) {
            UV.setCedula(Integer.parseInt(req.getParameter("cedula")));
        }
        if (req.getParameter("contrasena") != null && !req.getParameter("contrasena").isEmpty()) {
            UV.setContrasena(req.getParameter("contrasena"));
        }
        if (req.getParameter("telefono") != null && !req.getParameter("telefono").isEmpty()) {
            UV.setTelefono(Integer.parseInt(req.getParameter("telefono")));
        }
        if (req.getParameter("nombre") != null && !req.getParameter("nombre").isEmpty()) {
            UV.setNombre(req.getParameter("nombre"));
        }
        if (req.getParameter("apellido") != null && !req.getParameter("apellido").isEmpty()) {
            UV.setApellido(req.getParameter("apellido"));
        }
    }

}