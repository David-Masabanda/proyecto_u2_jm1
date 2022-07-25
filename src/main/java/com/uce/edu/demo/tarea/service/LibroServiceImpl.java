package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.ILibroRepository;
import com.uce.edu.demo.tarea.repository.modelo.Libro;

@Service
public class LibroServiceImpl implements ILibroService{
	
	@Autowired
	private ILibroRepository libroRepository;
	
	@Override
	public void insertar(Libro lib) {
		this.libroRepository.insertar(lib);
	}

	@Override
	public void actualizar(Libro lib) {
		this.libroRepository.actualizar(lib);
	}

	@Override
	public void eliminar(Integer id) {
		this.libroRepository.eliminar(id);
	}

	@Override
	public Libro buscarPorId(Integer id) {
		return this.libroRepository.buscarPorId(id);
	}

}
