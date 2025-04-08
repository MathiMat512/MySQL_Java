package com.inventario.dao;
import com.inventario.models.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public List<Producto> listarProductos(){
        List<Producto> productos = new ArrayList<>();
        String consulta = "select * from tb_productos";
            
        try (Connection conn = MySQLConnection.conectarMySQL();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("id_producto"), // Asegúrate que la columna se llame así en tu tabla
                        rs.getString("nombre_producto"),
                        rs.getString("categoria_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getInt("cantidad_producto"),
                        rs.getDate("fecha_producto"), // O rs.getTimestamp si almacenas fecha y hora
                        rs.getString("area_producto"),
                        rs.getString("disponibilidad_producto"),
                        rs.getInt("id_area"),
                        rs.getInt("id_categoria")
                );
                productos.add(producto);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return productos;
    }
}
