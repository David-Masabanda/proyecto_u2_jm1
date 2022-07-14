package com.uce.edu.demo.tarea.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.uce.edu.demo.repository.modelo.Persona;

@Entity
@Table(name="estudiante")

/*
@NamedQueries({
	@NamedQuery(name="Estudiante.buscarPorApellido", query="SELECT e FROM Estudiante e WHERE e.apellido =:datoApellido"),
	@NamedQuery(name="Estudiante.buscarPorNombreLetra", query="SELECT e FROM Estudiante e WHERE e.nombre LIKE :datoLetra"),
	@NamedQuery(name="Estudiante.buscarPorCarreraSemestre", query="SELECT e FROM Estudiante e WHERE e.carrera =:datoCarrera AND e.semestre=:datoSemestre"),
	@NamedQuery(name="Estudiante.buscarPorApellidoLetra", query="SELECT e FROM Estudiante e WHERE e.apellido LIKE :datoLetra")
})*/
@NamedNativeQueries({
	@NamedNativeQuery(name="Estudiante.buscarPorApellidoCarreraNative" , query="SELECT * FROM estudiante WHERE apellido= :datoApellido AND carrera= :datoCarrera", resultClass=Estudiante.class),
	@NamedNativeQuery(name="Estudiante.buscarPorCarreraNative" , query="SELECT * FROM estudiante WHERE carrera= :datoCarrera", resultClass=Estudiante.class)	
})

public class Estudiante {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="carrera")
	private String carrera;
	
	@Column(name="semestre")
	private String semestre;
	
	//SET y GET
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", carrera=" + carrera
				+ ", semestre=" + semestre + "]";
	}
	
	
	
	

}
