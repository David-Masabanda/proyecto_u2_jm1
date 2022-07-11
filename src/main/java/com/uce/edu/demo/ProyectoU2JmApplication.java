package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IGestorMatriculaService;
import com.uce.edu.demo.prueba.service.IPropietarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	//@Autowired
	//private IPersonaJpaService personaJpaService;
	
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
		
		//Creo un VEHICULO 
		Vehiculo v1=new Vehiculo();
		v1.setMarca("Chevrolet");
		v1.setPlaca("PIA-1920");
		v1.setTipo("Liviano");
		v1.setPrecio(new BigDecimal(28600));
		this.vehiculoService.insertar(v1);
		
		
		//Creo un PROPIETARIO 
		Propietario p1=new Propietario();
		p1.setNombre("Daniel");
		p1.setApellido("Andrade");
		p1.setCedula("1715647800");
		p1.setFechaNacimiento(LocalDateTime.of(1999, 9, 21, 9, 30, 2));
		this.propietarioService.insertar(p1);
		
		
		
		this.matriculaGestor.matricular("1715786922", "GAA-1512");

		
	}

}
