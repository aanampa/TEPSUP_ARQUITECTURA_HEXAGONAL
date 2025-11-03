package com.tepsup.universidad.application.dto.command;

public class UpdateCarreraCommand {
    
    private Integer facultadId;
    private String nombre;
    private String descripcion;
    private Integer duracionSemestres;
    private String tituloOtorgado;
    
     // Constructor vacío
    public UpdateCarreraCommand() {}
    
    // Constructor con parámetros
    public UpdateCarreraCommand(Integer facultadId, 
                                String nombre, 
                                String descripcion, 
                                Integer duracionSemestres, 
                                String tituloOtorgado) {

        this.facultadId = facultadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionSemestres = duracionSemestres;
        this.tituloOtorgado = tituloOtorgado;
    }
    
    // Getters y Setters
    public Integer getFacultadId() {
        return facultadId;
    }
    
    public void setFacultadId(Integer facultadId) {
        this.facultadId = facultadId;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getDuracionSemestres() {
        return duracionSemestres;
    }
    
    public void setDuracionSemestres(Integer duracionSemestres) {
        this.duracionSemestres = duracionSemestres;
    }
    
    public String getTituloOtorgado() {
        return tituloOtorgado;
    }
    
    public void setTituloOtorgado(String tituloOtorgado) {
        this.tituloOtorgado = tituloOtorgado;
    }

    @Override
    public String toString() {
        return "UpdateCarreraCommand{" +
                "  nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracionSemestres= " + duracionSemestres + 
                ", tituloOtorgado='" + tituloOtorgado + '\'' +
                '}';
    }
}
