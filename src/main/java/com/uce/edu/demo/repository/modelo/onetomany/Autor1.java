package com.uce.edu.demo.repository.modelo.onetomany;

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
@Table(name="autor1")
public class Autor1 {
	
	@Id
	@Column(name = "au1_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "au1_id_seq")
	@SequenceGenerator(name = "au1_id_seq", sequenceName = "au1_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="au1_nombre")
	private String nombre;

	@OneToMany(mappedBy="autor")
	private List<LibroAutor> libros;
	

	//SET y GET
	public List<LibroAutor> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroAutor> libros) {
		this.libros = libros;
	}

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
	
	
}
