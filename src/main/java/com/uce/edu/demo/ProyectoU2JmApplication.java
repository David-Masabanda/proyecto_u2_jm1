package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.Detalle;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2JmApplication implements CommandLineRunner{
	
	private static Logger LOG =Logger.getLogger(ProyectoU2JmApplication.class);
	
	//@Autowired
	//private IHotelService hotelService;
	
	//@Autowired
	//private IHabitacionService habitacionService;
	
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Factura fact=this.facturaService.consultar(1);
		LOG.info("Numero: "+fact.getNumero());
		LOG.info("Fecha: "+fact.getFecha());
		LOG.info("Cliente: "+fact.getCliente().getNumeroTarjeta());
		//LOG.info("Detalles: "+fact.getCliente().getNumeroTarjeta());
		
		List<Detalle>detalles=fact.getDetalles();
		for(Detalle item: detalles) {
			LOG.info("Detalle: "+item);
		}
	}

}
