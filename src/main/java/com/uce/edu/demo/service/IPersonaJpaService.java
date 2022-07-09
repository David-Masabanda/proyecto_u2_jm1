package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	
	public void guardar(Persona p);
	public void actualizar(Persona p);
	public void eliminar(Integer id);
	
	public Persona buscarPorId(Integer id);
	public Persona buscarPorCedula(String cedula);
	
	public List<Persona> buscarPorApellido(String apellido);
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorNombre(String nombre);
	
	//Nuevos
	public int actualizarPorApellido(String genero, String apellido);
	public int eliminarPorGenero(String genero);
}
