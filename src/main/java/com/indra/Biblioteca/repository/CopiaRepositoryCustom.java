package com.indra.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.Biblioteca.model.Copia;

public interface CopiaRepositoryCustom extends JpaRepository<Copia, Long> {
	
}
