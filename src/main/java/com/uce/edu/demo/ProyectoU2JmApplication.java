package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	//@Autowired
	//private IPersonaJpaService personaJpaService;
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante busqueda1=this.estudianteJpaService.buscarDinamicamente("Madelyn", "Ramirez", "Decimo");
		LOG.info("Persona Criteria API: "+busqueda1);
		
		Estudiante busqueda2=this.estudianteJpaService.buscarDinamicamente2("Vasquez", "Sexto", "Odontologia");
		LOG.info("Persona Criteria API: "+busqueda2);
		
	
		
		
	}

}
