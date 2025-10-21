using UniversidadAPI.DTOs;
using UniversidadAPI.Models;
using UniversidadAPI.Repositories;

namespace UniversidadAPI.Services
{
    public class FacultadService : IFacultadService
    {
        private readonly IFacultadRepository _facultadRepository;

        public FacultadService(IFacultadRepository facultadRepository)
        {
            _facultadRepository = facultadRepository;
        }

        public async Task<IEnumerable<FacultadDTO>> GetAllFacultadesAsync()
        {
            var facultades = await _facultadRepository.GetAllAsync();
            return facultades.Select(f => MapToDTO(f));
        }

        public async Task<FacultadDTO?> GetFacultadByIdAsync(int id)
        {
            var facultad = await _facultadRepository.GetByIdAsync(id);
            return facultad != null ? MapToDTO(facultad) : null;
        }

        public async Task<FacultadDTO> CreateFacultadAsync(CreateFacultadDTO facultadDto)
        {
            // Validar si ya existe una facultad con el mismo nombre
            if (await _facultadRepository.ExistsByNameAsync(facultadDto.Nombre))
            {
                throw new InvalidOperationException($"Ya existe una facultad con el nombre '{facultadDto.Nombre}'");
            }

            var facultad = new Facultad
            {
                Nombre = facultadDto.Nombre,
                Descripcion = facultadDto.Descripcion,
                Ubicacion = facultadDto.Ubicacion,
                Decano = facultadDto.Decano,
                Activo = true
            };

            var createdFacultad = await _facultadRepository.CreateAsync(facultad);
            return MapToDTO(createdFacultad);
        }

        public async Task<FacultadDTO?> UpdateFacultadAsync(int id, UpdateFacultadDTO facultadDto)
        {
            var existingFacultad = await _facultadRepository.GetByIdAsync(id);
            if (existingFacultad == null)
                return null;

            // Si se está actualizando el nombre, validar que no exista otro con el mismo nombre
            if (!string.IsNullOrEmpty(facultadDto.Nombre) && facultadDto.Nombre != existingFacultad.Nombre)
            {
                if (await _facultadRepository.ExistsByNameAsync(facultadDto.Nombre))
                {
                    throw new InvalidOperationException($"Ya existe una facultad con el nombre '{facultadDto.Nombre}'");
                }
            }

            var facultadToUpdate = new Facultad
            {
                Nombre = facultadDto.Nombre ?? existingFacultad.Nombre,
                Descripcion = facultadDto.Descripcion ?? existingFacultad.Descripcion,
                Ubicacion = facultadDto.Ubicacion ?? existingFacultad.Ubicacion,
                Decano = facultadDto.Decano ?? existingFacultad.Decano,
                Activo = facultadDto.Activo ?? existingFacultad.Activo
            };

            var updatedFacultad = await _facultadRepository.UpdateAsync(id, facultadToUpdate);
            return updatedFacultad != null ? MapToDTO(updatedFacultad) : null;
        }

        public async Task<bool> DeleteFacultadAsync(int id)
        {
            return await _facultadRepository.DeleteAsync(id);
        }

        private static FacultadDTO MapToDTO(Facultad facultad)
        {
            return new FacultadDTO
            {
                FacultadId = facultad.FacultadId,
                Nombre = facultad.Nombre,
                Descripcion = facultad.Descripcion,
                Ubicacion = facultad.Ubicacion,
                Decano = facultad.Decano,
                FechaRegistro = facultad.FechaRegistro,
                Activo = facultad.Activo
            };
        }
    }
}