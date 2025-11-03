package com.tepsup.universidad.domain.repository;

import java.util.List;
import java.util.Optional;
import com.tepsup.universidad.domain.model.Facultad;

public interface FacultadRepository {

    // Operaciones CRUD básicas
    Optional<Facultad> obtenerPorId(Integer id);
    List<Facultad> listarTodos();
    Facultad guardar(Facultad facultad);
    void eliminarPorId(Integer id);

    boolean existePorId(Integer id);
    Optional<Facultad> buscarPorNombre(String nombre);
   
}