package com.minerva.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minerva.bridge.domain.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
