package com.tepsup.universidad.infrastructure.adapter.out.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tepsup.universidad.domain.model.Facultad;
import com.tepsup.universidad.domain.repository.FacultadRepository;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.entity.FacultadJpaEntity;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.repository.FacultadJpaRepository;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.mapper.FacultadJpaMapper;
import com.tepsup.universidad.shared.annotation.Adapter;

@Adapter
public class FacultadRepositoryAdapter implements FacultadRepository {

    private final FacultadJpaRepository jpaRepository;
    private final FacultadJpaMapper mapper;

    public FacultadRepositoryAdapter(
                            FacultadJpaRepository jpaRepository, 
                            FacultadJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Facultad> obtenerPorId(Integer id) {

        Optional<FacultadJpaEntity> facu = jpaRepository.findById(id);
        
        if (facu.isPresent()) {
                FacultadJpaEntity entity = facu.get();
                System.out.println("ID: " + entity.getFacultadId());
                System.out.println("Nombre: " + entity.getNombre());
                
                System.out.println("Facultad JPA Entity: " + entity.toString());
        }

        return jpaRepository.findById(id)
                .map(mapper::toDomainModel);
    }

    @Override
    public List<Facultad> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Facultad guardar(Facultad facultad) {
        FacultadJpaEntity entity = mapper.toJpaEntity(facultad);
        FacultadJpaEntity savedEntity = jpaRepository.save(entity);

        
        return mapper.toDomainModel(savedEntity);
    }

    @Override
    public void eliminarPorId(Integer id) {
        jpaRepository.deleteById(id);
    }


    @Override
    public boolean existePorId(Integer id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Optional<Facultad> buscarPorNombre(String nombre) {
        return jpaRepository.findByNombre(nombre)
                .map(mapper::toDomainModel);
    }
}
