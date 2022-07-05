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

		//Buscar
		//LOG.info("Dato con JPA:"+this.personaJpaService.buscar(2));
			
		//Guardar
		Persona p=new Persona();
		//p.setId(8);
		p.setNombre("Lucia");
		p.setApellido("Marks");
		this.personaJpaService.guardar(p);
				
				
		//Actualizar
		Persona p1=new Persona();
		//p1.setId(3);
		p1.setNombre("Madelynn");
		p1.setApellido("Ruiz");
		//this.personaJpaService.actualizar(p1);
				
				
		//Eliminar
		//this.personaJpaService.eliminar(1);
		
	}

}
