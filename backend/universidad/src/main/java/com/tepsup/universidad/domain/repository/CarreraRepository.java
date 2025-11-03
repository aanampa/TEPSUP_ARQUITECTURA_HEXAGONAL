package com.tepsup.universidad.domain.repository;

import java.util.List;
import java.util.Optional;

import com.tepsup.universidad.domain.model.Carrera;

public interface CarreraRepository {
    
    // Operaciones CRUD básicas
    Optional<Carrera> obtenerPorId(Integer id);
    List<Carrera> listarTodos();
    Carrera guardar(Carrera carrera);
    void eliminarPorId(Integer id);
        
    boolean existePorId(Integer id);

    // Operaciones específicas de búsqueda
    /* 
    Optional<Carrera> buscarPorNombre(String nombre);
    List<Carrera> listarPorEstadoActivo(Boolean activo);
    List<Carrera> listarPorFacultadId(Integer facultadId);
    List<Carrera> listarPorDuracionSemestres(Integer duracion);
    List<Carrera> listarPorTituloOtorgado(String titulo);
    */
    /*
    // Búsquedas combinadas
    List<Carrera> buscarPorFacultadIdYEstadoActivo(Integer facultadId, Boolean activo);
    List<Carrera> buscarPorDuracionSemestresMayorOIgual(Integer duracionMinima);
    List<Carrera> buscarPorDuracionSemestresEntre(Integer duracionMin, Integer duracionMax);
    
    // Operaciones de verificación
    boolean existePorId(Integer id);
    boolean existePorNombre(String nombre);
    boolean existePorFacultadIdYNombre(Integer facultadId, String nombre);
    
    // Operaciones de conteo
    long contar();
    long contarPorEstadoActivo(Boolean activo);
    long contarPorFacultadId(Integer facultadId);
    long contarPorFacultadIdYEstadoActivo(Integer facultadId, Boolean activo);
    
    // Operaciones adicionales útiles
    List<Carrera> buscarPorDescripcionConteniendo(String texto);
    List<Carrera> buscarPorTituloConteniendo(String texto);
    List<Carrera> buscarPorDuracionMenorA(Integer duracionMaxima);

    */
}