CREATE DATABASE iswdevelopment;
USE iswdevelopment;
CREATE TABLE signed_in(
	id int PRIMARY KEY,
	nombreUsuario text,
	fechaRegistro text,
	correo text
);

CREATE TABLE dioses(
	id int,
	FOREIGN KEY (id) REFERENCES signed_in(id),
	PRIMARY KEY (id)
);

CREATE TABLE jefes(
	id int,
	FOREIGN KEY (id) REFERENCES signed_in(id),
PRIMARY KEY (id)
);

CREATE TABLE administradores(
	id int,
	FOREIGN KEY (id) REFERENCES signed_in(id),
primary key (id)
);

CREATE TABLE personas(
	id int,
	FOREIGN KEY (id) REFERENCES signed_in(id),
PRIMARY KEY(id),
	nombre text,
	apellido1 text,
	apellido2 text,
	telefono int(9),
	direccion text,
	ciudad text,
	cp int(5)
);

CREATE TABLE empleados(
	id int, 
	FOREIGN KEY (id) REFERENCES personas(id),
PRIMARY KEY (id)
);


CREATE TABLE clientes(
	id int,
	FOREIGN KEY (id) REFERENCES personas(id),
	PRIMARY KEY (id)
);


CREATE TABLE pedidos(
	codPedido int PRIMARY KEY,
	fechaPedido text,
	horaPedido text,
	esPagadoPedido boolean,
	id int,
FOREIGN KEY (id) REFERENCES clientes(id)
);



CREATE TABLE productos(
	codProducto int PRIMARY KEY,
	tipoProducto text,
	precioProducto int,
	nombreProducto text,
	descripcionProducto text,
	fotoProducto text
);

CREATE TABLE servicios(
codServicio int PRIMARY KEY,
precioServicio int,
duracionServicio int,
nombreServicio text,
descripcionServicio text,
fotoServicio text
);
CREATE TABLE tintes(
	codTinte int PRIMARY KEY,
	fotoTinte text
);

CREATE TABLE citas(
	codCita int PRIMARY KEY,
	fechaCita text,
	horaCita text,
            duracionCita int
);

CREATE TABLE cita_cliente(
	codCita int,
	codCliente int,
	FOREIGN KEY (codCita) REFERENCES citas(codCita),
FOREIGN KEY (codCliente) REFERENCES clientes(codCliente),
PRIMARY KEY(codCita, codCliente)
);

CREATE TABLE cita_tinte(
	codCita int,
	codTinte int,
	FOREIGN KEY (codCita) REFERENCES citas(codCita),
FOREIGN KEY (codTinte) REFERENCES tintes(codTinte),
PRIMARY KEY (codCita, codTinte)
);



CREATE TABLE cita_empleado(
	codCita int,
	codEmpleado int ,
FOREIGN KEY (codCita REFERENCES citas(codCita),
FOREIGN KEY (codEmpleado) REFERENCES empleados (id),
PRIMARY KEY (codCita, codEmpleado)
);
	
CREATE TABLE cita_servicio(
	codCita int,
	codServicio int,
FOREIGN KEY (codCita) REFERENCES citas(codCita),
FOREIGN KEY (codServicio) REFERENCES servicios (codServicio),
PRIMARY KEY (codCita, codServicio)
);
