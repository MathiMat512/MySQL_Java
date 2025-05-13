DELIMITER //
CREATE TRIGGER tb_productos_AFTER_INSERT
AFTER INSERT ON tb_productos
FOR EACH ROW
BEGIN
    INSERT INTO tb_actividades (descripcion, fecha_mov, id_user, id_producto)
    VALUES ('Se insertó el producto con ID: ' || NEW.id_producto, NOW(), 1, NEW.id_producto);
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tb_productos_AFTER_UPDATE
AFTER UPDATE ON tb_productos
FOR EACH ROW
BEGIN
    INSERT INTO tb_actividades (descripcion, fecha_mov, id_user, id_producto)
    VALUES (
        CONCAT(
            'Se modificó el producto con ID: ', id_producto, '. '
        ),
        NOW(),
        @current_user_id,
        OLD.id_producto
    );
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tb_productos_AFTER_DELETE
AFTER DELETE ON tb_productos
FOR EACH ROW
BEGIN
    INSERT INTO tb_actividades (descripcion, fecha_mov, id_user, id_producto)
    VALUES ('Se eliminó el producto con ID: ' || OLD.id_producto, NOW(), @current_user_id, OLD.id_producto);
END;
//
DELIMITER ;