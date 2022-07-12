package com.uce.edu.demo;

import java.util.List;

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
		
		//Metodo 1 /TypedQuey
		List<Estudiante>lista1=this.estudianteJpaService.buscarPorSemestreTyped("Octavo");
		for(Estudiante item: lista1) {
			LOG.info("Persona: "+item);
		}
		
		List<Estudiante>lista2=this.estudianteJpaService.buscarPorCarreraTyped("Medicina");
		for(Estudiante item: lista2) {
			LOG.info("Persona: "+item);
		}
		
		
		//Metodo 2 /NamedQuery
		List<Estudiante>lista3=this.estudianteJpaService.buscarPorApellidoNamed("Martinez");
		for(Estudiante item: lista3) {
			LOG.info("Persona: "+item);
		}
		
		List<Estudiante>lista4=this.estudianteJpaService.buscarPorNombreNamed("L%");
		for(Estudiante item: lista4) {
			LOG.info("Persona: "+item);
		}
		
		
		//Metodo 3 /Typed y Named
		List<Estudiante>lista5=this.estudianteJpaService.buscarPorCarreraSemestre("Medicina", "Noveno");
		for(Estudiante item: lista5) {
			LOG.info("Persona: "+item);
		}
		
		List<Estudiante>lista6=this.estudianteJpaService.buscarPorApellido("R%");
		for(Estudiante item: lista6) {
			LOG.info("Persona: "+item);
		}
		
	}

}
