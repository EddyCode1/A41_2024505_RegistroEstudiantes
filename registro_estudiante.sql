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
    
    constraint pk_cursos primary key(codigo_curso)
    
); 

insert into Estudiantes(nombre, apellido, correo)
		value("Angel","Reyes","ag@kinal.edu.gt"); 
        
        