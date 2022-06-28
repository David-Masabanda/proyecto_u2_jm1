package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.tarea.to.Estudiante;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{
	
	@Autowired
	private IEstudianteJdbcRepository estudianteJdbcRepository;
	
	@Override
	public void guardar(Estudiante e) {
		this.estudianteJdbcRepository.insertar(e);
	}

	@Override
	public void actualizar(Estudiante e) {
		this.estudianteJdbcRepository.actualizar(e);
	}

	@Override
	public void eliminar(int id) {
		this.estudianteJdbcRepository.eliminar(id);
	}

	@Override
	public Estudiante buscar(int id) {
		return this.estudianteJdbcRepository.buscarPorId(id);
	}

}
