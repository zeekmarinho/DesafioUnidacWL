package com.desafio.cafe.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafio.cafe.model.Colaborador;
import com.desafio.cafe.repositories.ColaboradorRepository;
import com.desafio.cafe.servicer.exceptions.ControllerNotFoundException;
import com.desafio.cafe.servicer.exceptions.DatabaseException;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	public List<Colaborador> findAll(){
		return repository.findAll();		
	}
	
	public Colaborador findById(String cpf) {
		Optional<Colaborador> obj = repository.findById(cpf);
		return obj.orElseThrow(() -> new ControllerNotFoundException(cpf));
	}
	
	public Colaborador insert(Colaborador obj) {
		return repository.save(obj);
	}
	
	public void delete(String cpf) {
		try {
			repository.deleteById(cpf);
		}catch(EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(cpf);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Colaborador update(String cpf, Colaborador obj) {
		Colaborador entity = repository.getById(cpf);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Colaborador entity, Colaborador obj) {
		entity.setNome(obj.getNome());		
	}

}
