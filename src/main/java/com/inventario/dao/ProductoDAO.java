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
        String consulta = "SELECT \n" +
            "    p.id_producto,\n" +
            "    p.nombre_producto,\n" +
            "    p.descripcion_producto,\n" +
            "    p.cantidad_producto,\n" +
            "    p.fecha_producto,\n" +
            "    p.disponibilidad_producto,\n" +
            "    p.id_area,\n" +
            "    a.nombre_area,\n" +
            "    p.id_categoria,\n" +
            "    c.nombre_categoria\n" +
            "FROM tb_productos p\n" +
            "INNER JOIN tb_area a ON p.id_area = a.id_area\n" +
            "INNER JOIN tb_categoria c ON p.id_categoria = c.id_categoria;";
            
        try (Connection conn = MySQLConnection.conectarMySQL();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("id_producto"), // Asegúrate que la columna se llame así en tu tabla
                        rs.getString("nombre_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getInt("cantidad_producto"),
                        rs.getDate("fecha_producto"), // O rs.getTimestamp si almacenas fecha y hora
                        rs.getString("disponibilidad_producto"),
                        rs.getInt("id_area"),
                        rs.getString("nombre_area"),
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria")
                );
                productos.add(producto);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return productos;
    }
    
    public guardarProducto(){
        String sp1 = "call spAgregarProducto ";
        
    }
}
