drop database if exists registro_estudiante_db;
create database  registro_estudiante_db;
use registro_estudiante_db;
 
create table Estudiante(
	 codigo_estudiante int auto_increment, 
     nombre varchar(68), 
     apellido varchar(68), 
     correo varchar(68), 
     constraint pk_estudiante primary key(codigo_estudiante)
);
 
create table Cursos(
	codigo_curso int auto_increment, 
    nombre_curso varchar(68), 
    codigo_estudiante int, 
    constraint pk_cursos primary key(codigo_curso), 
    constraint fk_Cursos foreign key(codigo_estudiante)
		references Estudiante(codigo_estudiante)
);
 
insert into Estudiante(nombre, apellido, correo)
		value("Angel","Reyes","ag@kinal.edu.gt"); 
insert into Cursos(nombre_curso, codigo_estudiante)
		value('Matematica', 1),
			('Fisica', 1),
            ('Etica', 1); 
select * from Estudiante; 