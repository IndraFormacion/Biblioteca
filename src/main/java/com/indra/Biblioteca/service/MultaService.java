package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.Multa;

public interface MultaService {

	List<Multa> getAllMultas();

	void saveMulta(Multa multa);

	Multa getMultaById(long id);

	void deleteMultaById(long id);

	Page<Multa> findPaginatedMulta(int pageNum, int pageSize, String sortField, String sortDirection);

}
