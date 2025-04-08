-- Store Procedure de Agregar un Producto
DELIMITER //
CREATE PROCEDURE spAgregarProducto(
    IN p_id INT,
    IN p_nombre VARCHAR(200),
    IN p_descripcion VARCHAR(300),
    IN p_cantidad INT,
    IN p_fecha DATE,
    IN p_disponibilidad VARCHAR(2),
    IN P_area INT,
    IN P_categoria INT
)
BEGIN
    INSERT INTO tb_productos(id_producto, nombre_producto, descripcion_producto, cantidad_producto, fecha_producto, disponibilidad_producto, id_area, id_categoria)
    VALUES (p_id, p_nombre, p_telefono);
    SELECT 'Cliente agregado correctamente.';
END //
DELIMITER ;
call spAgregarProducto (5, "Camila","90033813");


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

