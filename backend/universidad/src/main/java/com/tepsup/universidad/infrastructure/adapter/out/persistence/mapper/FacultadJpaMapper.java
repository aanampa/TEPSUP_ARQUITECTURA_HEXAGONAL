package com.tepsup.universidad.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.tepsup.universidad.domain.model.Facultad;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.entity.FacultadJpaEntity;

@Component
public class FacultadJpaMapper {

     public FacultadJpaEntity toJpaEntity(Facultad facultad) {
        if (facultad == null) {
            return null;
        }
        
        System.out.println("Mapping Facultad to FacultadJpaEntity toJpaEntity: " + facultad.toString());

        FacultadJpaEntity entity = new FacultadJpaEntity();
        entity.setFacultadId(facultad.getFacultadId());
        entity.setNombre(facultad.getNombre());
        entity.setDescripcion(facultad.getDescripcion());
        entity.setUbicacion(facultad.getUbicacion());
        entity.setDecano(facultad.getDecano());
        entity.setFechaRegistro(facultad.getFechaRegistro());
        entity.setActivo(facultad.getActivo());
        
        return entity;
    }

    public Facultad toDomainModel(FacultadJpaEntity entity) {
        

        if (entity == null) {
            return null;
        }
        
        System.out.println("Mapping Facultad to FacultadJpaEntity toDomainModel: " + entity.toString());
        System.out.println("Mapping Facultad to FacultadJpaEntity toDomainModel: id = " + entity.getFacultadId());


        return new Facultad(
            entity.getFacultadId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getUbicacion(),
            entity.getDecano(),
            entity.getFechaRegistro(),
            entity.getActivo()
        );
    }
}
