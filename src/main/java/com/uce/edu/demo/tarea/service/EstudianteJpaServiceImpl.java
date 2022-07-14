package com.uce.edu.demo.tarea.service;

import java.util.List;

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

	@Override
	public List<Estudiante> buscarPorSemestreTyped(String semestre) {
		return this.estudianteJpaRepository.buscarPorSemestreTyped(semestre);
	}

	@Override
	public List<Estudiante> buscarPorCarreraTyped(String carrera) {
		return this.estudianteJpaRepository.buscarPorCarreraTyped(carrera);
	}

	@Override
	public List<Estudiante> buscarPorApellidoNamed(String apellido) {
		return this.estudianteJpaRepository.buscarPorApellidoNamed(apellido);
	}

	@Override
	public List<Estudiante> buscarPorNombreNamed(String nombre) {
		return this.estudianteJpaRepository.buscarPorNombreNamed(nombre);
	}

	@Override
	public List<Estudiante> buscarPorCarreraSemestre(String carrera, String semestre) {
		return this.estudianteJpaRepository.buscarPorCarreraSemestre(carrera, semestre);
	}

	@Override
	public List<Estudiante> buscarPorApellido(String apellido) {
		return this.estudianteJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public Estudiante buscarPorIdNative(Integer id) {
		return this.estudianteJpaRepository.buscarPorIdNative(id);
	}

	@Override
	public Estudiante buscarPorApellidoSemestreNative(String apellido, String semestre) {
		return this.estudianteJpaRepository.buscarPorApellidoSemestreNative(apellido, semestre);
	}

	@Override
	public Estudiante buscarPorApellidoCarreraNative(String apellido, String carrera) {
		return this.estudianteJpaRepository.buscarPorApellidoCarreraNative(apellido, carrera);
	}

	@Override
	public List<Estudiante> buscarPorCarreraNative(String carrera) {
		return this.estudianteJpaRepository.buscarPorCarreraNative(carrera);
	}

}
