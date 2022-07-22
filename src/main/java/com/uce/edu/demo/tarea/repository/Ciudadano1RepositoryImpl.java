package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.Ciudadano1;

@Repository
@Transactional
public class Ciudadano1RepositoryImpl implements ICiudadano1Repository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Ciudadano1 c) {
		this.entityManager.persist(c);
	}

	@Override
	public void actualizar(Ciudadano1 c) {
		this.entityManager.merge(c);
	}

	@Override
	public void eliminar(Integer id) {
		Ciudadano1 c=this.buscarPorId(id);
		this.entityManager.remove(c);
	}

	@Override
	public Ciudadano1 buscarPorId(Integer id) {
		//SELECT * FROM ciudadano1  WHERE ciud_id =2
		TypedQuery<Ciudadano1>myQuery=this.entityManager.createQuery(
				"SELECT c FROM Ciudadano1 c WHERE c.id =:datoID",
				Ciudadano1.class);
		myQuery.setParameter("datoID", id);
		return myQuery.getSingleResult();
	}

}
