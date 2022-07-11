package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;

@Repository
@Transactional
public class PropietarioJpaRepositoryImpl implements IPropietarioJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Propietario p) {
		this.entityManager.persist(p);
	}

	@Override
	public void delete(String cedula) {
		Propietario p=this.buscarPorCedula(cedula);
		this.entityManager.remove(p);
	}

	@Override
	public Propietario buscarPorCedula(String cedula) {
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula =:datoCedula");
		myQuery.setParameter("datoCedula",cedula);
		return (Propietario)myQuery.getSingleResult();
	}


}
