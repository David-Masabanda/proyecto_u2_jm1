package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAutorDeberRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Autor1;

@Service
public class AutorDeberServiceImpl implements IAutorDeberService{
	
	@Autowired
	private IAutorDeberRepository autorDeberRepository;
	
	@Override
	public void insertar(Autor1 a1) {
		this.autorDeberRepository.insertar(a1);
	}

}
