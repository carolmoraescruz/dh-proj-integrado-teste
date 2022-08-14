package br.com.bridge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bridge.domain.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

	Page<Curso> findByNomeCurso(String nomeCurso, Pageable pageable);

}
