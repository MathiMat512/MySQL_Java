package com.inventario.dao;
import com.inventario.models.Area;
import com.inventario.models.Categoria;
import com.inventario.models.Producto;
import com.inventario.models.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String consulta = "SELECT\n" +
            "	a.id_producto,\n" +
            "    a.descripcion_producto,\n" +
            "    a.und_medida,\n" +
            "    a.fecha_recepcion,\n" +
            "    a.fecha_salida,\n" +
            "    a.cantidad_producto,\n" +
            "    a.cod_marca,\n" +
            "    b.descripcion_marca,\n" +
            "    b.modelo,\n" +
            "    a.cod_proveedor,\n" +
            "    c.descripcion_proveedor,\n" +
            "    a.cod_area,\n" +
            "    d.descripcion_area,\n" +
            "    a.id_categoria,\n" +
            "    e.descripcion_categoria\n" +
            "FROM\n" +
            "	tb_productos a\n" +
            "INNER JOIN\n" +
            "	tb_marca b ON a.cod_marca = b.id_marca\n" +
            "INNER JOIN\n" +
            "	tb_proveedor c ON a.cod_proveedor = c.id_proveedor\n" +
            "INNER JOIN \n" +
            "	tb_area d ON a.cod_area = d.id_area\n" +
            "INNER JOIN \n" +
            "	tb_categoria e ON a.id_categoria = e.id_categoria";

        try (Connection conn = MySQLConnection.conectarMySQL(); 
                PreparedStatement ps = conn.prepareStatement(consulta); 
                ResultSet rs = ps.executeQuery(consulta)) {

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
                rs.getString("modelo"),
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
    public List<Proveedor> listarProveedores(){
        List<Proveedor> proveedores = new ArrayList<>();
        String consulta = "select * from tb_proveedor";
        
        try (Connection conn = MySQLConnection.conectarMySQL();
         PreparedStatement stmt = conn.prepareStatement(consulta);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Proveedor proveedor = new Proveedor(
            rs.getInt("id_proveedor"),
            rs.getString("descripcion_proveedor")
            );
            proveedores.add(proveedor);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return proveedores;
    }
    
    @Override
    public List<Area> listarAreas(){
        List<Area> areas = new ArrayList<>();
        String consulta = "select * from tb_area";
        
        try (Connection conn = MySQLConnection.conectarMySQL();
         PreparedStatement stmt = conn.prepareStatement(consulta);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Area area = new Area(
            rs.getInt("id_area"),
            rs.getString("descripcion_area")
            );
            areas.add(area);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return areas;
    }
    
    @Override
    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        String consulta = "select * from tb_categoria";
        
        try (Connection conn = MySQLConnection.conectarMySQL();
         PreparedStatement stmt = conn.prepareStatement(consulta);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Categoria categoria = new Categoria(
            rs.getInt("id_categoria"),
            rs.getString("descripcion_categoria")
            );
            categorias.add(categoria);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return categorias;
    }
    
    @Override
    public int totalCantidades(){
        String consulta = "Select sum(cantidad_producto) AS Total_Cantidades from tb_productos;";
        int totalCantidad = 0;
        
        try(Connection conexion = MySQLConnection.conectarMySQL()){
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            
            if(rs.next()){
                totalCantidad=rs.getInt("Total_Cantidades");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return totalCantidad;
    }
    
    @Override
    public int productosRegistrados(){
        String consulta = "Select count(cantidad_producto) as Productos_Registrados from tb_productos;";
        int totalProductos = 0;
        
        try(Connection conexion = MySQLConnection.conectarMySQL()){
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            
            if(rs.next()){
                totalProductos=rs.getInt("Productos_Registrados");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return totalProductos;
    }
    
    @Override
    public void buscarProductoporId(){
        
    }

    @Override
    public void guardarProducto(Producto producto) {
        String consulta = "INSERT INTO tb_productos (descripcion_producto, und_medida, fecha_recepcion, fecha_salida"
                + "cantidad_producto, descripcion_marca, modelo, descripcion_proveedor, descripcion_area, descripcion_categoria) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = MySQLConnection.conectarMySQL(); 
                PreparedStatement st = conexion.prepareStatement(consulta)) {

            st.setString(1, producto.getDescripcion_producto());
            st.setString(2, producto.getUnd_medida());
            st.setDate(3, producto.getFecha_recepcion());
            st.setDate(4, producto.getFecha_salida());
            st.setInt(5, producto.getCantidad_producto());
            st.setString(6, producto.getDescripcion_marca());
            st.setString(7, producto.getModelo());
            st.setString(8, producto.getDescripcion_proveedor());
            st.setString(8, producto.getDescripcion_area());
            st.setString(8, producto.getDescripcion_categoria());

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
    
    /*@Override
    public void actualizarProducto(Producto producto) {
        String consulta = "UPDATE tb_productos SET id_producto, nombre_producto, descripcion_producto, cantidad_producto, "
                + "fecha_producto, disponibilidad_producto, id_area, id_categoria = "
                + "'Multiconector para la placa' WHERE (id_producto = '10');";
        
        try(Connection conexion = MySQLConnection.conectarMySQL()){
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/
}