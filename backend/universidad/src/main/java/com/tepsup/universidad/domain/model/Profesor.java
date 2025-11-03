package com.tepsup.universidad.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.tepsup.universidad.domain.model.valueobjects.Email;

public class Profesor {
    private Integer profesorId;
    private String nombre;
    private String apellido;
    private String dni;
    private Email email;
    private String telefono;
    private String especialidad;
    private String tituloAcademico;
    private LocalDateTime fechaRegistro;
    private Boolean activo;

    // Constructor vacío
    public Profesor() {
    }

    // Constructor sin ID (para inserciones)
    public Profesor(String nombre, String apellido, String dni, Email email, 
                   String telefono, String especialidad, String tituloAcademico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.tituloAcademico = tituloAcademico;
        this.activo = true;
    }

    // Constructor completo
    public Profesor(Integer profesorId, String nombre, String apellido, String dni, 
                   Email email, String telefono, String especialidad, 
                   String tituloAcademico, LocalDateTime fechaRegistro, Boolean activo) {
        this.profesorId = profesorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = Objects.requireNonNull(email, "Email cannot be null");
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = Objects.requireNonNull(email, "Email cannot be null");
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

    public boolean isActivo() {
        return activo != null && activo;
    }

    // Método toString
    @Override
    public String toString() {
        return "Profesor{" +
                "profesorId=" + profesorId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email.getValue() + '\'' +
                ", telefono='" + telefono + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", tituloAcademico='" + tituloAcademico + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                '}';
    }

    // Método útil para obtener el nombre completo
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}