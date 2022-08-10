/**
 * 
 */
package com.indra.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.Biblioteca.model.TipoLibro;

/**
 * @author aocarballo
 *
 */
public interface TipoLibroRepositorio extends JpaRepository<TipoLibro, Long>{

}
