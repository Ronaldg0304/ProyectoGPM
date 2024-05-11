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
    SolicitudDAOImpl solicitudDAO = new SolicitudDAOImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletSolicitudes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSolicitudes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

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

        solicitudDAO.crearSolicitud(solicitud);

        RequestDispatcher vista = request.getRequestDispatcher("/index.jsp");
        vista.forward(request, response);

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
