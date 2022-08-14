package br.com.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bridge.adapter.DozerConverter;
import br.com.bridge.domain.entity.Turma;
import br.com.bridge.domain.vo.v1.TurmaVO;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	public TurmaVO insert(TurmaVO turma) {
		var entity = DozerConverter.parseObject(turma, Turma.class);
		var vo = DozerConverter.parseObject(repository.save(entity), TurmaVO.class);
		return vo;
	}
	
	public List<TurmaVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), TurmaVO.class);
	}
	
	public TurmaVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return DozerConverter.parseObject(entity, TurmaVO.class);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		repository.delete(entity);
	}
	
	public TurmaVO update(TurmaVO turma) {
		var entity = repository.findById(turma.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		entity.setHorario(turma.getHorario());
		entity.setDataInicio(turma.getDataInicio());
		entity.setDataTermino(turma.getDataTermino());
		entity.setCurso(turma.getCurso());
		entity.setStatusTurma(turma.getStatusTurma());
		entity.setTipoTurma(turma.getTipoTurma());

		var vo = DozerConverter.parseObject(repository.save(entity), TurmaVO.class);
		return vo;
	}

}
