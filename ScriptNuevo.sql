SELECT
	a.id_producto,
    a.descripcion_producto,
    a.und_medida,
    a.fecha_recepcion,
    a.fecha_salida,
    a.cantidad_producto,
    a.cod_marca,
    b.descripcion_marca,
    b.modelo,
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
    
