package com.prueba.app.rest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.app.rest.entities.peliculaSalaCine;


@Repository
public interface IPeliculaSalaCine extends JpaRepository<peliculaSalaCine, Long> {
	
	 List<peliculaSalaCine> findByPeliculaNombreAndSalaCineId(String nombrePelicula, Long idSalaCine);
	 List<peliculaSalaCine> findByFechaPublicacion(Date fechaPublicacion);
	 
	 
	 
}


