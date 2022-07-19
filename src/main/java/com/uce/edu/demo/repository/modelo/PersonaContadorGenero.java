package com.uce.edu.demo.repository.modelo;

public class PersonaContadorGenero {
	
	private String genero;
	private Long numero;
	
	public PersonaContadorGenero(String genero, Long numero) {
		this.genero=genero;
		this.numero=numero;
	}
	


	//SET y GET
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
	@Override
	public String toString() {
		return "PersonaContadorGenero [genero=" + genero + ", numero=" + numero + "]";
	}
}
