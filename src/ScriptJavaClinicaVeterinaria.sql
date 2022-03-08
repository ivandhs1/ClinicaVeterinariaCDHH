create database bd_clinica;

use bd_clinica

create table persona(
	id_persona int primary key not null,
    nombre_persona varchar(45) default null,
    profesion_persona varchar(45) default null,
    telefono_persona varchar(45) default null,
    tipo_persona int not null,
    nacimiento_id int not null
);

create table nacimiento(
	id_nacimiento int not null auto_increment primary key,
    ciudad_nacimiento varchar(45) default null,
    departamento_nacimiento varchar(45) default null,
    fecha_nacimiento date default null,
    pais_nacimiento varchar(45) default null
);

alter table persona
add index fk_persona_nacimiento (nacimiento_id ASC);
alter table persona
add constraint fk_persona_nacimiento
	foreign key (nacimiento_id)
    references nacimiento (id_nacimiento)
    on delete no action
    on update no action

