package com.inventario.models;
import java.sql.Date;

public class Producto {
    int id_producto;
    String nombre_producto;
    String descripcion_producto;
    int cantidad_producto;
    Date fecha_producto;
    String disponibilidad_producto;
    int id_area;
    String nombre_area;
    int id_categoria;
    String categoria_producto;
    
    public Producto(int id_producto, String nombre_producto, String descripcion_producto, int cantidad_producto, Date fecha_producto, String disponibilidad_producto, int id_area, String nombre_area, int id_categoria, String categoria_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.categoria_producto = categoria_producto;
        this.descripcion_producto = descripcion_producto;
        this.cantidad_producto = cantidad_producto;
        this.fecha_producto = fecha_producto;
        this.disponibilidad_producto = disponibilidad_producto;
        this.id_area = id_area;
        this.nombre_area = nombre_area;
        this.id_categoria = id_categoria;
        this.categoria_producto = categoria_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public Date getFecha_producto() {
        return fecha_producto;
    }

    public void setFecha_producto(Date fecha_producto) {
        this.fecha_producto = fecha_producto;
    }

    public String getDisponibilidad_producto() {
        return disponibilidad_producto;
    }

    public void setDisponibilidad_producto(String disponibilidad_producto) {
        this.disponibilidad_producto = disponibilidad_producto;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria_producto() {
        return categoria_producto;
    }

    public void setCategoria_producto(String categoria_producto) {
        this.categoria_producto = categoria_producto;
    }
}