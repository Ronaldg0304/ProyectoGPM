/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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

/**
 *
 * @author rolan
 */
@WebServlet(name = "ServletSolicitudes", urlPatterns = {"/ServletSolicitudes"})
public class ServletSolicitudes extends HttpServlet {

    Solicitud solicitud = new Solicitud();
    SolicitudDAOImpl solicitudDAOImpl = new SolicitudDAOImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String action = request.getParameter("accion");
        String idSolicitud = request.getParameter("idSolicitud");

        if (action.equalsIgnoreCase("add")) {
            String idEquipo = request.getParameter("txtEquipo");
            String solicitante = request.getParameter("txtSolicitante");
            String tipoSolicitud = request.getParameter("txtTipoSolicitud");
            String operatividad = request.getParameter("txtOperatividad");
            String descripción = request.getParameter("txtDescripcion");
            Date fechaActual = new Date();

            solicitud.setIdEquipo(Integer.parseInt(idEquipo));
            solicitud.setSolicitante(solicitante);
            solicitud.setIdTipoSolicitud(Integer.parseInt(tipoSolicitud));
            solicitud.setIdOperatividad(Integer.parseInt(operatividad));
            solicitud.setFechaInicioSolicitud(fechaActual);
            solicitud.setFechaFinSolicitud(null);
            solicitud.setIdEstado(1);
            solicitud.setDescripcion(descripción);

            solicitudDAOImpl.crearSolicitud(solicitud);

            response.sendRedirect("index.jsp");

        }
        if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("idSolicitud", idSolicitud);
            
            int estado = Integer.parseInt(request.getParameter("txtEstado"));
            solicitud = solicitudDAOImpl.obtenerSolicitud(Integer.parseInt(idSolicitud));
            solicitud.setIdEstado(estado);
            solicitudDAOImpl.actualizarSolicitud(solicitud);
            request.getRequestDispatcher("ordenes.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("read")) {
            request.setAttribute("idSolicitud", idSolicitud);
            request.getRequestDispatcher("ordenes.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("delete")) {
            solicitudDAOImpl.eliminarSolicitud(Integer.parseInt(idSolicitud));
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
