/**
 * 
 */
package com.indra.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.indra.Biblioteca.model.TipoLibro;
import com.indra.Biblioteca.repository.TipoLibroRepositorio;

/**
 * @author aocarballo
 *
 */
@Service
public class TipoLibroServiceImpl implements TipoLibroService{
	
		@Autowired
		private TipoLibroRepositorio tipoLibroRepository;

		@Override
		public List<TipoLibro> getAllTipoLibro() {
			return tipoLibroRepository.findAll();
		}

		@Override
		public void saveTipoLibro(TipoLibro tipoLibro) {
			this.tipoLibroRepository.save(tipoLibro);
		}

		@Override
		public TipoLibro getTipoLibroById(long id) {
			Optional<TipoLibro> optionalTipoLibro = tipoLibroRepository.findById(id);
			TipoLibro tipoLibro = null;
			if (optionalTipoLibro.isPresent()) {
				tipoLibro = optionalTipoLibro.get();
			} else {
				throw new RuntimeException("TipoLibro not found for id : " + id);
			}
			return tipoLibro;
		}

		@Override
		public void deleteTipoLibroById(long id) {
			this.tipoLibroRepository.deleteById(id);
		}

		@Override
		public Page<TipoLibro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
			Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();

			Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
			return this.tipoLibroRepository.findAll(pageable);
		}
}
