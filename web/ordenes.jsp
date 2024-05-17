<%-- 
    Document   : index
    Created on : 9 may 2024, 23:11:30
    Author     : rolan
--%>
<%@ page import="java.util.List" %>
<%@ page import="dao.SolicitudDAOImpl, dao.TipoSolicitudDAOImpl, dao.EquipoDAOImpl, dao.EstadoDAOImpl, dao.OrdenDAOImpl, dao.OperatividadDAOImpl" %>
<%@ page import="model.Solicitud, model.TipoSolicitud, model.Equipo, model.Operatividad, model.Estado, model.Orden" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Órdenes de trabajo</title>
        <link href="css/general.css" rel="stylesheet" type="text/css"/>
        <!-- Enlaces a Bootstrap 5 -->
        <link rel="stylesheet" href="css/styles/nav.css">
        <link rel="stylesheet" href="css/styles/button.css">
        <link href="css/styles/modal.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/styles/logo.css">
        <link rel="stylesheet" href="css/styles/acciones.css">
        <link rel="stylesheet" href="css/styles/table.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.2/css/dataTables.bootstrap5.css">
    </head>

    <body >
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
                                <a class="nav-link text-gray hover-nav-link" href="index.jsp">Inicio</a>
                            </li>
                            <li class="nav-col-md-2">
                                <a class="nav-link text-gray hover-nav-link" href="index.jsp">Órdenes de trabajo</a>
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
        <div class="container mt-4" >
            <div class="card mb-2">
                <%
                    int idSolicitud = Integer.parseInt((String)request.getAttribute("idSolicitud"));
                    Solicitud solicitud = new SolicitudDAOImpl().obtenerSolicitud(idSolicitud);
                    TipoSolicitud tipoSolicitud = new TipoSolicitudDAOImpl().obtenerTipoSolicitud(solicitud.getIdTipoSolicitud());
                    Operatividad operatividadDescripcion = new OperatividadDAOImpl().obtenerOperatividad(solicitud.getIdOperatividad());
                    Estado estadoSolicitud = new EstadoDAOImpl().obtenerEstado(solicitud.getIdEstado());
                    
                %>
                <div class="card-header">
                    <h5 class="text-secondary ">N° Solicitud - <%= solicitud.getIdSolicitud() %></h5>  
                </div>
                <div class="card-body row" >
                    <form action="ServletSolicitudes" method="GET" class="row g-2 m-0 pt-2 shadow-sm needs-validation" id="formSolictud">
                        <input type="hidden" name="idSolicitud" value="<%=solicitud.getIdSolicitud()%>">
                        <div class="col-md-3">
                            <label class="form-label fw-bold text-secondary">N° Equipo</label><br>
                            <input class="form-control" type="number" id="txtEquipo" name="txtEquipo" value="<%= solicitud.getIdEquipo() %>" disabled readonly />
                        </div>
                        <div class="col-md-3">
                            <label class="form-label fw-bold text-secondary">Solicitante</label><br>
                            <input class="form-control" type="text" id="txtSolicitante" name="txtSolicitante" value="<%= solicitud.getSolicitante() %>" disabled readonly />
                        </div>
                        <div class="col-md-3">
                            <label class="form-label fw-bold text-secondary">Tipo Solicitud</label><br>
                            <input class="form-control" type="text" id="txtTipoSolicitud" name="txtTipoSolicitud" value="<%= tipoSolicitud.getDescripcion() %>" disabled readonly />
                        </div>
                        <div class="col-md-3">
                            <label class="form-label fw-bold text-secondary">Operatividad</label><br>
                            <input class="form-control" type="text" id="txtOperatividad" name="txtOperatividad" value="<%= operatividadDescripcion.getDescripcion() %>" disabled readonly />
                        </div>
                        <div class="col-md-3">
                            <label class="form-label fw-bold text-secondary">Estado</label><br>
                            <select class="form-select" type="text" id="txtEstado" name="txtEstado"  required>
                                <option value="" hidden selected>
                                    <%= estadoSolicitud.getDescripcion() %>
                                </option>  
                                <%
                                                
                                    List<Estado> listEstados= new EstadoDAOImpl().obtenerTodosLosEstados();
                                    for (Estado estado : listEstados) {
                                %>

                                <option value="<%= estado.getIdEstado()%>">
                                    <%= estado.getDescripcion() %>
                                </option>
                                <%
                                    }
                                %>
                            </select><br> 
                        </div>
                        <div class="col-md-3">
                            <label class="form-label fw-bold text-secondary">Fecha Inicio</label><br>
                            <input class="form-control" type="date" id="txtFechaInicioSolicitud" name="txtFechaInicioSolicitud" value="<%= solicitud.getFechaInicioSolicitud() %>" disabled readonly />
                        </div>
                        <div class="col-md-4"> 
                            <label class="form-label fw-bold text-secondary">Descripción</label><br>
                            <textarea class="form-control" id="txtDescripcion" name="txtDescripcion" disabled readonly><%= solicitud.getDescripcion() %></textarea>
                        </div>
                        <div> 
                            <button type="submit" name="accion" value="edit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form>
                </div>
            </div> 
            <div class="card"> 
                <div class="card-header">
                    <h6 class="text-secondary">Ordenes de trabajo</h6>  
                </div>
                <div class="card-body row">
                    <div class="border-end col-md-2">
                        <%       
                            List<Orden> listOrden = new OrdenDAOImpl().obtenerOrdenByIdSolicitud(idSolicitud);
                            for (Orden orden : listOrden) {                   
                        %>
                        <a href="ServletEditarOrden?accion=edit&idOt=<%= orden.getIdOt()%>&idSolicitud=<%= orden.getIdSolicitud()%>" class="text-decoration-none"> 
                            <div class="row card p-2 m-1 bg-primary text-white fw-bold ">
                                <span>OT - <%= orden.getIdOt() %></span>
                                <span>Equipo - <%= orden.getIdEquipo() %></span>
                            </div> 
                        </a>
                        <% } %>
                    </div>
                    <div class="col-md-10">
                        <div class="card-body row p-0"  >
                            <%
                                //  Obtener los atributos de la solicitud
                               String idOt = (String)request.getAttribute("idOt");
                               System.out.println("Orden" + idOt);
                                
   
                            %>
                            <!-- <% //String iframeUrl = (String) request.getAttribute("iframeUrl"); %>-->
                            <iframe src="editarOrden.jsp?idOt=<%= idOt %>" frameborder="0" width="100%" height="500px"></iframe>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="p-2">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Nueva Orden</button>
                    </div>
                </div>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Crear nueva orden</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="ServletOrdenes" method="POST" class="row g-2 m-0 pt-2 shadow-sm needs-validation" id="formSolictud">
                                    <input class="form-select" type="number" id="txtIdSolicitud" name="txtIdSolicitud" value="<%= solicitud.getIdSolicitud() %>" hidden />
                                    <label class="form-label fw-bold text-secondary">N° Equipo</label><br>
                                    <input class="form-select" type="number" id="txtEquipo" name="txtEquipo" value="<%= solicitud.getIdEquipo() %>" readonly /><br>
                                    <label class="form-label fw-bold text-secondary">Responsable</label><br>
                                    <input class="form-control" type="text" id="txtResponsable" name="txtResponsable" required /><br>
                                    <label class="form-labelfw-bold text-secondary">Operatividad</label><br>
                                    <select class="form-select" id="txtOperatividad" name="txtOperatividad" required>
                                        <%
                                            List<Operatividad> listOperatividad = new OperatividadDAOImpl().obtenerTodasLasOperatividades();
                                            for (Operatividad operatividad : listOperatividad) { 
                                        %>
                                        <option value="<%= operatividad.getIdOperatividad() %>">
                                            <%= operatividad.getDescripcion() %>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select><br>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                        <button type="submit" name="accion" value="add" class="btn btn-primary">Crear orden</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        <!-- Scripts de Bootstrap 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-1NyRHkS7ADwkQqrePXVqf8ADrYSpSlFJpNBk9Ey2xooP0+hHTo7zm8sDr6pgODLx" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-DEkJY6qUp0G1WqvWnhczbpxEe6vVl8VjJRnqrO7lgEPvjFbafYpD1ZXLm7v0i9Sb" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.datatables.net/2.0.2/js/dataTables.js"></script>
        <script src="https://cdn.datatables.net/2.0.2/js/dataTables.bootstrap5.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </body>
</html>
