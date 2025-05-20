package com.inventario.models;

import java.sql.Date;

public class Producto {
    private Integer id_producto;
    private String descripcion_producto;
    private String und_medida;
    private Integer cantidad_producto;
    private Integer cod_marca;
    private String descripcion_marca;
    private Integer cod_proveedor;
    private String descripcion_proveedor;
    private Integer cod_area;
    private String descripcion_area;
    private Integer id_categoria;
    private String descripcion_categoria;

    public Producto(Integer id_producto, String descripcion_producto, String und_medida,Integer cantidad_producto, 
            Integer cod_marca, String descripcion_marca, Integer cod_proveedor,String descripcion_proveedor, 
            Integer cod_area, String descripcion_area, Integer id_categoria, String descripcion_categoria) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.und_medida = und_medida;
        this.cantidad_producto = cantidad_producto;
        this.cod_marca = cod_marca;
        this.descripcion_marca = descripcion_marca;
        this.cod_proveedor = cod_proveedor;
        this.descripcion_proveedor = descripcion_proveedor;
        this.cod_area = cod_area;
        this.descripcion_area = descripcion_area;
        this.id_categoria = id_categoria;
        this.descripcion_categoria = descripcion_categoria;
    }
    
    public Producto(String descripcion_producto, String und_medida, Integer cantidad_producto,
            Integer cod_marca, Integer cod_proveedor, Integer cod_area, Integer id_categoria){
        this.descripcion_producto = descripcion_producto;
        this.und_medida = und_medida;
        this.cantidad_producto = cantidad_producto;
        this.cod_marca = cod_marca;
        this.cod_proveedor = cod_proveedor;
        this.cod_area = cod_area;
        this.id_categoria = id_categoria;
    }
    
    public Producto(Integer id_producto){
        this.id_producto = id_producto;
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
}