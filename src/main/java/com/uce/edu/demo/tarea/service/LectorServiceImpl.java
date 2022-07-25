package com.uce.edu.demo.tarea.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.ILectorRepository;
import com.uce.edu.demo.tarea.repository.modelo.Lector;

@Service
public class LectorServiceImpl implements ILectorService{
	
	@Autowired
	private ILectorRepository lectorRepository;
	
	@Override
	public void insertar(Lector l) {
		this.lectorRepository.insertar(l);
	}

	@Override
	public void actualizar(Lector l) {
		this.lectorRepository.actualizar(l);
	}

	@Override
	public void eliminar(Integer id) {
		this.lectorRepository.eliminar(id);
	}

	@Override
	public Lector buscarPorId(Integer id) {
		return this.lectorRepository.buscarPorId(id);
	}

}
