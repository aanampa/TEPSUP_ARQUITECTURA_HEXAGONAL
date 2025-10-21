USE UniversidadDB;
GO

-- Inserción de registros ejemplo para la tabla FACULTAD
INSERT INTO facultad (nombre, descripcion, ubicacion, decano) VALUES
('Facultad de Ingeniería', 'Formación de profesionales en diversas ramas de la ingeniería con estándares internacionales', 'Edificio A - Campus Central', 'Dr. Roberto Mendoza García'),
('Facultad de Ciencias de la Salud', 'Dedicada a la formación de profesionales en medicina, enfermería y especialidades médicas', 'Edificio B - Campus Central', 'Dra. Ana Lucía Fernández Vargas'),
('Facultad de Ciencias Económicas y Empresariales', 'Formación en administración, contabilidad, economía y negocios internacionales', 'Edificio C - Campus Norte', 'Dr. Carlos Eduardo Ramírez Soto'),
('Facultad de Humanidades y Ciencias Sociales', 'Enfoque en psicología, sociología, comunicación y relaciones internacionales', 'Edificio D - Campus Sur', 'Dra. María Elena Cordero Jiménez'),
('Facultad de Ciencias Básicas y Tecnología', 'Especializada en matemáticas, física, química y tecnologías emergentes', 'Edificio E - Campus Este', 'Dr. Javier Antonio Rojas Méndez');


-- Inserción de registros ejemplo para la tabla CARRERA
INSERT INTO carrera (facultad_id, nombre, descripcion, duracion_semestres, titulo_otorgado) VALUES
-- Carreras de la Facultad de Ingeniería (facultad_id = 1)
(1, 'Ingeniería de Sistemas', 'Formación en desarrollo de software, bases de datos y arquitectura de sistemas informáticos', 10, 'Ingeniero de Sistemas'),
(1, 'Ingeniería Civil', 'Formación en diseño, construcción y mantenimiento de obras de infraestructura y edificaciones', 10, 'Ingeniero Civil'),
(1, 'Ingeniería Industrial', 'Especialización en optimización de procesos productivos y gestión de operaciones', 10, 'Ingeniero Industrial'),

-- Carreras de la Facultad de Ciencias de la Salud (facultad_id = 2)
(2, 'Medicina', 'Formación integral en ciencias médicas para el diagnóstico y tratamiento de enfermedades', 12, 'Médico Cirujano'),
(2, 'Enfermería', 'Formación en cuidado integral del paciente y procedimientos de atención en salud', 8, 'Licenciado en Enfermería'),
(2, 'Odontología', 'Especialización en salud bucal, tratamientos dentales y ortodoncia', 10, 'Cirujano Dentista'),

-- Carreras de la Facultad de Ciencias Económicas y Empresariales (facultad_id = 3)
(3, 'Administración de Empresas', 'Formación en gestión organizacional, finanzas y dirección estratégica', 8, 'Licenciado en Administración'),
(3, 'Contaduría Pública', 'Especialización en normas contables, auditoría y finanzas corporativas', 8, 'Contador Público'),
(3, 'Economía', 'Análisis de mercados, políticas económicas y desarrollo financiero', 8, 'Licenciado en Economía'),

-- Carreras de la Facultad de Humanidades y Ciencias Sociales (facultad_id = 4)
(4, 'Psicología', 'Estudio del comportamiento humano y técnicas de intervención psicológica', 10, 'Licenciado en Psicología'),
(4, 'Comunicación Social', 'Formación en periodismo, producción audiovisual y relaciones públicas', 8, 'Licenciado en Comunicación Social'),
(4, 'Sociología', 'Análisis de estructuras sociales y dinámicas de la sociedad contemporánea', 8, 'Licenciado en Sociología'),

-- Carreras de la Facultad de Ciencias Básicas y Tecnología (facultad_id = 5)
(5, 'Matemáticas Aplicadas', 'Formación en modelamiento matemático y solución de problemas complejos', 8, 'Licenciado en Matemáticas Aplicadas'),
(5, 'Física', 'Estudio de las leyes fundamentales del universo y aplicaciones tecnológicas', 8, 'Licenciado en Física'),
(5, 'Química', 'Especialización en análisis químico, síntesis y procesos industriales', 8, 'Licenciado en Química');


