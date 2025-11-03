package com.tepsup.universidad.application.dto.query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EstudianteQuery {
    private Integer estudianteId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private LocalDate fechaNacimientoDesde;
    private LocalDate fechaNacimientoHasta;
    private String direccion;
    private LocalDateTime fechaRegistroDesde;
    private LocalDateTime fechaRegistroHasta;
    private Boolean activo;
    
    // Constructor vacío
    public EstudianteQuery() {}
    
    // Getters y Setters
    public Integer getEstudianteId() {
        return estudianteId;
    }
    
    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public LocalDate getFechaNacimientoDesde() {
        return fechaNacimientoDesde;
    }
    
    public void setFechaNacimientoDesde(LocalDate fechaNacimientoDesde) {
        this.fechaNacimientoDesde = fechaNacimientoDesde;
    }
    
    public LocalDate getFechaNacimientoHasta() {
        return fechaNacimientoHasta;
    }
    
    public void setFechaNacimientoHasta(LocalDate fechaNacimientoHasta) {
        this.fechaNacimientoHasta = fechaNacimientoHasta;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
    // Métodos helper
    public boolean tieneFiltros() {
        return estudianteId != null || nombre != null || apellido != null ||
               dni != null || email != null || telefono != null ||
               fechaNacimientoDesde != null || fechaNacimientoHasta != null ||
               direccion != null || fechaRegistroDesde != null ||
               fechaRegistroHasta != null || activo != null;
    }
    
    public boolean buscarPorNombreCompleto() {
        return (nombre != null && !nombre.isEmpty()) && 
               (apellido != null && !apellido.isEmpty());
    }
}