package com.prueba.app.rest.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prueba.app.rest.entities.peliculaSalaCine;
import com.prueba.app.rest.repository.IPeliculaSalaCine;


public class PeliculaSalaCineServices {
	
	private IPeliculaSalaCine ipeliculaSalaCineServices;
	
	@Autowired
	public PeliculaSalaCineServices (IPeliculaSalaCine ipeliculaSalaCineServices) {
		this.ipeliculaSalaCineServices=ipeliculaSalaCineServices;
		
	}
	
	public List<peliculaSalaCine>findByPeliculaNombreAndSalaCineId(String nombrePelicula, Long idSalaCine){
		return ipeliculaSalaCineServices.findByPeliculaNombreAndSalaCineId(nombrePelicula, idSalaCine);
	}
	
	public List<peliculaSalaCine> buscarPeliculasPorFechaPublicacion(Date fechaPublicacion) {
	       return ipeliculaSalaCineServices.findByFechaPublicacion(fechaPublicacion);
	   }
	   

}
