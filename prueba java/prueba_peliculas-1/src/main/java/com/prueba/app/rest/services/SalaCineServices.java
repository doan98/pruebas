package com.prueba.app.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.app.rest.repository.ISalaCine;

@Service
public class SalaCineServices {

	private ISalaCine isalaCine;
	
	@Autowired
	public SalaCineServices (ISalaCine isalaCine) {
		this.isalaCine=isalaCine;
	}
	
	
	public String obtenerEstadoSalaCinePorNombre(String nombre) {
	       int cantidadPeliculas = isalaCine.countByNombre(nombre);
	       if (cantidadPeliculas < 3) {
	           return "Sala casi Vacía";
	       } else if (cantidadPeliculas >= 3 && cantidadPeliculas <= 5) {
	           return "Sala casi Llena";
	       } else {
	           return "Sala Llena";
	       }
	   }
	

}
