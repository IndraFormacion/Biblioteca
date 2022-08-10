package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.Lector;

public interface LectorService {
	List<Lector> getAllLectores();
	
	void saveLector(Lector lector);
	
	Lector getLectorById(long id);
	
	void deleteLectorById(long id);
	
	Page<Lector> findPaginatedLector(int pageNum, int pageSize, String sortField, String sortDirection);	
	
}
