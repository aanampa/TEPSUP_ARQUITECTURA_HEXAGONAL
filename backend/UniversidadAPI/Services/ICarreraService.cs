using UniversidadAPI.DTOs;

namespace UniversidadAPI.Services
{
    public interface ICarreraService
    {
        Task<IEnumerable<CarreraDTO>> GetAllCarrerasAsync();
        Task<CarreraDTO?> GetCarreraByIdAsync(int id);
        Task<IEnumerable<CarreraDTO>> GetCarrerasByFacultadIdAsync(int facultadId);
        Task<CarreraDTO> CreateCarreraAsync(CreateCarreraDTO carreraDto);
        Task<CarreraDTO?> UpdateCarreraAsync(int id, UpdateCarreraDTO carreraDto);
        Task<bool> DeleteCarreraAsync(int id);
    }
}