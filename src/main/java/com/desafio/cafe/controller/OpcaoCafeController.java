package com.desafio.cafe.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.cafe.model.OpcaoCafe;
import com.desafio.cafe.servicer.OpcaoCafeService;

@RestController
@RequestMapping(value = "/api")
public class OpcaoCafeController {
	
	@Autowired
	private OpcaoCafeService service;
	
	//Listar todas opções de café
	@GetMapping("/opcoescafe")
	public ResponseEntity<List<OpcaoCafe>> findAll(){
		List<OpcaoCafe> list = service.findAll();				
		return ResponseEntity.ok().body(list);
	}
	
	//Pesquisar opção de café informando a opção
	@GetMapping("/opcoescafe/{opcafe}")
	public ResponseEntity<OpcaoCafe> findById(@PathVariable String opcafe) {
		OpcaoCafe obj = service.findById(opcafe);
		return ResponseEntity.ok().body(obj);
	}	
	
	@PostMapping("/opcoescafe")
	public ResponseEntity<OpcaoCafe> insert(@RequestBody OpcaoCafe obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{opcafe}").buildAndExpand(obj.getOpcafe()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//Deletar Colaborador inforfando cpf do colaborador que será deletado
		@DeleteMapping("/opcoescafe/{opcafe}")
		public ResponseEntity<Void> delete(@PathVariable String opcafe){
			service.delete(opcafe);
			return ResponseEntity.noContent().build();
		}

}
