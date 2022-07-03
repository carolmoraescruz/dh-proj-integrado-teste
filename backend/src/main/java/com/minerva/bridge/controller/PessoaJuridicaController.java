package com.minerva.bridge.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.minerva.bridge.domain.entity.PessoaJuridica;
import com.minerva.bridge.service.PessoaJuridicaService;

@RestController
@RequestMapping(value = "/pessoas-juridicas")
public class PessoaJuridicaController {
	
	@Autowired
	private PessoaJuridicaService pjService;
	
	@GetMapping
	public ResponseEntity<List<PessoaJuridica>> findAll() {
		List<PessoaJuridica> listaPessoaJuridicas = pjService.findAll();
		return ResponseEntity.ok().body(listaPessoaJuridicas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaJuridica> findById(@PathVariable Long id) {
		PessoaJuridica obj = pjService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<PessoaJuridica> insert(@RequestBody PessoaJuridica obj) {
		obj = pjService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPessoa()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pjService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaJuridica> update(@PathVariable Long id, @RequestBody PessoaJuridica obj) {
		obj = pjService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
