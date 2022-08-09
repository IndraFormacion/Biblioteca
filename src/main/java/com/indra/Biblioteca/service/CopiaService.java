package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.Copia;

public interface CopiaService {
    List<Copia> getAllCopia();
    void saveCopia(Copia copy);
    Copia getCopiaById(long id);
    void deleteCopiaById(long id);
    Page<Copia> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}
