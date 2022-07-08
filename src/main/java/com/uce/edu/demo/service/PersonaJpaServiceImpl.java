package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService{
	
	@Autowired
	private IPersonaJpaRepository personaJpaRepository;
	
	@Override
	public void guardar(Persona p) {
		this.personaJpaRepository.insertar(p);
	}

	@Override
	public void actualizar(Persona p) {
		this.personaJpaRepository.actualizar(p);
	}

	@Override
	public void eliminar(Integer id) {
		this.personaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarPorId(Integer id) {
		return this.personaJpaRepository.buscarPorId(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		return this.personaJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		return this.personaJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		return this.personaJpaRepository.buscarPorGenero(genero);
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		return this.personaJpaRepository.buscarPorNombre(nombre);
	}

}
