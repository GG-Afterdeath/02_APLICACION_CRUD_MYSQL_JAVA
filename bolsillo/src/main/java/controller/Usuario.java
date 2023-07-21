package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.crypto.SealedObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bolsillo_digital.Nequi;
import Bolsillo_digital.Daviplata;
import model.DaviplataDAO;
import model.DaviplataVO;
import model.NequiDAO;
import model.NequiVO;
import model.UsuarioDAO;
import model.UsuarioVO;

public class Usuario extends HttpServlet {

    UsuarioDAO UDAO = new UsuarioDAO();
    UsuarioVO UVO = new UsuarioVO();
    NequiDAO nDAO = new NequiDAO();
    NequiVO nVO = new NequiVO();
    DaviplataDAO DDAO = new DaviplataDAO();
    DaviplataVO dVO = new DaviplataVO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accionU = req.getParameter("accionU");
        switch(accionU){
            case "consultaU":
                listar(req, resp);
            break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accionU = req.getParameter("accionU");

        switch(accionU){
            case "registro":
                registrar(req, resp);
            break;
            case "inicio":
                try {
                    inicio(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            break;
        }
    }

    private void registrar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("cedula")!= null ){
            UVO.setCedula(Integer.parseInt(req.getParameter("cedula")));
        }
        if(req.getParameter("contrasena") != null){
            UVO.setContrasena(req.getParameter("contrasena"));
        }
        if(req.getParameter("telephono") != null){
            UVO.setTelefono(Integer.parseInt(req.getParameter("telephono")));
            nVO.setTelefono(Integer.parseInt(req.getParameter("telephono")));
            dVO.setTelefono(Integer.parseInt(req.getParameter("telephono")));
        }
        if(req.getParameter("nombrer") != null){
            UVO.setNombre(req.getParameter("nombrer"));
        }
        if(req.getParameter("apellido") !=null){
            UVO.setApellido(req.getParameter("apellido"));
        }
        

        try{
            UDAO.registrar(UVO);
            nDAO.registrarNequi(nVO);
            DDAO.registrarDavi(dVO);
            System.out.println("Registro de usuario exitoso");
            req.getRequestDispatcher("verificar.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println("Ha habido un error en el registro " + e.getMessage());
        }
    
    }

    int rws = 0;
    private void inicio(HttpServletRequest req, HttpServletResponse resp)throws SQLException, IOException, ServletException{
        String accionU = req.getParameter("accionU");
        if(accionU.equals("inicio")){
            UVO.setCedula(Integer.parseInt(req.getParameter("cedula")));
            UVO.setContrasena(req.getParameter("contrasena"));
            rws = UDAO.iniciarSesion(UVO);
            if(rws == 1){
                System.out.println("Ingresaste al sistema");
                req.getRequestDispatcher("view/neda.jsp").forward(req, resp);
            }else{
                System.out.println("No se pudo ingresar al sistema");
                req.getRequestDispatcher("verificar.jsp").forward(req, resp);
            }
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp){
        try{
            List usuario = UDAO.listar();
            req.setAttribute("usuarios", usuario);
            req.getRequestDispatcher("view/listar.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println("Error al listar " + e.getMessage());
        }
    }
    

}