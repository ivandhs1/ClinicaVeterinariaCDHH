create database bd_clinica;



use bd_clinica;

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

create table mascotas(
	id_mascotas int primary key not null,
	color varchar(45),
	nombre varchar(45),
	raza varchar(45),
	sexo varchar(45),
	persona_id int
);

create table productos 
(
	id_producto int primary key not null,
    nombre_producto varchar(45),
    precio_producto double
);

create table personas_producto
(
	id_personasproducto int primary key auto_increment,
	persona_id int,
    producto_id int
);

alter table persona
add index fk_persona_nacimiento (nacimiento_id ASC);
alter table persona
add constraint fk_persona_nacimiento
	foreign key (nacimiento_id)
    references nacimiento (id_nacimiento)
    on delete no action
    on update no action;

alter table mascotas
add index fk_mascotas_persona (persona_id ASC);
alter table mascotas
add constraint fk_mascotas_persona
	foreign key (persona_id)
	references persona (id_persona)
	on delete no action
	on update no action;
    
ALTER TABLE `bd_clinica`.`personas_producto` 
ADD INDEX `fk_persona_id_id_persona_idx` (`persona_id` ASC) ;
;
ALTER TABLE `bd_clinica`.`personas_producto` 
ADD CONSTRAINT `fk_persona_id_id_persona`
  FOREIGN KEY (`persona_id`)
  REFERENCES `bd_clinica`.`persona` (`id_persona`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `bd_clinica`.`personas_producto` 
ADD INDEX `fk_producto_id_id_producto_idx` (`producto_id` ASC);
;
ALTER TABLE `bd_clinica`.`personas_producto` 
ADD CONSTRAINT `fk_producto_id_id_producto`
  FOREIGN KEY (`producto_id`)
  REFERENCES `bd_clinica`.`productos` (`id_producto`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  