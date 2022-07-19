package com.uce.edu.demo.tarea.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private String carrera;
	
	public EstudianteSencillo(String nombre, String apellido, String carrera) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.carrera=carrera;
	}
	
	//SET y GET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	@Override
	public String toString() {
		return "EstudianteSencillo [nombre=" + nombre + ", apellido=" + apellido + ", carrera=" + carrera + "]";
	}
	
	
}
