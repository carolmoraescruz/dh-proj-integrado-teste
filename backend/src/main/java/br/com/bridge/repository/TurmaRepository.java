package br.com.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bridge.domain.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{

}
