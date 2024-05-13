<%-- 
    Document   : index
    Created on : 10 may 2024, 15:55:24
    Author     : rolan
--%>
<%@ page import="java.util.List" %>
<%@ page import="dao.SolicitudDAOImpl" %>
<%@ page import="dao.TipoSolicitudDAOImpl" %>
<%@ page import="dao.EquipoDAOImpl" %>
<%@ page import="dao.EstadoDAOImpl" %>
<%@ page import="model.Solicitud" %>
<%@ page import="dao.OperatividadDAOImpl" %>
<%@ page import="model.TipoSolicitud" %>
<%@ page import="model.Equipo" %>
<%@ page import="model.Operatividad" %>
<%@ page import="model.Estado" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles/nav.css">
        <link rel="stylesheet" href="css/styles/button.css">
        <link href="css/styles/modal.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/styles/logo.css">
        <link rel="stylesheet" href="css/styles/acciones.css">
        <link rel="stylesheet" href="css/styles/table.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link href="swetalert/sweetalert.css" rel="stylesheet" type="text/css"/>
        <title>Solicitudes</title>
    </head>
    <body>
        <div class="container-fluid bg-white">
            <header class="row">
                <nav class=" navbar navbar-expand-lg shadow-sm ">
                    <div class=" container-fluid">
                        <!--i class="mdi--gear-play ms-3"></i-->
                        <h1 class="col-md-6 text-gray mb-0 fs-h1-logo" href="#">GPM.net</h1>
                        <button class="navbar-toggler bg-white " type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse items-right" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 ">
                                <li class="nav-col-md-2  ">
                                    <a class="nav-link text-gray hover-nav-link" href="index.html">Inicio</a>
                                </li>
                                <li class="nav-col-md-2">
                                    <a class="nav-link text-gray hover-nav-link" href="solicitudes.jsp">Órdenes de trabajo</a>
                                </li>
                                <li class="nav-col-md-2">
                                    <a class="nav-link text-gray hover-nav-link" href="catalogo.html">Catálogos</a>
                                </li>
                                <li class="nav-col-md-2">
                                    <a class="nav-link text-gray hover-nav-link" href="administrar.html">Administrar</a>
                                </li>
                                <li class="nav-col-md-2">
                                    <a class="nav-link text-gray hover-nav-link" href="ayuda.html">Ayuda</a>
                                </li>
                                <button class="btn-login-index " type="button">
                                    <a href="login.html" style="text-decoration: none; color: white;">Cerrar
                                        sesión</a></button>
                            </ul>

                        </div>
                    </div>
                </nav>
            </header>
            <div class="row pb-2  ms-1 ">
                <div class=" p-2 border-bottom ">
                    <h4 class="ms-1 text-secondary">Solicitudes de servicio</h4>
                </div>
                <div class="p-2 border-bottom">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Nueva solicitud</button>
                </div>

                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Crear solicitud</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="ServletSolicitudes" method="GET" class="row g-2 m-0 pt-2 shadow-sm needs-validation" id="formSolictud">
                                    <label class="form-label" >N° Equipo</label><br>
                                    <select class="form-select" type="number" id="txtEquipo" name="txtEquipo" required>
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
                                    <label class="form-label">Solicitante</label><br>
                                    <input class="form-control" type="text" id="txtSolicitante" name="txtSolicitante" required /><br>
                                    <label class="form-label">Tipo Solicitud</label><br>

                                    <select class="form-select" type="text" id="txtTipoSolicitud" name="txtTipoSolicitud" required>
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
                                    <label class="form-label" >Operatividad</label><br>
                                    <select class="form-select" type="text" id="txtOperatividad" name="txtOperatividad" required>
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
                                    <label class="form-label">Descripción</label><br>
                                    <textarea class="form-control" id="txtDescripcion" name="txtDescripcion" required></textarea><br><br>
                                    <div for="formSolictud" class="modal-footer">
                                        <button type="button" class="btn btn-secondary"
                                                data-bs-dismiss="modal">Cancelar</button>
                                        <button type="submit" name="accion" value="add" class="btn btn-primary">Crear solicitud</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row  pb-2 shadow-sm border b-1 ms-1 ">
                <div class="table-responsive  ">
                    <table id="example" class="table table-striped" style="width:100%">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Equipo</th>
                                <th>N° Solicitud</th>
                                <th>Solicitante</th>
                                <th>Tipo solicitud</th>
                                <th>Operatividad</th>
                                <th>Estado</th>
                                <th>Fecha de alta</th>
                                <th>Descripción</th>
                            </tr>
                        </thead>

                        <tbody>

                            <%
                                           SolicitudDAOImpl solicitudDAOImpl = new SolicitudDAOImpl();
                                           List<Solicitud> listSolicitud = solicitudDAOImpl.obtenerTodasLasSolicitudes();
                                           for (Solicitud solicitud : listSolicitud ) {
                                           TipoSolicitud tipoSolicitud = tipoSolicitudDAOImpl.obtenerTipoSolicitud(solicitud.getIdTipoSolicitud());
                                           Operatividad  operatividad = operatividadDAOImpl.obtenerOperatividad(solicitud.getIdOperatividad());
                                           EstadoDAOImpl estadoDAOImpl = new EstadoDAOImpl();
                                           Estado estado = estadoDAOImpl.obtenerEstado(solicitud.getIdEstado());
                                           
                            %>
                            <tr>
                                <td>
                                    <a href="editarOt.html" class="fluent--edit-16-filled btn btn-success btn-edit"></a>
                                    <button class="ic--baseline-delete btn btn-danger btn-edit"></button>
                                </td>
                                <td value=""> <%= solicitud.getIdEquipo() %> </td>
                                <td value=""><%= solicitud.getIdSolicitud() %></td>
                                <td value=""><%= solicitud.getSolicitante()%></td>
                                <td value=""><%= tipoSolicitud.getDescripcion()%></td>
                                <td value=""><%= operatividad.getDescripcion() %></td>
                                <td value=""><%= estado.getDescripcion() %></td>
                                <td value=""><%= solicitud.getFechaInicioSolicitud() %></td>
                                <td value=""><%= solicitud.getDescripcion() %></td>
                            </tr>
                           
                            <% } %>
                        </tbody>

                    </table>
                </div>
            </div>

        </div>
        <script type="text/Javascript" src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <script type="text/Javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
        <script type="text/Javascript" src="https://cdn.datatables.net/2.0.2/js/dataTables.js"></script>
        <script type="text/Javascript"
        src="https://cdn.datatables.net/2.0.2/js/dataTables.bootstrap5.js"></script>
        <script type="text/Javascript">
            $(document).ready(function(){
            $('#example').DataTable();
            });
        </script>

    </body>
</html>
