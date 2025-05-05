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

        if ("eliminar".equals(accion)) {
            doDelete(request, response); // Reutiliza tu lógica de DELETE
            return;
        }

        String idProducto = request.getParameter("id_producto");
        String descripcion_producto = request.getParameter("descripcion_producto");
        String und_medida = request.getParameter("und_medida");
        Date fecha_recepcion = parseDateOrDefault(request.getParameter("fecha_recepcion"), null);
        Date fecha_salida = parseDateOrDefault(request.getParameter("fecha_salida"), null);
        Integer cantidad_producto = Integer.valueOf(request.getParameter("cantidad_producto"));
        Integer cod_marca = Integer.valueOf(request.getParameter("cod_marca"));
        Integer cod_proveedor = Integer.valueOf(request.getParameter("cod_proveedor"));
        Integer cod_area = Integer.valueOf(request.getParameter("cod_area"));
        Integer id_categoria = Integer.valueOf(request.getParameter("id_categoria"));

        Producto producto = new Producto(descripcion_producto, und_medida, fecha_recepcion, fecha_salida,
                cantidad_producto, cod_marca, cod_proveedor, cod_area, id_categoria);
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
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Validar el parámetro id_producto
            String idParam = request.getParameter("id_producto");
            if (idParam == null || idParam.trim().isEmpty()) {
                return;
            }
            int id_producto;
            try {
                id_producto = Integer.parseInt(idParam);
            } catch (NumberFormatException e) {
                return;
            }
            // Crear el objeto Producto y eliminar
            Producto producto = new Producto(id_producto);
            productoDAO.eliminarProducto(producto);
            
            response.sendRedirect("productos");
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: "+e);
        }
    }

    private Date parseDateOrDefault(String value, Date defaultValue) {
        try {
            return (value != null && !value.trim().isEmpty()) ? Date.valueOf(value) : defaultValue;
        } catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }
}
