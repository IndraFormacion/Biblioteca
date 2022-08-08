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

import com.indra.Biblioteca.model.Libro;
import com.indra.Biblioteca.repository.LibroRepositorio;

/**
 * @author aocarballo
 *
 */
@Service
public class LibroServiceImpl implements LibroService{
	
		@Autowired
		private LibroRepositorio libroRepository;

		@Override
		public List<Libro> getAllLibros() {
			return libroRepository.findAll();
		}

		@Override
		public void saveLibro(Libro libro) {
			this.libroRepository.save(libro);
		}

		@Override
		public Libro getLibroById(long id) {
			Optional<Libro> optionalLibro = libroRepository.findById(id);
			Libro libro = null;
			if (optionalLibro.isPresent()) {
				libro = optionalLibro.get();
			} else {
				throw new RuntimeException("Libro not found for id : " + id);
			}
			return libro;
		}

		@Override
		public void deleteLibroById(long id) {
			this.libroRepository.deleteById(id);
		}

		@Override
		public Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
			Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();

			Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
			return this.libroRepository.findAll(pageable);
		}
}
