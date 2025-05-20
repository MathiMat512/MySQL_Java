package com.inventario.models;

public class Rol {
    private Integer id_rol;
    private String descripcion_rol;
    
    public Rol(Integer id_rol, String descripcion_rol){
        this.id_rol = id_rol;
        this.descripcion_rol = descripcion_rol;
    }

    public Rol(String descripcion_rol){
        this.descripcion_rol = descripcion_rol;
    }
    
    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }
    
    
}
