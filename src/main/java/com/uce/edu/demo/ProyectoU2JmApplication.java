package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea.repository.modelo.Ciudadano1;
import com.uce.edu.demo.tarea.repository.modelo.Pasaporte;
import com.uce.edu.demo.tarea.service.ICiudadano1Service;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	//@Autowired
	//private IPersonaJpaService personaJpaService;
	
	@Autowired
	private ICiudadano1Service ciudadanoService2;
	
	//@Autowired
	//private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		//Insertar
		Ciudadano1 c1=new Ciudadano1();
		c1.setNombre("David");
		c1.setApellido("Lagos");	
		c1.setCedula("1719178245");
		c1.setFechaNacimiento(LocalDateTime.of(2000, 3, 17, 8, 50, 2));
		
		Pasaporte p1=new Pasaporte();
		p1.setNumero(112407);
		p1.setFechaEmision(LocalDateTime.of(2016, 5, 19, 8, 50, 2));
		p1.setFechaCaducidad(LocalDateTime.of(2023, 5, 19, 8, 50, 2));
		p1.setCiudadano(c1);
		
		c1.setPasaporte(p1);	
		this.ciudadanoService2.insertar(c1);
		
		
		
		//Actualizar
		Ciudadano1 c2=new Ciudadano1();
		c2.setId(3);
		c2.setNombre("Alex");
		c2.setApellido("Perez");
		c2.setCedula("1719150384");
		c2.setFechaNacimiento(LocalDateTime.of(1999, 2, 10, 8, 50, 2));
		this.ciudadanoService2.actualizar(c2);
		
		//Eliminar
		this.ciudadanoService2.eliminar(4);
		
		//Buscar 
		this.ciudadanoService2.buscarPorId(5);
		
		

	}

}
