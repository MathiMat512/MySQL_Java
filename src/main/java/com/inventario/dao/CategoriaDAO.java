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
        String consulta = "select * from tb_categoria where estado_categoria = 1";

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
    
    public void guardarCategoria(Categoria categoria){
        String consulta = "INSERT INTO tb_categoria "
                + "(descripcion_categoria, estado_categoria) values (?,1)";
        
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, categoria.getDescripcion_categoria());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editarCategoria(Categoria categoria){
        String consulta = "UPDATE tb_categoria SET \n"
                + " descripcion_categoria = ? \n"
                + " WHERE id_categoria = ?";
        
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, categoria.getDescripcion_categoria());
            ps.setInt(2, categoria.getId_categoria());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarCategoria(Categoria categoria){
        String consulta = "UPDATE tb_categoria SET estado_categoria = 0 where id_categoria = ? ";
        
        try(Connection conexion = MySQLConnection.conectarMySQL();
                PreparedStatement ps = conexion.prepareStatement(consulta)){
            
            ps.setInt(1, categoria.getId_categoria());
            ps.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
