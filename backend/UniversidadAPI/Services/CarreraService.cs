using UniversidadAPI.DTOs;
using UniversidadAPI.Models;
using UniversidadAPI.Repositories;

namespace UniversidadAPI.Services
{
    public class CarreraService : ICarreraService
    {
        private readonly ICarreraRepository _carreraRepository;
        private readonly IFacultadRepository _facultadRepository;

        public CarreraService(ICarreraRepository carreraRepository, IFacultadRepository facultadRepository)
        {
            _carreraRepository = carreraRepository;
            _facultadRepository = facultadRepository;
        }

        public async Task<IEnumerable<CarreraDTO>> GetAllCarrerasAsync()
        {
            var carreras = await _carreraRepository.GetAllWithFacultadAsync();
            return carreras.Select(c => MapToDTO(c));
        }

        public async Task<CarreraDTO?> GetCarreraByIdAsync(int id)
        {
            var carrera = await _carreraRepository.GetWithFacultadAsync(id);
            return carrera != null ? MapToDTO(carrera) : null;
        }

        public async Task<IEnumerable<CarreraDTO>> GetCarrerasByFacultadIdAsync(int facultadId)
        {
            // Validar que la facultad existe
            if (!await _facultadRepository.ExistsAsync(facultadId))
            {
                throw new KeyNotFoundException($"No se encontró la facultad con ID {facultadId}");
            }

            var carreras = await _carreraRepository.GetByFacultadIdAsync(facultadId);
            return carreras.Select(c => MapToDTO(c));
        }

        public async Task<CarreraDTO> CreateCarreraAsync(CreateCarreraDTO carreraDto)
        {
            // Validar que la facultad existe
            if (!await _facultadRepository.ExistsAsync(carreraDto.FacultadId))
            {
                throw new KeyNotFoundException($"No se encontró la facultad con ID {carreraDto.FacultadId}");
            }

            // Validar si ya existe una carrera con el mismo nombre
            if (await _carreraRepository.ExistsByNameAsync(carreraDto.Nombre))
            {
                throw new InvalidOperationException($"Ya existe una carrera con el nombre '{carreraDto.Nombre}'");
            }

            var carrera = new Carrera
            {
                FacultadId = carreraDto.FacultadId,
                Nombre = carreraDto.Nombre,
                Descripcion = carreraDto.Descripcion,
                DuracionSemestres = carreraDto.DuracionSemestres,
                TituloOtorgado = carreraDto.TituloOtorgado,
                Activo = true
            };

            var createdCarrera = await _carreraRepository.CreateAsync(carrera);
            return MapToDTO(createdCarrera);
        }

        public async Task<CarreraDTO?> UpdateCarreraAsync(int id, UpdateCarreraDTO carreraDto)
        {
            var existingCarrera = await _carreraRepository.GetByIdAsync(id);
            if (existingCarrera == null)
                return null;

            // Si se está actualizando el nombre, validar que no exista otro con el mismo nombre
            if (!string.IsNullOrEmpty(carreraDto.Nombre) && carreraDto.Nombre != existingCarrera.Nombre)
            {
                if (await _carreraRepository.ExistsByNameAsync(carreraDto.Nombre))
                {
                    throw new InvalidOperationException($"Ya existe una carrera con el nombre '{carreraDto.Nombre}'");
                }
            }

            var carreraToUpdate = new Carrera
            {
                Nombre = carreraDto.Nombre ?? existingCarrera.Nombre,
                Descripcion = carreraDto.Descripcion ?? existingCarrera.Descripcion,
                DuracionSemestres = carreraDto.DuracionSemestres ?? existingCarrera.DuracionSemestres,
                TituloOtorgado = carreraDto.TituloOtorgado ?? existingCarrera.TituloOtorgado,
                Activo = carreraDto.Activo ?? existingCarrera.Activo
            };

            var updatedCarrera = await _carreraRepository.UpdateAsync(id, carreraToUpdate);
            return updatedCarrera != null ? MapToDTO(updatedCarrera) : null;
        }

        public async Task<bool> DeleteCarreraAsync(int id)
        {
            return await _carreraRepository.DeleteAsync(id);
        }

        private static CarreraDTO MapToDTO(Carrera carrera)
        {
            var dto = new CarreraDTO
            {
                CarreraId = carrera.CarreraId,
                FacultadId = carrera.FacultadId,
                Nombre = carrera.Nombre,
                Descripcion = carrera.Descripcion,
                DuracionSemestres = carrera.DuracionSemestres,
                TituloOtorgado = carrera.TituloOtorgado,
                FechaRegistro = carrera.FechaRegistro,
                Activo = carrera.Activo
            };

            if (carrera.Facultad != null)
            {
                dto.Facultad = new FacultadDTO
                {
                    FacultadId = carrera.Facultad.FacultadId,
                    Nombre = carrera.Facultad.Nombre,
                    Descripcion = carrera.Facultad.Descripcion,
                    Ubicacion = carrera.Facultad.Ubicacion,
                    Decano = carrera.Facultad.Decano,
                    FechaRegistro = carrera.Facultad.FechaRegistro,
                    Activo = carrera.Facultad.Activo
                };
            }

            return dto;
        }
    }
}