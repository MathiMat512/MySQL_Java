use bd_prueba;

SELECT * FROM tb_productos;
SELECT * FROM tb_categoria;
SELECT * FROM tb_area;

CREATE TABLE `tb_productos` (
  `id_producto` int NOT NULL,
  `nombre_producto` varchar(200) DEFAULT NULL,
  `categoria_producto` varchar(100) DEFAULT NULL,
  `descripcion_producto` varchar(300) DEFAULT NULL,
  `cantidad_producto` int DEFAULT NULL,
  `fecha_producto` date DEFAULT NULL,
  `area_producto` varchar(45) DEFAULT NULL,
  `disponibilidad_producto` varchar(2) DEFAULT NULL,
  `id_area` int DEFAULT NULL,
  `id_categoria` int DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`),
  CONSTRAINT fk_id_categoria
	FOREIGN KEY (id_categoria)
    REFERENCES tb_categoria(id_categoria),
  CONSTRAINT fk_id_area
	FOREIGN KEY (id_area)
    REFERENCES tb_area(id_area)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Creación de la tabla de categoria
CREATE TABLE `bd_prueba`.`tb_categoria` (
  `id_categoria` INT NOT NULL,
  `nombre_categoria` VARCHAR(100) NULL,
  `descripcion_categoria` VARCHAR(200) NULL,
  UNIQUE INDEX `id_categoria_UNIQUE` (`id_categoria` ASC) VISIBLE,
  PRIMARY KEY (`id_categoria`));

-- Creacion de la tabla de area
CREATE TABLE `bd_prueba`.`tb_area` (
  `id_area` INT NOT NULL,
  `nombre_area` VARCHAR(200) NULL,
  `descripcion_area` VARCHAR(200) NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE INDEX `id_area_UNIQUE` (`id_area` ASC) VISIBLE);
  
-- Consulta inner join
  SELECT 
    p.id_producto,
    p.nombre_producto,
    p.descripcion_producto,
    p.cantidad_producto,
    p.fecha_producto,
    p.disponibilidad_producto,
    p.id_area,
    a.nombre_area,
    p.id_categoria,
    c.nombre_categoria
FROM tb_productos p
INNER JOIN tb_area a ON p.id_area = a.id_area
INNER JOIN tb_categoria c ON p.id_categoria = c.id_categoria;
