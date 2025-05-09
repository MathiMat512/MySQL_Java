package com.inventario.dao;
import com.inventario.models.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO {
    public List<Area> listarAreas (){
        List<Area> areas = new ArrayList<>();
        String consulta = "select * from tb_area where estado_area = 1";
        
        try (Connection conn = MySQLConnection.conectarMySQL();
            PreparedStatement ps = conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
            Area area = new Area(
            rs.getInt("id_area"),
            rs.getString("descripcion_area")
            );
            areas.add(area);
        }
        }catch(SQLException e){
            e.getMessage();
        }
        return areas;
    }
    
    public void crearArea(Area area){
        String consulta = "INSERT INTO tb_area "
                + "(descripcion_area, estado_area) values (?,1)";
        
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, area.getDescripcion_area());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editarArea(Area area){
        String consulta = "UPDATE tb_area SET \n"
                + " descripcion_area = ? \n"
                + " WHERE id_area = ?";
        
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, area.getDescripcion_area());
            ps.setInt(2, area.getId_area());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarArea(Area area){
        String consulta = "UPDATE tb_area SET estado_area = 0 where id_area = ? ";
        
        try(Connection conexion = MySQLConnection.conectarMySQL();
                PreparedStatement ps = conexion.prepareStatement(consulta)){
            
            ps.setInt(1, area.getId_area());
            ps.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
