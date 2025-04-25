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
        String consulta = "select * from tb_area";
        
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
}
