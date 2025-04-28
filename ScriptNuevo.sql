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
order by a.id_producto asc;

select * from tb_productos;

Update tb_productos
set descripcion_producto = "Teclado",
	und_medida = "-",
	fecha_recepcion = "2025-04-15",
    fecha_salida = "2025-04-16",
	cantidad_producto = 2,
    cod_marca = 2,
    cod_proveedor = 2,
    cod_area = 2, 
    id_categoria = 1
where id_producto = 2;
    
