package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

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
	
	//NATIVE
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		Query myQuery=this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula =:datoCedula",Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona)myQuery.getSingleResult();
	}
	
	//NAMED NATIVE
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		TypedQuery<Persona> miQuery=this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",Persona.class);
		miQuery.setParameter("datoCedula", cedula);
		return miQuery.getSingleResult();
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

	@Override
	public Persona buscarPorCedulaNamedCriteriaApi(String cedula) {
		// SELECT p FROM Persona p WHERE p.cedula=:cedula
				CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
				// Espicificamos el tipo de retorno
				CriteriaQuery<Persona> myQuery = builder.createQuery(Persona.class);
				// Root FROM
				// Construimos el sql
				Root<Persona> personaRoot = myQuery.from(Persona.class);// From Persona
				myQuery.select(personaRoot); // Select p FROM Persona

				Predicate p1 = builder.equal(personaRoot.get("cedula"), cedula);// p.cedula=:cedula
				//CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaRoot).where(p1);
				myQuery.select(personaRoot).where(p1);
				// Finalizado mi query completo
				TypedQuery<Persona> myFinal = this.entityManager.createQuery(myQuery);
				return myFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona>myQuery=myCriteria.createQuery(Persona.class);
		Root<Persona>myTabla=myQuery.from(Persona.class);
		
		Predicate predicadoNombre=myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate myPredicadoFinal;
		if(genero.equals("M")) {
			myPredicadoFinal=myCriteria.and(predicadoNombre, predicadoApellido);
		}else {
			myPredicadoFinal=myCriteria.or(predicadoNombre, predicadoApellido);
		}
		myQuery.select(myTabla).where(myPredicadoFinal);
		TypedQuery<Persona>myQueryFinal=this.entityManager.createQuery(myQuery);
		
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona>myQuery=myCriteria.createQuery(Persona.class);
		Root<Persona>myTabla=myQuery.from(Persona.class);
		Predicate pNombre=myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate pApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate pGenero=myCriteria.equal(myTabla.get("genero"), genero);
		Predicate pFinal;
		
		if(genero.equals("M")) {
			pFinal=myCriteria.or(pNombre,pApellido);
			pFinal=myCriteria.and(pFinal,pGenero);
		}
		else {
			 pFinal=myCriteria.and(pNombre,pApellido);
			 pFinal=myCriteria.or(pFinal,pGenero);
		}
		myQuery.select(myTabla).where(pFinal);
		
		TypedQuery<Persona> myFinal = this.entityManager.createQuery(myQuery);
		return myFinal.getSingleResult();
	}
	
	
	//Persona Sencilla
	@Override
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido) {
		TypedQuery<PersonaSencilla> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaSencilla(p.nombre,p.apellido) FROM Persona p WHERE p.apellido=:datoApellido ",
				PersonaSencilla.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// select pers_genero, count(pers_genero) from persona GROUP BY pers_genero
		// SELECT p.genero, COUNT(p.genero) FROM Persona p GROUP BY p.genero
		// SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero,
		// COUNT(p.genero)) FROM Persona p GROUP BY p.genero
		TypedQuery<PersonaContadorGenero> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero, COUNT(p.genero)) FROM Persona p GROUP BY p.genero",
				PersonaContadorGenero.class);
		return myQuery.getResultList();
	}

}
