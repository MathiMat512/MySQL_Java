package com.inventario.dao;
import com.inventario.models.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO {
    public List<Marca> listarMarcas(){
        List<Marca> marcas = new ArrayList<>();
        String consulta = "select * from tb_marca";
        
        try (Connection conn = MySQLConnection.conectarMySQL();
         PreparedStatement stmt = conn.prepareStatement(consulta);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Marca marca = new Marca(
            rs.getInt("id_marca"),
            rs.getString("descripcion_marca"),
            rs.getString("modelo")
            );
            marcas.add(marca);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return marcas;
    }
}
