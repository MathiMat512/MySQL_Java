<%@page import="com.inventario.models.Rol"%>
<%@page import="com.inventario.models.Usuario"%>
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
        <title>Usuarios</title>
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
                                <a class="nav-link" href="/Inventariado-1.0-SNAPSHOT/transacciones">
                                    <i class="bi bi-reception-4"></i> Kárdex
                                </a>
                            </li>
                            <li class="nav-item mt-4">
                                <a class="nav-link active" href="#">
                                    <i class="bi bi-person-circle"></i> Usuarios
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <main class="col-md-9 col-lg-10 main-content">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">
                            <i class="bi bi-person-circle text-primary"></i> Lista de usuarios registrados
                        </h1>
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group me-2">
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <i class="bi bi-printer"></i> Imprimir
                                </button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <i class="bi bi-download"></i> Exportar
                                </button>
                            </div>
                            <button type="button" class="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                <i class="bi bi-plus-circle"></i> Nuevo Usuario
                            </button>

                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Agregar nuevo usuario</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">

                                            <form id="formAgregarUsuario" action="usuarios" method="POST">
                                                <input type="hidden" name="accion" value="crear">
                                                <input type="text" class="form-control mb-3" name="username" placeholder="Nombre de usuario" required>
                                                <input type="password" class="form-control mb-3" name="password" placeholder="Contraseña" required>
                                                <input type="text" class="form-control mb-3" name="nombre" placeholder="Nombres" required>
                                                <input type="text" class="form-control mb-3" name="apellido" placeholder="Apellido" required>
                                                <label>Rol</label>
                                                <div class="dropdown mb-3 w-100">
                                                    <button type="button" class="btn btn-primary dropdown-toggle w-100" id="rolDropdownButtonAdd" data-bs-toggle="dropdown">
                                                        Rol
                                                    </button>
                                                    <ul class="dropdown-menu w-100">
                                                        <%
                                                            List<Rol> roles = (List<Rol>) request.getAttribute("roles");
                                                            if (roles != null) {
                                                                for (Rol rol : roles) {
                                                        %>
                                                        <li><a class="dropdown-item" href="#" onclick="seleccionarRolAdd('<%= rol.getDescripcion_rol()%>', '<%= rol.getId_rol()%>', this)"><%= rol.getDescripcion_rol()%></a></li>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                    </ul>
                                                    <input type="hidden" id="cod_rol_add" name="id_rol" value="" required>
                                                </div>

                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-primary" form="formAgregarUsuario">Guardar cambios</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-3">
                            <div class="card bg-primary text-white">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div>
                                            <h6 class="card-title">Usuarios Totales</h6>
                                            <h2 class="mb-0"><%= request.getAttribute("Usuarios_totales")%></h2>
                                        </div>
                                        <i class="bi bi-check-circle-fill fs-1"></i>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Listado de Usuarios</h5>
                            <div class="search-box">
                                <i class="bi bi-search"></i>
                                <input type="text" class="form-control" id="buscar" 
                                placeholder="Buscar usuario..." onkeyup="filtrarBusqueda()">
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID usuario</th>
                                            <th>Usuario</th>
                                            <th>Nombres</th>
                                            <th>Apellido</th>
                                            <th>Rol</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                                            if (usuarios != null) {
                                                for (Usuario usuario : usuarios) {
                                        %>
                                        <tr>
                                            <td><%= usuario.getId_User()%></td>
                                            <td>
                                                <strong><%= usuario.getUsername()%></strong>
                                            </td>
                                            <td><%= usuario.getNombre()%></td>
                                            <td><%= usuario.getApellido()%></td>
                                            <td><%= usuario.getDescripcion()%></td>
                                            <td>
                                                <button class="btn btn-sm btn-outline-primary" data-bs-toggle="modal" data-bs-target="#EditarUsuario<%= usuario.getId_User()%>">
                                                    <i class="bi bi-pencil"></i>
                                                </button>
                                                <button class="btn btn-sm btn-outline-danger" data-bs-toggle="modal" data-bs-target="#EliminarUsuario<%= usuario.getId_User()%>">
                                                    <i class="bi bi-trash"></i>
                                                </button>

                                                <div class="modal fade" id="EditarUsuario<%= usuario.getId_User()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Editar usuario</h1>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <form id="formEditarUsuario_<%= usuario.getId_User()%>" action="usuarios" method="POST">
                                                                <div class="modal-body">
                                                                    <input type="hidden" name="id_user" value="<%= usuario.getId_User()%>">
                                                                    <input type="hidden" name="accion" value="editar">
                                                                    <h6>Nombre de Usuario</h6>
                                                                    <input class="form-control mb-2" name="username" value="<%= usuario.getUsername()%>">
                                                                    <h6>Nombres</h6>
                                                                    <input class="form-control mb-2" name="nombre" value="<%= usuario.getNombre()%>">
                                                                    <h6>Apellidos</h6>
                                                                    <input class="form-control mb-2" name="apellido" value="<%= usuario.getApellido()%>">
                                                                    <label>Rol</label>
                                                                    <div class="dropdown mb-3 w-100">
                                                                        <button type="button" class="btn btn-primary dropdown-toggle w-100" 
                                                                                id="rolDropdownButton_<%= usuario.getId_User()%>" data-bs-toggle="dropdown">
                                                                            <%= usuario.getDescripcion()%>
                                                                        </button>

                                                                        <ul class="dropdown-menu w-100">
                                                                            <% for (Rol rol : roles) {%>
                                                                            <li><a class="dropdown-item" href="#" 
                                                                                   onclick="seleccionarRolEdit('<%= rol.getDescripcion_rol()%>', '<%= rol.getId_rol()%>', <%= usuario.getId_User()%>)">
                                                                                    <%= rol.getDescripcion_rol()%>
                                                                                </a></li>
                                                                                <% }%>
                                                                        </ul>
                                                                        <input type="hidden" id="cod_rol_<%= usuario.getId_User()%>" name="id_rol" value="<%= usuario.getId_rol()%>" required>

                                                                    </div>

                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                                        <button type="submit" class="btn btn-primary" form="formEditarUsuario_<%= usuario.getId_User()%>">Guardar cambios</button>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div> 

                                                <div class="modal fade" id="EliminarUsuario<%= usuario.getId_User()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <form action="usuarios" method="POST">
                                                            <input type="hidden" name="id_user" value="<%= usuario.getId_User()%>">
                                                            <input type="hidden" name="accion" value="eliminar">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Eliminar usuario</h1>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    ¿Estás seguro que deseas eliminar el usuario <strong><%=usuario.getUsername()%></strong> con ID <strong><%=usuario.getId_User()%></strong>?
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
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
        <script src="Javascript/script.js"></script>
        <script src="Javascript/buscar.js"></script>
    </body>
</html>
