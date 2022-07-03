package com.minerva.bridge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minerva.bridge.domain.entity.Turma;
import com.minerva.bridge.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Turma> findAll() {
		return turmaRepository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional<Turma> obj = turmaRepository.findById(id);
		return obj.get();
	}
	
	public Turma insert(Turma obj) {
		return turmaRepository.save(obj);
	}
	
	public void delete(Long id) {
		turmaRepository.deleteById(id);
	}
	
	public Turma update(Long id, Turma obj) {
		Turma entity = turmaRepository.getOne(id);
		updateData(entity, obj);
		return turmaRepository.save(entity);
	}

	private void updateData(Turma entity, Turma obj) {
		entity.setHorario(obj.getHorario());;
		entity.setDataInicio(obj.getDataInicio());;
		entity.setDataTermino(obj.getDataTermino());;
		entity.setCurso(obj.getCurso());
	}

}
