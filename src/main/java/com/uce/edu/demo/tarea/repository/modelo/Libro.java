package com.uce.edu.demo.tarea.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {
	
	@Id
	@Column(name="lib_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="lib_id_seq" )
	@SequenceGenerator(name="lib_id_seq", sequenceName = "lib_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="lib_titulo")
	private String titulo;
	
	@Column(name="lib_genero")
	private String genero;
	
	@Column(name="lib_editorial")
	private String editorial;
	
	@Column(name="lib_autor")
	private String autor;
	
	@ManyToOne
	@JoinColumn(name="lib_id_lector")
	private Lector lector;

	
	//GET y SET
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", editorial=" + editorial + ", autor="
				+ autor + ", lector=" + lector + "]";
	}
	
	
	

}
