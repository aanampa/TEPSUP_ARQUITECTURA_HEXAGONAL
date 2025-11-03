package com.tepsup.universidad.domain.exception;

public class FacultadNotFoundException extends DomainException {

    public FacultadNotFoundException(String message) {
        super(message);
    }

     public FacultadNotFoundException(Integer id) {
        super("Facultad no encontrada con ID: " + id);
    }
}
