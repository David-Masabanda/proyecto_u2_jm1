package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	@Autowired
	private IPersonaJpaService personaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Persona p=new Persona();
		p.setNombre("Rebeca");
		p.setApellido("Vasquez");
		p.setCedula("1231231230");
		p.setGenero("F");
		this.personaJpaService.guardar(p);
		*/
		
		//Metodo 1 /TypedQuey
		Persona perTyped=this.personaJpaService.buscarPorCedulaTyped("1719139980");
		LOG.info("Persona Typed: "+perTyped);
		//Metodo 2 /NamedQuery
		Persona perNamed=this.personaJpaService.buscarPorCedulaNamed("1704906542");
		LOG.info("Persona Named: "+perNamed);
		//Metodo 3 /Typed y Named
		Persona perTypedNamed=this.personaJpaService.buscarPorCedulaTypedNamed("1713190052");
		LOG.info("Persona TypedNamed: "+perTypedNamed);
			
		//4. Varios NamedQuery
		List<Persona>listaPersonas=this.personaJpaService.buscarPorNombreApellido("Rebeca", "Vasquez");
		for(Persona item: listaPersonas) {
			LOG.info("Persona: "+item);
		}
	}

}
