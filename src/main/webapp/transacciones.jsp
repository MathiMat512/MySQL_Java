<%@page import="com.inventario.models.Transaccion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transacciones de productos</title>
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
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/actividades">
                                    <i class="bi bi-graph-up"></i> Actividades
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
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
                            <i class="bi bi-reception-4 text-primary"></i> Sistema de transacciones Kárdex
                        </h1>
                    </div>

                    <div class="card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Historial de vida de productos</h5>
                            <div class="search-box">
                                <i class="bi bi-search"></i>
                                <input type="text" id="buscar" class="form-control" 
                                       placeholder="Buscar producto..." onkeyup="filtrarBusqueda()">
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Código</th>
                                            <th>Producto afectado</th>
                                            <th>Fecha y hora</th>
                                            <th>Tipo de transacción</th>
                                            <th>Cantidad</th>
                                            <th>Cantidad actual</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Transaccion> transacciones = (List<Transaccion>) request.getAttribute("transacciones");
                                            if (transacciones != null) {
                                                for (Transaccion transaccion : transacciones) {
                                        %>
                                        <tr>
                                            <td><%= transaccion.getId_transaccion()%></td>
                                            <td>
                                                <strong><%= transaccion.getDescripcion_producto()%></strong>
                                            </td>
                                            <td><%= transaccion.getFecha_movimiento()%></td>
                                            <td><%= transaccion.getTipo_transaccion()%></td>
                                            <td><%= transaccion.getCantidad()%></td>
                                            <td><%= transaccion.getCantidad_actual()%></td>
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
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
        <script src="Javascript/script.js"></script>
        <script src="Javascript/buscar.js"></script>
    </body>
</html>
