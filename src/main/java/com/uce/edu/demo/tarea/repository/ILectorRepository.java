package com.uce.edu.demo.tarea.repository;

import com.uce.edu.demo.tarea.repository.modelo.Lector;

public interface ILectorRepository {
	
	public void insertar (Lector l);
	public void actualizar(Lector l);
	public void eliminar(Integer id);
	
	public Lector buscarPorId(Integer id);
}
