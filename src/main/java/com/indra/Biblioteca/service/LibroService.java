/**
 * 
 */
package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.Libro;

/**
 * @author aocarballo
 *
 */
public interface LibroService {
	 List<Libro> getAllLibros();
	    void saveLibro(Libro libro);
	    Libro getLibroById(long id);
	    void deleteLibroById(long id);
	    Page<Libro> findPaginated(int pageNum, int pageSize,
	                               String sortField,
	                               String sortDirection);
}
