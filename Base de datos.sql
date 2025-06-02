-- Script para crear la base de datos del sistema de mascotas
CREATE DATABASE IF NOT EXISTS Mascotas;
USE Mascotas;

-- Tabla Cliente
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    paterno VARCHAR(50) NOT NULL,
    materno VARCHAR(50),
    fecha_nacimiento DATE,
    curp VARCHAR(18),
    numero_tarjeta BIGINT,
    cvc SMALLINT
);

-- Tabla Mascota
CREATE TABLE Mascota (
    id_mascota INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    vacunas TEXT,
    disponible BOOLEAN DEFAULT TRUE
);

-- Tabla Veterinario
CREATE TABLE Veterinario (
    id_veterinario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    paterno VARCHAR(50) NOT NULL,
    materno VARCHAR(50),
    fecha_nacimiento DATE,
    curp VARCHAR(18),
    numero_cedula INT UNIQUE
);

-- Tabla Cita
CREATE TABLE Cita (
    id_cita INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_mascota INT,
    id_veterinario INT,
    fecha_hora DATETIME,
    descripcion varchar(200),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_mascota) REFERENCES Mascota(id_mascota),
    FOREIGN KEY (id_veterinario) REFERENCES Veterinario(id_veterinario)
);

-- Insertar algunos datos de ejemplo
INSERT INTO Cliente (nombre, paterno, curp, numero_tarjeta, cvc) VALUES 
('Juan', 'Pérez', 'JUAP850101HDFRXN01', 1234567812345678, 123);

INSERT INTO Mascota (nombre, raza, vacunas) VALUES 
('Firulais', 'Labrador', 'Rabia,Parvovirus'),
('Michi', 'Persa', 'Rabia,Triple');

INSERT INTO Veterinario (nombre, paterno, curp, numero_cedula) VALUES 
('Dr. Carlos', 'López', 'CARL800515HDFLPR02', 12345);