package com.inventario.dao;
import com.inventario.models.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String consulta = "select * from tabla1";
            
        try (Connection conn = MySQLConnection.conectarMySQL();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("Codigo_cliente"),
                        rs.getString("Nombre_cliente"),
                        rs.getString("Telefono_cliente")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
}
