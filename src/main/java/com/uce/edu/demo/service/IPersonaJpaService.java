package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	
	public void guardar(Persona p);
	public void actualizar(Persona p);
	public void eliminar(Integer id);
	
	public Persona buscarPorId(Integer id);
	public Persona buscarPorCedula(String cedula);
	//Native
	public Persona buscarPorCedulaNative(String cedula);
	
	//Named-Native
	public Persona buscarPorCedulaNamedNative(String cedula);
	
	//Criteria Api
	public Persona buscarPorCedulaNamedCriteriaApi(String cedula);
	public Persona buscarDinamicamente(String nombre, String apellido, String genero);
	
	
	public List<Persona> buscarPorApellido(String apellido);
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorNombre(String nombre);
	
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);
	
	//Nuevos
	public int actualizarPorApellido(String genero, String apellido);
	public int eliminarPorGenero(String genero);
	
	
	//Typed
	public Persona buscarPorCedulaTyped(String cedula);
	//Named
	public Persona buscarPorCedulaNamed(String cedula);
	//TypedNamed
	public Persona buscarPorCedulaTypedNamed(String cedula);
	
}
