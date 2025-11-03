package com.tepsup.universidad.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.tepsup.universidad.application.dto.command.RegisterFacultadCommand;
import com.tepsup.universidad.application.dto.command.UpdateFacultadCommand;
import com.tepsup.universidad.application.dto.response.FacultadResponse;
import com.tepsup.universidad.application.mapper.FacultadMapper;
import com.tepsup.universidad.application.port.in.FacultadUseCase;
import com.tepsup.universidad.domain.exception.CarreraNotFoundException;
import com.tepsup.universidad.domain.exception.FacultadNotFoundException;
import com.tepsup.universidad.domain.model.Facultad;
import com.tepsup.universidad.domain.repository.FacultadRepository;
import com.tepsup.universidad.shared.annotation.UseCase;

@UseCase
@Transactional
public class FacultadApplicationService implements FacultadUseCase {

    private final FacultadRepository facultadRepository;
    private final FacultadMapper facultadMapper;

    public FacultadApplicationService(
        FacultadRepository facultadRepository,
        FacultadMapper facultadMapper
    ) {
        this.facultadRepository = facultadRepository;
        this.facultadMapper = facultadMapper;
    }

    @Override
    public FacultadResponse register(RegisterFacultadCommand command) {
        
        Facultad facultad = new Facultad(
            command.getNombre(),
            command.getDescripcion(),
            command.getUbicacion(),
            command.getDecano()
        );
        
        Facultad savedFacultad = facultadRepository.guardar(facultad);

        return facultadMapper.toResponse(savedFacultad);
    }

    @Override
    public FacultadResponse actualizar(Integer id, UpdateFacultadCommand command) {
        
        Facultad facultad = facultadRepository.obtenerPorId(id)
           .orElseThrow(() -> new FacultadNotFoundException(id));

        facultad.setNombre(command.getNombre());
        facultad.setDescripcion(command.getDescripcion());  
        facultad.setUbicacion(command.getUbicacion());
        facultad.setDecano(command.getDecano());    
        
        Facultad savedFacultad = facultadRepository.guardar(facultad);

        return facultadMapper.toResponse(savedFacultad);

    }

    @Override
    public void eliminar(Integer id) {
        if (!facultadRepository.existePorId(id)) {
            throw new CarreraNotFoundException(id);
        }
        facultadRepository.eliminarPorId(id);
    }

    @Override
    public Optional<Facultad> obtenerPorId(Integer id){
        return facultadRepository.obtenerPorId(id);
    }

    @Override
    public List<Facultad> listarTodos(){
        return facultadRepository.listarTodos();
    }

}
