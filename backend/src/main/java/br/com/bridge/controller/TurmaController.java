package br.com.bridge.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bridge.domain.vo.v1.TurmaVO;
import br.com.bridge.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Turma Endpoint")
@RestController
@RequestMapping("/api/turmas/v1")
public class TurmaController {
	
	@Autowired
	TurmaService service;
	
	@CrossOrigin("localhost:8080")
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	@Operation(summary="Listar todas as turmas")
	@ResponseStatus(value = HttpStatus.OK)
	public List<TurmaVO> findAll() {
		List<TurmaVO> turmasVO = service.findAll();
		turmasVO.stream().forEach(t -> t.add(linkTo(methodOn(TurmaController.class).findById(t.getKey())).withSelfRel()));
		return turmasVO;
	}
	
	@CrossOrigin("localhost:8080")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	@Operation(summary="Listar turmas por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public TurmaVO findById(@PathVariable("id") Long id) {
		TurmaVO turmaVO = service.findById(id);
		turmaVO.add(linkTo(methodOn(TurmaController.class).findById(id)).withSelfRel());
		return turmaVO;
	}
	
	@PostMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	@Operation(summary="Cadastrar nova turma")
	@ResponseStatus(value = HttpStatus.CREATED)
	public TurmaVO create(@Valid @RequestBody TurmaVO turma) {
		TurmaVO turmaVO = service.insert(turma);
		turmaVO.add(linkTo(methodOn(TurmaController.class).findById(turmaVO.getKey())).withSelfRel());
		return turmaVO;
	}
	
	@PutMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	@Operation(summary="Atualizar dados de turma")
	@ResponseStatus(value = HttpStatus.OK)
	public TurmaVO update(@Valid @RequestBody TurmaVO turma) {
		TurmaVO turmaVO = service.update(turma);
		turmaVO.add(linkTo(methodOn(TurmaController.class).findById(turmaVO.getKey())).withSelfRel());
		return turmaVO;
	}
	
	@DeleteMapping(value="/{id}")
	@Operation(summary="Deletar turmas por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
