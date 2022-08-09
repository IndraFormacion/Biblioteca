/**
 * 
 */
package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.Autor;

/**
 * @author aocarballo
 *
 */
public interface AutorService {
	 List<Autor> getAllAutor();
	    void saveAutor(Autor autor);
	    Autor getAutorById(long id);
	    void deleteAutorById(long id);
	    Page<Autor> findPaginated(int pageNum, int pageSize,
	                               String sortField,
	                               String sortDirection);
}
