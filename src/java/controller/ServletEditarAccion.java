/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccionDAOImpl;
import dao.OrdenDAOImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Accion;
import model.Orden;

/**
 *
 * @author rolan
 */
@WebServlet(name = "ServletEditarAccion", urlPatterns = {"/ServletEditarAccion"})
public class ServletEditarAccion extends HttpServlet {

    Accion accion = new Accion();
    AccionDAOImpl accionDAOImpl = new AccionDAOImpl();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Orden orden = new OrdenDAOImpl().obtenerOrden( Integer.parseInt((String)request.getParameter("txtIdOt")));
            String idOt = request.getParameter("txtIdOt");
            String tipoAccion = request.getParameter("txtTipoAccionModal");
            String componente= request.getParameter("txtComponenteModal");
            String averia = request.getParameter("txtAveriaModal");
            String causaAveria = request.getParameter("txtCausaAveriaModal");
            String comentarioAccion = request.getParameter("txtComentarioAccionModal");
           
            accion.setIdOt(Integer.parseInt(idOt));
            accion.setIdTipoAccion(Integer.parseInt(tipoAccion));
            accion.setIdComponente(Integer.parseInt(componente));
            accion.setIdAveria(Integer.parseInt(averia));
            accion.setIdCausaAveria(Integer.parseInt(causaAveria));
            accion.setComentarioAccion(comentarioAccion);
            
            accionDAOImpl.crearAccion(accion);
            //request.removeAttribute("idOt");
            request.setAttribute("idOt", idOt);
            request.setAttribute("idSolicitud", String.valueOf(orden.getIdSolicitud()));
            System.out.println("ServletEditarAccion" + idOt);
            request.getRequestDispatcher("ordenes.jsp").forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
