package com.prueba.app.rest.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(schema = "pelicula_sala_cine")
public class peliculaSalaCine {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)		
 private Long id;

 private Date fechaPublicacion;

 private Date fechaFin;
 
 @OneToOne
 @JoinColumn(name = "id_pelicula")
 private pelicula pelicula;
 
 @ManyToOne
 @JoinColumn(name = "id_sala_cine")
 private salaCine salaCine;

 private char estado;
 
 public peliculaSalaCine() {
	// TODO Auto-generated constructor stub
}

public peliculaSalaCine(Long id, Date fechaPublicacion, Date fechaFin, com.prueba.app.rest.entities.pelicula pelicula,
		com.prueba.app.rest.entities.salaCine salaCine, char estado) {
	super();
	this.id = id;
	this.fechaPublicacion = fechaPublicacion;
	this.fechaFin = fechaFin;
	this.pelicula = pelicula;
	this.salaCine = salaCine;
	this.estado = estado;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getFechaPublicacion() {
	return fechaPublicacion;
}

public void setFechaPublicacion(Date fechaPublicacion) {
	this.fechaPublicacion = fechaPublicacion;
}

public Date getFechaFin() {
	return fechaFin;
}

public void setFechaFin(Date fechaFin) {
	this.fechaFin = fechaFin;
}

public pelicula getPelicula() {
	return pelicula;
}

public void setPelicula(pelicula pelicula) {
	this.pelicula = pelicula;
}

public salaCine getSalaCine() {
	return salaCine;
}

public void setSalaCine(salaCine salaCine) {
	this.salaCine = salaCine;
}

public char getEstado() {
	return estado;
}

public void setEstado(char estado) {
	this.estado = estado;
}


 
 

}
