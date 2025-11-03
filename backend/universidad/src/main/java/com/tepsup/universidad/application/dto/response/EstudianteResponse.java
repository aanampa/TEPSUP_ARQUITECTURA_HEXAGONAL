package com.tepsup.universidad.application.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EstudianteResponse {
    private Integer estudianteId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    
    // Constructor vacío
    public EstudianteResponse() {}
    
    // Constructor desde entidad Estudiante
    /* 
    public EstudianteResponse(Estudiante estudiante) {
        this.estudianteId = estudiante.getEstudianteId();
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.dni = estudiante.getDni();
        this.email = estudiante.getEmail() != null ? estudiante.getEmail().getValue() : null;
        this.telefono = estudiante.getTelefono();
        this.fechaNacimiento = estudiante.getFechaNacimiento();
        this.direccion = estudiante.getDireccion();
        this.fechaRegistro = estudiante.getFechaRegistro();
        this.activo = estudiante.getActivo();
    }
    */
    
    // Constructor con todos los parámetros
    public EstudianteResponse(Integer estudianteId, String nombre, String apellido, 
                             String dni, String email, String telefono, 
                             LocalDate fechaNacimiento, String direccion, 
                             LocalDateTime fechaRegistro, Boolean activo) {
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }
    
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
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
    // Método helper para calcular edad aproximada
    public Integer getEdad() {
        if (fechaNacimiento == null) {
            return null;
        }
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }
    
    @Override
    public String toString() {
        return "EstudianteResponse{" +
                "estudianteId=" + estudianteId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion='" + direccion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                '}';
    }
}