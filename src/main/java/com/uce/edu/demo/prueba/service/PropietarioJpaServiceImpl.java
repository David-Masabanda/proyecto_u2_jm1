package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Propietario;

@Service
public class PropietarioJpaServiceImpl implements IPropietarioJpaService{
	
	@Autowired
	private IPropietarioJpaRepository  propietarioJpaRepository;
	
	@Override
	public void insertar(Propietario p) {
		this.propietarioJpaRepository.create(p);
	}

	@Override
	public void eliminar(String cedula) {
		this.propietarioJpaRepository.delete(cedula);
	}

	@Override
	public Propietario buscarPorCedula(String cedula) {
		return this.propietarioJpaRepository.buscarPorCedula(cedula);
	}


	



}
