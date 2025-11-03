package com.tepsup.universidad.domain.repository;

import java.util.List;
import java.util.Optional;

import com.tepsup.universidad.domain.model.Carrera;
import com.tepsup.universidad.domain.model.Estudiante;

public interface EstudianteRepository {
    
    // Operaciones CRUD básicas
    Estudiante guardar(Estudiante estudiante);
    Estudiante actualizar(Estudiante estudiante);
    void eliminarPorId(Integer id);
    Optional<Carrera> obtenerPorId(Integer id);
    List<Estudiante> listarTodos();

    // Create
   
    
    // Read
    Optional<Estudiante> buscarPorId(Integer id);

    List<Estudiante> listarActivos();
    
    // Búsquedas específicas
    Optional<Estudiante> buscarPorDni(String dni);
    Optional<Estudiante> buscarPorEmail(String email);
    List<Estudiante> buscarPorNombre(String nombre);
    List<Estudiante> buscarPorApellido(String apellido);
    List<Estudiante> buscarPorNombreCompleto(String nombre, String apellido);
    List<Estudiante> buscarPorDireccion(String direccion);
    
    // Update
  
    
    // Delete
  
    void desactivar(Integer id);
    void activar(Integer id);
    

}