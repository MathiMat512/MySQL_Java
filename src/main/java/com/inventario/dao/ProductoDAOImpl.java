package com.inventario.dao;

import com.inventario.models.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String consulta = "SELECT p.id_producto, p.nombre_producto, p.descripcion_producto, p.cantidad_producto, p.fecha_producto, "
                + "p.disponibilidad_producto, p.id_area, a.nombre_area, p.id_categoria, c.nombre_categoria "
                + "FROM tb_productos p "
                + "INNER JOIN tb_area a ON p.id_area = a.id_area "
                + "INNER JOIN tb_categoria c ON p.id_categoria = c.id_categoria";

        try (Connection conn = MySQLConnection.conectarMySQL(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getInt("cantidad_producto"),
                        rs.getDate("fecha_producto"),
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

    @Override
    public void guardarProducto(Producto producto) {
        String consulta = "INSERT INTO tb_productos (id_producto, nombre_producto, descripcion_producto, cantidad_producto, fecha_producto, disponibilidad_producto, id_area, id_categoria) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement statement = conexion.prepareStatement(consulta)) {

            statement.setInt(1, producto.getId_producto());
            statement.setString(2, producto.getNombre_producto());
            statement.setString(3, producto.getDescripcion_producto());
            statement.setInt(4, producto.getCantidad_producto());
            statement.setDate(5, producto.getFecha_producto());
            statement.setString(6, producto.getDisponibilidad_producto());
            statement.setInt(7, producto.getId_area());
            statement.setInt(8, producto.getId_categoria());

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Producto guardado correctamente.");
            } else {
                System.out.println("Error al guardar el producto.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int totalCantidades(){
        String consulta = "Select sum(cantidad_producto) AS Total_Cantidades from tb_productos;";
        int totalCantidad = 0;
        
        try(Connection conexion = MySQLConnection.conectarMySQL()){
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            
            if(rs.next()){
                totalCantidad=rs.getInt("Total_Cantidades");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return totalCantidad;
    }
    
    @Override
    public int productosRegistrados(){
        String consulta = "Select count(cantidad_producto) as Productos_Registrados from tb_productos;";
        int totalProductos = 0;
        
        try(Connection conexion = MySQLConnection.conectarMySQL()){
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            
            if(rs.next()){
                totalProductos=rs.getInt("Productos_Registrados");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return totalProductos;
    }

    @Override
    public void actualizarProducto(Producto producto) {
        String consulta = "UPDATE tb_productos SET id_producto, nombre_producto, descripcion_producto, cantidad_producto, "
                + "fecha_producto, disponibilidad_producto, id_area, id_categoria = "
                + "'Multiconector para la placa' WHERE (id_producto = '10');";
        
        try(Connection conexion = MySQLConnection.conectarMySQL()){
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}