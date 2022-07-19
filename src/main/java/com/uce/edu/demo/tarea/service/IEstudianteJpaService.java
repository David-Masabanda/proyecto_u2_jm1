package com.uce.edu.demo.tarea.service;

import java.util.List;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteSencillo;

public interface IEstudianteJpaService {
	
	public void guardar(Estudiante e);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
	public Estudiante buscar(int id);
	
	//Typed
	public List<Estudiante> buscarPorSemestreTyped(String semestre);
	public List<Estudiante> buscarPorCarreraTyped(String carrera);
	//Named
	public List<Estudiante> buscarPorApellidoNamed(String apellido);
	public List<Estudiante> buscarPorNombreNamed(String nombre);
	//TypedNamed
	public List<Estudiante> buscarPorCarreraSemestre(String carrera, String semestre);
	public List<Estudiante> buscarPorApellido(String apellido);

	
	//Native
	public Estudiante buscarPorIdNative(Integer id);
	public Estudiante buscarPorApellidoSemestreNative(String apellido, String semestre);
		
	//Named-Native
	public Estudiante buscarPorApellidoCarreraNative(String apellido, String carrera);
	public List<Estudiante> buscarPorCarreraNative(String carrera);
	
	//Criteria API
	public Estudiante buscarDinamicamente(String nombre, String apellido, String semestre);
	public Estudiante buscarDinamicamente2(String apellido, String semestre, String carrera);
	
	//Persona Sencilla
	public List<EstudianteSencillo> consultarPorCarreraSencillo(String carrera);
	public List<EstudianteContadorCarrera> consultarCantidadPorCarrera();
}
