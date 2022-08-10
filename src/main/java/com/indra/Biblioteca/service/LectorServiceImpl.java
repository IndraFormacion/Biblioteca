package com.indra.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.indra.Biblioteca.model.Lector;
import com.indra.Biblioteca.repository.LectorRepository;
@Service
public class LectorServiceImpl implements LectorService {
	@Autowired
	private LectorRepository lectorRepository;

	@Override
	public List<Lector> getAllLectores() {
		return lectorRepository.findAll();
	}

	@Override
	public void saveLector(Lector lector) {
		this.lectorRepository.save(lector);

	}

	@Override
	public Lector getLectorById(long id) {
		Optional<Lector> optionalLector = lectorRepository.findById(id);
		Lector lector = null;
		if (optionalLector.isPresent()) {
			lector = optionalLector.get();
		} else {
			throw new RuntimeException("Lector not found for id : " + id);
		}		
		return lector;
	}

	@Override
	public void deleteLectorById(long id) {
		this.lectorRepository.deleteById(id);
	}

	@Override
	public Page<Lector> findPaginatedLector(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.lectorRepository.findAll(pageable);
	}
	
	

}
