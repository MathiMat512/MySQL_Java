package com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    public boolean validarUsuario(String username, String password){
        boolean esUsuario = false;
        String consulta = "SELECT * FROM tb_usuarios WHERE username = ? AND password = ?";
        try(Connection conexion = MySQLConnection.conectarMySQL();) {
            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                esUsuario = true;
            }
            rs.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return esUsuario;
    }
}
