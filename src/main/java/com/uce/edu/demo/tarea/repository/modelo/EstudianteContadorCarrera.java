package com.uce.edu.demo.tarea.repository.modelo;

public class EstudianteContadorCarrera {
	private String carrera;
	private Long cantidad;
	
	public EstudianteContadorCarrera(String carrera, Long cantidad) {
		this.carrera=carrera;
		this.cantidad=cantidad;
	}
	
	//SET y GET
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "EstudianteContadorCarrera [carrera=" + carrera + ", cantidad=" + cantidad + "]";
	}
	
	
}
