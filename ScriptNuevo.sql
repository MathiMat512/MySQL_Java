SELECT 
    p.id_producto, 
    p.descripcion_producto, 
    p.und_medida, 
    p.fecha_recepcion, 
    p.fecha_salida, 
    p.cantidad_producto,
    m.cod_marca, 
    pr.cod_proveedor, 
    a.cod_area, 
    c.id_categoria
FROM bd_inventario.tb_productos p
INNER JOIN a.tb_marca m ON p.id_marca = m.id_marca
INNER JOIN b.tb_proveedor pr ON p.id_proveedor = pr.id_proveedor
INNER JOIN c.tb_area a ON p.id_area = a.id_area
INNER JOIN d.tb_categoria c ON p.id_categoria = c.id_categoria;
