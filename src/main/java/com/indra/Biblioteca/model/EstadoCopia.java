package com.indra.Biblioteca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estadoCopia")
public class EstadoCopia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="estado")
	private String copyStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCopyStatus() {
		return copyStatus;
	}

	public void setCopyStatus(String copyStatus) {
		this.copyStatus = copyStatus;
	}

	public EstadoCopia(String copyStatus) {
		super();
		this.copyStatus = copyStatus;
	}
	public EstadoCopia() {
		super();
	}
	
}