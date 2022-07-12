package com.uce.edu.demo.tarea.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Estudiante buscarPorId(int id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante e) {
		this.entityManager.persist(e);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.entityManager.merge(e);
	}

	@Override
	public void eliminar(int id) {
		Estudiante estudiante=this.buscarPorId(id);
		this.entityManager.remove(estudiante);
	}

	//TYPED --------
	@Override
	public List<Estudiante> buscarPorSemestreTyped(String semestre) {
		TypedQuery<Estudiante> myTypedQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.semestre =:datoSemestre",
				Estudiante.class);
		myTypedQuery.setParameter("datoSemestre", semestre);
		return myTypedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorCarreraTyped(String carrera) {
		TypedQuery<Estudiante> myTypedQuery1=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.carrera =:datoCarrera",
				Estudiante.class);
		myTypedQuery1.setParameter("datoCarrera", carrera);
		return myTypedQuery1.getResultList();
	}

	
	//NAMED --------
	@Override
	public List<Estudiante> buscarPorApellidoNamed(String apellido) {
		Query myNamedQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorApellido");
		myNamedQuery.setParameter("datoApellido", apellido);
		return myNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreNamed(String nombre) {
		Query myNamedQuery1=this.entityManager.createNamedQuery("Estudiante.buscarPorNombreLetra");
		myNamedQuery1.setParameter("datoLetra", nombre);
		return myNamedQuery1.getResultList();
	}

	
	//TYPED NAMED --------
	@Override
	public List<Estudiante> buscarPorCarreraSemestre(String carrera, String semestre) {
		TypedQuery<Estudiante>myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorCarreraSemestre", Estudiante.class);
		myQuery.setParameter("datoCarrera", carrera);
		myQuery.setParameter("datoSemestre", semestre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellido(String apellido) {
		TypedQuery<Estudiante>myQuery1=this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoLetra", Estudiante.class);
		myQuery1.setParameter("datoLetra", apellido);
		return myQuery1.getResultList();
	}

}
