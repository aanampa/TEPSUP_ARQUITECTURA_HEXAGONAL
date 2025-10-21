IF NOT EXISTS(SELECT name FROM master.dbo.sysdatabases WHERE name = 'UniversidadDB')
BEGIN
    CREATE DATABASE UniversidadDB;
    PRINT 'Base de datos UniversidadDB creada exitosamente';
END
ELSE
BEGIN
    PRINT 'La base de datos UniversidadDB ya existe';
END
GO