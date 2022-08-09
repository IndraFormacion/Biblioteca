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

import com.indra.Biblioteca.model.Autor;
import com.indra.Biblioteca.repository.AutorRepositorio;

/**
 * @author aocarballo
 *
 */
@Service
public class AutorServiceImpl implements AutorService{
	
		@Autowired
		private AutorRepositorio autorRepository;

		@Override
		public List<Autor> getAllAutor() {
			return autorRepository.findAll();
		}

		@Override
		public void saveAutor(Autor autor) {
			this.autorRepository.save(autor);
		}

		@Override
		public Autor getAutorById(long id) {
			Optional<Autor> optionalAutor = autorRepository.findById(id);
			Autor autor = null;
			if (optionalAutor.isPresent()) {
				autor = optionalAutor.get();
			} else {
				throw new RuntimeException("Autor not found for id : " + id);
			}
			return autor;
		}

		@Override
		public void deleteAutorById(long id) {
			this.autorRepository.deleteById(id);
		}

		@Override
		public Page<Autor> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
			Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();

			Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
			return this.autorRepository.findAll(pageable);
		}
}
