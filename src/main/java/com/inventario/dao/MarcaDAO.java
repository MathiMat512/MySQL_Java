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
        String consulta = "select * from tb_marca where estado_marca = 1";
        
        try (Connection conn = MySQLConnection.conectarMySQL();
         PreparedStatement stmt = conn.prepareStatement(consulta);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Marca marca = new Marca(
            rs.getInt("id_marca"),
            rs.getString("descripcion_marca")
            );
            marcas.add(marca);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return marcas;
    }
    
    public void crearMarca(Marca marca){
        String consulta = "INSERT INTO tb_marca "
                + "(descripcion_marca, estado_marca) values (?,1)";
        
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, marca.getDescripcion_marca());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editarMarca(Marca marca){
        String consulta = "UPDATE tb_marca SET \n"
                + " descripcion_marca = ? \n"
                + " WHERE id_marca = ?";
        
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, marca.getDescripcion_marca());
            ps.setInt(2, marca.getId_marca());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarMarca(Marca marca){
        String consulta = "UPDATE tb_marca SET estado_marca = 0 where id_marca = ? ";
        
        try(Connection conexion = MySQLConnection.conectarMySQL();
                PreparedStatement ps = conexion.prepareStatement(consulta)){
            
            ps.setInt(1, marca.getId_marca());
            ps.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
