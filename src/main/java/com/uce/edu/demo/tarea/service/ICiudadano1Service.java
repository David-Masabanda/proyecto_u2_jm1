package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.repository.modelo.Ciudadano1;

public interface ICiudadano1Service {
	
	public void insertar(Ciudadano1 c);
	public void actualizar(Ciudadano1 c);
	public void eliminar(Integer id);
	
	public Ciudadano1 buscarPorId(Integer id);
}
