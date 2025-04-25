package com.inventario.dao;
import com.inventario.models.Area;
import com.inventario.models.Categoria;
import com.inventario.models.Producto;
import com.inventario.models.Proveedor;
import java.util.List;

public interface ProductoDAO {
    List<Producto> listarProductos();
    List<Proveedor> listarProveedores();
    List<Area> listarAreas();
    List<Categoria> listarCategorias();
    public int totalCantidades();
    public int productosRegistrados();
    public void buscarProductoporId();
    public void guardarProducto(Producto producto);
    /*public void actualizarProducto(Producto producto);
    public void eliminarProducto(int id);
    */
}