INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico) VALUES("Gerente",1,"Matias","Milla",41558153,35050);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico) VALUES("Gerente",2,"Luana","Traversa",45020342,38000);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico) VALUES("Gerente",3,"Nicolas","Borea",32460034,37500);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico) VALUES("Gerente",4,"Nahuel","Ovejero",45634029,31000);
INSERT INTO persona (dtype,id,nombre,apellido,dni,sueldo_basico) VALUES("Gerente",5,"Gabriel","Fernandez",43495963,25000);

INSERT INTO persona (dtype,id,nombre,apellido,dni,mail) VALUES("Cliente",6,"Alejandra","Vranic",45240342,"alejandravranic@gmail.com");
INSERT INTO persona (dtype,id,nombre,apellido,dni,mail) VALUES("Cliente",7,"Gustavo","Siciliano",32266034,"gussiciliano@gmail.com");
INSERT INTO persona (dtype,id,nombre,apellido,dni,mail) VALUES("Cliente",8,"Romina","Mansilla",45234329,"romina.e.mansilla@gmail.com");

INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(9,"Estanzuela del Rey","Buenos aires",32454,52453,558);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(10,"Uriarte","Buenos aires",35654,22453,120);
INSERT INTO direccion (id,calle,ciudad,latitud,longitud,numero) VALUES(11,"Hipolito Yrigoyen","Buenos aires",42454,82453,420);

INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(12,"Microfono","Samson",450,1);
INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(13,"Microfono","Shure",750,1);
INSERT INTO producto (id,descripcion,marca,precio_unitario,status)VALUES(14,"Auriculares","AudioTechnica",1150,1);

INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(15,15543245,9,1);
INSERT INTO sucursal (id,telefono,direccion_id,gerente_id) VALUES(16,15543245,11,2);

INSERT INTO lote (id,cantidad,cantidad_total,producto_id) VALUES(17,234,235,13);
INSERT INTO lote (id,cantidad,cantidad_total,producto_id) VALUES(18,120,125,14);
