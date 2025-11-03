package com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tepsup.universidad.infrastructure.adapter.out.persistence.jpa.entity.CarreraJpaEntity;

@Repository
public interface CarreraJpaRepository extends JpaRepository<CarreraJpaEntity, Integer>{

}
