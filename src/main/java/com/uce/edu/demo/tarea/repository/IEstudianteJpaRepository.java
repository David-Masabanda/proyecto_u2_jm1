package com.uce.edu.demo.tarea.repository;

import java.util.List;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {
	
	public Estudiante buscarPorId(int id);
	public void insertar(Estudiante e);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
	
	//Typed
	public List<Estudiante> buscarPorSemestreTyped(String semestre);
	public List<Estudiante> buscarPorCarreraTyped(String carrera);
	//Named
	public List<Estudiante> buscarPorApellidoNamed(String apellido);
	public List<Estudiante> buscarPorNombreNamed(String nombre);
	//TypedNamed
	public List<Estudiante> buscarPorCarreraSemestre(String carrera, String semestre);
	public List<Estudiante> buscarPorApellido(String apellido);
}
