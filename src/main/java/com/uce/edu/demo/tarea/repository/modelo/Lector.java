package com.uce.edu.demo.tarea.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lector")
public class Lector {

	@Id
	@Column(name = "lec_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lec_id_seq")
	@SequenceGenerator(name = "lec_id_seq", sequenceName = "lec_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "lec_nombre")
	private String nombre;

	@Column(name = "lec_apellido")
	private String apellido;

	@Column(name = "lec_cedula")
	private String cedula;

	@Column(name = "lec_direccion")
	private String direccion;

	@OneToMany(mappedBy = "lector")
	private List<Escrito> escritos;

	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public List<Escrito> getEscritos() {
		return escritos;
	}

	public void setEscritos(List<Escrito> escritos) {
		this.escritos = escritos;
	}

	@Override
	public String toString() {
		return "Lector [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", direccion=" + direccion + ", escritos=" + escritos + "]";
	}


	
	
}
