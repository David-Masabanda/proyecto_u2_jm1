package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

public interface IVehiculoJpaService {
	
	public void insertar(Vehiculo v);
	public void actualizar(Vehiculo v);
	public void eliminar(String nombre);
	
	public Vehiculo buscarPorPlaca(String placa);

}
