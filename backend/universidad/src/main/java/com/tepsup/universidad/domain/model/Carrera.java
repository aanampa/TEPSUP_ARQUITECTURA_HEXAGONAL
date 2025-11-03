package com.tepsup.universidad.domain.model;

import java.time.LocalDateTime;

public class Carrera {
    private Integer carreraId;
    private Integer facultadId;
    private String nombre;
    private String descripcion;
    private Integer duracionSemestres;
    private String tituloOtorgado;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    
    // Constructor por defecto
    public Carrera() {
        this.activo = true;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    // Constructor con parámetros
    public Carrera(Integer carreraId,
                   Integer facultadId, 
                   String nombre, 
                   String descripcion, 
                   Integer duracionSemestres, 
                   String tituloOtorgado,
                   LocalDateTime fechaRegistro,
                   Boolean activo ) {
        this();
        this.carreraId = carreraId;
        this.facultadId = facultadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionSemestres = duracionSemestres;
        this.tituloOtorgado = tituloOtorgado;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;

    }

    // Constructor con parámetros
    public Carrera(Integer facultadId, 
                   String nombre, 
                   String descripcion, 
                   Integer duracionSemestres, 
                   String tituloOtorgado) {
        this();
        this.facultadId = facultadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionSemestres = duracionSemestres;
        this.tituloOtorgado = tituloOtorgado;
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
        return "Carrera{" +
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