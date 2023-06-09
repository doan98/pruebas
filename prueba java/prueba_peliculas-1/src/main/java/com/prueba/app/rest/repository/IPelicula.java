package com.prueba.app.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.app.rest.entities.pelicula;
import com.prueba.app.rest.entities.peliculaSalaCine;

@Repository
public interface IPelicula extends JpaRepository<pelicula, Long>{
	
	
	

}
