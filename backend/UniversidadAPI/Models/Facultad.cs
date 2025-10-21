namespace UniversidadAPI.Models
{
    public class Facultad
    {
        public int FacultadId { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public string? Descripcion { get; set; }
        public string? Ubicacion { get; set; }
        public string? Decano { get; set; }
        public DateTime FechaRegistro { get; set; }
        public bool Activo { get; set; }
    }
}