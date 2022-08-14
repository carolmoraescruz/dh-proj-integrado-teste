package br.com.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bridge.adapter.DozerConverter;
import br.com.bridge.domain.entity.PessoaJuridica;
import br.com.bridge.domain.vo.v1.PessoaJuridicaVO;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	
	@Autowired
	private PessoaJuridicaRepository repository;
	
	public PessoaJuridicaVO insert(PessoaJuridicaVO empresa) {
		var entity = DozerConverter.parseObject(empresa, PessoaJuridica.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PessoaJuridicaVO.class);
		return vo;
	}
	
	public Page<PessoaJuridicaVO> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToPessoaJuridicaVO);
	}
	
	public PessoaJuridicaVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return DozerConverter.parseObject(entity, PessoaJuridicaVO.class);
	}
	
	public Page<PessoaJuridicaVO> findByName(String nome, Pageable pageable){
		var page = repository.findByNome(nome, pageable);
		return page.map(this::convertToPessoaJuridicaVO);	
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		repository.delete(entity);
	}
	
	public PessoaJuridicaVO update(PessoaJuridicaVO empresa) {
		var entity = repository.findById(empresa.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		entity.setNome(empresa.getNome());
		entity.setEmail(empresa.getEmail());
		entity.setEndereco(empresa.getEndereco());
		entity.setCnpj(empresa.getCnpj());
		entity.setSobreInstituicao(empresa.getSobreInstituicao());

		var vo = DozerConverter.parseObject(repository.save(entity), PessoaJuridicaVO.class);
		return vo;
	}
	
	private PessoaJuridicaVO convertToPessoaJuridicaVO(PessoaJuridica entity) {
        return DozerConverter.parseObject(entity, PessoaJuridicaVO.class);
	}

}
