SELECT * FROM tb_productos;

Select count(cantidad_producto) as Tipos_de_productos from tb_productos ;

Select sum(cantidad_producto) from tb_productos;

Select count(*) as Total_Categorias from tb_categoria;

Select count(*) as Total_Areas from tb_area;

Select sum(cantidad_producto) AS Total_De_Productos from tb_productos;

-- Store Procedure de Agregar un Producto
DELIMITER //
CREATE PROCEDURE spAgregarProducto(
    IN p_id_producto INT,
    IN p_nombre_producto VARCHAR(200),
    IN p_descripcion_producto VARCHAR(300),
    IN p_cantidad_producto INT,
    IN p_fecha_producto DATE,
    IN p_disponibilidad_producto VARCHAR(2),
    IN p_id_area INT,
    IN p_id_categoria INT
)
BEGIN
    INSERT INTO tb_productos(id_producto, nombre_producto, descripcion_producto, cantidad_producto, fecha_producto, disponibilidad_producto, id_area, id_categoria)
    VALUES (p_id_producto, p_nombre_producto, p_descripcion_producto, p_cantidad_producto, p_fecha_producto, p_disponibilidad_producto, p_id_area, p_id_categoria);
    SELECT 'Producto agregado correctamente.';
END //
DELIMITER ;
call spAgregarProducto (5, "Mouse HP","asdas",1,"2025-03-01","SI",1,1);


-- Store procedure Editar un producto
DELIMITER //
CREATE PROCEDURE spEditarProducto (
    IN p_id INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20)
)
BEGIN
    IF EXISTS (SELECT 1 FROM tb_productos WHERE Codigo_cliente = p_id) THEN
        UPDATE tabla1
        SET Nombre_cliente = p_nombre,
            Telefono_cliente = p_telefono
        WHERE Codigo_cliente = p_id;

        SELECT 'Cliente con ID ' AS Mensaje, p_id AS ID, ' actualizado correctamente.' AS Estado;
    ELSE
        SELECT 'Error: No existe ningún cliente con el ID ' AS Mensaje, p_id AS ID;
    END IF;
END //
DELIMITER ;
call spEditarProducto(3, "Martina", "900138121");


-- Store procedure Eliminar un producto
DELIMITER //
CREATE PROCEDURE spEliminarProducto (
    IN p_id INT
)
BEGIN
    IF EXISTS (SELECT 1 FROM tb_productos WHERE Codigo_cliente = p_id) THEN
        DELETE FROM tabla1
        WHERE Codigo_cliente = p_id;

        SELECT 'Cliente con ID ' AS Mensaje, p_id AS ID, ' eliminado correctamente.' AS Estado;
    ELSE
        SELECT 'Error: No existe ningún cliente con el ID ' AS Mensaje, p_id AS ID;
    END IF;
END //
DELIMITER ;
call spEliminarProducto(5);

