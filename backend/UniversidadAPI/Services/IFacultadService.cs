using UniversidadAPI.DTOs;

namespace UniversidadAPI.Services
{
    public interface IFacultadService
    {
        Task<IEnumerable<FacultadDTO>> GetAllFacultadesAsync();
        Task<FacultadDTO?> GetFacultadByIdAsync(int id);
        Task<FacultadDTO> CreateFacultadAsync(CreateFacultadDTO facultadDto);
        Task<FacultadDTO?> UpdateFacultadAsync(int id, UpdateFacultadDTO facultadDto);
        Task<bool> DeleteFacultadAsync(int id);
    }
}