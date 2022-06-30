package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService{
	
	@Autowired
	private IEstudianteJpaRepository estudianteJpaRepository;

	@Override
	public void guardar(Estudiante e) {
		this.estudianteJpaRepository.insertar(e);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.estudianteJpaRepository.actualizar(e);
	}

	@Override
	public void eliminar(int id) {
		this.estudianteJpaRepository.eliminar(id);
	}

	@Override
	public Estudiante buscar(int id) {
		return this.estudianteJpaRepository.buscarPorId(id);
	}

}
