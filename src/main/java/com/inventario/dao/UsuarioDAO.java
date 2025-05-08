package com.inventario.dao;

import com.inventario.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String consulta = "select \n"
                + "	a.id_user,\n"
                + "    a.username,\n"
                + "    a.password,\n"
                + "    a.nombre,\n"
                + "    a.apellido,\n"
                + "    a.id_rol,\n"
                + "    b.descripcion\n"
                + "FROM \n"
                + "	tb_usuarios a\n"
                + "INNER JOIN \n"
                + "	tb_roles b ON a.id_rol = b.id_rol;";

        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement ps = conn.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_user"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("id_rol"),
                        rs.getString("descripcion")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return usuarios;
    }

    public int totalUsuarios() {
        String consulta = "Select count(username) as Usuarios_totales from tb_usuarios";
        int totalUsuarios = 0;

        try (Connection conexion = MySQLConnection.conectarMySQL()) {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            if (rs.next()) {
                totalUsuarios = rs.getInt("Usuarios_totales");
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return totalUsuarios;
    }

}
