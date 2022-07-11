package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

@Service
public class VehiculoJpaServiceImpl implements IVehiculoJpaService{
	
	@Autowired
	private IVehiculoJpaRepository vehiculoJpaRepository;
	
	@Override
	public void insertar(Vehiculo v) {
		this.vehiculoJpaRepository.create(v);
	}

	@Override
	public void actualizar(Vehiculo v) {
		this.vehiculoJpaRepository.update(v);
	}

	@Override
	public void eliminar(String nombre) {
		this.vehiculoJpaRepository.delete(nombre);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		return this.vehiculoJpaRepository.buscarPorPlaca(placa);
	}
	


}
