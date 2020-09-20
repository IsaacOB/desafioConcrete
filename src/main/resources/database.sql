CREATE DATABASE desafioConcrete
GO

USE[desafioConcrete]
GO


CREATE TABLE formulario (
	id VARCHAR(128) PRIMARY KEY,
	email VARCHAR(50),
	name VARCHAR(50),
	password VARCHAR(15),
	created DATE,
	modified DATE,
	last_login DATE,
	token VARCHAR(128)
)
GO

CREATE TABLE phone (
	id INTEGER PRIMARY KEY, 
	ddd INTEGER,
	numero VARCHAR(10),
	FormID VARCHAR(128) FOREIGN KEY REFERENCES formulario(id)
)
GO

