package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	//@Autowired
	//private IPersonaJpaService personaJpaService;
	
	//@Autowired
	//private IEstudianteJpaService estudianteJpaService;
	
	//@Autowired
	//private IHotelService hotelService;
	
	//@Autowired
	//private IHabitacionService habitacionService;
	
	//@Autowired
	//private ILectorService lectorService;
	@Autowired
	private ILibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Autor a=new Autor();
		a.setNombre("Ernest Cline");
		Set<Autor> autores=new HashSet<>();
		autores.add(a);
		
		Libro l=new Libro();
		l.setTitulo("Armada");
		l.setCantidadPaginas(370);
		
		l.setAutores(autores);
		
		this.libroService.insertar(l);

	}

}
