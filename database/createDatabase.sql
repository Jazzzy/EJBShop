# source  C:/Users/gladi/Documents/GitHub/gestionBibliotecaISO/baseDeDatos/createDatabase.sql;


DROP DATABASE EJBtienda;

CREATE DATABASE EJBtienda;

use EJBtienda;

CREATE TABLE Pedidos(
	id INT NOT NULL AUTO_INCREMENT,
	nombreUsuario VARCHAR(30) NOT NULL,
	fecha DATE NOT NULL,
	precioTotal DECIMAL(20,5) NOT NULL,
	PRIMARY KEY (id)
);