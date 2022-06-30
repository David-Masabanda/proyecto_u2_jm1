package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	
	public void guardar(Estudiante e);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
	public Estudiante buscar(int id);
}
