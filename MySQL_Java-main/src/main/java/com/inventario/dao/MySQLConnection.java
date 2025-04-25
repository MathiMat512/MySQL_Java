package com.inventario.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String database = "bd_inventario";
    public static final String hostname = "localhost";
    public static final String port = "3306";
    public static final String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC";
    public static final String username = "root";
    public static final String password = "mathias123";

    public static Connection conectarMySQL() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}