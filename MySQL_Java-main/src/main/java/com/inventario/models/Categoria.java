package com.inventario.models;

public class Categoria {
    Integer id_categoria;
    String descripcion_categoria;
    
    public Categoria(Integer id_categoria, String descripcion_categoria){
        this.id_categoria = id_categoria;
        this.descripcion_categoria = descripcion_categoria;
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
        return "Categoria{" + "id_categoria=" + id_categoria + ", descripcion_categoria=" + descripcion_categoria + '}';
    }
}
