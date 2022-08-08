/**
 * 
 */
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

/**
 * @author aocarballo
 *
 */
// @NoArgsConstructor
// @AllArgsConstructor
// @Data
@Entity
@Table(name="libro")
public class Libro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tipoLibro")
	private TipoLibro tipoLibro;
	
	@Column(name="editorial")
	private String editorial;
	
	@Column(name="anyo")
	private int anyo;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the tipoLibro
	 */
	public TipoLibro getTipoLibro() {
		return tipoLibro;
	}

	/**
	 * @param tipoLibro the tipoLibro to set
	 */
	public void setTipoLibro(TipoLibro tipoLibro) {
		this.tipoLibro = tipoLibro;
	}

	/**
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the anyo
	 */
	public int getAnyo() {
		return anyo;
	}

	/**
	 * @param anyo the anyo to set
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	/**
	 * @param id
	 * @param titulo
	 * @param tipoLibro
	 * @param editorial
	 * @param anyo
	 */
	public Libro(Long id, String titulo, TipoLibro tipoLibro, String editorial, int anyo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tipoLibro = tipoLibro;
		this.editorial = editorial;
		this.anyo = anyo;
	}

	/**
	 * 
	 */
	public Libro() {
		super();
	}
	
}
