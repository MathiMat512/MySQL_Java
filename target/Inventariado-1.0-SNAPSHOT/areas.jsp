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
        <title>Áreas</title>
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
                                <a class="nav-link active" href="#">
                                    <i class="bi bi-grid-fill"></i> Áreas
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/actividades">
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
                            <i class="bi bi-grid-fill text-primary"></i> Áreas Registradas
                        </h1>
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <button type="button" class="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                <i class="bi bi-plus-circle"></i> Nueva Área
                            </button>

                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Agregar nueva área</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">

                                            <form id="formAgregarArea" action="areas" method="POST">
                                                <input type="hidden" name="accion" value="crear">
                                                <input type="text" class="form-control mb-3" name="descripcion_area" placeholder="Area" required>
                                                
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-primary" form="formAgregarArea">Guardar cambios</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Listado de Áreas</h5>
                            <div class="search-box">
                                <i class="bi bi-search"></i>
                                <input type="text" class="form-control" id="buscar" 
                                placeholder="Buscar área..." onkeyup="filtrarBusqueda()">
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID área</th>
                                            <th>Descripcion del área</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Area> areas = (List<Area>) request.getAttribute("areas");
                                            if (areas != null) {
                                                for (Area area : areas) {
                                        %>
                                        <tr>
                                            <td><%= area.getId_area()%></td>
                                            <td>
                                                <strong><%= area.getDescripcion_area()%></strong>
                                            </td>
                                            <td>
                                                <button class="btn btn-sm btn-outline-primary" data-bs-toggle="modal" data-bs-target="#EditarArea<%= area.getId_area()%>">
                                                    <i class="bi bi-pencil"></i>
                                                </button>
                                                <button class="btn btn-sm btn-outline-danger" data-bs-toggle="modal" data-bs-target="#EliminarArea<%= area.getId_area()%>">
                                                    <i class="bi bi-trash"></i>
                                                </button>

                                                <div class="modal fade" id="EditarArea<%= area.getId_area()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Editar área</h1>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <form id="formEditarArea_<%= area.getId_area()%>" action="areas" method="POST">
                                                                <div class="modal-body">
                                                                    <input type="hidden" name="id_area" value="<%= area.getId_area()%>">
                                                                    <input type="hidden" name="accion" value="editar">
                                                                    <h6>Descripción</h6>
                                                                    <input class="form-control mb-2" name="descripcion_area" value="<%= area.getDescripcion_area()%>">

                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                                        <button type="submit" class="btn btn-primary" form="formEditarArea_<%= area.getId_area()%>">Guardar cambios</button>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div> 

                                                <div class="modal fade" id="EliminarArea<%= area.getId_area()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <form action="areas" method="POST">
                                                            <input type="hidden" name="id_area" value="<%= area.getId_area()%>">
                                                            <input type="hidden" name="accion" value="eliminar">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Eliminar area</h1>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    ¿Estás seguro que deseas eliminar el area <strong><%=area.getDescripcion_area()%></strong> con ID <strong><%=area.getId_area()%></strong>?
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </td>
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
