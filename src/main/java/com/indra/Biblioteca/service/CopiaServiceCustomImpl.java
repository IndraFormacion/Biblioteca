package com.indra.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.indra.Biblioteca.model.Copia;
import com.indra.Biblioteca.repository.CopiaRepositoryCustom;

@Service
public class CopiaServiceCustomImpl implements CopiaService{

	@Autowired
	private CopiaRepositoryCustom copiaRepository;

	@Override
	public List<Copia> getAllCopia() {
		return copiaRepository.findAll();
	}

	@Override
	public void saveCopia(Copia course) {
		this.copiaRepository.save(course);
	}

	@Override
	public Copia getCopiaById(long id) {
		Optional<Copia> optionalCourse = copiaRepository.findById(id);
		Copia course = null;
		if (optionalCourse.isPresent()) {
			course = optionalCourse.get();
		} else {
			throw new RuntimeException("Course not found for id : " + id);
		}
		return course;
	}

	@Override
	public void deleteCopiaById(long id) {
		this.copiaRepository.deleteById(id);
	}

	@Override
	public Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.copiaRepository.findAll(pageable);
	}
}
