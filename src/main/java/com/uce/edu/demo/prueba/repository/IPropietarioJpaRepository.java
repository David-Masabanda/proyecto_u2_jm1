package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;

public interface IPropietarioJpaRepository {
	
	public void create(Propietario p);
	public void delete(String cedula);
	
	public Propietario buscarPorCedula(String cedula);
	
}
