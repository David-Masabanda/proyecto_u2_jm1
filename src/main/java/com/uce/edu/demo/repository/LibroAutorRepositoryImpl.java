package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.LibroAutor;

@Repository
@Transactional
public class LibroAutorRepositoryImpl implements ILibroAutorRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(LibroAutor la) {
		this.entityManager.persist(la);
	}

}
