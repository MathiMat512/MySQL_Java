package com.inventario.dao;
import com.inventario.models.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        String consulta = "select * from tb_categoria";

        try(Connection conn = MySQLConnection.conectarMySQL();
            PreparedStatement ps = conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
            Categoria categoria = new Categoria(
            rs.getInt("id_categoria"),
            rs.getString("descripcion_categoria")
            );
            categorias.add(categoria);
        }
        }
        catch(SQLException e){
                e.getMessage();
        }
        return categorias;
    }
}
