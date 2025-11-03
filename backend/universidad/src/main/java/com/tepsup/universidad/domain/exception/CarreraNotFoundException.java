package com.tepsup.universidad.domain.exception;

public class CarreraNotFoundException extends DomainException {

    public CarreraNotFoundException(String message) {
        super(message);
    }

     public CarreraNotFoundException(Integer id) {
        super("Carrera no encontrada con ID: " + id);
    }

}
