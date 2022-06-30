package com.uce.edu.demo.tarea.repository;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {
	
	public Estudiante buscarPorId(int id);
	public void insertar(Estudiante e);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
}
