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
import model.Orden;
import jakarta.servlet.RequestDispatcher;
import java.util.Date;

/**
 *
 * @author rolan
 */
@WebServlet(name = "ServletEditarOrden", urlPatterns = {"/ServletEditarOrden"})
public class ServletEditarOrden extends HttpServlet {
    
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String idOt= request.getParameter("idOt");
        String idSolcitud =request.getParameter("idSolicitud");
        
        request.setAttribute("idOt", idOt);
        System.out.println("Servlet" + idOt);
        request.setAttribute("idSolicitud", idSolcitud);
        request.getRequestDispatcher("ordenes.jsp").forward(request, response);
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
