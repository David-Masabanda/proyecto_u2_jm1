package com.uce.edu.demo.tarea.repository;

import com.uce.edu.demo.tarea.repository.modelo.Libro;

public interface ILibroRepository {
	
	public void insertar (Libro lib);
	public void actualizar(Libro lib);
	public void eliminar(Integer id);
	
	public Libro buscarPorId(Integer id);
}
