package com.inventario.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class Transaccion {
    private Integer id_transaccion;
    private Integer id_producto;
    private String descripcion_producto;
    private LocalDateTime fecha_movimiento;
    private String tipo_transaccion;
    private Integer cantidad;
    private Integer cantidad_actual;
    
    public Transaccion(Integer id_transaccion, Integer id_producto, 
            String descripcion_producto, LocalDateTime fecha_movimiento, String tipo_transaccion,
            Integer cantidad, Integer cantidad_actual){
            this.id_transaccion = id_transaccion;
            this.id_producto = id_producto;
            this.descripcion_producto = descripcion_producto;
            this.fecha_movimiento = fecha_movimiento;
            this.tipo_transaccion = tipo_transaccion;
            this.cantidad = cantidad;
            this.cantidad_actual = cantidad_actual;
    }

    public Integer getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Integer id_transaccion) {
        this.id_transaccion = id_transaccion;
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

    public LocalDateTime getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(LocalDateTime fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(Integer cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }
}
