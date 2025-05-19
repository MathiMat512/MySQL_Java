SELECT
	a.id_producto,
    a.descripcion_producto,
    a.und_medida,
    a.fecha_recepcion,
    a.fecha_salida,
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
where estado_producto=1
order by a.id_producto;


select 
	a.id_actividad,
    a.descripcion,
    a.fecha_mov,
    a.id_user,
    b.username,
    a.id_producto,
    c.descripcion_producto
FROM
	tb_actividades a
INNER JOIN
	tb_usuarios b ON a.id_user = b.id_user
INNER JOIN
	tb_productos c ON a.id_producto = c.id_producto;



select * from tb_transacciones;

select
	a.id_transaccion,
    a.id_producto,
    b.descripcion_producto,
    a.fecha_movimiento,
    a.tipo_transaccion,
    a.cantidad,
    a.cantidad_actual
FROM 
	tb_transacciones a
INNER JOIN
	tb_productos b ON a.id_producto = b.id_producto;


Select sum(cantidad_producto) AS Total_Cantidades from tb_productos where estado_producto=1;

Select count(cantidad_producto) as Productos_Registrados from tb_productos where estado_producto=1;

UPDATE tb_productos SET estado_producto = 1 WHERE id_producto = 3;

