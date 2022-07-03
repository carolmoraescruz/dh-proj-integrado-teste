package com.minerva.bridge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minerva.bridge.domain.entity.PessoaJuridica;
import com.minerva.bridge.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	
	@Autowired
	private PessoaJuridicaRepository pjRepository;
	
	public List<PessoaJuridica> findAll() {
		return pjRepository.findAll();
	}
	
	public PessoaJuridica findById(Long id) {
		Optional<PessoaJuridica> obj = pjRepository.findById(id);
		return obj.get();
	}
	
	public PessoaJuridica insert(PessoaJuridica obj) {
		return pjRepository.save(obj);
	}
	
	public void delete(Long id) {
		pjRepository.deleteById(id);
	}
	
	public PessoaJuridica update(Long id, PessoaJuridica obj) {
		PessoaJuridica entity = pjRepository.getOne(id);
		updateData(entity, obj);
		return pjRepository.save(entity);
	}

	private void updateData(PessoaJuridica entity, PessoaJuridica obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setEndereco(obj.getEndereco());
		entity.setCnpj(obj.getCnpj());
		entity.setSobreInstituicao(obj.getSobreInstituicao());
	}

}
