package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.Escrito;

@Repository
@Transactional
public class EscritoRepositoryImpl implements IEscritoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Escrito lib) {
		this.entityManager.persist(lib);
	}

	@Override
	public void actualizar(Escrito lib) {
		this.entityManager.merge(lib);
	}

	@Override
	public void eliminar(Integer id) {
		Escrito lib=this.buscarPorId(id);
		this.entityManager.remove(lib);
	}

	@Override
	public Escrito buscarPorId(Integer id) {
		TypedQuery<Escrito> myQuery=this.entityManager.createQuery(
				"SELECT b FROM Libro b WHERE b.id =:datoID",
				Escrito.class);
		myQuery.setParameter("datoID", id);
		return myQuery.getSingleResult();
	}

}
