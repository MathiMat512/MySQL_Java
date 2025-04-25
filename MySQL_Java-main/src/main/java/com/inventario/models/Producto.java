package com.inventario.models;

import java.sql.Date;

public class Producto {
    Integer id_producto;
    String descripcion_producto;
    String und_medida;
    Date fecha_recepcion;
    Date fecha_salida;
    Integer cantidad_producto;
    Integer cod_marca;
    String descripcion_marca;
    String modelo;
    Integer cod_proveedor;
    String descripcion_proveedor;
    Integer cod_area;
    String descripcion_area;
    Integer id_categoria;
    String descripcion_categoria;

    public Producto(Integer id_producto, String descripcion_producto, String und_medida, Date fecha_recepcion, Date fecha_salida,
            Integer cantidad_producto, Integer cod_marca, String descripcion_marca, String modelo, Integer cod_proveedor,
            String descripcion_proveedor, Integer cod_area, String descripcion_area, Integer id_categoria, String descripcion_categoria) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.und_medida = und_medida;
        this.fecha_recepcion = fecha_recepcion;
        this.fecha_salida = fecha_salida;
        this.cantidad_producto = cantidad_producto;
        this.cod_marca = cod_marca;
        this.descripcion_marca = descripcion_marca;
        this.modelo = modelo;
        this.cod_proveedor = cod_proveedor;
        this.descripcion_proveedor = descripcion_proveedor;
        this.cod_area = cod_area;
        this.descripcion_area = descripcion_area;
        this.id_categoria = id_categoria;
        this.descripcion_categoria = descripcion_categoria;
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

    public String getUnd_medida() {
        return und_medida;
    }

    public void setUnd_medida(String und_medida) {
        this.und_medida = und_medida;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Integer getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(Integer cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public Integer getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(Integer cod_marca) {
        this.cod_marca = cod_marca;
    }

    public String getDescripcion_marca() {
        return descripcion_marca;
    }

    public void setDescripcion_marca(String descripcion_marca) {
        this.descripcion_marca = descripcion_marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(Integer cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getDescripcion_proveedor() {
        return descripcion_proveedor;
    }

    public void setDescripcion_proveedor(String descripcion_proveedor) {
        this.descripcion_proveedor = descripcion_proveedor;
    }

    public Integer getCod_area() {
        return cod_area;
    }

    public void setCod_area(Integer cod_area) {
        this.cod_area = cod_area;
    }

    public String getDescripcion_area() {
        return descripcion_area;
    }

    public void setDescripcion_area(String descripcion_area) {
        this.descripcion_area = descripcion_area;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", descripcion_producto=" + descripcion_producto + ", und_medida=" 
                + und_medida + ", fecha_recepcion=" + fecha_recepcion + ", fecha_salida=" + fecha_salida + ", cantidad_producto="
                + cantidad_producto + ", cod_marca=" + cod_marca + ", descripcion_marca=" + descripcion_marca + ", modelo="
                + modelo + ", cod_proveedor=" + cod_proveedor + ", descripcion_proveedor=" + descripcion_proveedor + ", cod_area="
                + cod_area + ", descripcion_area=" + descripcion_area + ", id_categoria=" + id_categoria + ", descripcion_categoria=" 
                + descripcion_categoria + '}';
    }
}