package com.inventario.dao;

import com.inventario.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        String consulta = "select * from tb_usuarios";
        
        try(Connection conn = MySQLConnection.conectarMySQL();
            PreparedStatement ps = conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Usuario usuario = new Usuario(
                        rs.getInt("id_user"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("id_rol")
                );
                usuarios.add(usuario);
        }
        }catch(SQLException e){
            e.getMessage();
        }
        return usuarios;
    }
}
