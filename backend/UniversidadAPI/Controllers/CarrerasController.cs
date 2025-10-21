using Microsoft.AspNetCore.Mvc;
using UniversidadAPI.DTOs;
using UniversidadAPI.Services;

namespace UniversidadAPI.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CarrerasController : ControllerBase
    {
        private readonly ICarreraService _carreraService;

        public CarrerasController(ICarreraService carreraService)
        {
            _carreraService = carreraService;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<CarreraDTO>>> GetCarreras()
        {
            var carreras = await _carreraService.GetAllCarrerasAsync();
            return Ok(carreras);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<CarreraDTO>> GetCarrera(int id)
        {
            var carrera = await _carreraService.GetCarreraByIdAsync(id);
            if (carrera == null)
            {
                return NotFound();
            }
            return Ok(carrera);
        }

        [HttpGet("facultad/{facultadId}")]
        public async Task<ActionResult<IEnumerable<CarreraDTO>>> GetCarrerasByFacultad(int facultadId)
        {
            try
            {
                var carreras = await _carreraService.GetCarrerasByFacultadIdAsync(facultadId);
                return Ok(carreras);
            }
            catch (KeyNotFoundException ex)
            {
                return NotFound(new { message = ex.Message });
            }
        }

        [HttpPost]
        public async Task<ActionResult<CarreraDTO>> CreateCarrera(CreateCarreraDTO carreraDto)
        {
            try
            {
                var createdCarrera = await _carreraService.CreateCarreraAsync(carreraDto);
                return CreatedAtAction(nameof(GetCarrera), new { id = createdCarrera.CarreraId }, createdCarrera);
            }
            catch (Exception ex) when (ex is KeyNotFoundException || ex is InvalidOperationException)
            {
                return BadRequest(new { message = ex.Message });
            }
        }

        [HttpPut("{id}")]
        public async Task<ActionResult<CarreraDTO>> UpdateCarrera(int id, UpdateCarreraDTO carreraDto)
        {
            try
            {
                var updatedCarrera = await _carreraService.UpdateCarreraAsync(id, carreraDto);
                if (updatedCarrera == null)
                {
                    return NotFound();
                }
                return Ok(updatedCarrera);
            }
            catch (InvalidOperationException ex)
            {
                return BadRequest(new { message = ex.Message });
            }
        }

        [HttpDelete("{id}")]
        public async Task<ActionResult> DeleteCarrera(int id)
        {
            var result = await _carreraService.DeleteCarreraAsync(id);
            if (!result)
            {
                return NotFound();
            }
            return NoContent();
        }
    }
}