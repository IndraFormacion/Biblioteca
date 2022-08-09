package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.EstadoCopia;

public interface EstadoCopiaService {
    List<EstadoCopia> getAllCopia();
    void saveCopia(EstadoCopia copy);
    EstadoCopia getCopiaById(long id);
    void deleteCopiaById(long id);
    Page<EstadoCopia> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}
