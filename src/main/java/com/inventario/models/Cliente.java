package com.inventario.models;

public class Cliente {
    int Codigo_cliente;
    String Nombre_cliente;
    String Telefono_cliente;
    
    public Cliente(int Codigo_cliente, String Nombre_cliente, String Telefono_cliente){
        this.Codigo_cliente = Codigo_cliente;
        this.Nombre_cliente = Nombre_cliente;
        this.Telefono_cliente = Telefono_cliente;
    }

    public int getCodigo_cliente() {
        return this.Codigo_cliente;
    }

    public void setCodigo_cliente(int Codigo_cliente) {
        this.Codigo_cliente = Codigo_cliente;
    }

    public String getNombre_cliente() {
        return this.Nombre_cliente;
    }

    public void setNombre_cliente(String Nombre_cliente) {
        this.Nombre_cliente = Nombre_cliente;
    }

    public String getTelefono_cliente() {
        return this.Telefono_cliente;
    }

    public void setTelefono_cliente(String Telefono_cliente) {
        this.Telefono_cliente = Telefono_cliente;
    }
}