package com.inventario.models;

public class Proveedor {
    Integer id_proveedor;
    String descripcion_proveedor;
    
    public Proveedor(Integer id_proveedor, String descripcion_proveedor){
        this.id_proveedor = id_proveedor;
        this.descripcion_proveedor = descripcion_proveedor;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getDescripcion_proveedor() {
        return descripcion_proveedor;
    }

    public void setDescripcion_proveedor(String descripcion_proveedor) {
        this.descripcion_proveedor = descripcion_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", descripcion_proveedor=" + descripcion_proveedor + '}';
    }
}
