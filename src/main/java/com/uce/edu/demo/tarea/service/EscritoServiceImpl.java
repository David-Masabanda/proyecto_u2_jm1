package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IEscritoRepository;
import com.uce.edu.demo.tarea.repository.modelo.Escrito;

@Service
public class EscritoServiceImpl implements IEscritoService{
	
	@Autowired
	private IEscritoRepository libroRepository;
	
	@Override
	public void insertar(Escrito lib) {
		this.libroRepository.insertar(lib);
	}

	@Override
	public void actualizar(Escrito lib) {
		this.libroRepository.actualizar(lib);
	}

	@Override
	public void eliminar(Integer id) {
		this.libroRepository.eliminar(id);
	}

	@Override
	public Escrito buscarPorId(Integer id) {
		return this.libroRepository.buscarPorId(id);
	}

}
