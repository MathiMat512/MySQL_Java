package com.inventario.models;

public class Usuario {

    private Integer id_user;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private Integer id_rol;
    private String descripcion;

    public Usuario(Integer id_user, String username, String nombre,
            String apellido, int id_rol, String descripcion) {
        this.id_user = id_user;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_rol = id_rol;
        this.descripcion = descripcion;
    }
    
    public Usuario(String username, String password, String nombre, 
            String apellido, Integer id_rol){
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_rol = id_rol;
    }

    public Integer getId_User() {
        return id_user;
    }

    public void setId_User(Integer id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
