package com.uce.edu.demo.tarea.repository;

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

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteSencillo;

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
	
	//Native
	@Override
	public Estudiante buscarPorIdNative(Integer id) {
		Query myQuery1=this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE id = :datoId", Estudiante.class);
		myQuery1.setParameter("datoId", id);
		return (Estudiante)myQuery1.getSingleResult();
	}

	@Override
	public Estudiante buscarPorApellidoSemestreNative(String apellido, String semestre) {
		Query myQuery2=this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE apellido= :datoApellido AND semestre= :datoSemestre", Estudiante.class);
		myQuery2.setParameter("datoApellido", apellido);
		myQuery2.setParameter("datoSemestre", semestre);
		return (Estudiante)myQuery2.getSingleResult();
	}
	
	//Named Native
	@Override
	public Estudiante buscarPorApellidoCarreraNative(String apellido, String carrera) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoCarreraNative", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorCarreraNative(String carrera) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscarPorCarreraNative", Estudiante.class);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}
	
	
	//Criteria API
	@Override
	public Estudiante buscarDinamicamente(String nombre, String apellido, String semestre) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery=myCriteria.createQuery(Estudiante.class);
		Root<Estudiante> myTabla=myQuery.from(Estudiante.class);
		
		Predicate predicadoNombre=myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate predicadoFinal;
		
		if(semestre.equals("Decimo")) {
			predicadoFinal=myCriteria.and(predicadoNombre, predicadoApellido);
		}else {
			predicadoFinal=myCriteria.or(predicadoNombre, predicadoApellido);
		}
		myQuery.select(myTabla).where(predicadoFinal);
		TypedQuery<Estudiante>queryFinal=this.entityManager.createQuery(myQuery);
		
		return queryFinal.getSingleResult();
	}

	@Override
	public Estudiante buscarDinamicamente2(String apellido, String semestre, String carrera) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery=myCriteria.createQuery(Estudiante.class);
		Root<Estudiante> myTabla=myQuery.from(Estudiante.class);
		
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate predicadoSemestre=myCriteria.equal(myTabla.get("semestre"), semestre);
		Predicate predicadoFinal;
		
		if(carrera.equals("Odontologia")) {
			predicadoFinal=myCriteria.and(predicadoApellido, predicadoSemestre);
		}else {
			predicadoFinal=myCriteria.or(predicadoApellido,predicadoSemestre);
		}
		myQuery.select(myTabla).where(predicadoFinal);
		TypedQuery<Estudiante>queryFinal=this.entityManager.createQuery(myQuery);
		
		return queryFinal.getSingleResult();
	}
	
	//Estudiante Sencillo
	@Override
	public List<EstudianteSencillo> consultarPorCarreraSencillo(String carrera) {
		//SELECT nombre, apellido, semestre FROM estudiante WHERE carrera='Medicina'
		TypedQuery<EstudianteSencillo>myQuery=this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.tarea.repository.modelo.EstudianteSencillo(e.nombre, e.apellido, e.semestre)FROM Estudiante e WHERE e.carrera= :datoCarrera",
				EstudianteSencillo.class);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteContadorCarrera> consultarCantidadPorCarrera() {
		//SELECT carrera, COUNT(carrera) as "Cantidad Estudiantes" FROM estudiante  GROUP BY carrera
		//"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero, COUNT(p.genero)) FROM Persona p GROUP BY p.genero"
		TypedQuery<EstudianteContadorCarrera> myQuery=this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.tarea.repository.modelo.EstudianteContadorCarrera(e.carrera, COUNT(e.carrera))FROM Estudiante e GROUP BY e.carrera",
				EstudianteContadorCarrera.class);
		return myQuery.getResultList();
	}

}
