package com.inventario.dao;
import com.inventario.models.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    public List<Proveedor> listarProveedores(){
        List<Proveedor> proveedores = new ArrayList<>();
        String consulta = "select * from tb_proveedor";
        
        try(Connection conn = MySQLConnection.conectarMySQL();
            PreparedStatement ps = conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Proveedor proveedor = new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("descripcion_proveedor")
                );
                proveedores.add(proveedor);
        }
        }catch(SQLException e){
            e.getMessage();
        }
        return proveedores;
    }
    
    public void guardarProveedor(Proveedor proveedor){
        String consulta = "INSERT INTO tb_proveedor (descripcion_proveedor) VALUES (?)";
        
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement st = conexion.prepareStatement(consulta)) {

            st.setString(1, proveedor.getDescripcion_proveedor());

            int filasInsertadas = st.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Proveedor guardado correctamente.");
            } else {
                System.out.println("Error al guardar el proveedor.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
