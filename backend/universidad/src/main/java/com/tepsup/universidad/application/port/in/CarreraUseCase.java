package com.tepsup.universidad.application.port.in;

import java.util.List;
import java.util.Optional;

import com.tepsup.universidad.application.dto.command.RegisterCarreraCommand;
import com.tepsup.universidad.application.dto.command.UpdateCarreraCommand;
import com.tepsup.universidad.application.dto.response.CarreraResponse;
import com.tepsup.universidad.domain.model.Carrera;


public interface CarreraUseCase {
    
    CarreraResponse grabar(RegisterCarreraCommand command);
    CarreraResponse actualizar(Integer id, UpdateCarreraCommand command);
    void eliminar(Integer id);
    Optional<Carrera> obtenerPorId(Integer id);
    List<Carrera> listarTodos();
}
