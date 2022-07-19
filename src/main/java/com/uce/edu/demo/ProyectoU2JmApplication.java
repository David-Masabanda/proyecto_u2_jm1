package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	@Autowired
	private IPersonaJpaService personaJpaService;
	
	//@Autowired
	//private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Estudiante busqueda1=this.estudianteJpaService.buscarDinamicamente("Madelyn", "Ramirez", "Decimo");
		LOG.info("Persona Criteria API: "+busqueda1);
		
		Estudiante busqueda2=this.estudianteJpaService.buscarDinamicamente2("Vasquez", "Sexto", "Odontologia");
		LOG.info("Persona Criteria API: "+busqueda2);
		*/
		
		List<PersonaSencilla>listaPersona=this.personaJpaService.buscarPorApellidoSencillo("Andrade");
		for(PersonaSencilla item: listaPersona) {
			LOG.info("PersonaSencilla: "+item);
		}
		
		List<PersonaContadorGenero>myLista=this.personaJpaService.consultarCantidadPorGenero();
		for(PersonaContadorGenero item: myLista) {
			LOG.info("Genero: "+item);
		}
	}

}
