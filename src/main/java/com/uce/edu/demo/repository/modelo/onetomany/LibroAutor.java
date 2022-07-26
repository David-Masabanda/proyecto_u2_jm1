package com.uce.edu.demo.repository.modelo.onetomany;

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
@Table(name="LibroAutor1")
public class LibroAutor {

	@Id
	@Column(name="la_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "la_id_seq")
	@SequenceGenerator(name = "la_id_seq", sequenceName = "la_id_seq", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="la_id_autor")
	private Autor1 autor;

	@ManyToOne
	@JoinColumn(name="la_id_libro")
	
	
	//SET y GET
	private Libro1 libro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Autor1 getAutor() {
		return autor;
	}

	public void setAutor(Autor1 autor) {
		this.autor = autor;
	}

	public Libro1 getLibro() {
		return libro;
	}

	public void setLibro(Libro1 libro) {
		this.libro = libro;
	}
	
	

	
}
