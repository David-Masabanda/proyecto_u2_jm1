package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea.service.IEstudianteJdbcService;
import com.uce.edu.demo.tarea.to.Estudiante;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1.Insertar
		Estudiante e=new Estudiante();
		e.setId(1214);
		e.setNombre("Lucas");
		e.setApellido("Ruiz");
		e.setCarrera("Odontologia");
		e.setSemestre("Octavo");
		this.estudianteJdbcService.guardar(e);
		
		//2.Actualizar
		Estudiante e1=new Estudiante();
		e1.setNombre("Alex");
		e1.setApellido("Martinez");
		e1.setCarrera("Psicologia");
		e1.setSemestre("Noveno");
		e1.setId(1317);
		//this.estudianteJdbcService.actualizar(e1);
		
		//3.Eliminar
		//this.estudianteJdbcService.eliminar(1010);
		
		//4.Buscar
		Estudiante e2=new Estudiante();
		//e2=this.estudianteJdbcService.buscar(1513);
		//LOG.info(e2);
	}

}
