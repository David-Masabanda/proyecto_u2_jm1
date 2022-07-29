package com.uce.edu.demo.prueba.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	
	@Id
	@Column(name="matr_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="matr_id_seq" )
	@SequenceGenerator(name="matr_id_seq", sequenceName = "matr_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="matr_fecha_matricula")
	private LocalDateTime fechamatricula;
	
	@Column(name="matr_valor_vatricula")
	private BigDecimal valorMatricula;
	
	
	@ManyToOne
	@JoinColumn(name = "matr_prop_id")
	private Propietario propietario;
	
	@OneToOne
	@JoinColumn(name = "matr_veh_id")
	private Vehiculo vehiculo;
	
	
	//SET y GET
	public LocalDateTime getFechamatricula() {
		return fechamatricula;
	}
	public void setFechamatricula(LocalDateTime fechamatricula) {
		this.fechamatricula = fechamatricula;
	}
	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}
	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechamatricula=" + fechamatricula + ", valorMatricula=" + valorMatricula
				+ ", propietario=" + propietario + ", vehiculo=" + vehiculo + "]";
	}
	
	
	
	
	
	
	
	
}
