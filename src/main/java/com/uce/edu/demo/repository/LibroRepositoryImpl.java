package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro l) {
		this.entityManager.persist(l);
		
	}

}
