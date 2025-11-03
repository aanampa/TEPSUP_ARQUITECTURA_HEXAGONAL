package com.tepsup.universidad.domain.service;

import java.util.ArrayList;

//import com.tepsup.universidad.domain.model.Carrera;
import com.tepsup.universidad.domain.model.Facultad;
//import com.tepsup.universidad.domain.repository.CarreraRepository;
import com.tepsup.universidad.domain.repository.FacultadRepository;
import com.tepsup.universidad.shared.annotation.DomainService;

@DomainService
public class FacultadService {

    //private final CarreraRepository _carreraRepository;
    private final FacultadRepository _facultadRepository;

     public FacultadService(
        //CarreraRepository carreraRepository, 
        FacultadRepository facultadRepository) {
        
      //  this._carreraRepository = carreraRepository;
        this._facultadRepository = facultadRepository;
    }


    public Facultad crearFacultad() {
        return _facultadRepository.guardar(new Facultad());
    }

    /* 
    public boolean existeCarrerasActivasEnFacultad(Integer facultadId) {
        return !_carreraRepository.buscarPorFacultadIdYEstadoActivo(facultadId, true).isEmpty();
    }

    public ArrayList<Carrera> listarCarrerasDeFacultad(Integer facultadId) {
        return new ArrayList<Carrera>(_carreraRepository.listarPorFacultadId(facultadId));
    }
    */
    
    public ArrayList<Facultad> listarFacultades() {
        return new ArrayList<Facultad>(_facultadRepository.listarTodos());
    }


}
