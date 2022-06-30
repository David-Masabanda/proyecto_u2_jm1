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
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Buscar
		LOG.info("Datos con JPA:"+this.estudianteJpaService.buscar(1612));
		
		//Guardar
		Estudiante e=new Estudiante();
		e.setId(1123);
		e.setNombre("Rebeca");
		e.setApellido("Ordoñez");
		e.setCarrera("Arquitectura");
		e.setSemestre("Decimo");
		this.estudianteJpaService.guardar(e);
		
		
		//Actualizar
		Estudiante e1=new Estudiante();
		e1.setId(1513);
		e1.setNombre("Martha");
		e1.setApellido("Alban");
		e1.setCarrera("Medicina");
		e1.setSemestre("Septimo");
		this.estudianteJpaService.actualizar(e1);
		
		
		//Eliminar
		this.estudianteJpaService.eliminar(1214);
		
		
		
	}

}
