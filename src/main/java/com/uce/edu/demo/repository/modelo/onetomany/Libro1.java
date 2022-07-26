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
@Table(name="libro1")
public class Libro1 {
	
	@Id
	@Column(name="lib1_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lib1_id_seq")
	@SequenceGenerator(name = "lib1_id_seq", sequenceName = "lib1_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="lib1_titulo")
	private String titulo;
	
	@Column(name="lib1_paginas")
	private Integer cantidadPaginas;
	
	@OneToMany(mappedBy="libro")
	private List<LibroAutor> autores;
	

	//SET y GET
	public List<LibroAutor> getAutores() {
		return autores;
	}

	public void setAutores(List<LibroAutor> autores) {
		this.autores = autores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}
	
	
	
	
}	
