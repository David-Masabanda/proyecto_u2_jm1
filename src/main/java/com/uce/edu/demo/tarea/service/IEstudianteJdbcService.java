package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.to.EstudianteTo;

public interface IEstudianteJdbcService {
	
	public void guardar(EstudianteTo e);
	public void actualizar(EstudianteTo e);
	public void eliminar(int id);
	public EstudianteTo buscar(int id);
}
