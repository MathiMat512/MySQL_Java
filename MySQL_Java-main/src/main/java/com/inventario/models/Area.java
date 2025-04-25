package com.inventario.models;

public class Area {
    Integer id_area;
    String descripcion_area;
    
    public Area(Integer id_area, String descripcion_area){
        this.id_area = id_area;
        this.descripcion_area = descripcion_area;
    }

    public Integer getId_area() {
        return id_area;
    }

    public void setId_area(Integer id_area) {
        this.id_area = id_area;
    }

    public String getDescripcion_area() {
        return descripcion_area;
    }

    public void setDescripcion_area(String descripcion_area) {
        this.descripcion_area = descripcion_area;
    }

    @Override
    public String toString() {
        return "Area{" + "id_area=" + id_area + ", descripcion_area=" + descripcion_area + '}';
    }
    
    
}
