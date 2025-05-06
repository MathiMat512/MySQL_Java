package com.inventario.dao;

import com.inventario.models.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    public List<Proveedor> listarProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String consulta = "select * from tb_proveedor where estado_proveedor = 1";

        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement ps = conn.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("descripcion_proveedor")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return proveedores;
    }

    public void guardarProveedor(Proveedor proveedor) {
        String consulta = "INSERT INTO tb_proveedor (descripcion_proveedor) VALUES (?)";

        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, proveedor.getDescripcion_proveedor());

            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Proveedor guardado correctamente.");
            } else {
                System.out.println("Error al guardar el proveedor.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarProveedor(Proveedor proveedor) {
        String consulta = "UPDATE tb_proveedor SET \n"
                + "descripcion_proveedor = ? \n"
                + "WHERE id_proveedor = ?";

        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, proveedor.getDescripcion_proveedor()); // Set the new description
            ps.setInt(2, proveedor.getId_proveedor());           // Set the ID for the WHERE clause
            ps.executeUpdate(); // Execute the UPDATE statement

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarProveedor(Proveedor proveedor){
        String consulta = "UPDATE tb_proveedor SET estado_proveedor = 0 where id_proveedor = ? ";
        
        try(Connection conexion = MySQLConnection.conectarMySQL();
                PreparedStatement ps = conexion.prepareStatement(consulta)){
            
            ps.setInt(1, proveedor.getId_proveedor());
            ps.executeQuery();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
