package com.tepsup.universidad.infrastructure.adapter.out.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tepsup.universidad.domain.model.Carrera;
import com.tepsup.universidad.domain.repository.CarreraRepository;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.entity.CarreraJpaEntity;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.repository.CarreraJpaRepository;
import com.tepsup.universidad.infrastructure.adapter.out.persistence.mapper.CarreraJpaMapper;

import com.tepsup.universidad.shared.annotation.Adapter;

@Adapter
public class CarreraRepositoryAdapter  implements CarreraRepository{

    private final CarreraJpaRepository jpaRepository;
    private final CarreraJpaMapper mapper;

    public CarreraRepositoryAdapter(
                            CarreraJpaRepository jpaRepository, 
                            CarreraJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

	@Override
    public Optional<Carrera> obtenerPorId(Integer id) {

        Optional<CarreraJpaEntity> item = jpaRepository.findById(id);
        
        if (item.isPresent()) {
                CarreraJpaEntity entity = item.get();
                System.out.println("- carrera_id: " + entity.getCarreraId());
                System.out.println("- facultad_id: " + entity.getFacultadId());
                System.out.println("- nombre: " + entity.getNombre());
                System.out.println("- descripcion: " + entity.getDescripcion());
        }

        return jpaRepository.findById(id)
                .map(mapper::toDomainModel);
    }
    
    @Override
    public List<Carrera> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Carrera guardar(Carrera carrera) {
       
        System.out.println("- CarreraRepositoryAdapter > carrera.facultad_id: " + carrera.getFacultadId());   

        CarreraJpaEntity entity = mapper.toJpaEntity(carrera);

        System.out.println("- CarreraRepositoryAdapter > CarreraJpaEntity.facultad_id: " + entity.getFacultadId());   

        CarreraJpaEntity savedEntity = jpaRepository.save(entity);
       
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
    
}
