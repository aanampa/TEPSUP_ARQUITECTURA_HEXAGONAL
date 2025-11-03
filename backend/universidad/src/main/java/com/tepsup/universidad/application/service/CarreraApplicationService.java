package com.tepsup.universidad.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.tepsup.universidad.application.dto.command.RegisterCarreraCommand;
import com.tepsup.universidad.application.dto.command.UpdateCarreraCommand;
import com.tepsup.universidad.application.dto.response.CarreraResponse;
import com.tepsup.universidad.application.mapper.CarreraMapper;
import com.tepsup.universidad.application.port.in.CarreraUseCase;
import com.tepsup.universidad.domain.exception.CarreraNotFoundException;
import com.tepsup.universidad.domain.exception.FacultadNotFoundException;
import com.tepsup.universidad.domain.model.Carrera;
import com.tepsup.universidad.domain.repository.CarreraRepository;
import com.tepsup.universidad.shared.annotation.UseCase;

@UseCase
@Transactional
public class CarreraApplicationService implements CarreraUseCase {
    
    private final CarreraRepository carreraRepository;
    private final CarreraMapper carreraMapper;

     public CarreraApplicationService(
        CarreraRepository carreraRepository,
        CarreraMapper carreraMapper
    ) {
        this.carreraRepository = carreraRepository;
        this.carreraMapper = carreraMapper;
    }

    @Override
    public CarreraResponse grabar(RegisterCarreraCommand command) {
        
        Carrera carrera = new Carrera(
            command.getFacultadId(),
            command.getNombre(),
            command.getDescripcion(),
            command.getDuracionSemestres(),
            command.getTituloOtorgado()
        );
        
        Carrera savedCarrera = carreraRepository.guardar(carrera);

        return carreraMapper.toResponse(savedCarrera);
    }
 
    @Override
    public CarreraResponse actualizar(Integer id, UpdateCarreraCommand command) {
        
        Carrera carrera = carreraRepository.obtenerPorId(id)
           .orElseThrow(() -> new FacultadNotFoundException(id));

        System.out.println("- CarreraApplicationService > facultad_id: " + command.getFacultadId());   

        carrera.setFacultadId(command.getFacultadId());   
        carrera.setNombre(command.getNombre());
        carrera.setDescripcion(command.getDescripcion());  
        carrera.setDuracionSemestres(command.getDuracionSemestres());
        carrera.setTituloOtorgado(command.getTituloOtorgado());
       
        Carrera savedCarrera = carreraRepository.guardar(carrera);

        return carreraMapper.toResponse(savedCarrera);

    }

    @Override
    public void eliminar(Integer id) {
        if (!carreraRepository.existePorId(id)) {
            throw new CarreraNotFoundException(id);
        }
        carreraRepository.eliminarPorId(id);
    }

    @Override
    public Optional<Carrera> obtenerPorId(Integer id){
        return carreraRepository.obtenerPorId(id);
    }

    @Override
    public List<Carrera> listarTodos(){
        return carreraRepository.listarTodos();
    }    

}
