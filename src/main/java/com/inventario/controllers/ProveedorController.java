package com.inventario.controllers;
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
    private ProveedorDAO proveedorDAO;
    
    @Override
    public void init() throws ServletException {
        proveedorDAO = new ProveedorDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Proveedor> listarProveedores = proveedorDAO.listarProveedores();
        request.setAttribute("proveedores", listarProveedores);
        
        int totalProveedores = proveedorDAO.totalProveedores();
        request.setAttribute("Proveedores_Totales", totalProveedores);
        
        request.getRequestDispatcher("proveedores.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String accion = request.getParameter("accion");
        
        String id_proveedor = request.getParameter("id_proveedor");
        String descripcion_proveedor = request.getParameter("descripcion_proveedor");
        Proveedor proveedor = new Proveedor(descripcion_proveedor);
        
        switch (accion) {
            case "crear":{
                proveedorDAO.guardarProveedor(proveedor);
                break;
            }
            case "actualizar":{
                proveedor.setId_proveedor(Integer.valueOf(id_proveedor));
                proveedorDAO.editarProveedor(proveedor);
                break;
            }
            case "eliminar":{
                proveedor.setId_proveedor(Integer.valueOf(id_proveedor));
                proveedorDAO.eliminarProveedor(proveedor);
                break;
            }
        }
        response.sendRedirect("proveedores");
    }
}
