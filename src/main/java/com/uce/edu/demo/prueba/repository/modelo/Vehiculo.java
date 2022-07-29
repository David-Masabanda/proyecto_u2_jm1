package com.uce.edu.demo.prueba.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
	
	@Id
	@Column(name="veh_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="veh_id_seq" )
	@SequenceGenerator(name="veh_id_seq", sequenceName = "veh_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="veh_marca")
	private String marca;
	
	@Column(name="veh_placa")
	private String placa;
	
	@Column(name="veh_tipo")
	private String tipo;
	
	@Column(name="veh_precio")
	private BigDecimal precio;
	
	@OneToOne(mappedBy = "vehiculo")
	private Matricula matricula;
	
	//SET y GET
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", placa=" + placa + ", tipo=" + tipo + ", precio=" + precio
				+ ", matricula=" + matricula + "]";
	}
	
	
	
	
}
