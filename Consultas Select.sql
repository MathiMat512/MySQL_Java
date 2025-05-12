select * from tb_actividades;
	select * from tb_usuarios;
select * from tb_roles;


SELECT * FROM tb_productos;
select * from tb_marca;
select * from tb_proveedor;
select * from tb_area;
select * from tb_categoria;

select * from tb_proveedor where estado_proveedor = 1;

UPDATE tb_categoria SET estado_categoria = 0 where id_categoria = 5;

UPDATE tb_proveedor SET estado_proveedor = 0 where id_proveedor = 4;

UPDATE tb_usuarios SET username = 'prueba', nombre='Carlos', apellido='Martinez', id_rol=2 where id_user=2

UPDATE tb_usuarios SET estado_usuario=0 where id_user=?