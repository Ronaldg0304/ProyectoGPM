<%-- 
    Document   : index
    Created on : 10 may 2024, 15:55:24
    Author     : rolan
--%>
<%@ page import="java.util.List" %>
<%@ page import="dao.TipoSolicitudDAOImpl" %>
<%@ page import="dao.EquipoDAOImpl" %>
<%@ page import="dao.OperatividadDAOImpl" %>
<%@ page import="model.TipoSolicitud" %>
<%@ page import="model.Equipo" %>
<%@ page import="model.Operatividad" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Test Solicitudes</h4>
        <form action="ServletSolicitudes" method="GET"> 
            <label>N° Equipo</label><br>
            <select type="number" id="txtEquipo" name="txtEquipo" required>
                <%
                    EquipoDAOImpl equipoDAOImpl = new EquipoDAOImpl();
                    List<Equipo> listEquipo = equipoDAOImpl.obtenerTodosLosEquipos();
                    for (Equipo equipo : listEquipo ) {
                %>

                <option value ="<%= equipo.getIdEquipo() %>">
                    <%= equipo.getIdEquipo() %>
                </option>
                <%
                    }
                %>
            </select><br>
            <label>Solicitante</label><br>
            <input type="text" id="txtSolicitante" name="txtSolicitante" required /><br>
            <label>Tipo Solicitud</label><br>

            <select type="text" id="txtTipoSolicitud" name="txtTipoSolicitud" required>
                <%
                    TipoSolicitudDAOImpl tipoSolicitudDAOImpl = new TipoSolicitudDAOImpl();
                    List<TipoSolicitud> listTipoSolicitud = tipoSolicitudDAOImpl.obtenerTodosLosTiposSolicitudes();
                    for (TipoSolicitud tipoSolicitud : listTipoSolicitud) {
                %>

                <option value="<%= tipoSolicitud.getIdTipoSolicitud() %>">
                    <%= tipoSolicitud.getDescripcion() %>
                </option>
                <%
                    }
                %>
            </select><br> 
            <label>Operatividad</label><br>
            <select type="text" id="txtOperatividad" name="txtOperatividad" required>
                <%
                    OperatividadDAOImpl operatividadDAOImpl = new OperatividadDAOImpl();
                    List<Operatividad> listOperatividad = operatividadDAOImpl.obtenerTodasLasOperatividades();
                    for (Operatividad operatividad : listOperatividad) {
                %>

                <option value="<%= operatividad.getIdOperatividad() %>">
                    <%= operatividad.getDescripcion() %>
                </option>
                <%
                    }
                %>
            </select><br> 
            <label>Descripción</label><br>
            <textarea id="txtDescripcion" name="txtDescripcion" required></textarea><br><br>

            <button type="submit" name="accion" value="add"> Crear solicitud</button>
        </form>
    </body>
</html>
