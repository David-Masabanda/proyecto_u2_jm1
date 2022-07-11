package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IMatriculaRepository;
import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Matricula;
import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

@Service
public class GestorMatriculaServiceImpl implements IGestorMatriculaService{
	
	@Autowired
	private IPropietarioJpaRepository propietarioJpaRepository;
	@Autowired
	private IVehiculoJpaRepository vehiculoJpaRepository;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaPesadoService;
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaLivianoService;
	
	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	
	@Override
	public void matricular(String cedula, String placa) {
		Propietario p=this.propietarioJpaRepository.buscarPorCedula(cedula);	
		Vehiculo v=this.vehiculoJpaRepository.buscarPorPlaca(placa);
			
		
		String tipo=v.getTipo();
		BigDecimal valorMatricula;
		
		if(tipo.equals("Liviano")) {
			valorMatricula=this.matriculaLivianoService.calcular(v.getPrecio());
		}else {
			valorMatricula=this.matriculaPesadoService.calcular(v.getPrecio());
		}
		
		if(valorMatricula.compareTo(new BigDecimal(2000))>0) {
			BigDecimal descuento=valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula=valorMatricula.subtract(descuento);
		}
		
		Matricula matricula=new Matricula();
		matricula.setFechamatricula(LocalDateTime.now());
		matricula.setValorMatricula(valorMatricula);
		matricula.setPropietario(p);
		matricula.setVehiculo(v);
		
		this.matriculaRepository.create(matricula);
		
		
	}

}
