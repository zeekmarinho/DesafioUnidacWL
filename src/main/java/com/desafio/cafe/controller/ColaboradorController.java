package com.desafio.cafe.controller;

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

import com.desafio.cafe.model.Colaborador;
import com.desafio.cafe.servicer.ColaboradorService;

@RestController
@RequestMapping(value = "/api")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;
	
	//Listar todos colaboradores
	@GetMapping("/colaborador")
	public ResponseEntity<List<Colaborador>> findAll(){
		List<Colaborador> list = service.findAll();				
		return ResponseEntity.ok().body(list);
	}
	
	//Pesquisar Colaborador por cpf
	@GetMapping("/colaborador/{cpf}")
	public ResponseEntity<Colaborador> findById(@PathVariable String cpf) {
		Colaborador obj = service.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	//Inserir Colaborador
	@PostMapping("/colaborador")
	public ResponseEntity<Colaborador> insert(@RequestBody Colaborador obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(obj.getCpf()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//Deletar Colaborador inforfando cpf do colaborador que será deletado
	@DeleteMapping("/colaborador/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable String cpf){
		service.delete(cpf);
		return ResponseEntity.noContent().build();
	}
	
	//Atualizar Colaborador
	@PutMapping("/colaborador/{cpf}")
	public ResponseEntity<Colaborador> update(@PathVariable String cpf, @RequestBody Colaborador obj){
		obj = service.update(cpf, obj);
		return ResponseEntity.ok().body(obj);
	}

}
