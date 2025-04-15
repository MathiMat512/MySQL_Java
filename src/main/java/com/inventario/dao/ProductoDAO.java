package com.inventario.dao;
import com.inventario.models.Producto;
import java.util.List;

public interface ProductoDAO {
    List<Producto> listarProductos();
    public void guardarProducto(Producto producto);
    public void actualizarProducto(Producto producto);
    public void eliminarProducto(int id);
    public int totalCantidades();
    public int productosRegistrados();
}