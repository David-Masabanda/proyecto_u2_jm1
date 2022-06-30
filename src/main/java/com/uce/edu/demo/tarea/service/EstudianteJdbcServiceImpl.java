package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.tarea.to.EstudianteTo;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{
	
	@Autowired
	private IEstudianteJdbcRepository estudianteJdbcRepository;
	
	@Override
	public void guardar(EstudianteTo e) {
		this.estudianteJdbcRepository.insertar(e);
	}

	@Override
	public void actualizar(EstudianteTo e) {
		this.estudianteJdbcRepository.actualizar(e);
	}

	@Override
	public void eliminar(int id) {
		this.estudianteJdbcRepository.eliminar(id);
	}

	@Override
	public EstudianteTo buscar(int id) {
		return this.estudianteJdbcRepository.buscarPorId(id);
	}

}
