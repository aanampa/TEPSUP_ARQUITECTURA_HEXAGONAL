package com.tepsup.universidad.application.dto.command;

public class RegisterProfesorCommand {
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String especialidad;
    private String tituloAcademico;
    
    // Constructor vacío
    public RegisterProfesorCommand() {}
    
    // Constructor con parámetros
    public RegisterProfesorCommand(String nombre, String apellido, String dni, String email, 
                                 String telefono, String especialidad, String tituloAcademico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.tituloAcademico = tituloAcademico;
    }
    
    // Getters y Setters
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
    
    @Override
    public String toString() {
        return "RegisterProfesorCommand{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", tituloAcademico='" + tituloAcademico + '\'' +
                '}';
    }
}