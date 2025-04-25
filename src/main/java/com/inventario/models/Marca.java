package com.inventario.models;

public class Marca {
    Integer id_marca;
    String descripcion_marca;
    String modelo;
    
    public Marca(Integer id_marca, String descripcion_marca, String modelo){
        this.id_marca = id_marca;
        this.descripcion_marca = descripcion_marca;
        this.modelo = modelo;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Marca{" + "id_marca=" + id_marca + ", descripcion_marca=" +
                descripcion_marca + ", modelo=" + modelo + '}';
    }
}
