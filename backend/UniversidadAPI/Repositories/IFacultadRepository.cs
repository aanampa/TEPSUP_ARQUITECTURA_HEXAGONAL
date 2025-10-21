using UniversidadAPI.Models;

namespace UniversidadAPI.Repositories
{
    public interface IFacultadRepository
    {
        Task<IEnumerable<Facultad>> GetAllAsync();
        Task<Facultad?> GetByIdAsync(int id);
        Task<Facultad> CreateAsync(Facultad facultad);
        Task<Facultad?> UpdateAsync(int id, Facultad facultad);
        Task<bool> DeleteAsync(int id);
        Task<bool> ExistsAsync(int id);
        Task<bool> ExistsByNameAsync(string nombre);
    }
}