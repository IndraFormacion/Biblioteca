package com.indra.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.Biblioteca.model.EstadoCopia;

public interface EstadoCopiaRepositoryCustom extends JpaRepository<EstadoCopia, Long> {
	
}
