package com.uce.edu.demo.service;

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
	public Persona buscar(Integer id) {
		return this.personaJpaRepository.buscarPorId(id);
	}

}
