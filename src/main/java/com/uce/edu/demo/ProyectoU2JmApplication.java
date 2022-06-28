package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	@Autowired
	private IPersonaJdbcService personaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Persona p=new Persona();
		p.setId(5);
		p.setNombre("A");
		p.setApellido("M");
		//INSERTAR
		//this.personaJdbcService.guardar(p);
		
		Persona p1=new Persona();
		p1.setNombre("Samanta");
		p1.setApellido("Velez");
		p1.setId(2);
		//ACTUALIZAR
		//this.personaJdbcService.actualizar(p1);
		
		//ELIMINAR
		//this.personaJdbcService.eliminar(5);
		
		//BUSCAR
		Persona p2=new Persona();
		p2=this.personaJdbcService.buscar(2);
		LOG.info(p2);
		
	}

}
