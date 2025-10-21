using UniversidadAPI.Models;

namespace UniversidadAPI.Repositories
{
    public interface ICarreraRepository
    {
        Task<IEnumerable<Carrera>> GetAllAsync();
        Task<Carrera?> GetByIdAsync(int id);
        Task<IEnumerable<Carrera>> GetByFacultadIdAsync(int facultadId);
        Task<Carrera> CreateAsync(Carrera carrera);
        Task<Carrera?> UpdateAsync(int id, Carrera carrera);
        Task<bool> DeleteAsync(int id);
        Task<bool> ExistsAsync(int id);
        Task<bool> ExistsByNameAsync(string nombre);
        Task<Carrera?> GetWithFacultadAsync(int id);
        Task<IEnumerable<Carrera>> GetAllWithFacultadAsync();
    }
}