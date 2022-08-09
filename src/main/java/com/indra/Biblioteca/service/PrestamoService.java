package com.indra.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.indra.Biblioteca.model.Prestamo;

public interface PrestamoService {
    List<Prestamo> getAllPrestamo();
    void savePrestamo(Prestamo copy);
    Prestamo getPrestamoById(long id);
    void deletePrestamoById(long id);
    Page<Prestamo> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}
