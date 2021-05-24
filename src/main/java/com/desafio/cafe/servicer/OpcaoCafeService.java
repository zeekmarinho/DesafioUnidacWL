package com.desafio.cafe.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafio.cafe.model.OpcaoCafe;
import com.desafio.cafe.repositories.OpcaoCafeRepository;
import com.desafio.cafe.servicer.exceptions.ControllerNotFoundException;
import com.desafio.cafe.servicer.exceptions.DatabaseException;

@Service
public class OpcaoCafeService {
	
	@Autowired
	private OpcaoCafeRepository repository;
	
	public List<OpcaoCafe> findAll(){
		return repository.findAll();
		
	}
	
	public OpcaoCafe findById(String opcafe) {
		Optional<OpcaoCafe> obj = repository.findById(opcafe);
		return obj.get();
	}
	
	public OpcaoCafe insert(OpcaoCafe obj) {
		return repository.save(obj);
	}
	
	public void delete(String opcafe) {
		try {
			repository.deleteById(opcafe);
		}catch(EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(opcafe);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

}
