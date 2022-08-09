package com.indra.Biblioteca.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Date courseName;

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

	public Date getCourseName() {
		return courseName;
	}

	public void setCourseName(Date courseName) {
		this.courseName = courseName;
	}

	public Prestamo(Long id, Date inicio, Date courseName) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.courseName = courseName;
	}
	public Prestamo() {
		super();
	}
	
}