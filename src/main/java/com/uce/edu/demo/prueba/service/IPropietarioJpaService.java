package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;

public interface IPropietarioJpaService {
	
	public void insertar(Propietario p);
	public void eliminar(String cedula);
	
	public Propietario buscarPorCedula(String cedula);
}
