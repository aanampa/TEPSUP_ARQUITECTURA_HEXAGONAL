namespace UniversidadAPI.DTOs
{
    public class CarreraDTO
    {
        public int CarreraId { get; set; }
        public int FacultadId { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public string? Descripcion { get; set; }
        public int DuracionSemestres { get; set; }
        public string? TituloOtorgado { get; set; }
        public DateTime FechaRegistro { get; set; }
        public bool Activo { get; set; }
        public FacultadDTO? Facultad { get; set; }
    }

    public class CreateCarreraDTO
    {
        public int FacultadId { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public string? Descripcion { get; set; }
        public int DuracionSemestres { get; set; }
        public string? TituloOtorgado { get; set; }
    }

    public class UpdateCarreraDTO
    {
        public string? Nombre { get; set; }
        public string? Descripcion { get; set; }
        public int? DuracionSemestres { get; set; }
        public string? TituloOtorgado { get; set; }
        public bool? Activo { get; set; }
    }
}