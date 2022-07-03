package com.minerva.bridge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minerva.bridge.domain.entity.PessoaFisica;
import com.minerva.bridge.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository pfRepository;
	
	public List<PessoaFisica> findAll() {
		return pfRepository.findAll();
	}
	
	public PessoaFisica findById(Long id) {
		Optional<PessoaFisica> obj = pfRepository.findById(id);
		return obj.get();
	}
	
	public PessoaFisica insert(PessoaFisica obj) {
		return pfRepository.save(obj);
	}
	
	public void delete(Long id) {
		pfRepository.deleteById(id);
	}
	
	public PessoaFisica update(Long id, PessoaFisica obj) {
		PessoaFisica entity = pfRepository.getOne(id);
		updateData(entity, obj);
		return pfRepository.save(entity);
	}

	private void updateData(PessoaFisica entity, PessoaFisica obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setEndereco(obj.getEndereco());
		entity.setSobrenome(obj.getSobrenome());
		entity.setNomeSocial(obj.getNomeSocial());
		entity.setCpf(obj.getCpf());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setTipoPcd(obj.getTipoPcd());
		entity.setCvLinkedin(obj.getCvLinkedin());
	}

}
