package com.inventario.dao;

import com.inventario.models.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActividadDAO {
    
    public List<Actividad> listarActividades() {
        List<Actividad> actividades = new ArrayList<>();
        String consulta = "select \n"
                + "	a.id_actividad,\n"
                + "    a.descripcion,\n"
                + "    a.fecha_mov,\n"
                + "    a.id_user,\n"
                + "    b.username,\n"
                + "    a.id_producto,\n"
                + "    c.descripcion_producto\n"
                + "FROM\n"
                + "	tb_actividades a\n"
                + "INNER JOIN\n"
                + "	tb_usuarios b ON a.id_user = b.id_user\n"
                + "INNER JOIN\n"
                + "	tb_productos c ON a.id_producto = c.id_producto;";
        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Actividad actividad = new Actividad(
                        rs.getInt("id_actividad"),
                        rs.getString("descripcion"),
                        rs.getObject("fecha_mov", LocalDateTime.class),
                        rs.getInt("id_user"),
                        rs.getString("username"),
                        rs.getInt("id_producto"),
                        rs.getString("descripcion_producto")
                );
                actividades.add(actividad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actividades;
    }
}
