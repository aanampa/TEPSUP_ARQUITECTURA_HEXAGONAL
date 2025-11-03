package com.tepsup.universidad.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.tepsup.universidad.domain.model.Carrera;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.entity.CarreraJpaEntity;

@Component
public class CarreraJpaMapper {

     public CarreraJpaEntity toJpaEntity(Carrera carrera) {
        if (carrera == null) {
            return null;
        }
        
        CarreraJpaEntity entity = new CarreraJpaEntity();
        entity.setCarreraId(carrera.getCarreraId());
		entity.setFacultadId(carrera.getFacultadId());
        entity.setNombre(carrera.getNombre());
        entity.setDescripcion(carrera.getDescripcion());
		entity.setDuracionSemestres(carrera.getDuracionSemestres());
        entity.setTituloOtorgado(carrera.getTituloOtorgado());
		entity.setFechaRegistro(carrera.getFechaRegistro());
        entity.setActivo(carrera.getActivo());
        
        return entity;
    }

    public Carrera toDomainModel(CarreraJpaEntity entity) {

        if (entity == null) {
            return null;
        }

        System.out.println("- toDomainModel carrera_id: " + entity.getCarreraId());
        System.out.println("- toDomainModel facultad_id: " + entity.getFacultadId());

        return new Carrera(
            entity.getCarreraId(),
			entity.getFacultadId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getDuracionSemestres(),
            entity.getTituloOtorgado(),
            entity.getFechaRegistro(),
            entity.getActivo()
        );
    }
}
