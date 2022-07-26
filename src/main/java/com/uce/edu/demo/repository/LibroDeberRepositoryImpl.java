package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Libro1;

@Repository
@Transactional
public class LibroDeberRepositoryImpl implements ILibroDeberRepository{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro1 l1) {
		this.entityManager.persist(l1);
	}

}
