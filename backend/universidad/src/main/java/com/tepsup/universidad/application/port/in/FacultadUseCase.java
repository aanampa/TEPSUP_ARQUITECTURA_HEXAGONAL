package com.tepsup.universidad.application.port.in;

import java.util.List;
import java.util.Optional;

import com.tepsup.universidad.application.dto.command.RegisterFacultadCommand;
import com.tepsup.universidad.application.dto.command.UpdateFacultadCommand;
import com.tepsup.universidad.application.dto.response.FacultadResponse;
import com.tepsup.universidad.domain.model.Facultad;

public interface FacultadUseCase {
    
    FacultadResponse register(RegisterFacultadCommand command);
    FacultadResponse actualizar(Integer id, UpdateFacultadCommand command);
    public void eliminar(Integer id); 
    Optional<Facultad> obtenerPorId(Integer id);
    List<Facultad> listarTodos();

}
