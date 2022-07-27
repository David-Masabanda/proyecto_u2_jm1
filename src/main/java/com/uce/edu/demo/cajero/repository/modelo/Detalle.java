package com.uce.edu.demo.cajero.repository.modelo;

import java.math.BigDecimal;

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
@Table(name="detalle")
public class Detalle {
	
	@Id
	@Column(name="det_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="det_id_seq" )
	@SequenceGenerator(name="det_id_seq", sequenceName = "det_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="det_cantidad")
	private Integer cantidad;
	
	@Column(name="det_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name="det_fact_id")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name="det_prod_id")
	private Producto producto;
	
	
	//SET y GET
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal ;
	}
	
	
}
