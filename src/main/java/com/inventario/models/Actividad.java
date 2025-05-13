package com.inventario.models;

import java.time.LocalDateTime;

public class Actividad {
    private Integer id_actividad;
    private String descripcion;
    private LocalDateTime fecha_mov;
    private Integer id_user;
    private String username;
    private Integer id_producto;
    private String descripcion_producto;
    
    public Actividad(Integer id_actividad, String descripcion, LocalDateTime fecha_mov, Integer id_user, Integer id_producto){
        this.id_actividad = id_actividad;
        this.descripcion = descripcion;
        this.fecha_mov = fecha_mov;
        this.id_user = id_user;
        this.id_producto = id_producto;
    }
    
    public Actividad(Integer id_actividad, String descripcion, LocalDateTime fecha_mov, Integer id_user, String username, Integer id_producto, String descripcion_producto){
        this.id_actividad = id_actividad;
        this.descripcion = descripcion;
        this.fecha_mov = fecha_mov;
        this.id_user = id_user;
        this.username = username;
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
    }

    public Integer getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(Integer id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha_mov() {
        return fecha_mov;
    }

    public void setFecha_mov(LocalDateTime fecha_mov) {
        this.fecha_mov = fecha_mov;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }
    
}
