/**
 * 
 */
package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.TipoLibro;

/**
 * @author aocarballo
 *
 */
public interface TipoLibroService {
	 List<TipoLibro> getAllTipoLibro();
	    void saveTipoLibro(TipoLibro tipoLibro);
	    TipoLibro getTipoLibroById(long id);
	    void deleteTipoLibroById(long id);
	    Page<TipoLibro> findPaginated(int pageNum, int pageSize,
	                               String sortField,
	                               String sortDirection);
}
