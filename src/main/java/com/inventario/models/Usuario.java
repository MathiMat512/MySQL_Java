package com.inventario.models;

public class Usuario {
    private Integer id_usuario;
    private String username;
    private String usuario;
    private String nombre;
    private String apellido;
    private int id_rol;
    
    public Usuario(Integer id_usuario, String username, String usuario, String nombre,
            String apellido, int id_rol){
        this.id_usuario = id_usuario;
        this.username = username;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_rol = id_rol;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
    
    
}
