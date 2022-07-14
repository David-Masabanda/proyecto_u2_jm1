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
		
		//Native 1
		Estudiante busqueda=this.estudianteJpaService.buscarPorIdNative(1001);
		LOG.info("Persona Native: "+busqueda);
		
		//Native 2
		busqueda=this.estudianteJpaService.buscarPorApellidoSemestreNative("Ramirez", "Decimo");
		LOG.info("Persona Native: "+busqueda);
		
		//Named Native 1
		busqueda=this.estudianteJpaService.buscarPorApellidoCarreraNative("Ordoñez", "Biologia");
		LOG.info("Persona Named Native: "+busqueda);
		
		//Named Native 2
		List<Estudiante> lista=this.estudianteJpaService.buscarPorCarreraNative("Medicina");
		for(Estudiante item: lista) {
			LOG.info("Persona Named Native: "+item);
		}
		
		
	}

}
