select * from tb_actividades;
select * from tb_usuarios;
select * from tb_roles;
select * from tb_transacciones;


SELECT * FROM tb_productos;
select * from tb_marca;
select * from tb_proveedor;
select * from tb_area;
select * from tb_categoria;

select * from tb_proveedor where estado_proveedor = 1;

UPDATE tb_categoria SET estado_categoria = 0 where id_categoria = 5;

UPDATE tb_proveedor SET estado_proveedor = 0 where id_proveedor = 4;

UPDATE tb_usuarios SET username = 'prueba', nombre='Carlos', apellido='Martinez', id_rol=2 where id_user=2;

UPDATE tb_usuarios SET estado_usuario=0 where id_user=2;


ALTER TABLE tb_actividades
ADD COLUMN tipo_actividad ENUM('entrada', 'salida') NOT NULL DEFAULT 'entrada';

SHOW TRIGGERS WHERE `Table` = 'tb_productos';

DELIMITER //

CREATE TRIGGER trg_UpdateCantidadProducto
AFTER UPDATE ON tb_productos
FOR EACH ROW
BEGIN
    DECLARE diferencia INT;
    DECLARE tipo_transaccion VARCHAR(7);
    DECLARE fecha_movimiento DATETIME;
    DECLARE saldo_actual INT;

    -- Calcular la diferencia entre la nueva y la antigua cantidad
    SET diferencia = NEW.cantidad_producto - OLD.cantidad_producto;

    -- Determinar el tipo de transacción
    IF diferencia > 0 THEN
        SET tipo_transaccion = 'entrada';
    ELSEIF diferencia < 0 THEN
        SET tipo_transaccion = 'salida';
    ELSE
        SET tipo_transaccion = NULL; -- No insertar si no hay cambio
    END IF;

    -- Si hay cambio, registrar la transacción
    IF tipo_transaccion IS NOT NULL THEN
        -- Establecer la fecha actual
        SET fecha_movimiento = NOW();

        -- El saldo actual es igual a la nueva cantidad
        SET saldo_actual = NEW.cantidad_producto;

        -- Insertar el registro en tb_transacciones
        INSERT INTO tb_transacciones (id_producto, fecha_movimiento, tipo_transaccion, cantidad, saldo_actual)
        VALUES (NEW.id_producto, fecha_movimiento, tipo_transaccion, diferencia, saldo_actual);
    END IF;
END //

DELIMITER ;