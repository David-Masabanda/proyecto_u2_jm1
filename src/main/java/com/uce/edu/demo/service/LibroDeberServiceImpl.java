package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroDeberRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Libro1;

@Service
public class LibroDeberServiceImpl implements ILibroDeberService{
	
	@Autowired
	private ILibroDeberRepository libroDeberRepository;
	
	@Override
	public void insertar(Libro1 l1) {
		this.libroDeberRepository.insertar(l1);
	}

}
