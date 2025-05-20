<%@page import="com.inventario.models.Actividad"%>
<%@page import="java.util.List"%>
<%@page import="com.inventario.models.Categoria"%>
<%@page import="com.inventario.models.Proveedor"%>
<%@page import="com.inventario.models.Area"%>
<%@page import="com.inventario.models.Marca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividades</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link href="styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 col-lg-2 d-md-block sidebar px-0" style="width: 250px;">
                    <div class="p-4">
                        <h4 class="text-white mb-4">
                            <i class="bi bi-box-seam"></i> Inventario
                        </h4>
                        <hr class="bg-light">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/dashboard">
                                    <i class="bi bi-speedometer2"></i> Dashboard
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/productos">
                                    <i class="bi bi-boxes"></i> Productos
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/categorias">
                                    <i class="bi bi-list-check"></i> Categorias
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/proveedores">
                                    <i class="bi bi-truck"></i> Proveedores
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/marcas">
                                    <i class="bi bi-cart-check"></i> Marcas
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/areas">
                                    <i class="bi bi-grid-fill"></i> Áreas
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    <i class="bi bi-graph-up"></i> Actividades
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/transacciones">
                                    <i class="bi bi-reception-4"></i> Kárdex
                                </a>
                            </li>
                            <li class="nav-item mt-4">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/usuarios">
                                    <i class="bi bi-person-circle"></i> Usuarios
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <main class="col-md-9 col-lg-10 main-content">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">
                            <i class="bi bi-graph-up text-primary"></i> Registro de Actividades por los usuarios
                        </h1>
                    </div>

                    <div class="card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Historial de Actividades y últimos cambios hechos</h5>
                            <div class="d-flex align-items-center gap-2"> <label class="mb-0">Mostrar</label>
                                <select class="form-select form-select-sm w-auto" aria-label="Small select example"
                                        id="selectLimite" onchange="cambiarLimite()">
                                    <option selected value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                    <option value="40">40</option>
                                </select>
                                <label class="mb-0">resultados</label>
                            </div>
                            <div class="search-box">
                                <i class="bi bi-search"></i>
                                <input type="text" id="buscarCodigo" class="form-control" 
                                       placeholder="Buscar código..." onkeyup="filtrarBusquedaporCodigo()">
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table id="tabla" class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Código</th>
                                            <th>Descripcion</th>
                                            <th>Fecha y hora</th>
                                            <th>Usuario</th>
                                            <th>Producto afectado</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Actividad> actividades = (List<Actividad>) request.getAttribute("actividades");
                                            if (actividades != null) {
                                                for (Actividad actividad : actividades) {
                                        %>
                                        <tr>
                                            <td><%= actividad.getId_actividad()%></td>
                                            <td><%= actividad.getDescripcion()%></td>
                                            <td><%= actividad.getFecha_mov()%></td>
                                            <td><%= actividad.getUsername()%></td>
                                            <td><%= actividad.getDescripcion_producto()%></td>
                                        </tr>
                                        <%
                                            }
                                        } else {
                                        %>
                                        <tr>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- Pagination -->
                        <nav aria-label="Page navigation" class="mt-4">
                            <ul class="pagination justify-content-center">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Anterior</a>
                                </li>
                                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#">Siguiente</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
        <script src="Javascript/script.js"></script>
        <script src="Javascript/buscarCodigo.js"></script>
        <script src="Javascript/cambiarLimiteActividad.js"></script>
    </body>
</html>
