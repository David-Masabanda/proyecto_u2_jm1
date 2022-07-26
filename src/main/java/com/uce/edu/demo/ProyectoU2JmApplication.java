package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Autor1;
import com.uce.edu.demo.repository.modelo.onetomany.Libro1;
import com.uce.edu.demo.repository.modelo.onetomany.LibroAutor;
import com.uce.edu.demo.service.IAutorDeberService;
import com.uce.edu.demo.service.ILibroAutorService;
import com.uce.edu.demo.service.ILibroDeberService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	//@Autowired
	//private IHotelService hotelService;
	
	//@Autowired
	//private IHabitacionService habitacionService;
	
	@Autowired
	private IAutorDeberService autorDeberService;
	
	@Autowired
	private ILibroDeberService libroDeberService;
	
	@Autowired
	private ILibroAutorService libroAutorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//AUTOR CON 2 LIBROS
		Autor1 a=new Autor1();
		a.setNombre("Ernest Cline");
		this.autorDeberService.insertar(a);
		
		Libro1 l1=new Libro1();
		l1.setTitulo("Armada");
		l1.setCantidadPaginas(352);
		this.libroDeberService.insertar(l1);
		
		Libro1 l2=new Libro1();
		l2.setTitulo("Ready Player One");
		l2.setCantidadPaginas(397);
		this.libroDeberService.insertar(l2);
		
		LibroAutor la=new LibroAutor();
		la.setAutor(a);
		la.setLibro(l1);
		this.libroAutorService.insertar(la);
		
		LibroAutor la1=new LibroAutor();
		la1.setAutor(a);
		la1.setLibro(l2);
		this.libroAutorService.insertar(la1);
		
		//--------------------------------------------
		//LIBRO CON 2 AUTORES
		Libro1 l3=new Libro1();
		l3.setTitulo("En la hierba alta");
		l3.setCantidadPaginas(352);
		this.libroDeberService.insertar(l3);
		
		Autor1 a1=new Autor1();
		a1.setNombre("Stephen King");
		this.autorDeberService.insertar(a1);
		
		Autor1 a2=new Autor1();
		a2.setNombre("Joe Hill");
		this.autorDeberService.insertar(a2);
		
		LibroAutor la2=new LibroAutor();
		la2.setAutor(a1);
		la2.setLibro(l3);
		this.libroAutorService.insertar(la2);
		
		LibroAutor la3=new LibroAutor();
		la3.setAutor(a2);
		la3.setLibro(l3);
		this.libroAutorService.insertar(la3);
		

	}

}
