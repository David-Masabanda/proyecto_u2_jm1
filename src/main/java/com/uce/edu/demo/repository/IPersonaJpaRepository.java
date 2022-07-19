package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

public interface IPersonaJpaRepository {
	
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorNombre(String nombre);
	public List<Persona> buscarPorApellido(String apellido);
	
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);
	
	public Persona buscarPorCedula(String cedula);
	//Native
	public Persona buscarPorCedulaNative(String cedula);
	//Named-Native
	public Persona buscarPorCedulaNamedNative(String cedula);
	
	
	//Criteria Api
	public Persona buscarPorCedulaNamedCriteriaApi(String cedula);
	public Persona buscarDinamicamente(String nombre, String apellido, String genero);
	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero);
	
	//Typed
	public Persona buscarPorCedulaTyped(String cedula);
	//Named
	public Persona buscarPorCedulaNamed(String cedula);
	//TypedNamed
	public Persona buscarPorCedulaTypedNamed(String cedula);
	
	
	public Persona buscarPorId(Integer id);
	
	//Clasicos
	public void insertar(Persona p);
	public void actualizar(Persona p);
	public void eliminar(Integer id);
	
	//Nuevos
	public int actualizarPorApellido(String genero, String apellido);
	public int eliminarPorGenero(String genero);
	
	//Persona Sencilla
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido);
	public List<PersonaContadorGenero> consultarCantidadPorGenero();
}
