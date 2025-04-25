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
}
