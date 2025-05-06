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


Select sum(cantidad_producto) AS Total_Cantidades from tb_productos where estado_producto=1;

Select count(cantidad_producto) as Productos_Registrados from tb_productos where estado_producto=1;

UPDATE tb_productos SET estado_producto = 1 WHERE id_producto = 3;