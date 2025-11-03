package com.tepsup.universidad.application.dto.query;

import java.time.LocalDateTime;

public class ProfesorQuery {
    private Integer profesorId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String especialidad;
    private String tituloAcademico;
    private LocalDateTime fechaRegistroDesde;
    private LocalDateTime fechaRegistroHasta;
    private Boolean activo;
    
    // Constructor vacío
    public ProfesorQuery() {}
    
    // Getters y Setters
    public Integer getProfesorId() {
        return profesorId;
    }
    
    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
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
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String getTituloAcademico() {
        return tituloAcademico;
    }
    
    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
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
        return profesorId != null || nombre != null || apellido != null ||
               dni != null || email != null || telefono != null ||
               especialidad != null || tituloAcademico != null ||
               fechaRegistroDesde != null || fechaRegistroHasta != null || activo != null;
    }
    
    public boolean buscarPorEspecialidad() {
        return especialidad != null && !especialidad.isEmpty();
    }
    
    public boolean buscarPorTitulo() {
        return tituloAcademico != null && !tituloAcademico.isEmpty();
    }
}