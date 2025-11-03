package com.tepsup.universidad.application.dto.query;

import java.time.LocalDateTime;

public class CarreraQuery {
    private Integer carreraId;
    private Integer facultadId;
    private String nombre;
    private String descripcion;
    private Integer duracionSemestres;
    private String tituloOtorgado;
    private LocalDateTime fechaRegistroDesde;
    private LocalDateTime fechaRegistroHasta;
    private Boolean activo;
    
    // Constructor vacío
    public CarreraQuery() {}
    
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
    
    public LocalDateTime getFechaRegistroDesde() {
        return fechaRegistroDesde;
    }
    
    public void setFechaRegistroDesde(LocalDateTime fechaRegistroDesde) {
        this.fechaRegistroDesde = fechaRegistroDesde;
    }
    
    public LocalDateTime getFechaRegistroHasta() {
        return fechaRegistroHasta;
    }
    
    public void setFechaRegistroHasta(LocalDateTime fechaRegistroHasta) {
        this.fechaRegistroHasta = fechaRegistroHasta;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    // Métodos helper para construir queries
    public boolean tieneFiltros() {
        return carreraId != null || facultadId != null || nombre != null ||
               descripcion != null || duracionSemestres != null ||
               tituloOtorgado != null || fechaRegistroDesde != null ||
               fechaRegistroHasta != null || activo != null;
    }
    
    public boolean tieneFiltroTexto() {
        return (nombre != null && !nombre.isEmpty()) ||
               (descripcion != null && !descripcion.isEmpty()) ||
               (tituloOtorgado != null && !tituloOtorgado.isEmpty());
    }
}