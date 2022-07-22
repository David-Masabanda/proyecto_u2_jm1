package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.ICiudadano1Repository;
import com.uce.edu.demo.tarea.repository.modelo.Ciudadano1;

@Service
public class Ciudadano1ServiceImpl implements ICiudadano1Service{
	
	@Autowired
	private ICiudadano1Repository ciudadanoRepository;
	
	@Override
	public void insertar(Ciudadano1 c) {
		this.ciudadanoRepository.insertar(c);
	}

	@Override
	public void actualizar(Ciudadano1 c) {
		this.ciudadanoRepository.actualizar(c);		
	}

	@Override
	public void eliminar(Integer id) {
		this.ciudadanoRepository.eliminar(id);
	}

	@Override
	public Ciudadano1 buscarPorId(Integer id) {
		return this.ciudadanoRepository.buscarPorId(id);
	}

}
