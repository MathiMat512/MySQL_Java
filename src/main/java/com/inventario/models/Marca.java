package com.inventario.models;

public class Marca {
    Integer id_marca;
    String descripcion_marca;
    
    public Marca(Integer id_marca, String descripcion_marca){
        this.id_marca = id_marca;
        this.descripcion_marca = descripcion_marca;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getDescripcion_marca() {
        return descripcion_marca;
    }

    public void setDescripcion_marca(String descripcion_marca) {
        this.descripcion_marca = descripcion_marca;
    }
}
