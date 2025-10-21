using Microsoft.AspNetCore.Mvc;
using UniversidadAPI.DTOs;
using UniversidadAPI.Services;

namespace UniversidadAPI.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class FacultadesController : ControllerBase
    {
        private readonly IFacultadService _facultadService;

        public FacultadesController(IFacultadService facultadService)
        {
            _facultadService = facultadService;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<FacultadDTO>>> GetFacultades()
        {
            var facultades = await _facultadService.GetAllFacultadesAsync();
            return Ok(facultades);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<FacultadDTO>> GetFacultad(int id)
        {
            var facultad = await _facultadService.GetFacultadByIdAsync(id);
            if (facultad == null)
            {
                return NotFound();
            }
            return Ok(facultad);
        }

        [HttpPost]
        public async Task<ActionResult<FacultadDTO>> CreateFacultad(CreateFacultadDTO facultadDto)
        {
            try
            {
                var createdFacultad = await _facultadService.CreateFacultadAsync(facultadDto);
                return CreatedAtAction(nameof(GetFacultad), new { id = createdFacultad.FacultadId }, createdFacultad);
            }
            catch (InvalidOperationException ex)
            {
                return BadRequest(new { message = ex.Message });
            }
        }

        [HttpPut("{id}")]
        public async Task<ActionResult<FacultadDTO>> UpdateFacultad(int id, UpdateFacultadDTO facultadDto)
        {
            try
            {
                var updatedFacultad = await _facultadService.UpdateFacultadAsync(id, facultadDto);
                if (updatedFacultad == null)
                {
                    return NotFound();
                }
                return Ok(updatedFacultad);
            }
            catch (InvalidOperationException ex)
            {
                return BadRequest(new { message = ex.Message });
            }
        }

        [HttpDelete("{id}")]
        public async Task<ActionResult> DeleteFacultad(int id)
        {
            var result = await _facultadService.DeleteFacultadAsync(id);
            if (!result)
            {
                return NotFound();
            }
            return NoContent();
        }
    }
}