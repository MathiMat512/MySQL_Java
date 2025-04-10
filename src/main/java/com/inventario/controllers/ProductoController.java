package com.inventario.controllers;
import com.inventario.dao.ProductoDAO;
import com.inventario.models.Producto;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/productos")
public class ProductoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> listaProductos = productoDAO.listarProductos();

        request.setAttribute("productos", listaProductos);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    protected void doPost(Producto producto) {
            Connection conn = null;
            CallableStatement stmt = null;
         
            try {
            conn = Conexion.getConnection(); // Asegúrate de tener esta clase
            String sql = "{CALL sp_guardar_producto(?, ?, ?, ?)}";
            stmt = conn.prepareCall(sql);

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    protected void doPut(){
        
    }
    
    protected void doDelete(){
        
    }
}
