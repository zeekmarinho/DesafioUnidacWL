package com.desafio.cafe.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.cafe.model.Colaborador;
import com.desafio.cafe.model.OpcaoCafe;
import com.desafio.cafe.repositories.ColaboradorRepository;
import com.desafio.cafe.repositories.OpcaoCafeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private OpcaoCafeRepository opcaocafeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//Test inserindo colaborador
		Colaborador c1 = new Colaborador("49384582115","Daniel",null);
		Colaborador c2 = new Colaborador("46512481474","Ana",null);		
		
		//Test inserindo opcão de café para colaborador
		OpcaoCafe o1 = new OpcaoCafe("Bolo",c1);
		OpcaoCafe o2 = new OpcaoCafe("Cafe",c1);
		OpcaoCafe o3 = new OpcaoCafe("Suco de Limão",c2);
		
		colaboradorRepository.saveAll(Arrays.asList(c1,c2));
		opcaocafeRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
	

}
