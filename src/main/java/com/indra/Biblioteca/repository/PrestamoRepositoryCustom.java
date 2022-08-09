package com.indra.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.Biblioteca.model.Prestamo;

public interface PrestamoRepositoryCustom extends JpaRepository<Prestamo, Long> {

}
