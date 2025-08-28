drop database if exists registro_estudiante_db;
create database  registro_estudiante_db;
use registro_estudiante_db;

create table Estudiantes(
	 codigo_estudiante int auto_increment, 
     nombre varchar(68), 
     apellido varchar(68), 
     correo varchar(68), 
     constraint pk_estudiante primary key(codigo_estudiante)
); 

create table cursos(
	codigo_curso int auto_increment, 
    nombre_curso varchar(68), 
    codigo_estudiante int null,
    
    constraint pk_cursos primary key(codigo_curso),
    constraint fk_cursos_Estudiantes foreign key(codigo_estudiante)
		references Estudiantes(codigo_estudiante)
); 

insert into Estudiantes(nombre, apellido, correo)
		value("Angel","Reyes","ag@kinal.edu.gt"); 
        