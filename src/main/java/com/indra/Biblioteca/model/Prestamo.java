package com.indra.Biblioteca.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Prestamo")
public class Prestamo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="inicio")
	private Date inicio;
	
	@Column(name="fin")
	private Date fin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_lector")
	private Lector lector;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_copia")
	private Copia copia;

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Prestamo(Long id, Date inicio, Date fin, Lector lector, Copia copia) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.lector = lector;
		this.copia = copia;
	}
	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}

	public Prestamo() {
		super();
	}
	
}