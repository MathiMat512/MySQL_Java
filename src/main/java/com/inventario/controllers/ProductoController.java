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
import jxl.*;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;
import jxl.write.Label;

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
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "exportarExcel": {
                    exportarExcel(request, response);
                    return;
                }
                case "buscar": {
                    String termino = request.getParameter("termino");
                    List<Producto> resultados = productoDAO.buscarPorDescripcion(termino);
                    request.setAttribute("productos", resultados);
                    request.getRequestDispatcher("partials/tabla-productos.jsp").forward(request, response);
                    return;
                }
            }
        }

        int limite = 10;

        try {
            String limiteParam = request.getParameter("limite");
            if (limiteParam != null && !limiteParam.isEmpty()) {
                limite = Integer.parseInt(limiteParam);
            }
        } catch (NumberFormatException e) {
            // Mantener el valor por defecto si hay error en el parámetro
        }

        List<Producto> listaProductos = productoDAO.listarProductos(limite);
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
        Integer cantidad_producto = parseIntegerOrDefault(request.getParameter("cantidad_producto"), 0);
        Integer cod_marca = parseIntegerOrDefault(request.getParameter("cod_marca"), null); // Puedes usar null si no es obligatorio
        Integer cod_proveedor = parseIntegerOrDefault(request.getParameter("cod_proveedor"), null); // Igualmente, puedes usar null si no es obligatorio
        Integer cod_area = parseIntegerOrDefault(request.getParameter("cod_area"), null);
        Integer id_categoria = parseIntegerOrDefault(request.getParameter("id_categoria"), null);

        Producto producto = new Producto(descripcion_producto, und_medida,
                cantidad_producto, cod_marca, cod_proveedor, cod_area, id_categoria);

        switch (accion) {
            case "crear": {
                productoDAO.guardarProducto(producto);
                break;
            }
            case "editar": {
                producto.setId_producto(Integer.valueOf(idProducto));
                productoDAO.actualizarProducto(producto);
                break;
            }
            case "eliminar": {
                producto.setId_producto(Integer.valueOf(idProducto));
                productoDAO.eliminarProducto(producto);
                break;
            }
        }
        response.sendRedirect("productos");
    }

    protected void exportarExcel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=productos.xls");

        try {
            WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());

            WritableSheet sheet = workbook.createSheet("Productos", 0);

            WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
            WritableCellFormat headerFormat = new WritableCellFormat(headerFont);
            headerFormat.setBackground(Colour.GRAY_25);

            String[] headers = {"ID", "Nombre", "Medida", "Stock", "Marca", "Proveedor", "Área", "Categoría"};
            for (int i = 0; i < headers.length; i++) {
                Label label = new Label(i, 0, headers[i], headerFormat) {
                };
                sheet.addCell(label);
            }

            List<Producto> productos = productoDAO.listarProductos(Integer.MAX_VALUE);

            int rowNum = 1;
            for (Producto p : productos) {
                sheet.addCell(new Number(0, rowNum, p.getId_producto()));
                sheet.addCell(new Label(1, rowNum, p.getDescripcion_producto()));
                sheet.addCell(new Label(2, rowNum, p.getUnd_medida()));
                sheet.addCell(new Number(3, rowNum, p.getCantidad_producto()));
                sheet.addCell(new Label(4, rowNum, p.getDescripcion_marca()));
                sheet.addCell(new Label(5, rowNum, p.getDescripcion_proveedor()));
                sheet.addCell(new Label(6, rowNum, p.getDescripcion_area()));
                sheet.addCell(new Label(7, rowNum, p.getDescripcion_categoria()));
                rowNum++;
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.setColumnView(i, 20); // Ancho de columna en caracteres
            }

            workbook.write();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                return defaultValue;
            }
        }
        return defaultValue;
    }
}
