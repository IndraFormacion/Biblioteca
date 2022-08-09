package com.indra.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.indra.Biblioteca.model.Prestamo;
import com.indra.Biblioteca.repository.PrestamoRepositoryCustom;

@Service
public class PrestamoServiceImpl implements PrestamoService{

	@Autowired
	private PrestamoRepositoryCustom prestamoRepository;

	@Override
	public List<Prestamo> getAllPrestamo() {
		return prestamoRepository.findAll();
	}

	@Override
	public void savePrestamo(Prestamo course) {
		this.prestamoRepository.save(course);
	}

	@Override
	public Prestamo getPrestamoById(long id) {
		Optional<Prestamo> optionalCourse = prestamoRepository.findById(id);
		Prestamo course = null;
		if (optionalCourse.isPresent()) {
			course = optionalCourse.get();
		} else {
			throw new RuntimeException("Course not found for id : " + id);
		}
		return course;
	}

	@Override
	public void deletePrestamoById(long id) {
		this.prestamoRepository.deleteById(id);
	}

	@Override
	public Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.prestamoRepository.findAll(pageable);
	}
}