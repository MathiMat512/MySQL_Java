select * from tb_actividades;
select * from tb_usuarios;
select * from tb_roles;
select * from tb_transacciones;


SELECT * FROM tb_productos;
select * from tb_marca;
select * from tb_proveedor;
select * from tb_area;
select * from tb_categoria;

SELECT * FROM tb_actividades LIMIT 15;

select * from tb_proveedor where estado_proveedor = 1;

UPDATE tb_categoria SET estado_categoria = 0 where id_categoria = 5;

UPDATE tb_proveedor SET estado_proveedor = 0 where id_proveedor = 4;

UPDATE tb_usuarios SET username = 'prueba', nombre='Carlos', apellido='Martinez', id_rol=2 where id_user=2;

UPDATE tb_usuarios SET estado_usuario=0 where id_user=2;


ALTER TABLE tb_actividades
ADD COLUMN tipo_actividad ENUM('entrada', 'salida') NOT NULL DEFAULT 'entrada';

SHOW TRIGGERS WHERE `Table` = 'tb_productos';

-- Llave foránea para relacionar tb_transacciones con tb_productos
ALTER TABLE `bd_inventario`.`tb_transacciones`
ADD CONSTRAINT `fk_transacciones_producto`
  FOREIGN KEY (`id_producto`)
  REFERENCES `bd_inventario`.`tb_productos` (`id_producto`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
