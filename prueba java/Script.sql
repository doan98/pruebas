


create table pelicula (
id int primary key auto_increment,
nombre varchar (100),
duracion int,
estado char (1)
);



create table pelicula_sala_cine(
id int primary key auto_increment,
fecha_publicacion datetime,
fecha_fin datetime,
id_pelicula int,
id_sala_cine int,
estado char(1)
);


create table sala_cine(
id int primary key auto_increment,
nombre varchar(100),
estado char (1)
);

INSERT INTO pelicula (nombre, duracion, estado) VALUES
('Pelicula 1', 120, 'A'),
('Pelicula 2', 90, 'A'),
('Pelicula 3', 105, 'A');

INSERT INTO sala_cine (nombre, estado) VALUES
('Sala 1', 'A'),
('Sala 2', 'A'),
('Sala 3', 'A');

INSERT INTO pelicula_sala_cine (fecha_publicacion, fecha_fin, id_pelicula, id_sala_cine, estado) VALUES
('2023-06-01', '2023-06-15', 1, 1, 'A');

-- Asociar la película 2 con la sala 2
INSERT INTO pelicula_sala_cine (fecha_publicacion, fecha_fin, id_pelicula, id_sala_cine, estado) VALUES
('2023-06-10', '2023-06-20', 2, 2, 'A');

-- Asociar la película 3 con la sala 3
INSERT INTO pelicula_sala_cine (fecha_publicacion, fecha_fin, id_pelicula, id_sala_cine, estado) VALUES
('2023-06-15', '2023-06-25', 3, 3, 'A');


SELECT p.*
FROM pelicula p
JOIN pelicula_sala_cine psc ON psc.id_pelicula = p.id
JOIN sala_cine sc ON sc.id = psc.id_sala_cine
WHERE sc.nombre = 'Sala 1';

SELECT p.*
FROM pelicula p
JOIN pelicula_sala_cine psc ON psc.id_pelicula = p.id
WHERE '2023-06-12' BETWEEN psc.fecha_publicacion AND psc.fecha_fin;

SELECT p.nombre AS pelicula, sc.nombre AS sala_cine
FROM pelicula p
JOIN pelicula_sala_cine psc ON psc.id_pelicula = p.id
JOIN sala_cine sc ON sc.id = psc.id_sala_cine;

