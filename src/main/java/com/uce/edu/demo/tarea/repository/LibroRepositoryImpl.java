package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.Libro;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro lib) {
		this.entityManager.persist(lib);
	}

	@Override
	public void actualizar(Libro lib) {
		this.entityManager.merge(lib);
	}

	@Override
	public void eliminar(Integer id) {
		Libro lib=this.buscarPorId(id);
		this.entityManager.remove(lib);
	}

	@Override
	public Libro buscarPorId(Integer id) {
		TypedQuery<Libro> myQuery=this.entityManager.createQuery(
				"SELECT b FROM Libro b WHERE b.id =:datoID",
				Libro.class);
		myQuery.setParameter("datoID", id);
		return myQuery.getSingleResult();
	}

}
