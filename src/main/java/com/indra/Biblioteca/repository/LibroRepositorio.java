/**
 * 
 */
package com.indra.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.Biblioteca.model.Libro;

/**
 * @author aocarballo
 *
 */
public interface LibroRepositorio extends JpaRepository<Libro, Long>{

}
