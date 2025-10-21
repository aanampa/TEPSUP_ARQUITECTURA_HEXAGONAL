using Dapper;
using UniversidadAPI.Data;
using UniversidadAPI.Models;

namespace UniversidadAPI.Repositories
{
    public class CarreraRepository : ICarreraRepository
    {
        private readonly DatabaseContext _context;

        public CarreraRepository(DatabaseContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<Carrera>> GetAllAsync()
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                SELECT 
                    carrera_id AS CarreraId,
                    facultad_id AS FacultadId,
                    nombre AS Nombre,
                    descripcion AS Descripcion,
                    duracion_semestres AS DuracionSemestres,
                    titulo_otorgado AS TituloOtorgado,
                    fecha_registro AS FechaRegistro,
                    activo AS Activo
                FROM carrera 
                WHERE activo = 1";
            return await connection.QueryAsync<Carrera>(sql);
        }

        public async Task<Carrera?> GetByIdAsync(int id)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                SELECT 
                    carrera_id AS CarreraId,
                    facultad_id AS FacultadId,
                    nombre AS Nombre,
                    descripcion AS Descripcion,
                    duracion_semestres AS DuracionSemestres,
                    titulo_otorgado AS TituloOtorgado,
                    fecha_registro AS FechaRegistro,
                    activo AS Activo
                FROM carrera 
                WHERE carrera_id = @Id AND activo = 1";
            return await connection.QueryFirstOrDefaultAsync<Carrera>(sql, new { Id = id });
        }

        public async Task<IEnumerable<Carrera>> GetByFacultadIdAsync(int facultadId)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                SELECT 
                    carrera_id AS CarreraId,
                    facultad_id AS FacultadId,
                    nombre AS Nombre,
                    descripcion AS Descripcion,
                    duracion_semestres AS DuracionSemestres,
                    titulo_otorgado AS TituloOtorgado,
                    fecha_registro AS FechaRegistro,
                    activo AS Activo
                FROM carrera 
                WHERE facultad_id = @FacultadId AND activo = 1";
            return await connection.QueryAsync<Carrera>(sql, new { FacultadId = facultadId });
        }

        public async Task<Carrera> CreateAsync(Carrera carrera)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                INSERT INTO carrera (facultad_id, nombre, descripcion, duracion_semestres, titulo_otorgado)
                OUTPUT INSERTED.carrera_id AS CarreraId, 
                       INSERTED.facultad_id AS FacultadId, 
                       INSERTED.nombre AS Nombre, 
                       INSERTED.descripcion AS Descripcion,
                       INSERTED.duracion_semestres AS DuracionSemestres, 
                       INSERTED.titulo_otorgado AS TituloOtorgado, 
                       INSERTED.fecha_registro AS FechaRegistro, 
                       INSERTED.activo AS Activo
                VALUES (@FacultadId, @Nombre, @Descripcion, @DuracionSemestres, @TituloOtorgado)";

            return await connection.QuerySingleAsync<Carrera>(sql, carrera);
        }

        public async Task<Carrera?> UpdateAsync(int id, Carrera carrera)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                UPDATE carrera 
                SET nombre = @Nombre, 
                    descripcion = @Descripcion, 
                    duracion_semestres = @DuracionSemestres, 
                    titulo_otorgado = @TituloOtorgado,
                    activo = @Activo
                WHERE carrera_id = @CarreraId;
                
                SELECT 
                    carrera_id AS CarreraId,
                    facultad_id AS FacultadId,
                    nombre AS Nombre,
                    descripcion AS Descripcion,
                    duracion_semestres AS DuracionSemestres,
                    titulo_otorgado AS TituloOtorgado,
                    fecha_registro AS FechaRegistro,
                    activo AS Activo
                FROM carrera WHERE carrera_id = @CarreraId";

            var parameters = new
            {
                CarreraId = id,
                carrera.Nombre,
                carrera.Descripcion,
                carrera.DuracionSemestres,
                carrera.TituloOtorgado,
                carrera.Activo
            };

            return await connection.QueryFirstOrDefaultAsync<Carrera>(sql, parameters);
        }

        public async Task<bool> DeleteAsync(int id)
        {
            using var connection = _context.CreateConnection();
            var sql = "UPDATE carrera SET activo = 0 WHERE carrera_id = @Id";
            var affectedRows = await connection.ExecuteAsync(sql, new { Id = id });
            return affectedRows > 0;
        }

        public async Task<bool> ExistsAsync(int id)
        {
            using var connection = _context.CreateConnection();
            var sql = "SELECT COUNT(1) FROM carrera WHERE carrera_id = @Id AND activo = 1";
            return await connection.ExecuteScalarAsync<bool>(sql, new { Id = id });
        }

        public async Task<bool> ExistsByNameAsync(string nombre)
        {
            using var connection = _context.CreateConnection();
            var sql = "SELECT COUNT(1) FROM carrera WHERE nombre = @Nombre AND activo = 1";
            return await connection.ExecuteScalarAsync<bool>(sql, new { Nombre = nombre });
        }

        public async Task<Carrera?> GetWithFacultadAsync(int id)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                SELECT 
                    c.carrera_id AS CarreraId,
                    c.facultad_id AS FacultadId,
                    c.nombre AS Nombre,
                    c.descripcion AS Descripcion,
                    c.duracion_semestres AS DuracionSemestres,
                    c.titulo_otorgado AS TituloOtorgado,
                    c.fecha_registro AS FechaRegistro,
                    c.activo AS Activo,
                    f.facultad_id AS FacultadId,
                    f.nombre AS Nombre,
                    f.descripcion AS Descripcion,
                    f.ubicacion AS Ubicacion,
                    f.decano AS Decano,
                    f.fecha_registro AS FechaRegistro,
                    f.activo AS Activo
                FROM carrera c
                INNER JOIN facultad f ON c.facultad_id = f.facultad_id
                WHERE c.carrera_id = @Id AND c.activo = 1 AND f.activo = 1";

            var result = await connection.QueryAsync<Carrera, Facultad, Carrera>(
                sql,
                (carrera, facultad) =>
                {
                    carrera.Facultad = facultad;
                    return carrera;
                },
                new { Id = id },
                splitOn: "FacultadId"  // Cambiado para que coincida con el alias
            );

            return result.FirstOrDefault();
        }

        public async Task<IEnumerable<Carrera>> GetAllWithFacultadAsync()
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                SELECT 
                    c.carrera_id AS CarreraId,
                    c.facultad_id AS FacultadId,
                    c.nombre AS Nombre,
                    c.descripcion AS Descripcion,
                    c.duracion_semestres AS DuracionSemestres,
                    c.titulo_otorgado AS TituloOtorgado,
                    c.fecha_registro AS FechaRegistro,
                    c.activo AS Activo,
                    f.facultad_id AS FacultadId,
                    f.nombre AS Nombre,
                    f.descripcion AS Descripcion,
                    f.ubicacion AS Ubicacion,
                    f.decano AS Decano,
                    f.fecha_registro AS FechaRegistro,
                    f.activo AS Activo
                FROM carrera c
                INNER JOIN facultad f ON c.facultad_id = f.facultad_id
                WHERE c.activo = 1 AND f.activo = 1
                ORDER BY f.nombre, c.nombre";

            return await connection.QueryAsync<Carrera, Facultad, Carrera>(
                sql,
                (carrera, facultad) =>
                {
                    carrera.Facultad = facultad;
                    return carrera;
                },
                splitOn: "FacultadId"  // Cambiado para que coincida con el alias
            );
        }
    }
}