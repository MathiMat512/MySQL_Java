package com.inventario.controllers;
import com.inventario.dao.AreaDAO;
import com.inventario.dao.CategoriaDAO;
import com.inventario.dao.MarcaDAO;
import com.inventario.dao.ProductoDAO;
import com.inventario.dao.ProveedorDAO;
import com.inventario.dao.UsuarioDAO;
import com.inventario.models.Proveedor;
import com.inventario.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    private ProductoDAO productoDAO;
    private MarcaDAO marcaDAO;
    private AreaDAO areaDAO;
    private ProveedorDAO proveedorDAO;
    private CategoriaDAO categoriaDAO;
    private UsuarioDAO usuarioDAO;
    
    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();
        marcaDAO = new MarcaDAO();
        areaDAO = new AreaDAO();
        proveedorDAO = new ProveedorDAO();
        categoriaDAO = new CategoriaDAO();
        usuarioDAO = new UsuarioDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Usuario> listarUsuarios = usuarioDAO.listarUsuarios();
        request.setAttribute("usuarios", listarUsuarios);
        
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }
    
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String descripcion_proveedor = request.getParameter("descripcion_proveedor");
        
        Proveedor proveedor = new Proveedor(descripcion_proveedor);
        
        proveedorDAO.guardarProveedor(proveedor);
        
        response.sendRedirect("proveedores");
    }*/
}
