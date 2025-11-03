package com.tepsup.universidad.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private Integer facultadId;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String decano;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    private List<Carrera> carreras = new ArrayList<>();

    // Constructor por defecto
    public Facultad() {
        this.activo = true;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    // Constructor con parámetros
    public Facultad(
        Integer facultadId,
        String nombre, 
        String descripcion, 
        String ubicacion, 
        String decano,
        LocalDateTime fechaRegistro,
        Boolean activo        
        ) {
        
        this();
        this.facultadId = facultadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.decano = decano;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }
    
    public Facultad(
        String nombre, 
        String descripcion, 
        String ubicacion, 
        String decano
  
        ) {
        
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.decano = decano;

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
    

    public List<Carrera> getCarreras() {
        return carreras;
    }
    
    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    public void agregarCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    @Override
    public String toString() {
        return "Facultad{" +
                "  facultadId=" + facultadId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", decano='" + decano + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                '}';
    }
}
