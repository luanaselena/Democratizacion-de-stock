INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",1,"Matias","Milla",41558153,35050,"2000-04-02","09:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",2,"Luana","Traversa",45020342,38000,"2000-05-04","09:00:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",3,"Nicolas","Borea",32460034,37500,"2001-05-04","09:00:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",4,"Nahuel","Ovejero",45634029,31000,"1999-06-04","09:00:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",5,"Gabriel","Fernandez",43495963,25000,"1999-05-04","09:00:00");

INSERT INTO persona (dtype,id,nombre,apellido,dni,mail,fecha_de_nacimiento) VALUES("Cliente",6,"Alejandra","Vranic",45240342,"alejandravranic@gmail.com","1998-06-24");
INSERT INTO persona (dtype,id,nombre,apellido,dni,mail,fecha_de_nacimiento) VALUES("Cliente",7,"Gustavo","Siciliano",32266034,"gussiciliano@gmail.com","2003-05-04");
INSERT INTO persona (dtype,id,nombre,apellido,dni,mail,fecha_de_nacimiento) VALUES("Cliente",8,"Romina","Mansilla",45234329,"romina.e.mansilla@gmail.com","2002-02-14");

INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada,plus) VALUES("Vendedor",19,"Juan","Perez",43243963,25200,"1999-05-04","09:00:00",550);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada,plus) VALUES("Vendedor",20,"Pedro","Gauna",43242343,25200,"1990-11-04","06:00:00",520);

INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(9,"Estanzuela del Rey","Buenos aires",32454,52453,558);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(10,"Uriarte","Buenos aires",35654,22453,120);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(11,"Hipolito Yrigoyen","Buenos aires",42454,82453,420);

INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(12,"Microfono","Samson",450,1);
INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(13,"Microfono2","Shure",750,1);
INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(14,"Auriculares","AudioTechnica",1150,1);

INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(15,15543245,9,1);
INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(16,15543245,11,2);

INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(17,234,235,13,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(18,120,125,14,"2020-05-04");

INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(15,17);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(15,18);

INSERT INTO sucursal_vendedores (sucursal_id,vendedores_id) VALUES(15,19);

INSERT INTO venta (id, fecha, hora, precio_total, idcliente,idvendedor) VALUES(19,"2020-05-04","09:00:00",0,6,19);

INSERT INTO pedido (id,aceptado,cantidad,productoid) VALUES(20,false,32,12);

INSERT INTO venta_pedidos (venta_id,pedidos_id) VALUES(19,20);
