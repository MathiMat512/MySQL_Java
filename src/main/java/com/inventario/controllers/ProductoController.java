package com.inventario.controllers;

import com.inventario.dao.AreaDAO;
import com.inventario.dao.CategoriaDAO;
import com.inventario.dao.ProductoDAO;
import com.inventario.models.Producto;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import com.inventario.dao.MarcaDAO;
import com.inventario.dao.ProveedorDAO;
import com.inventario.models.Area;
import com.inventario.models.Categoria;
import com.inventario.models.Marca;
import com.inventario.models.Proveedor;

@WebServlet("/productos")
public class ProductoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductoDAO productoDAO;
    private MarcaDAO marcaDAO;
    private AreaDAO areaDAO;
    private ProveedorDAO proveedorDAO;
    private CategoriaDAO categoriaDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();
        marcaDAO = new MarcaDAO();
        areaDAO = new AreaDAO();
        proveedorDAO = new ProveedorDAO();
        categoriaDAO = new CategoriaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> listaProductos = productoDAO.listarProductos();
        request.setAttribute("productos", listaProductos);

        int totalCantidad = productoDAO.totalCantidades();
        request.setAttribute("Total_Cantidades", totalCantidad);

        int totalProductos = productoDAO.productosRegistrados();
        request.setAttribute("Productos_Registrados", totalProductos);

        List<Marca> listarMarcas = marcaDAO.listarMarcas();
        request.setAttribute("marcas", listarMarcas);

        List<Area> listarAreas = areaDAO.listarAreas();
        request.setAttribute("areas", listarAreas);

        List<Proveedor> listarProveedores = proveedorDAO.listarProveedores();
        request.setAttribute("proveedores", listarProveedores);

        List<Categoria> listarCategorias = categoriaDAO.listarCategorias();
        request.setAttribute("categorias", listarCategorias);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        String idProducto = request.getParameter("id_producto");
        String descripcion_producto = request.getParameter("descripcion_producto");
        String und_medida = request.getParameter("und_medida");
        Date fecha_recepcion = parseDateOrDefault(request.getParameter("fecha_recepcion"), null);
        Date fecha_salida = parseDateOrDefault(request.getParameter("fecha_salida"), null);
        Integer cantidad_producto = parseIntegerOrDefault(request.getParameter("cantidad_producto"), 0);
        Integer cod_marca = parseIntegerOrDefault(request.getParameter("cod_marca"), null); // Puedes usar null si no es obligatorio
        Integer cod_proveedor = parseIntegerOrDefault(request.getParameter("cod_proveedor"), null); // Igualmente, puedes usar null si no es obligatorio
        Integer cod_area = parseIntegerOrDefault(request.getParameter("cod_area"), null);
        Integer id_categoria = parseIntegerOrDefault(request.getParameter("id_categoria"), null);

        Producto producto = new Producto(descripcion_producto, und_medida, fecha_recepcion, fecha_salida,
                cantidad_producto, cod_marca, cod_proveedor, cod_area, id_categoria);

        if ("eliminar".equals(accion)) {
            if (idProducto != null && !idProducto.isEmpty()) {
                producto.setId_producto(Integer.valueOf(idProducto));
                productoDAO.eliminarProducto(producto);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del producto es necesario para eliminar.");
                return;
            }
            response.sendRedirect("productos");
            return;
        }

        if (idProducto != null && !idProducto.isEmpty()) {
            // Si hay un ID, es una actualización
            producto.setId_producto(Integer.valueOf(idProducto));
            productoDAO.actualizarProducto(producto); // <<-- LLAMAR AL MÉTODO DE ACTUALIZACIÓN
        } else {
            // Si no hay ID, es un nuevo producto
            productoDAO.guardarProducto(producto); // <<-- CREAR NUEVO
        }
        response.sendRedirect("productos");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private Date parseDateOrDefault(String value, Date defaultValue) {
        try {
            return (value != null && !value.trim().isEmpty()) ? Date.valueOf(value) : defaultValue;
        } catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }

    private Integer parseIntegerOrDefault(String param, Integer defaultValue) {
        if (param != null && !param.trim().isEmpty()) {
            try {
                return Integer.valueOf(param);
            } catch (NumberFormatException e) {
                // Puedes agregar un log aquí si es necesario
                return defaultValue;  // Devuelve el valor predeterminado si no se puede convertir
            }
        }
        return defaultValue;  // Devuelve el valor predeterminado si el parámetro es null o vacío
    }
}
