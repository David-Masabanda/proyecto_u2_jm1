package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteSencillo;
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
		
		/*
		List<PersonaSencilla>listaPersona=this.personaJpaService.buscarPorApellidoSencillo("Andrade");
		for(PersonaSencilla item: listaPersona) {
			LOG.info("PersonaSencilla: "+item);
		}
		
		List<PersonaContadorGenero>myLista=this.personaJpaService.consultarCantidadPorGenero();
		for(PersonaContadorGenero item: myLista) {
			LOG.info("Genero: "+item);
		}*/
		
		List<EstudianteSencillo>listaEstudiante=this.estudianteJpaService.consultarPorCarreraSencillo("Medicina");
		for(EstudianteSencillo item: listaEstudiante) {
			LOG.info("EstudianteSencillo: "+item);
		}
		
		List<EstudianteContadorCarrera>myLista=this.estudianteJpaService.consultarCantidadPorCarrera();
		for(EstudianteContadorCarrera item: myLista) {
			LOG.info("EstudianteContadorCarrera: "+item);
		}
	}

}
