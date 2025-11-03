package com.tepsup.universidad.application.dto.command;

public class RegisterFacultadCommand {
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String decano;
    
    // Constructor vacío
    public RegisterFacultadCommand() {}
    
    // Constructor con parámetros
    public RegisterFacultadCommand(String nombre, String descripcion, String ubicacion, String decano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.decano = decano;
    }
    
    // Getters y Setters
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
    
    @Override
    public String toString() {
        return "RegisterFacultadCommand{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", decano='" + decano + '\'' +
                '}';
    }
}