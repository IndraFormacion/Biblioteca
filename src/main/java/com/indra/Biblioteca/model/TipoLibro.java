/**
 * 
 */
package com.indra.Biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author aocarballo
 *
 */
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
@Entity
@Table(name="tipoLibro")
public class TipoLibro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipoLibro")
	private String tipoLibro;

	/**
	 * 
	 */
	public TipoLibro() {
		super();
	}

	/**
	 * @param id
	 * @param tipoLibro
	 */
	public TipoLibro(Long id, String tipoLibro) {
		super();
		this.id = id;
		this.tipoLibro = tipoLibro;
	}

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
	 * @return the tipoLibro
	 */
	public String getTipoLibro() {
		return tipoLibro;
	}

	/**
	 * @param tipoLibro the tipoLibro to set
	 */
	public void setTipoLibro(String tipoLibro) {
		this.tipoLibro = tipoLibro;
	}
}
