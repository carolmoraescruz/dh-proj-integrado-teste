package com.minerva.bridge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minerva.bridge.domain.entity.Curso;
import com.minerva.bridge.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}
	
	public Curso findById(Long id) {
		Optional<Curso> obj = cursoRepository.findById(id);
		return obj.get();
	}
	
	public Curso insert(Curso obj) {
		return cursoRepository.save(obj);
	}
	
	public void delete(Long id) {
		cursoRepository.deleteById(id);
	}
	
	public Curso update(Long id, Curso obj) {
		Curso entity = cursoRepository.getOne(id);
		updateData(entity, obj);
		return cursoRepository.save(entity);
	}

	private void updateData(Curso entity, Curso obj) {
		entity.setNomeCurso(obj.getNomeCurso());
		entity.setDuracao(obj.getDuracao());
		entity.setAreaInteresse(obj.getAreaInteresse());
		entity.setSobreCurso(obj.getSobreCurso());
		entity.setEscolaridadeMinima(obj.getEscolaridadeMinima());
		entity.setLinkCadastro(obj.getLinkCadastro());
	}

}
