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

		//Buscar
		//LOG.info("Dato con JPA:"+this.personaJpaService.buscar(2));
			
		//Guardar
		Persona p=new Persona();
		//p.setId(8);
		p.setNombre("Sara");
		p.setApellido("Lopez");
		p.setGenero("F");
		p.setCedula("1719139881");
		//this.personaJpaService.guardar(p);
		
		Persona p1=this.personaJpaService.buscarPorCedula("1719139881");
		LOG.info("Persona encontrada: "+ p1);
				
		List<Persona> lista=this.personaJpaService.buscarPorApellido("Lopez");
		for(Persona item:lista) {
			LOG.info("Personas:"+item);
		}
	}

}
