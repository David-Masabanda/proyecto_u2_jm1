package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Autor1;

@Repository
@Transactional
public class AutorDeberRepositoryImpl implements IAutorDeberRepository{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(Autor1 a1) {
		this.entityManager.persist(a1);
	}

}
