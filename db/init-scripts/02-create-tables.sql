-- Script para crear tablas
USE UniversidadDB;
GO

-- Tabla FACULTAD
CREATE TABLE facultad (
    facultad_id INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) UNIQUE NOT NULL,
    descripcion TEXT,
    ubicacion VARCHAR(100),
    decano VARCHAR(100),
    fecha_registro DATETIME2 DEFAULT GETDATE(),
    activo BIT DEFAULT 1
)
GO

-- Tabla CARRERA
CREATE TABLE carrera (
    carrera_id INT IDENTITY(1,1) PRIMARY KEY,
    facultad_id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    duracion_semestres INT NOT NULL,
    titulo_otorgado VARCHAR(100),
    fecha_registro DATETIME2 DEFAULT GETDATE(),
    activo BIT DEFAULT 1,
    CONSTRAINT fk_carrera_facultad FOREIGN KEY (facultad_id) REFERENCES facultad(facultad_id) ON DELETE NO ACTION,
    CONSTRAINT uk_carrera_nombre UNIQUE (nombre)
)
GO