package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.repository.modelo.Escrito;

public interface IEscritoService {
	
	public void insertar (Escrito lib);
	public void actualizar(Escrito lib);
	public void eliminar(Integer id);
	
	public Escrito buscarPorId(Integer id);
}
