-- Script de inicialización para PostgreSQL
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Tabla FACULTAD
CREATE TABLE IF NOT EXISTS facultad (
    facultad_id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) UNIQUE NOT NULL,
    descripcion TEXT,
    ubicacion VARCHAR(100),
    decano VARCHAR(100),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE
);

-- Tabla CARRERA
CREATE TABLE IF NOT EXISTS carrera (
    carrera_id SERIAL PRIMARY KEY,
    facultad_id INTEGER NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    duracion_semestres INTEGER NOT NULL,
    titulo_otorgado VARCHAR(100),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_facultad FOREIGN KEY (facultad_id) REFERENCES facultad(facultad_id),
    CONSTRAINT uk_carrera_nombre UNIQUE (nombre)
);

-- Insertar datos de ejemplo solo si las tablas están vacías
INSERT INTO facultad (nombre, descripcion, ubicacion, decano)
SELECT 
    'Facultad de Ingeniería', 
    'Formación de profesionales en diversas ramas de la ingeniería', 
    'Edificio A - Campus Central', 
    'Dr. Roberto Mendoza García'
WHERE NOT EXISTS (SELECT 1 FROM facultad WHERE nombre = 'Facultad de Ingeniería');

INSERT INTO facultad (nombre, descripcion, ubicacion, decano)
SELECT 
    'Facultad de Ciencias de la Salud', 
    'Dedicada a la formación de profesionales en medicina', 
    'Edificio B - Campus Central', 
    'Dra. Ana Lucía Fernández Vargas'
WHERE NOT EXISTS (SELECT 1 FROM facultad WHERE nombre = 'Facultad de Ciencias de la Salud');

INSERT INTO facultad (nombre, descripcion, ubicacion, decano)
SELECT 
    'Facultad de Ciencias Económicas', 
    'Formación en administración y negocios', 
    'Edificio C - Campus Norte', 
    'Dr. Carlos Eduardo Ramírez Soto'
WHERE NOT EXISTS (SELECT 1 FROM facultad WHERE nombre = 'Facultad de Ciencias Económicas');

INSERT INTO facultad (nombre, descripcion, ubicacion, decano)
SELECT 
    'Facultad de Humanidades', 
    'Enfoque en psicología y sociología', 
    'Edificio D - Campus Sur', 
    'Dra. María Elena Cordero'
WHERE NOT EXISTS (SELECT 1 FROM facultad WHERE nombre = 'Facultad de Humanidades');

INSERT INTO facultad (nombre, descripcion, ubicacion, decano)
SELECT 
    'Facultad de Ciencias Básicas', 
    'Especializada en matemáticas y física', 
    'Edificio E - Campus Este', 
    'Dr. Javier Rojas'
WHERE NOT EXISTS (SELECT 1 FROM facultad WHERE nombre = 'Facultad de Ciencias Básicas');

-- Insertar carreras
INSERT INTO carrera (facultad_id, nombre, descripcion, duracion_semestres, titulo_otorgado)
SELECT 
    1, 'Ingeniería de Sistemas', 'Formación en desarrollo de software', 10, 'Ingeniero de Sistemas'
WHERE NOT EXISTS (SELECT 1 FROM carrera WHERE nombre = 'Ingeniería de Sistemas');

INSERT INTO carrera (facultad_id, nombre, descripcion, duracion_semestres, titulo_otorgado)
SELECT 
    1, 'Ingeniería Civil', 'Formación en construcción', 10, 'Ingeniero Civil'
WHERE NOT EXISTS (SELECT 1 FROM carrera WHERE nombre = 'Ingeniería Civil');

INSERT INTO carrera (facultad_id, nombre, descripcion, duracion_semestres, titulo_otorgado)
SELECT 
    2, 'Medicina', 'Formación en ciencias médicas', 12, 'Médico Cirujano'
WHERE NOT EXISTS (SELECT 1 FROM carrera WHERE nombre = 'Medicina');

INSERT INTO carrera (facultad_id, nombre, descripcion, duracion_semestres, titulo_otorgado)
SELECT 
    2, 'Enfermería', 'Cuidado integral del paciente', 8, 'Licenciado en Enfermería'
WHERE NOT EXISTS (SELECT 1 FROM carrera WHERE nombre = 'Enfermería');

INSERT INTO carrera (facultad_id, nombre, descripcion, duracion_semestres, titulo_otorgado)
SELECT 
    3, 'Administración de Empresas', 'Gestión organizacional', 8, 'Licenciado en Administración'
WHERE NOT EXISTS (SELECT 1 FROM carrera WHERE nombre = 'Administración de Empresas');