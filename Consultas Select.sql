select * from tb_actividades;
select * from tb_usuarios;
select * from tb_roles;
select * from tb_transacciones;

select count(id_actividad) as totalActividades from tb_actividades;
SELECT 
    a.id_producto, 
    a.descripcion_producto, 
    a.und_medida, 
    a.cantidad_producto,
    a.cod_marca, 
    b.descripcion_marca, 
    a.cod_proveedor, 
    c.descripcion_proveedor,
    a.cod_area, 
    d.descripcion_area, 
    a.id_categoria, 
    e.descripcion_categoria
FROM 
    tb_productos a
INNER JOIN 
    tb_marca b ON a.cod_marca = b.id_marca
INNER JOIN 
    tb_proveedor c ON a.cod_proveedor = c.id_proveedor
INNER JOIN 
    tb_area d ON a.cod_area = d.id_area
INNER JOIN 
    tb_categoria e ON a.id_categoria = e.id_categoria
WHERE 
    a.estado_producto = 1 
    AND a.descripcion_producto LIKE 'mouse';
    
select * from tb_categoria where estado_categoria = 1 and descripcion_categoria LIKE 'Tintas';



SELECT * FROM tb_productos;
select * from tb_marca;
select * from tb_proveedor;
select * from tb_area;
select * from tb_categoria;


select username, password from tb_usuarios;

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
