package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Matricula;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Matricula m) {
		this.entityManager.persist(m);
	}

}
