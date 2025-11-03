package com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.entity.FacultadJpaEntity;

@Repository
public interface FacultadJpaRepository extends JpaRepository<FacultadJpaEntity, Integer> {

    List<FacultadJpaEntity> findByActivo(Boolean activo);
    Optional<FacultadJpaEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
