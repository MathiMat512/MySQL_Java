package com.inventario.dao;

import com.inventario.models.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActividadDAO {

    public List<Actividad> listarActividadesPaginadas(int limite, int pagina) {
        List<Actividad> actividades = new ArrayList<>();
        String consulta = "SELECT a.id_actividad, a.descripcion, a.fecha_mov, a.id_user, "
                + "b.username, a.id_producto, c.descripcion_producto "
                + "FROM tb_actividades a "
                + "INNER JOIN tb_usuarios b ON a.id_user = b.id_user "
                + "INNER JOIN tb_productos c ON a.id_producto = c.id_producto "
                + "ORDER BY a.fecha_mov DESC LIMIT ? OFFSET ?";

        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            int offset = (pagina - 1) * limite;
            ps.setInt(1, limite);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actividades;
    }

    public int totalActividades() {
        String consulta = "select count(id_actividad) as totalActividades from tb_actividades";
        int totalActividades = 0;

        try (Connection conexion = MySQLConnection.conectarMySQL()) {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            if (rs.next()) {
                totalActividades = rs.getInt("totalActividades");
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return totalActividades;
    }
}
