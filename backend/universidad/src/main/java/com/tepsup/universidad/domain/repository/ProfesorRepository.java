package com.tepsup.universidad.domain.repository;

import java.util.List;
import java.util.Optional;

import com.tepsup.universidad.domain.model.Profesor;

public interface ProfesorRepository {
    
    // Operaciones CRUD básicas
    Profesor guardar(Profesor profesor);
    Profesor actualizar(Profesor profesor);
    void eliminarPorId(Integer id);
    Optional<Profesor> obtenerPorId(Integer id);
    List<Profesor> listarTodos();

   
    List<Profesor> listarActivos();
    
    // Búsquedas específicas
    Optional<Profesor> buscarPorDni(String dni);
    Optional<Profesor> buscarPorEmail(String email);
    List<Profesor> buscarPorNombre(String nombre);
    List<Profesor> buscarPorApellido(String apellido);
    List<Profesor> buscarPorEspecialidad(String especialidad);
    List<Profesor> buscarPorTituloAcademico(String tituloAcademico);
    List<Profesor> buscarPorNombreCompleto(String nombre, String apellido);
    List<Profesor> buscarPorEspecialidadYActivo(String especialidad, boolean activo);
    List<Profesor> buscarPorMultiplesEspecialidades(List<String> especialidades);
    
    // Update
    
    
    // Delete
    void desactivar(Integer id);
    void activar(Integer id);
    
 
}