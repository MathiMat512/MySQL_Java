package com.inventario.dao;

import com.inventario.models.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO {

    public List<Transaccion> listarTransacciones(int limite) {
        List<Transaccion> transacciones = new ArrayList<>();
        String consulta = "select\n"
                + "	a.id_transaccion,\n"
                + "    a.id_producto,\n"
                + "    b.descripcion_producto,\n"
                + "    a.fecha_movimiento,\n"
                + "    a.tipo_transaccion,\n"
                + "    a.cantidad,\n"
                + "    a.cantidad_actual\n"
                + "FROM \n"
                + "	tb_transacciones a\n"
                + "INNER JOIN\n"
                + "	tb_productos b ON a.id_producto = b.id_producto LIMIT ?;";

        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement ps = conn.prepareStatement(consulta)) {

            if (limite > 0) {
                ps.setInt(1, limite);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Transaccion transaccion = new Transaccion(
                            rs.getInt("id_transaccion"),
                            rs.getInt("id_producto"),
                            rs.getString("descripcion_producto"),
                            rs.getObject("fecha_movimiento", LocalDateTime.class),
                            rs.getString("tipo_transaccion"),
                            rs.getInt("cantidad"),
                            rs.getInt("cantidad_actual")
                    );
                    transacciones.add(transaccion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transacciones;
    }
}
