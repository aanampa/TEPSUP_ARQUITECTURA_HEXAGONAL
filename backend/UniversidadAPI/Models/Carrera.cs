namespace UniversidadAPI.Models
{
    public class Carrera
    {
        public int CarreraId { get; set; }
        public int FacultadId { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public string? Descripcion { get; set; }
        public int DuracionSemestres { get; set; }
        public string? TituloOtorgado { get; set; }
        public DateTime FechaRegistro { get; set; }
        public bool Activo { get; set; }

        // Navigation property
        public Facultad? Facultad { get; set; }
    }
}
