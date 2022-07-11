package com.uce.edu.demo.prueba.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Matricula {
	
	private LocalDateTime fechamatricula;
	private BigDecimal valorMatricula;
	private Propietario propietario;
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
	
	@Override
	public String toString() {
		return "Matricula [fechamatricula=" + fechamatricula + ", valorMatricula=" + valorMatricula + ", propietario="
				+ propietario + ", vehiculo=" + vehiculo + "]";
	}
	
	
	
	
	
	
}
