package com.prueba.app.rest.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prueba.app.rest.entities.pelicula;
import com.prueba.app.rest.entities.peliculaSalaCine;
import com.prueba.app.rest.repository.IPelicula;
import com.prueba.app.rest.repository.IPeliculaSalaCine;
import com.prueba.app.rest.repository.ISalaCine;

@Service
public class PeliculaServices {
	
	private IPelicula ipelicula;
	private IPeliculaSalaCine ipeliculaSalaCine;
	private ISalaCine iSalaCine;
	
	@Autowired
	public PeliculaServices(@Qualifier("IPelicula") IPelicula ipelicula,
                            @Qualifier("IPeliculaSalaCine") IPeliculaSalaCine ipeliculaSalaCine,
                            @Qualifier("ISalaCine") ISalaCine iSalaCine) {
		this.ipelicula=ipelicula;
		this.ipeliculaSalaCine=ipeliculaSalaCine;
		this.iSalaCine=iSalaCine;
	}

	
	
	
	public List<pelicula>obtenerTodasLasPeliculas(){
		return ipelicula.findAll();
		
	}
	
	public pelicula guardarPelicula(pelicula pelicula) {
	       return ipelicula.save(pelicula);
	       
	 }
	
	public pelicula actulizarPelicula(Long id , pelicula pelicula) {
	  Optional<pelicula> peliculaExistente = ipelicula.findById(id);
	  if(peliculaExistente != null) {
		 pelicula peliculaActualizada = peliculaExistente.get();
		 peliculaActualizada.setNombre(pelicula.getNombre());
		 peliculaActualizada.setDuracion(pelicula.getDuracion());
		 peliculaActualizada.setEstado(pelicula.getEstado());
		 return ipelicula.save(peliculaActualizada);
	  }else {
		 
	   throw new RuntimeException("No se encontró la película con el ID especificado: " + id);

	  }
	}
	
	public void eliminarPelicula(Long id) {
		ipelicula.deleteById(id);
	}
	
	
	 public List<peliculaSalaCine> buscarPeliculaPorNombreYSala(String nombrePelicula, Long idSalaCine) {
	       return ipeliculaSalaCine.findByPeliculaNombreAndSalaCineId(nombrePelicula, idSalaCine);
	   }
	 
	 public List<peliculaSalaCine> buscarPeliculasPorFechaPublicacion(Date fechaPublicacion) {
	       return ipeliculaSalaCine.findByFechaPublicacion(fechaPublicacion);
	   }
	 
	 
	 public String obtenerEstadoSalaCinePorNombre(String nombre) {
	       int cantidadPeliculas = iSalaCine.countByNombre(nombre);
	       if (cantidadPeliculas < 3) {
	           return "Sala casi Vacía";
	       } else if (cantidadPeliculas >= 3 && cantidadPeliculas <= 5) {
	           return "Sala casi Llena";
	       } else {
	           return "Sala Llena";
	       }
	   }
	
	 
	   
	

	
	
	
	

}
