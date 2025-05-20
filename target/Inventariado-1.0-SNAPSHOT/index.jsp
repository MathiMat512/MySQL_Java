<%@page import="com.inventario.models.Categoria"%>
<%@page import="com.inventario.models.Proveedor"%>
<%@page import="com.inventario.models.Area"%>
<%@page import="com.inventario.models.Marca"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.inventario.models.Producto" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Productos</title>
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
                                <a class="nav-link active" href="#">
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
                            <i class="bi bi-boxes text-primary"></i> Gestión de Productos
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
                                <i class="bi bi-plus-circle"></i> Nuevo Producto
                            </button>

                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Agregar nuevo producto</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">

                                            <form id="formAgregarProducto" action="productos" method="POST">
                                                <input type="hidden" name="accion" value="crear">
                                                <input type="text" class="form-control mb-3" name="descripcion_producto" placeholder="Nombre" required>
                                                <input type="text" class="form-control mb-3" name="und_medida" placeholder="Unidad de medida">
                                                <label>Fecha de recepción</label>
                                                <input type="date" class="form-control mb-3" name="fecha_recepcion">
                                                <label>Fecha de salida</label>
                                                <input type="date" class="form-control mb-3" name="fecha_salida">
                                                <input type="number" class="form-control mb-3" name="cantidad_producto" placeholder="Cantidad">
                                                <label>Marca</label>
                                                <div class="dropdown mb-3 w-100">
                                                    <button type="button" class="btn btn-primary dropdown-toggle w-100" id="marcaDropdownButtonAdd" data-bs-toggle="dropdown">
                                                        Marca
                                                    </button>
                                                    <ul class="dropdown-menu w-100">
                                                        <%
                                                            List<Marca> marcas = (List<Marca>) request.getAttribute("marcas");
                                                            if (marcas != null) {
                                                                for (Marca marca : marcas) {
                                                        %>
                                                        <li><a class="dropdown-item" href="#" onclick="seleccionarMarcaAdd('<%= marca.getDescripcion_marca()%>', '<%= marca.getId_marca()%>', this)"><%= marca.getDescripcion_marca()%></a></li>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                    </ul>
                                                    <input type="hidden" id="cod_marca_add" name="cod_marca" value="" required>
                                                </div>

                                                <label>Proveedor</label>
                                                <div class="dropdown mb-3 w-100">
                                                    <button type="button" class="btn btn-primary dropdown-toggle w-100" id="proveedorDropdownButtonAdd" data-bs-toggle="dropdown">
                                                        Proveedor
                                                    </button>
                                                    <ul class="dropdown-menu w-100">
                                                        <%
                                                            List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
                                                            if (proveedores != null) {
                                                                for (Proveedor proveedor : proveedores) {
                                                        %>
                                                        <li><a class="dropdown-item" href="#" onclick="seleccionarProveedorAdd('<%= proveedor.getDescripcion_proveedor()%>', '<%= proveedor.getId_proveedor()%>', this)"><%= proveedor.getDescripcion_proveedor()%></a></li>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                    </ul>
                                                    <input type="hidden" id="cod_proveedor_add" name="cod_proveedor" value="" required>
                                                </div>

                                                <label>Área</label>
                                                <div class="dropdown mb-3 w-100">
                                                    <button type="button" class="btn btn-primary dropdown-toggle w-100" id="areaDropdownButtonAdd" data-bs-toggle="dropdown">
                                                        Área
                                                    </button>
                                                    <ul class="dropdown-menu w-100">
                                                        <%
                                                            List<Area> areas = (List<Area>) request.getAttribute("areas");
                                                            if (areas != null) {
                                                                for (Area area : areas) {
                                                        %>
                                                        <li><a class="dropdown-item" href="#" onclick="seleccionarAreaAdd('<%= area.getDescripcion_area()%>', '<%= area.getId_area()%>', this)"><%= area.getDescripcion_area()%></a></li>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                    </ul>
                                                    <input type="hidden" id="cod_area_add" name="cod_area" value="" required>
                                                </div>

                                                <label>Categoría</label>
                                                <div class="dropdown mb-3 w-100">
                                                    <button type="button" class="btn btn-primary dropdown-toggle w-100" id="categoriaDropdownButtonAdd" data-bs-toggle="dropdown">
                                                        Categoría
                                                    </button>
                                                    <ul class="dropdown-menu w-100">
                                                        <%
                                                            List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                                                            if (categorias != null) {
                                                                for (Categoria categoria : categorias) {
                                                        %>
                                                        <li><a class="dropdown-item" href="#" onclick="seleccionarCategoriaAdd('<%= categoria.getDescripcion_categoria()%>', '<%= categoria.getId_categoria()%>', this)"><%= categoria.getDescripcion_categoria()%></a></li>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                    </ul>
                                                    <input type="hidden" id="cod_categoria_add" name="id_categoria" value="" required>
                                                </div>
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-primary" form="formAgregarProducto">Guardar cambios</button>
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
                                            <h6 class="card-title">Cantidades Totales</h6>
                                            <h2 class="mb-0"><%= request.getAttribute("Total_Cantidades")%></h2>
                                        </div>
                                        <i class="bi bi-check-circle-fill fs-1"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="card bg-success text-white">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div>
                                            <h6 class="card-title">Productos Registrados</h6>
                                            <h2 class="mb-0"><%= request.getAttribute("Productos_Registrados")%></h2>
                                        </div>
                                        <i class="bi bi-cart4 fs-1"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Listado de Productos</h5>

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
                                <input type="text" id="buscar" class="form-control"
                                       placeholder="Buscar producto..." onkeyup="filtrarBusqueda()">
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table id="tabla" class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Medida</th>
                                            <th>Stock</th>
                                            <th>Marca</th>
                                            <th>Proveedor</th>
                                            <th>Área</th>
                                            <th>Categoria</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                                            if (productos != null) {
                                                for (Producto producto : productos) {
                                        %>
                                        <tr>
                                            <td><%= producto.getId_producto()%></td>
                                            <td>
                                                <strong><%= producto.getDescripcion_producto()%></strong>
                                            </td>
                                            <td><%= producto.getUnd_medida()%></td>
                                            <td><%= producto.getCantidad_producto()%></td>
                                            <td><%= producto.getDescripcion_marca()%></td>
                                            <td><%= producto.getDescripcion_proveedor()%></td>
                                            <td><%= producto.getDescripcion_area()%></td>
                                            <td><%= producto.getDescripcion_categoria()%></td>
                                            <td>
                                                <button class="btn btn-sm btn-outline-primary" data-bs-toggle="modal" data-bs-target="#EditarProducto<%= producto.getId_producto()%>">
                                                    <i class="bi bi-pencil"></i>
                                                </button>
                                                <button class="btn btn-sm btn-outline-danger" data-bs-toggle="modal" data-bs-target="#EliminarProducto<%= producto.getId_producto()%>">
                                                    <i class="bi bi-trash"></i>
                                                </button>
                                                <button class="btn btn-sm btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#GenerarCodigoBarras<%= producto.getId_producto()%>">
                                                    <i class="bi bi-qr-code"></i>
                                                </button>

                                                <div class="modal fade" id="EditarProducto<%= producto.getId_producto()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Editar producto</h1>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <form id="formActualizarProducto_<%= producto.getId_producto()%>" action="productos" method="POST">
                                                                <div class="modal-body">
                                                                    <input type="hidden" name="id_producto" value="<%= producto.getId_producto()%>">
                                                                    <input type="hidden" name="accion" value="editar">
                                                                    <h6>Descripción</h6>
                                                                    <input class="form-control mb-2" name="descripcion_producto" value="<%= producto.getDescripcion_producto()%>">
                                                                    <h6>Unidad de Medida</h6>
                                                                    <input class="form-control mb-2" name="und_medida" value="<%= producto.getUnd_medida()%>">
                                                                    <h6>Fecha Recepción</h6>
                                                                    <input type="date" class="form-control mb-2" name="fecha_recepcion" value="<%= producto.getFecha_recepcion()%>">
                                                                    <h6>Fecha Salida</h6>
                                                                    <input type="date" class="form-control mb-2" name="fecha_salida" value="<%= producto.getFecha_salida()%>">
                                                                    <h6>Cantidad</h6>
                                                                    <input class="form-control mb-2" name="cantidad_producto" value="<%= producto.getCantidad_producto()%>">
                                                                    <label>Marca de producto</label>
                                                                    <div class="dropdown mb-3 w-100">
                                                                        <button type="button" class="btn btn-primary dropdown-toggle w-100" 
                                                                                id="marcaDropdownButton_<%= producto.getId_producto()%>" 
                                                                                data-bs-toggle="dropdown">
                                                                            <%= producto.getDescripcion_marca()%>
                                                                        </button>
                                                                        <ul class="dropdown-menu w-100">
                                                                            <% for (Marca marca : marcas) {%>
                                                                            <li><a class="dropdown-item" href="#" 
                                                                                   onclick="seleccionarMarcaEdit('<%= marca.getDescripcion_marca()%>', '<%= marca.getId_marca()%>', <%= producto.getId_producto()%>)">
                                                                                    <%= marca.getDescripcion_marca()%>
                                                                                </a></li>
                                                                                <% }%>
                                                                        </ul>
                                                                        <input type="hidden" id="cod_marca_<%= producto.getId_producto()%>" name="cod_marca" value="<%= producto.getCod_marca()%>">
                                                                    </div>

                                                                    <label>Proveedor</label>
                                                                    <div class="dropdown mb-3 w-100">
                                                                        <button type="button" class="btn btn-primary dropdown-toggle w-100"
                                                                                id="proveedorDropdownButton_<%= producto.getId_producto()%>"
                                                                                data-bs-toggle="dropdown">
                                                                            <%= producto.getDescripcion_proveedor()%>
                                                                        </button>
                                                                        <ul class="dropdown-menu w-100">
                                                                            <% for (Proveedor proveedor : proveedores) {%>
                                                                            <li><a class="dropdown-item" href="#" 
                                                                                   onclick="seleccionarProveedorEdit('<%= proveedor.getDescripcion_proveedor()%>', '<%= proveedor.getId_proveedor()%>', <%= producto.getId_producto()%>)">
                                                                                    <%= proveedor.getDescripcion_proveedor()%>
                                                                                </a></li>
                                                                                <% }%>
                                                                        </ul>
                                                                        <input type="hidden" id="cod_proveedor_<%= producto.getId_producto()%>" name="cod_proveedor" value="<%= producto.getCod_proveedor()%>">
                                                                    </div>

                                                                    <label>Área</label>
                                                                    <div class="dropdown mb-3 w-100">
                                                                        <button type="button" class="btn btn-primary dropdown-toggle w-100" 
                                                                                id="areaDropdownButton_<%= producto.getId_producto()%>"
                                                                                data-bs-toggle="dropdown">
                                                                            <%= producto.getDescripcion_area()%>
                                                                        </button>
                                                                        <ul class="dropdown-menu w-100">
                                                                            <% for (Area area : areas) {%>
                                                                            <li><a class="dropdown-item" href="#" 
                                                                                   onclick="seleccionarAreaEdit('<%= area.getDescripcion_area()%>', '<%= area.getId_area()%>', <%= producto.getId_producto()%>)">
                                                                                    <%= area.getDescripcion_area()%>
                                                                                </a></li>
                                                                                <% }%>
                                                                        </ul>
                                                                        <input type="hidden" id="cod_area_<%= producto.getId_producto()%>" name="cod_area" value="<%= producto.getCod_area()%>">
                                                                    </div>

                                                                    <label>Categoría</label>
                                                                    <div class="dropdwon mb-3 w-100">
                                                                        <button type="button" class="btn btn-primary dropdown-toggle w-100" 
                                                                                id="categoriaDropdownButton_<%= producto.getId_producto()%>"
                                                                                data-bs-toggle="dropdown">
                                                                            <%= producto.getDescripcion_categoria()%>
                                                                        </button>
                                                                        <ul class="dropdown-menu w-100">
                                                                            <% for (Categoria categoria : categorias) {%>
                                                                            <li><a class="dropdown-item" href="#" 
                                                                                   onclick="seleccionarCategoriaEdit('<%= categoria.getDescripcion_categoria()%>', '<%= categoria.getId_categoria()%>', <%= producto.getId_producto()%>)">
                                                                                    <%= categoria.getDescripcion_categoria()%>
                                                                                </a></li>
                                                                                <% }%>
                                                                        </ul>
                                                                        <input type="hidden" id="cod_categoria_<%= producto.getId_producto()%>" name="id_categoria" value="<%= producto.getId_categoria()%>">
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                                        <button type="submit" class="btn btn-primary" form="formActualizarProducto_<%= producto.getId_producto()%>">Guardar cambios</button>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div> 

                                                <div class="modal fade" id="EliminarProducto<%= producto.getId_producto()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <form action="productos" method="POST">
                                                            <input type="hidden" name="id_producto" value="<%= producto.getId_producto()%>">
                                                            <input type="hidden" name="accion" value="eliminar">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Eliminar producto</h1>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    ¿Estás seguro que deseas eliminar el producto <strong><%=producto.getDescripcion_producto()%></strong> con ID <strong><%=producto.getId_producto()%></strong>?
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>

                                                <div class="modal fade" id="GenerarCodigoBarras<%= producto.getId_producto()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Generar código de barras</h1>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <img src="https://barcode.orcascan.com/?type=code128&data=<%= producto.getCod_marca()%><%= producto.getId_categoria()%><%= producto.getCod_proveedor()%><%= producto.getId_producto()%>&format=png" alt="alt" width="300" height="100"/>
                                                                <h5><%= producto.getCod_marca()%><%= producto.getId_categoria()%><%= producto.getCod_proveedor()%><%= producto.getId_producto()%></h5>
                                                                <h5>Código Marca: <%= producto.getCod_marca()%></h5>
                                                                <h5>Código Categoria: <%= producto.getId_categoria()%></h5>
                                                                <h5>Código Proveedor: <%= producto.getCod_proveedor()%></h5>
                                                                <h5>Código Producto: <%= producto.getId_producto()%></h5>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                            </div>
                                                        </div>
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
        <script src="Javascript/cambiarLimiteProducto.js"></script>
    </body>
</html>