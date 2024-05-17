/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrdenDAOImpl;
import dao.SolicitudDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Solicitud;
import jakarta.servlet.RequestDispatcher;
import java.util.Date;
import model.Orden;

/**
 *
 * @author rolan
 */
@WebServlet(name = "ServletOrdenes", urlPatterns = {"/ServletOrdenes"})
public class ServletOrdenes extends HttpServlet {

    Orden orden = new Orden();
    OrdenDAOImpl ordenDAOImpl = new OrdenDAOImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String action = request.getParameter("accion");
        String idSolicitud = request.getParameter("txtIdSolicitud");
        
        if (action.equalsIgnoreCase("add")) {
            String idEquipo = request.getParameter("txtEquipo");
            String responsable = request.getParameter("txtResponsable");
            String operatividad = request.getParameter("txtOperatividad");
            Date fechaActual = new Date();

            orden.setResponsable(responsable);
            orden.setIdEstado(1);
            orden.setFechaInicioOt(fechaActual);
            orden.setFechaFinOt(null);
            orden.setIdEquipo(Integer.parseInt(idEquipo));
            orden.setIdSolicitud(Integer.parseInt(idSolicitud));
            orden.setIdOperatividad(Integer.parseInt(operatividad));

            ordenDAOImpl.crearOrden(orden);

            request.setAttribute("idSolicitud", idSolicitud);
            request.getRequestDispatcher("ordenes.jsp").forward(request, response);
            
        }
        if (action.equalsIgnoreCase("edit")) {

            request.setAttribute("idSolicitud", idSolicitud);
            request.getRequestDispatcher("ordenes.jsp").forward(request, response);

        }
        if (action.equalsIgnoreCase("delete")) {
           
          
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("add")) {
            String idSolicitud = request.getParameter("txtIdSolicitud");
            String idEquipo = request.getParameter("txtEquipo");
            System.out.println(idSolicitud);
            String responsable = request.getParameter("txtResponsable");
            String operatividad = request.getParameter("txtOperatividad");
            Date fechaActual = new Date();

            orden.setResponsable(responsable);
            orden.setIdEstado(1);
            orden.setFechaInicioOt(fechaActual);
            orden.setFechaFinOt(null);
            orden.setIdEquipo(Integer.parseInt(idEquipo));
            orden.setIdSolicitud(Integer.parseInt(idSolicitud));
            orden.setIdOperatividad(Integer.parseInt(operatividad));

            ordenDAOImpl.crearOrden(orden);

            request.setAttribute("idSolicitud", idSolicitud);
            request.getRequestDispatcher("ordenes.jsp").forward(request, response);
            
        }
        if (action.equalsIgnoreCase("edit")) {

            request.setAttribute("idSolicitud", request.getParameter("id"));
            RequestDispatcher vista = request.getRequestDispatcher("/ordenes.jsp");
            vista.forward(request, response);

        }
        if (action.equalsIgnoreCase("delete")) {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
