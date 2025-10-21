namespace UniversidadAPI.DTOs
{
    public class FacultadDTO
    {
        public int FacultadId { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public string? Descripcion { get; set; }
        public string? Ubicacion { get; set; }
        public string? Decano { get; set; }
        public DateTime FechaRegistro { get; set; }
        public bool Activo { get; set; }
    }

    public class CreateFacultadDTO
    {
        public string Nombre { get; set; } = string.Empty;
        public string? Descripcion { get; set; }
        public string? Ubicacion { get; set; }
        public string? Decano { get; set; }
    }

    public class UpdateFacultadDTO
    {
        public string? Nombre { get; set; }
        public string? Descripcion { get; set; }
        public string? Ubicacion { get; set; }
        public string? Decano { get; set; }
        public bool? Activo { get; set; }
    }
}