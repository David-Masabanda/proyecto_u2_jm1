package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.repository.modelo.Matricula;
import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IGestorMatriculaService;
import com.uce.edu.demo.prueba.service.IPropietarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);

	@Autowired
	private IGestorMatriculaService matriculaGestor;
	@Autowired
	private IPropietarioJpaService propietarioService;
	@Autowired
	private IVehiculoJpaService vehiculoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		//Creo un VEHICULO 
		Vehiculo v1=new Vehiculo();
		v1.setMarca("Hino");
		v1.setPlaca("PBA-9921");
		v1.setTipo("Pesado");
		v1.setPrecio(new BigDecimal(38600));
		this.vehiculoService.insertar(v1);
				
				
		//Creo un PROPIETARIO 
		Propietario p1=new Propietario();
		p1.setNombre("Carlos");
		p1.setApellido("Araujo");
		p1.setCedula("1715646122");
		p1.setFechaNacimiento(LocalDateTime.of(1989, 12, 17, 9, 30, 2));
		this.propietarioService.insertar(p1);
				
		//List<Matricula> matriculas=new ArrayList();
		
		//p1.setMatriculas(null);
		 
		 */
				
		this.matriculaGestor.matricular("1715786922", "PBA-9921");
		
	}

}
