<%-- 
    Document   : index
    Created on : 9 may 2024, 23:11:30
    Author     : rolan
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Solicitudes de Servicio</title>
        <link href="css/general.css" rel="stylesheet" type="text/css"/>
        <!-- Enlaces a Bootstrap 5 -->
        <link href="css/table.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.2/css/dataTables.bootstrap5.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-r0FuEN3y4+Wk48bf1iEc5lSkkNAyiy3m04/ibzRcRV3geR8/W2wock7aCOlqOPSc" crossorigin="anonymous">
    </head>

    <body>
        <!-- Barra de navegación -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">GPM.net</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse items-right" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Solicitudes de Servicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Catálogos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Administrar</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Nombre de Usuario</a> <!-- Aquí iría el nombre de usuario obtenido desde el servidor -->
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Cerrar Sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container mt-4">
            <!-- Formulario para crear una nueva solicitud -->
            <div class="card mb-4">
                <div class="card-header">
                    <h2 class="text-secondary">Solicitudes de servicio</h2>
                </div>
                <div class="card-body">

                    <button type="submit" class="btn btn-primary">Crear Solicitud</button>

                </div>
            </div>

            <!-- Tabla para listar las solicitudes -->
            <div class="card">
                <div class="card-header">
                    <h5> Lista de Solicitudes </h5>
                </div>
                <div class="card-body">
                    <div class="table-responsive  ">
                        
                        <table id="example" class="table table-striped" style="width:100%">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>N° Ot</th>
                                    <th>Equipo</th>
                                    <th>Solicitante</th>
                                    <th>Responsable</th>
                                    <th>N° solicitud</th>
                                    <th>Tipo de solicitud</th>
                                    <th>Operatividad</th>
                                    <th>Fecha de alta</th>
                                    <th>Descripción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <a href="editarOt.html" class="fluent--edit-16-filled btn btn-success btn-edit"></a>
                                        <button class="ic--baseline-delete btn btn-danger btn-edit"></button>
                                    </td>
                                    <td>1000000</td>
                                    <td>1111111</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>2222222</td>
                                    <td>PREVENTIVO</td>
                                    <td>Mark</td>
                                    <td>01/01/2024</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>
                                        <button class="fluent--edit-16-filled btn btn-success btn-edit"></button> <button
                                            class="ic--baseline-delete btn btn-danger btn-edit"></button>
                                    </td>
                                    <td>1000000</td>
                                    <td>1111111</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>2222222</td>
                                    <td>PREVENTIVO</td>
                                    <td>Mark</td>
                                    <td>01/01/2024</td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <button class="fluent--edit-16-filled btn btn-success btn-edit"></button> <button
                                            class="ic--baseline-delete btn btn-danger btn-edit"></button>
                                    </td>
                                    <td>1000000</td>
                                    <td>1111111</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>2222222</td>
                                    <td>PREVENTIVO</td>
                                    <td>Mark</td>
                                    <td>01/01/2024</td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <button class="fluent--edit-16-filled btn btn-success btn-edit"></button> <button
                                            class="ic--baseline-delete btn btn-danger btn-edit"></button>
                                    </td>
                                    <td>1000000</td>
                                    <td>1111111</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>2222222</td>
                                    <td>PREVENTIVO</td>
                                    <td>Mark</td>
                                    <td>01/01/2024</td>
                                    <td></td>

                                </tr>
                                <tr class="text-overflow">
                                    <td>
                                        <button class="fluent--edit-16-filled btn btn-success btn-edit"></button> <button
                                            class="ic--baseline-delete btn btn-danger btn-edit"></button>
                                    </td>
                                    <td>1000000</td>
                                    <td>1111111</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>2222222</td>
                                    <td>PREVENTIVO</td>
                                    <td>Mark</td>
                                    <td>01/01/2024</td>
                                    <td>
                                        Lorem, ipsum
                                        dolor sit amet consectetur adipisicing
                                        elit.
                                        Rerum eveniet, distinctio qui
                                        corrupti sed quidem quae labore vero ducimus ullam cum aperiam eligendi sunt illum!
                                        Debitis esse alias corrupti voluptates?</td>

                                </tr>
                                <tr>
                                    <td>
                                        <button class="fluent--edit-16-filled btn btn-success btn-edit"></button> <button
                                            class="ic--baseline-delete btn btn-danger btn-edit"></button>
                                    </td>
                                    <td>1000000</td>
                                    <td>1111111</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>RONALD GUERRA ALVAREZ</td>
                                    <td>2222222</td>
                                    <td>PREVENTIVO</td>
                                    <td>Mark</td>
                                    <td>01/01/2024</td>
                                    <td></td>

                                </tr>

                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Scripts de Bootstrap 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-1NyRHkS7ADwkQqrePXVqf8ADrYSpSlFJpNBk9Ey2xooP0+hHTo7zm8sDr6pgODLx" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-DEkJY6qUp0G1WqvWnhczbpxEe6vVl8VjJRnqrO7lgEPvjFbafYpD1ZXLm7v0i9Sb" crossorigin="anonymous"></script>
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

