package com.indra.Biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="lector")
public class Lector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nSocio;
	@Column(name="nombre")
	private String nombre;
	@Column(name="telefono")
	private String telefono;
	@Column(name="direccion")
	private String direccion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_multa")
	private Multa multa;
	
	public Lector() {

	}

	public Lector(long nSocio, String nombre, String telefono, String direccion, Multa multa) {
		super();
		this.nSocio = nSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.multa = multa;
	}

	
	public long getnSocio() {
		return nSocio;
	}

	public void setnSocio(long nSocio) {
		this.nSocio = nSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}
	
	

}
