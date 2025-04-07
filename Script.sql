use bd_prueba;
create table tabla1;
insert into tabla1 values (1, "John", "910837002"),
(2, "Mathias", "910911013"),
(3, "Martina", "90013812");

insert into tabla1 values (4, "Eduardo", "988625110");

select * from tabla1;


-- Store Procedure de Agregar un Producto
DELIMITER //
CREATE PROCEDURE spAgregarProducto(
    IN p_id INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20)
)
BEGIN
    INSERT INTO tabla1(Codigo_cliente, Nombre_cliente, Telefono_Cliente)
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
    IF EXISTS (SELECT 1 FROM tabla1 WHERE Codigo_cliente = p_id) THEN
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
CREATE PROCEDURE spEliminarCliente (
    IN p_id INT
)
BEGIN
    IF EXISTS (SELECT 1 FROM tabla1 WHERE Codigo_cliente = p_id) THEN
        DELETE FROM tabla1
        WHERE Codigo_cliente = p_id;

        SELECT 'Cliente con ID ' AS Mensaje, p_id AS ID, ' eliminado correctamente.' AS Estado;
    ELSE
        SELECT 'Error: No existe ningún cliente con el ID ' AS Mensaje, p_id AS ID;
    END IF;
END //
DELIMITER ;

call spEliminarCliente(5);

