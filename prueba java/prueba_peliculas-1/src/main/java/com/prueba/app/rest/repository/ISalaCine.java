package com.prueba.app.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.app.rest.entities.salaCine;

@Repository
public interface ISalaCine extends JpaRepository<salaCine, Long> {
	
	int countByNombre(String nombre);

}
