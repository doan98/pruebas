package com.prueba.app.rest.controllers;


import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.app.rest.entities.pelicula;
import com.prueba.app.rest.entities.peliculaSalaCine;
import com.prueba.app.rest.services.PeliculaSalaCineServices;
import com.prueba.app.rest.services.PeliculaServices;




@RestController
@RequestMapping("/api/peliculas")
public class crudController {
	
	
	private PeliculaServices peliculaServices;
	
	
	
	
	@Autowired
	public crudController(PeliculaServices peliculaServices) {
		this.peliculaServices=peliculaServices;
		
	}
	
	
	
	@GetMapping
	public List<pelicula>obtenerTodasLasPeliculas(){
		return peliculaServices.obtenerTodasLasPeliculas();
		
	}
	
	@PostMapping
	public pelicula guardarPelicula(@RequestBody pelicula pelicula) {
		return peliculaServices.guardarPelicula(pelicula);
	}
	
	@PutMapping("/{id}")
	public pelicula actulizarPelicula(@PathVariable Long id, @RequestBody pelicula pelicula) {
		return peliculaServices.actulizarPelicula(id, pelicula);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarPelicula(@PathVariable Long id) {
	    peliculaServices.eliminarPelicula(id);
	    return ResponseEntity.ok("Película eliminada correctamente");
	}
	
	@GetMapping("/buscar")
	public List<peliculaSalaCine> buscarPeliculaPorNombreYSala(@RequestParam String nombrePelicula, @RequestParam Long idSalaCine) {
	    return peliculaServices.buscarPeliculaPorNombreYSala(nombrePelicula, idSalaCine);
	}
	
	@GetMapping("/publicacion")
	public List<peliculaSalaCine> buscarPeliculasPorFechaPublicacion(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaPublicacion) {
	    return peliculaServices.buscarPeliculasPorFechaPublicacion(fechaPublicacion);
	}
	
	@GetMapping("/estado-sala")
	public String obtenerEstadoSalaCinePorNombre(@RequestParam String nombreSala) {
	    return peliculaServices.obtenerEstadoSalaCinePorNombre(nombreSala);
	}




	
	
}
