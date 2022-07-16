package com.uce.edu.demo;

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
		
		Persona busqueda=this.personaJpaService.buscarPorCedulaNamedCriteriaApi("1719139980");
		LOG.info("Persona Criteria API: "+busqueda);
		
		Persona perDinamica=this.personaJpaService.buscarDinamicamente("David", "Andrade", "M");
		LOG.info("Persona Criteria API: "+perDinamica);
		
	
		
		
	}

}
