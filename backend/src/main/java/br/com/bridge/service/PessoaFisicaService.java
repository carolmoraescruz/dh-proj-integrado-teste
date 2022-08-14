package br.com.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bridge.adapter.DozerConverter;
import br.com.bridge.domain.entity.PessoaFisica;
import br.com.bridge.domain.vo.v1.PessoaFisicaVO;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository repository;
	
	public PessoaFisicaVO insert(PessoaFisicaVO aluno) {
		var entity = DozerConverter.parseObject(aluno, PessoaFisica.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PessoaFisicaVO.class);
		return vo;
	}
	
	public Page<PessoaFisicaVO> findAll(Pageable pageable) {
		var page = 	repository.findAll(pageable);
		return page.map(this::convertToPessoaFisicaVO);
	}
	
	public PessoaFisicaVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return DozerConverter.parseObject(entity, PessoaFisicaVO.class);
	}
	
	public Page<PessoaFisicaVO> findByName(String nome, Pageable pageable){
		var page = repository.findByNome(nome, pageable);
		return page.map(this::convertToPessoaFisicaVO);	
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		repository.delete(entity);
	}
	
	public PessoaFisicaVO update(PessoaFisicaVO aluno) {
		var entity = repository.findById(aluno.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		entity.setNome(aluno.getNome());
		entity.setEmail(aluno.getEmail());
		entity.setEndereco(aluno.getEndereco());
		entity.setSobrenome(aluno.getSobrenome());
		entity.setNomeSocial(aluno.getNomeSocial());
		entity.setCpf(aluno.getCpf());
		entity.setDataNascimento(aluno.getDataNascimento());
		entity.setTipoPcd(aluno.getTipoPcd());
		entity.setCvLinkedin(aluno.getCvLinkedin());

		var vo = DozerConverter.parseObject(repository.save(entity), PessoaFisicaVO.class);
		return vo;
	}
	
	private PessoaFisicaVO convertToPessoaFisicaVO(PessoaFisica entity) {
        return DozerConverter.parseObject(entity, PessoaFisicaVO.class);
	}

}
