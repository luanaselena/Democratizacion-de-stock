INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",1,"Matias","Milla",41558153,35050,"2000-04-02","09:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",2,"Luana","Traversa",45020342,38000,"2000-05-04","09:00:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",3,"Nicolas","Borea",32460034,37500,"2001-05-04","09:00:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",4,"Nahuel","Ovejero",45634029,31000,"1999-06-04","09:00:00");
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada) VALUES("Gerente",5,"Gabriel","Fernandez",43495963,25000,"1999-05-04","09:00:00");

INSERT INTO persona (dtype,id,nombre,apellido,dni,mail,fecha_de_nacimiento) VALUES("Cliente",6,"Alejandra","Vranic",45240342,"alejandravranic@gmail.com","1998-06-24");
INSERT INTO persona (dtype,id,nombre,apellido,dni,mail,fecha_de_nacimiento) VALUES("Cliente",7,"Gustavo","Siciliano",32266034,"gussiciliano@gmail.com","2003-05-04");
INSERT INTO persona (dtype,id,nombre,apellido,dni,mail,fecha_de_nacimiento) VALUES("Cliente",8,"Romina","Mansilla",45234329,"romina.e.mansilla@gmail.com","2002-02-14");

INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada,plus) VALUES("Vendedor",19,"Lautaro","Montalibet",43241111,25200,"1999-05-04","09:00:00",550);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada,plus) VALUES("Vendedor",20,"Juan","Trinidad",43242222,25200,"1990-11-04","06:00:00",520);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada,plus) VALUES("Vendedor",30,"Kevin","Nak",43243333,25200,"1999-01-01","09:00:00",550);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada,plus) VALUES("Vendedor",31,"Tomas","Silvestre",43244444,25200,"1990-02-02","06:00:00",520);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico,fecha_de_nacimiento,horas_por_jornada,plus) VALUES("Vendedor",32,"Samu","Rai",43245555,25200,"1990-05-05","06:00:00",520);

INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(9,"Estanzuela del Rey","Buenos aires",32454,52453,558);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(10,"Uriarte","Buenos aires",35654,22453,120);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(11,"Hipolito Yrigoyen","Buenos aires",42454,82453,420);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(21,"Manuel Francisco","Buenos aires",22454,72453,320);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(22,"Laprida","Buenos aires",22754,62453,122);

INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(12,"Microfono","Samson",450,1);
INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(13,"Microfono2","Shure",750,1);
INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(14,"Auriculares","AudioTechnica",1150,1);
INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(23,"Teclado Mecanico","Razer",33000,1);

INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(15,15543245,9,1);
INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(16,15543245,11,2);
INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(29,15543245,10,3);
INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(24,15541235,21,4);
INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(25,15543321,22,5);

INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(17,234,235,13,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(18,120,125,14,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(26,234,235,12,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(27,120,125,23,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(28,120,125,23,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(33,234,235,13,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(34,120,125,14,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(35,234,235,12,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(36,120,125,23,"2020-05-04");
INSERT INTO lote (id,cantidad,cantidad_total,producto_id,fecha_ingreso) VALUES(37,120,125,23,"2020-05-04");

INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(15,17);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(15,18);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(29,27);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(24,28);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(25,33);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(15,34);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(29,35);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(24,36);
INSERT INTO sucursal_lotes (sucursal_id,lotes_id) VALUES(25,37);

INSERT INTO sucursal_vendedores (sucursal_id,vendedores_id) VALUES(15,19);
INSERT INTO sucursal_vendedores (sucursal_id,vendedores_id) VALUES(16,20);
INSERT INTO sucursal_vendedores (sucursal_id,vendedores_id) VALUES(29,30);
INSERT INTO sucursal_vendedores (sucursal_id,vendedores_id) VALUES(24,31);
INSERT INTO sucursal_vendedores (sucursal_id,vendedores_id) VALUES(25,32);

INSERT INTO venta (id, fecha, hora, precio_total, idcliente,idvendedor) VALUES(19,"2020-05-04","09:00:00",14400,6,19);

INSERT INTO pedido (id,aceptado,cantidad,productoid) VALUES(20,false,32,12);

INSERT INTO venta_pedidos (venta_id,pedidos_id) VALUES(19,20);
