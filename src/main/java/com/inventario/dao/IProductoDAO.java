package com.inventario.dao;
import com.inventario.models.Categoria;
import com.inventario.models.Producto;
import com.inventario.models.Proveedor;
import java.util.List;

public interface IProductoDAO {
    List<Producto> listarProductos(int limite);
    List<Proveedor> listarProveedores();
    List<Categoria> listarCategorias();
    public int totalCantidades();
    public int productosRegistrados();
    public void buscarProductoporId();
    public void guardarProducto(Producto producto);
    public void actualizarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
}