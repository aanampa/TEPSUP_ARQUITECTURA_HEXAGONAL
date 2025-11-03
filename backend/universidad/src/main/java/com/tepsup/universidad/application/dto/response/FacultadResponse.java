package com.tepsup.universidad.application.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FacultadResponse {
    private Integer facultadId;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String decano;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    private List<CarreraResponse> carreras = new ArrayList<>();
    
    // Constructor vacío
    public FacultadResponse() {}
    
  // Constructor desde entidad Facultad (sin carreras)
  /* 
    public FacultadResponse(Facultad facultad) {
        this.facultadId = facultad.getFacultadId();
        this.nombre = facultad.getNombre();
        this.descripcion = facultad.getDescripcion();
        this.ubicacion = facultad.getUbicacion();
        this.decano = facultad.getDecano();
        this.fechaRegistro = facultad.getFechaRegistro();
        this.activo = facultad.getActivo();
    }
    
    // Constructor desde entidad Facultad con carreras
    public FacultadResponse(Facultad facultad, boolean incluirCarreras) {
        this(facultad);
        if (incluirCarreras && facultad.getCarreras() != null) {
            this.carreras = facultad.getCarreras().stream()
                    .map(CarreraResponse::new)
                    .toList();
        }
    }
    */
    // Constructor con todos los parámetros (sin carreras)
    public FacultadResponse(Integer facultadId, String nombre, String descripcion, 
                          String ubicacion, String decano, LocalDateTime fechaRegistro, 
                          Boolean activo) {
        this.facultadId = facultadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.decano = decano;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }
    
    // Constructor completo con carreras
    public FacultadResponse(Integer facultadId, String nombre, String descripcion, 
                          String ubicacion, String decano, LocalDateTime fechaRegistro, 
                          Boolean activo, List<CarreraResponse> carreras) {
        this(facultadId, nombre, descripcion, ubicacion, decano, fechaRegistro, activo);
        this.carreras = carreras != null ? new ArrayList<>(carreras) : new ArrayList<>();
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
    
    public List<CarreraResponse> getCarreras() {
        return carreras;
    }
    
    public void setCarreras(List<CarreraResponse> carreras) {
        this.carreras = carreras != null ? new ArrayList<>(carreras) : new ArrayList<>();
    }
    
    // Método helper para agregar carrera
    public void agregarCarrera(CarreraResponse carrera) {
        if (this.carreras == null) {
            this.carreras = new ArrayList<>();
        }
        this.carreras.add(carrera);
    }
    
    @Override
    public String toString() {
        return "FacultadResponse{" +
                "facultadId=" + facultadId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", decano='" + decano + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                ", carreras=" + (carreras != null ? carreras.size() : 0) +
                '}';
    }
}