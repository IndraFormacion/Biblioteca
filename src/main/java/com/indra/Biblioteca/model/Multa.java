package com.indra.Biblioteca.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="multa")
public class Multa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="fInicio")
	private Date fIncio;
	@Column(name="fFin")
	private Date fFin;
	
	public Multa() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Multa(long id, Date fIncio, Date fFin) {
		super();
		this.id = id;
		this.fIncio = fIncio;
		this.fFin = fFin;
	}

	public Date getfIncio() {
		return fIncio;
	}

	public void setfIncio(Date fIncio) {
		this.fIncio = fIncio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}
	
	

}
