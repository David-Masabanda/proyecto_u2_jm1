package com.uce.edu.demo;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	@Autowired
	private IPersonaJpaService personaJpaService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	//@Autowired
	//private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		List<PersonaSencilla>listaPersona=this.personaJpaService.buscarPorApellidoSencillo("Andrade");
		for(PersonaSencilla item: listaPersona) {
			LOG.info("PersonaSencilla: "+item);
		}
		
		List<PersonaContadorGenero>myLista=this.personaJpaService.consultarCantidadPorGenero();
		for(PersonaContadorGenero item: myLista) {
			LOG.info("Genero: "+item);
		}*/
		Ciudadano c1=new Ciudadano();
		c1.setNombre("Laura");
		c1.setApellido("Ordoñez");	
		
		Empleado e1=new Empleado();
		e1.setCodigoIess("151311");
		e1.setSalario(new BigDecimal(100));
		e1.setCiudadano(c1);
		
		c1.setEmpleado(e1);
		
		this.ciudadanoService.insertar(c1);

	}

}
