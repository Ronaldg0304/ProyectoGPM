<%-- 
    Document   : editarOrden
    Created on : 15 may 2024, 21:01:00
    Author     : rolan
--%>

<%@ page import="java.util.List" %>
<%@ page import="dao.OrdenDAOImpl" %>
<%@ page import="dao.EstadoDAOImpl" %>
<%@ page import="dao.OperatividadDAOImpl" %>
<%@ page import="dao.TipoAccionDAOImpl" %>
<%@ page import="dao.AccionDAOImpl" %>
<%@ page import="dao.AveriaDAOImpl" %>
<%@ page import="dao.ComponenteDAOImpl" %>
<%@ page import="dao.CausaAveriaDAOImpl" %>
<%@ page import="model.Orden" %>
<%@ page import="model.Operatividad" %>
<%@ page import="model.Estado" %>
<%@ page import="model.TipoAccion" %>
<%@ page import="model.Accion" %>
<%@ page import="model.Averia" %>
<%@ page import="model.CausaAveria" %>
<%@ page import="model.Componente" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/general.css" rel="stylesheet" type="text/css"/>
        <!-- Enlaces a Bootstrap 5 -->
        <link href="css/table.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.2/css/dataTables.bootstrap5.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid m-0 p-0">
            <div class="border-bottom p-4 row">
                <%  
                   // String idOtPrueba=(String)request.getAttribute("idOt");
                    String idOtString = request.getParameter("idOt");
                    System.out.println("editarOrden" + idOtString);
                    if("null".equals(idOtString)) { 
                %>
                <span>Selecciona una orden de trabajo por favor.</span>
                <% 
                    } else {
                        int idOt = Integer.parseInt(idOtString);
                        Orden orden = new OrdenDAOImpl().obtenerOrden(idOt);
                        Operatividad operatividad = new OperatividadDAOImpl().obtenerOperatividad(orden.getIdOperatividad());
                %>
                <div class="col-md-3">
                    <label class="form-label">Responsable</label><br>
                    <input class="form-control" type="text" id="txtResponsable" name="txtResponsable" value="<%= orden.getResponsable() %>" disabled readonly />
                </div>
                <div class="col-md-3">
                    <label class="form-label">Estado</label><br>
                    <select class="form-select" type="text" id="txtEstado" name="txtEstado" required>
                        <% 
                            List<Estado> listEstado = new EstadoDAOImpl().obtenerTodosLosEstados();
                            for (Estado estado : listEstado) {  
                        %>
                        <option value="<%= estado.getIdEstado() %>"><%= estado.getDescripcion() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Fecha inicio reparación</label><br>
                    <input class="form-control" type="date" id="txtFechaInicioOt" name="txtFechaInicioOt" value="<%= orden.getFechaInicioOt() %>" disabled readonly />
                </div>
                <div class="col-md-3">
                    <label class="form-label">Fecha fin reparación</label><br>
                    <input class="form-control" type="date" id="txtFechaFinOt" name="txtFechaFinOt" value="<%= orden.getFechaFinOt() %>" disabled readonly />
                </div>
                <div class="col-md-3">
                    <label class="form-label">Operatividad</label><br>
                    <input class="form-control" type="text" id="txtOperatividad" name="txtOperatividad" value="<%= operatividad.getDescripcion() %>" disabled readonly />
                </div>
            </div>
            <div class="row border-bottom p-1">
                <div>
                    <h6 class="text-secondary">Acciones</h6>
                </div>
                <div class="p-2 border-bottom">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar acción</button>
                </div>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Nueva acción</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="ServletEditarAccion?" method="GET" class="row g-2 m-0 pt-2 shadow-sm needs-validation" id="formSolictud">

                                    <label class="form-label">Tipo acción</label><br>
                                    <input type="hidden" name="txtIdOt" value="<%= idOt%>">
                                    <input type="hidden" name="txtIdSolicitud" value="<%= orden.getIdSolicitud()%>">
                                    <select class="form-select" type="number" id="txtTipoAccionModal" name="txtTipoAccionModal" required>
                                        <% 
                                            List<TipoAccion> listTipoAccion = new TipoAccionDAOImpl().obtenerTodosLosTiposAcciones();
                                            for (TipoAccion tipoAccion: listTipoAccion) { 
                                        %>
                                        <option value="<%= tipoAccion.getIdTipoAccion() %>"><%= tipoAccion.getDescripcion() %></option>
                                        <% } %>
                                    </select><br>
                                    <label class="form-label">Componente</label><br>
                                    <select class="form-select" type="number" id="txtComponenteModal" name="txtComponenteModal" required>
                                        <% 
                                            List<Componente> listComponente = new ComponenteDAOImpl().obtenerTodosLosComponentes();
                                            for (Componente componente : listComponente) { 
                                        %>
                                        <option value="<%= componente.getIdComponente() %>"><%= componente.getDescripcion() %></option>
                                        <% } %>
                                    </select><br>
                                    <label class="form-label">Avería</label><br>
                                    <select class="form-select" type="number" id="txtAveriaModal" name="txtAveriaModal" required>
                                        <% 
                                            List<Averia> listAveria = new AveriaDAOImpl().obtenerTodasLasAverias();
                                            for (Averia averia : listAveria) { 
                                        %>
                                        <option value="<%= averia.getIdAveria() %>"><%= averia.getDescripcion() %></option>
                                        <% } %>
                                    </select><br>
                                    <label class="form-label">Causa avería</label><br>
                                    <select class="form-select" type="number" id="txtCausaAveriaModal" name="txtCausaAveriaModal" required>
                                        <% 
                                            List<CausaAveria> listCausaAveria = new CausaAveriaDAOImpl().obtenerTodasLasCausasAverias();
                                            for (CausaAveria causaAveria : listCausaAveria) { 
                                        %>
                                        <option value="<%= causaAveria.getIdCausaAveria() %>"><%= causaAveria.getDescripcion() %></option>
                                        <% } %>
                                    </select><br>
                                    <label class="form-label">Comentario</label><br>
                                    <textarea class="form-control" type="text" id="txtComentarioAccionModal" name="txtComentarioAccionModal" ></textarea>

                                    <div for="formSolictud" class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                        <button type="submit" name="accion" value="add" class="btn btn-primary">Crear acción</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="border-bottom p-4 row">
                    <div class="row">
                        <% 
                               List<Accion> listAccion = new AccionDAOImpl().obtenerAccionByIdOt(idOt);
                               System.out.println("Lista Accion" + idOt);
                               for (Accion accion : listAccion) { 
                        %>
                        <div class="row border-bottom">

                            <div class="col-md-4 mt-2 mb-2 "> 
                                <input class="form-control" type="text" id="txtTipo Accion" name="txtTipoAccion" value="<%= accion.getIdTipoAccion() %>" disabled />
                            </div>
                            <div class="col-md-4 mt-2 mb-2"> 
                                <input class="form-control" type="text" id="txtTipoAccion" name="txtTipoAccion" value="<%= accion.getIdComponente() %>" disabled />
                            </div>
                            <div class="col-md-4 mt-2 mb-2"> 
                                <input class="form-control" type="text" id="txtTipoAccion" name="txtTipoAccion" value="<%= accion.getIdAveria() %>" disabled />
                            </div>
                            <div class="col-md-4 mt-2 mb-2"> 
                                <input class="form-control" type="text" id="txtTipoAccion" name="txtTipoAccion" value="<%= accion.getIdCausaAveria() %>" disabled />
                            </div>
                            <div class="col-md-4 mt-2 mb-2"> 
                                <input class="form-control" type="number" id="txtTipoAccion" name="txtTipoAccion" value="<%= accion.getTiempoAccion() %>" disabled />
                            </div>
                            <div class="col-md-4 mt-2 mb-2"> 
                                <textarea class="form-control" type="text" id="txtTipoAccion" name="txtTipoAccion"  disabled><%= accion.getComentarioAccion() %></textarea>
                            </div>

                        </div>
                        <% } %>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
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
