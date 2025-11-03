package com.tepsup.universidad.application.dto.response;

import java.time.LocalDateTime;

public class CarreraResponse {
    private Integer carreraId;
    private Integer facultadId;
    private String nombre;
    private String descripcion;
    private Integer duracionSemestres;
    private String tituloOtorgado;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    
    // Constructor vacío
    public CarreraResponse() {}
    
   // Constructor desde entidad Carrera
   /* *
    public CarreraResponse(Carrera carrera) {
        this.carreraId = carrera.getCarreraId();
        this.facultadId = carrera.getFacultadId();
        this.nombre = carrera.getNombre();
        this.descripcion = carrera.getDescripcion();
        this.duracionSemestres = carrera.getDuracionSemestres();
        this.tituloOtorgado = carrera.getTituloOtorgado();
        this.fechaRegistro = carrera.getFechaRegistro();
        this.activo = carrera.getActivo();
    }
    */
    // Constructor con todos los parámetros
    public CarreraResponse(Integer carreraId, Integer facultadId, String nombre, 
                          String descripcion, Integer duracionSemestres, 
                          String tituloOtorgado, LocalDateTime fechaRegistro, Boolean activo) {
        this.carreraId = carreraId;
        this.facultadId = facultadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionSemestres = duracionSemestres;
        this.tituloOtorgado = tituloOtorgado;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }
    
    // Getters y Setters
    public Integer getCarreraId() {
        return carreraId;
    }
    
    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }
    
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
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return "CarreraResponse{" +
                "carreraId=" + carreraId +
                ", facultadId=" + facultadId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracionSemestres=" + duracionSemestres +
                ", tituloOtorgado='" + tituloOtorgado + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                '}';
    }
}