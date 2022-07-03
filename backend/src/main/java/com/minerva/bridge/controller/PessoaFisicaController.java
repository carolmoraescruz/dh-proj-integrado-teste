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

import com.minerva.bridge.domain.entity.PessoaFisica;
import com.minerva.bridge.service.PessoaFisicaService;

@RestController
@RequestMapping(value = "/pessoas-fisicas")
public class PessoaFisicaController {
	
	@Autowired
	private PessoaFisicaService pfService;
	
	@GetMapping
	public ResponseEntity<List<PessoaFisica>> findAll() {
		List<PessoaFisica> listaPessoaFisicas = pfService.findAll();
		return ResponseEntity.ok().body(listaPessoaFisicas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaFisica> findById(@PathVariable Long id) {
		PessoaFisica obj = pfService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<PessoaFisica> insert(@RequestBody PessoaFisica obj) {
		obj = pfService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPessoa()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pfService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaFisica> update(@PathVariable Long id, @RequestBody PessoaFisica obj) {
		obj = pfService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
