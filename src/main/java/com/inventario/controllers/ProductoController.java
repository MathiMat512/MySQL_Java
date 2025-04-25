package com.inventario.controllers;
import com.inventario.dao.ProductoDAO;
import com.inventario.dao.ProductoDAOImpl;
import com.inventario.models.Producto;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/productos")
public class ProductoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAOImpl();
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

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id_producto = Integer.parseInt(request.getParameter("id_producto"));
        String descripcion_producto = request.getParameter("descripcion_producto");
        String und_medida = request.getParameter("und_medida");
        Date fecha_recepcion = parseDateOrDefault(request.getParameter("fecha_recepcion"), null);
        Date fecha_salida = parseDateOrDefault(request.getParameter("fecha_salida"), null);
        Integer cantidad_producto = Integer.parseInt(request.getParameter("cantidad_producto"));
        Integer cod_marca = Integer.parseInt(request.getParameter("cod_marca"));
        String descripcion_marca = request.getParameter("descripcion_marca");
        String modelo = request.getParameter("modelo");
        Integer cod_proveedor = Integer.parseInt(request.getParameter("cod_proveedor"));
        String descripcion_proveedor = request.getParameter("descripcion_proveedor");
        Integer cod_area = Integer.parseInt(request.getParameter("cod_area"));
        String descripcion_area = request.getParameter("descripcion_area");
        Integer id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        String descripcion_categoria = request.getParameter("descripcion_categoria");

        Producto producto = new Producto(id_producto, descripcion_producto, und_medida, fecha_recepcion, fecha_salida,
                cantidad_producto, cod_marca, descripcion_marca, modelo, cod_proveedor, descripcion_proveedor,
                cod_area, descripcion_area, id_categoria, descripcion_categoria);
        productoDAO.guardarProducto(producto);
        response.sendRedirect("productos");
    }

    /*protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String disponibilidad = request.getParameter("disponibilidad");
        int id_area = Integer.parseInt(request.getParameter("id_area"));
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        
        Producto producto = new Producto(0, nombre, descripcion, cantidad, fecha, disponibilidad, id_area, "", id_categoria, "");
        productoDAO.actualizarProducto(producto);
        response.sendRedirect("productos");
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        int id_producto = request.getParameter("id_producto");
        
        Producto producto = new Producto(id_producto);
        productoDAO.eliminarProducto(producto);
        response.sendRedirect("productos");
    }*/
    private Date parseDateOrDefault(String value, Date defaultValue) {
        try {
            return (value != null && !value.trim().isEmpty()) ? Date.valueOf(value) : defaultValue;
        } catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }
}
