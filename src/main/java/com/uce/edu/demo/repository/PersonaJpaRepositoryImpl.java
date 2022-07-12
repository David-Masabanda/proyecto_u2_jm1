package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Persona buscarPorId(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona p) {
		this.entityManager.persist(p);
	}

	@Override
	public void actualizar(Persona p) {
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(Integer id) {
		Persona persona=this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula =:datoCedula");
		jpqlQuery.setParameter("datoCedula",cedula);
		return (Persona)jpqlQuery.getSingleResult();
	}
	
	//TYPED no especifico el return
	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		TypedQuery<Persona> myTypedQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula =:datoCedula",Persona.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}
	
	//NAMED
	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona)myQuery.getSingleResult();
		
		//Combinamos el NamedQuery con el TypedQuery, de igual forma podemos
		//hacerlo al reves
	}

	//TYPED NAMED
	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		TypedQuery<Persona> miTypedQuery=this.entityManager.createNamedQuery("Persona.buscarPorCedula",Persona.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}
	
	
	@Override
	public List<Persona> buscarPorGenero(String genero) {
		Query myQuery2=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero =:datoGenero");
		myQuery2.setParameter("datoGenero", genero);
		return myQuery2.getResultList();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido =:datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		Query myQuery3=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre =:datoNombre");
		myQuery3.setParameter("datoNombre", nombre);
		return myQuery3.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		Query myQuery4=this.entityManager.createQuery("UPDATE Persona p SET p.genero =:datoGenero WHERE p.apellido =:datoApellido");
		myQuery4.setParameter("datoGenero", genero);
		myQuery4.setParameter("datoApellido", apellido);
		return myQuery4.executeUpdate();
	}
	
	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		TypedQuery<Persona> miTypedQuery2=this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",Persona.class);
		miTypedQuery2.setParameter("datoNombre", nombre);
		miTypedQuery2.setParameter("datoApellido", apellido);
		return miTypedQuery2.getResultList();
	}

	
	
	@Override
	public int eliminarPorGenero(String genero) {
		Query myQuery5=this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero =:datoGenero");
		myQuery5.setParameter("datoGenero", genero);
		return myQuery5.executeUpdate();
	}


}
