package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.Lector;

@Repository
@Transactional
public class LectorRepositoryImpl implements ILectorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Lector l) {
		this.entityManager.persist(l);
	}

	@Override
	public void actualizar(Lector l) {
		this.entityManager.merge(l);
	}

	@Override
	public void eliminar(Integer id) {
		Lector l=this.buscarPorId(id);
		this.entityManager.remove(l);
	}

	@Override
	public Lector buscarPorId(Integer id) {
		TypedQuery<Lector> myQuery=this.entityManager.createQuery(
				"SELECT l FROM Lector l WHERE l.id =:datoID",
				Lector.class);
		myQuery.setParameter("datoID", id);
		return myQuery.getSingleResult();
	}

}
