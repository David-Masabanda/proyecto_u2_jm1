package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.Persona;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService{
	
	@Autowired
	private IPersonaJdbcRepository personaJdbcRepository;
	
	@Override
	public void guardar(Persona p) {	
		this.personaJdbcRepository.insertar(p);
	}

	@Override
	public void actualizar(Persona p) {
		this.personaJdbcRepository.actualizar(p);
		
	}

	@Override
	public void eliminar(int id) {
		this.personaJdbcRepository.eliminar(id);
		
	}

	@Override
	public Persona buscar(int id) {
		return this.personaJdbcRepository.buscarPorId(id);
	}

}
