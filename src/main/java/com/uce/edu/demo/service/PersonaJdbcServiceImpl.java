package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.PersonaTo;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService{
	
	@Autowired
	private IPersonaJdbcRepository personaJdbcRepository;
	
	@Override
	public void guardar(PersonaTo p) {	
		this.personaJdbcRepository.insertar(p);
	}

	@Override
	public void actualizar(PersonaTo p) {
		this.personaJdbcRepository.actualizar(p);
		
	}

	@Override
	public void eliminar(int id) {
		this.personaJdbcRepository.eliminar(id);
		
	}

	@Override
	public PersonaTo buscar(int id) {
		return this.personaJdbcRepository.buscarPorId(id);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		return this.personaJdbcRepository.buscarTodos();
	}

}
