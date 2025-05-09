package com.inventario.dao;

import com.inventario.models.Rol;
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
                + "    b.descripcion_rol\n"
                + "FROM \n"
                + "	tb_usuarios a\n"
                + "INNER JOIN \n"
                + "	tb_roles b ON a.id_rol = b.id_rol where estado_usuario = 1;";

        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement ps = conn.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_user"),
                        rs.getString("username"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("id_rol"),
                        rs.getString("descripcion_rol")
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

    public List<Rol> listarRoles(){
        List<Rol> roles = new ArrayList<>();
        
        String consulta = "Select * from tb_roles";
        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(consulta); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Rol rol = new Rol(
                    rs.getString("descripcion_rol")
                );
                roles.add(rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return roles;
    }
    
    public void crearUsuario(){
        String consulta = "";
    }
    
    public void editarUsuario(){
        String consulta = "";
    }
    
    public void eliminarUsuario(){
        String consulta = "";
    }
}
