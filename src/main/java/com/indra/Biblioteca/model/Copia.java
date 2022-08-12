package com.indra.Biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Copia")
public class Copia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private EstadoCopia estadoCopia;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_libro")
    private Libro libro;
	
	public Copia() {
		super();
	}
	public Copia(Long id, EstadoCopia estadoCopia, Libro libro) {
		super();
		this.id = id;
		this.estadoCopia = estadoCopia;
		this.libro = libro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EstadoCopia getEstadoCopia() {
		return estadoCopia;
	}
	public void setEstadoCopia(EstadoCopia estadoCopia) {
		this.estadoCopia = estadoCopia;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
}
