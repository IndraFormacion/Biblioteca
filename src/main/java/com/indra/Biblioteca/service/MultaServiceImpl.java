package com.indra.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.indra.Biblioteca.model.Multa;
import com.indra.Biblioteca.repository.MultaRepository;

@Service
public class MultaServiceImpl implements MultaService {

	@Autowired
	private MultaRepository multaRepository;

	@Override
	public List<Multa> getAllMultas() {
		return multaRepository.findAll();

	}

	@Override
	public void saveMulta(Multa multa) {
		this.multaRepository.save(multa);

	}

	@Override
	public Multa getMultaById(long id) {
		Optional<Multa> optionalMulta = multaRepository.findById(id);
		Multa multa = null;
		if (optionalMulta.isPresent()) {
			multa = optionalMulta.get();
		} else {
			throw new RuntimeException("Multa not found for id : " + id);
		}
		return multa;
	}

	@Override
	public void deleteMultaById(long id) {
		this.multaRepository.deleteById(id);
	}

	@Override
	public Page<Multa> findPaginatedMulta(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.multaRepository.findAll(pageable);
	}

}
