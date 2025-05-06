package com.inventario.controllers;
import com.inventario.dao.AreaDAO;
import com.inventario.dao.CategoriaDAO;
import com.inventario.dao.MarcaDAO;
import com.inventario.dao.ProductoDAO;
import com.inventario.dao.ProveedorDAO;
import com.inventario.models.Proveedor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/proveedores")
public class ProveedorController extends HttpServlet {
    
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Proveedor> listarProveedores = proveedorDAO.listarProveedores();
        request.setAttribute("proveedores", listarProveedores);
        
        request.getRequestDispatcher("proveedores.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String id_proveedor = request.getParameter("id_proveedor");
        String descripcion_proveedor = request.getParameter("descripcion_proveedor");
        Proveedor proveedor = new Proveedor(descripcion_proveedor);
        
        if (id_proveedor != null && !id_proveedor.isEmpty()) {
            // Si hay un ID, es una actualización
            proveedor.setId_proveedor(Integer.valueOf(id_proveedor));
            proveedorDAO.editarProveedor(proveedor); // <<-- LLAMAR AL MÉTODO DE ACTUALIZACIÓN
        } else {
            // Si no hay ID, es un nuevo producto
            proveedorDAO.guardarProveedor(proveedor); // <<-- CREAR NUEVO
        }
        
        response.sendRedirect("proveedores");
    }
}
