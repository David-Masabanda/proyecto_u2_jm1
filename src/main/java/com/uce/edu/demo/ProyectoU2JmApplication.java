package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.tarea.repository.modelo.Lector;
import com.uce.edu.demo.tarea.service.ILectorService;
import com.uce.edu.demo.tarea.service.ILibroService;

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
	
	@Autowired
	private ILectorService lectorService;
	@Autowired
	private ILibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Lector l=new Lector();
		l.setNombre("Lucas");
		l.setApellido("Ramos");
		l.setCedula("1713110547");
		l.setDireccion("Condado");
		
		//Insertar
		this.lectorService.insertar(l);
		
		//Actualizar
		Lector l1=new Lector();
		l1.setNombre("Samantha");
		l1.setApellido("Lopez");
		l1.setCedula("1719139900");
		l1.setDireccion("La Gasca");
		l1.setId(1);
		this.lectorService.actualizar(l1);
		
		//Eliminar
		this.lectorService.eliminar(2);
		
		//Buscar
		this.lectorService.buscarPorId(3);
		
		/*
		Hotel h1=new Hotel();
		h1.setNombre("Hilton Colon");
		h1.setDireccion("Quito");
		this.hotelService.insertar(h1);
		
		
		Hotel h1=new Hotel();
		h1.setId(1);
		
		Habitacion hab=new Habitacion();
		hab.setNumero("A113");
		hab.setPiso("10");
		hab.setTipo("Familiar");
		hab.setHotel(h1);
		
		Habitacion hab2=new Habitacion();
		hab2.setNumero("A114");
		hab2.setPiso("11");
		hab2.setTipo("Suite");
		hab2.setHotel(h1);
		
		this.habitacionService.insertar(hab);
		this.habitacionService.insertar(hab2);
*/
	}

}
