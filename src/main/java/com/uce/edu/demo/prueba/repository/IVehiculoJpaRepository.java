package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

public interface IVehiculoJpaRepository {
	
	public void create(Vehiculo v);
	public void update(Vehiculo v);
	public void delete(String placa);
	
	public Vehiculo buscarPorPlaca(String placa);
}
