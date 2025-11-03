package com.tepsup.universidad.application.dto.query;

import java.time.LocalDateTime;

public class FacultadQuery {
    private Integer facultadId;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String decano;
    private LocalDateTime fechaRegistroDesde;
    private LocalDateTime fechaRegistroHasta;
    private Boolean activo;
    private Boolean conCarreras;
    
    // Constructor vacío
    public FacultadQuery() {}
    
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
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public String getDecano() {
        return decano;
    }
    
    public void setDecano(String decano) {
        this.decano = decano;
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
    
    public Boolean getConCarreras() {
        return conCarreras;
    }
    
    public void setConCarreras(Boolean conCarreras) {
        this.conCarreras = conCarreras;
    }
    
    // Métodos helper
    public boolean tieneFiltros() {
        return facultadId != null || nombre != null || descripcion != null ||
               ubicacion != null || decano != null || fechaRegistroDesde != null ||
               fechaRegistroHasta != null || activo != null || conCarreras != null;
    }
    
    public boolean incluirCarreras() {
        return Boolean.TRUE.equals(conCarreras);
    }
}