package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.tarea.repository.modelo.Ciudadano1;
import com.uce.edu.demo.tarea.repository.modelo.Pasaporte;
import com.uce.edu.demo.tarea.service.ICiudadano1Service;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	//@Autowired
	//private IPersonaJpaService personaJpaService;
	
	//@Autowired
	//private IEstudianteJpaService estudianteJpaService;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Hotel h1=new Hotel();
		h1.setNombre("Hilton Colon");
		h1.setDireccion("Quito");
		this.hotelService.insertar(h1);
		*/
		
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

	}

}
