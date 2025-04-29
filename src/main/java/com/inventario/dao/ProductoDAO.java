package com.inventario.dao;

import com.inventario.models.Categoria;
import com.inventario.models.Producto;
import com.inventario.models.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO implements IProductoDAO {

    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String consulta = "SELECT\n"
                + "	a.id_producto,\n"
                + "    a.descripcion_producto,\n"
                + "    a.und_medida,\n"
                + "    a.fecha_recepcion,\n"
                + "    a.fecha_salida,\n"
                + "    a.cantidad_producto,\n"
                + "    a.cod_marca,\n"
                + "    b.descripcion_marca,\n"
                + "    a.cod_proveedor,\n"
                + "    c.descripcion_proveedor,\n"
                + "    a.cod_area,\n"
                + "    d.descripcion_area,\n"
                + "    a.id_categoria,\n"
                + "    e.descripcion_categoria\n"
                + "FROM\n"
                + "	tb_productos a\n"
                + "INNER JOIN\n"
                + "	tb_marca b ON a.cod_marca = b.id_marca\n"
                + "INNER JOIN\n"
                + "	tb_proveedor c ON a.cod_proveedor = c.id_proveedor\n"
                + "INNER JOIN \n"
                + "	tb_area d ON a.cod_area = d.id_area\n"
                + "INNER JOIN \n"
                + "	tb_categoria e ON a.id_categoria = e.id_categoria\n"
                + "order by a.id_producto";

        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement ps = conn.prepareStatement(consulta); ResultSet rs = ps.executeQuery(consulta)) {

            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getString("und_medida"),
                        rs.getDate("fecha_recepcion"),
                        rs.getDate("fecha_salida"),
                        rs.getInt("cantidad_producto"),
                        rs.getInt("cod_marca"),
                        rs.getString("descripcion_marca"),
                        rs.getInt("cod_proveedor"),
                        rs.getString("descripcion_proveedor"),
                        rs.getInt("cod_area"),
                        rs.getString("descripcion_area"),
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion_categoria")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public List<Proveedor> listarProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String consulta = "select * from tb_proveedor";

        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(consulta); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("descripcion_proveedor")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedores;
    }

    @Override
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String consulta = "select * from tb_categoria";

        try (Connection conn = MySQLConnection.conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(consulta); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion_categoria")
                );
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    @Override
    public int totalCantidades() {
        String consulta = "Select sum(cantidad_producto) AS Total_Cantidades from tb_productos;";
        int totalCantidad = 0;

        try (Connection conexion = MySQLConnection.conectarMySQL()) {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            if (rs.next()) {
                totalCantidad = rs.getInt("Total_Cantidades");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCantidad;
    }

    @Override
    public int productosRegistrados() {
        String consulta = "Select count(cantidad_producto) as Productos_Registrados from tb_productos;";
        int totalProductos = 0;

        try (Connection conexion = MySQLConnection.conectarMySQL()) {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            if (rs.next()) {
                totalProductos = rs.getInt("Productos_Registrados");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalProductos;
    }

    @Override
    public void buscarProductoporId() {

    }

    @Override
    public void guardarProducto(Producto producto) {
        String consulta = "INSERT INTO tb_productos (descripcion_producto, und_medida, fecha_recepcion, fecha_salida, "
                + "cantidad_producto, cod_marca, cod_proveedor, cod_area, id_categoria) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement st = conexion.prepareStatement(consulta)) {

            st.setString(1, producto.getDescripcion_producto());
            st.setString(2, producto.getUnd_medida());
            st.setDate(3, producto.getFecha_recepcion());
            st.setDate(4, producto.getFecha_salida());
            st.setInt(5, producto.getCantidad_producto());
            st.setInt(6, producto.getCod_marca());
            st.setInt(7, producto.getCod_proveedor());
            st.setInt(8, producto.getCod_area());
            st.setInt(9, producto.getId_categoria());

            int filasInsertadas = st.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Producto guardado correctamente.");
            } else {
                System.out.println("Error al guardar el producto.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarProducto(Producto producto) {
        String consulta = "UPDATE tb_productos SET \n"
                + "descripcion_producto = ?, \n"
                + "und_medida = ?, \n"
                + "fecha_recepcion = ?, \n"
                + "fecha_salida = ?, \n"
                + "cantidad_producto = ?, \n"
                + "cod_marca = ?, \n"
                + "cod_proveedor = ?, \n"
                + "cod_area = ?, \n"
                + "id_categoria = ? \n"
                + "WHERE id_producto = ?";

        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, producto.getDescripcion_producto());
            ps.setString(2, producto.getUnd_medida());
            ps.setDate(3, producto.getFecha_recepcion());
            ps.setDate(4, producto.getFecha_salida());
            ps.setInt(5, producto.getCantidad_producto());
            ps.setInt(6, producto.getCod_marca());
            ps.setInt(7, producto.getCod_proveedor());
            ps.setInt(8, producto.getCod_area());
            ps.setInt(9, producto.getId_categoria());
            ps.setInt(10, producto.getId_producto());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 1) {
                System.out.println("✅ Producto actualizado correctamente.");
            } else {
                System.out.println("❌ No se actualizó el producto. Filas afectadas: " + filasAfectadas);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminarProducto(Producto producto) /*throws SQLException */{
        String consulta = "DELETE FROM tb_productos WHERE id_producto = ?";

        try (Connection conexion = MySQLConnection.conectarMySQL(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setInt(1, producto.getId_producto());
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 0) {
                throw new SQLException("No se encontró el producto con ID: " + producto.getId_producto());
            }
        } catch (SQLException e) {
            try {
                throw new SQLException("Error al eliminar el producto: " + e.getMessage(), e);
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
