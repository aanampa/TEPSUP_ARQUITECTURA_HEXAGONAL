using Dapper;
using UniversidadAPI.Data;
using UniversidadAPI.Models;

namespace UniversidadAPI.Repositories
{
    public class FacultadRepository : IFacultadRepository
    {
        private readonly DatabaseContext _context;

        public FacultadRepository(DatabaseContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<Facultad>> GetAllAsync()
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                SELECT 
                    facultad_id AS FacultadId,
                    nombre AS Nombre,
                    descripcion AS Descripcion,
                    ubicacion AS Ubicacion,
                    decano AS Decano,
                    fecha_registro AS FechaRegistro,
                    activo AS Activo
                FROM facultad 
                WHERE activo = 1";
            return await connection.QueryAsync<Facultad>(sql);
        }

        public async Task<Facultad?> GetByIdAsync(int id)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                SELECT 
                    facultad_id AS FacultadId,
                    nombre AS Nombre,
                    descripcion AS Descripcion,
                    ubicacion AS Ubicacion,
                    decano AS Decano,
                    fecha_registro AS FechaRegistro,
                    activo AS Activo
                FROM facultad 
                WHERE facultad_id = @Id AND activo = 1";
            return await connection.QueryFirstOrDefaultAsync<Facultad>(sql, new { Id = id });
        }

        public async Task<Facultad> CreateAsync(Facultad facultad)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                INSERT INTO facultad (nombre, descripcion, ubicacion, decano)
                OUTPUT INSERTED.facultad_id AS FacultadId, 
                       INSERTED.nombre AS Nombre, 
                       INSERTED.descripcion AS Descripcion,
                       INSERTED.ubicacion AS Ubicacion, 
                       INSERTED.decano AS Decano, 
                       INSERTED.fecha_registro AS FechaRegistro, 
                       INSERTED.activo AS Activo
                VALUES (@Nombre, @Descripcion, @Ubicacion, @Decano)";

            return await connection.QuerySingleAsync<Facultad>(sql, facultad);
        }

        public async Task<Facultad?> UpdateAsync(int id, Facultad facultad)
        {
            using var connection = _context.CreateConnection();
            var sql = @"
                UPDATE facultad 
                SET nombre = @Nombre, 
                    descripcion = @Descripcion, 
                    ubicacion = @Ubicacion, 
                    decano = @Decano,
                    activo = @Activo
                WHERE facultad_id = @FacultadId;
                
                SELECT 
                    facultad_id AS FacultadId,
                    nombre AS Nombre,
                    descripcion AS Descripcion,
                    ubicacion AS Ubicacion,
                    decano AS Decano,
                    fecha_registro AS FechaRegistro,
                    activo AS Activo
                FROM facultad WHERE facultad_id = @FacultadId";

            var parameters = new
            {
                FacultadId = id,
                facultad.Nombre,
                facultad.Descripcion,
                facultad.Ubicacion,
                facultad.Decano,
                facultad.Activo
            };

            return await connection.QueryFirstOrDefaultAsync<Facultad>(sql, parameters);
        }

        public async Task<bool> DeleteAsync(int id)
        {
            using var connection = _context.CreateConnection();
            var sql = "UPDATE facultad SET activo = 0 WHERE facultad_id = @Id";
            var affectedRows = await connection.ExecuteAsync(sql, new { Id = id });
            return affectedRows > 0;
        }

        public async Task<bool> ExistsAsync(int id)
        {
            using var connection = _context.CreateConnection();
            var sql = "SELECT COUNT(1) FROM facultad WHERE facultad_id = @Id AND activo = 1";
            return await connection.ExecuteScalarAsync<bool>(sql, new { Id = id });
        }

        public async Task<bool> ExistsByNameAsync(string nombre)
        {
            using var connection = _context.CreateConnection();
            var sql = "SELECT COUNT(1) FROM facultad WHERE nombre = @Nombre AND activo = 1";
            return await connection.ExecuteScalarAsync<bool>(sql, new { Nombre = nombre });
        }
    }
}