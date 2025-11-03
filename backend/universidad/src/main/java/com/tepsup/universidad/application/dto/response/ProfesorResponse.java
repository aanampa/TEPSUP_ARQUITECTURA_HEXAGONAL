package com.tepsup.universidad.application.dto.response;

import java.time.LocalDateTime;

public class ProfesorResponse {
    private Integer profesorId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String especialidad;
    private String tituloAcademico;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    
    // Constructor vacío
    public ProfesorResponse() {}
    
    // Constructor desde entidad Profesor
    /* 
    public ProfesorResponse(Profesor profesor) {
        this.profesorId = profesor.getProfesorId();
        this.nombre = profesor.getNombre();
        this.apellido = profesor.getApellido();
        this.dni = profesor.getDni();
        this.email = profesor.getEmail() != null ? profesor.getEmail().getValue() : null;
        this.telefono = profesor.getTelefono();
        this.especialidad = profesor.getEspecialidad();
        this.tituloAcademico = profesor.getTituloAcademico();
        this.fechaRegistro = profesor.getFechaRegistro();
        this.activo = profesor.getActivo();
    }
    */
    
    // Constructor con todos los parámetros
    public ProfesorResponse(Integer profesorId, String nombre, String apellido, 
                           String dni, String email, String telefono, 
                           String especialidad, String tituloAcademico, 
                           LocalDateTime fechaRegistro, Boolean activo) {
        this.profesorId = profesorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.tituloAcademico = tituloAcademico;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }
    
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
    
    // Método helper para obtener nombre completo
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    // Método helper para obtener título y nombre completo
    public String getTituloYNombre() {
        return tituloAcademico + " " + nombre + " " + apellido;
    }
    
    // Método helper para verificar si tiene especialidad
    public boolean tieneEspecialidad() {
        return especialidad != null && !especialidad.trim().isEmpty();
    }
    
    @Override
    public String toString() {
        return "ProfesorResponse{" +
                "profesorId=" + profesorId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", tituloAcademico='" + tituloAcademico + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                '}';
    }
}