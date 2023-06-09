package com.prueba.app.rest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "sala_cine")
public class salaCine {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nombre;
 private char estado;
 
 public salaCine() {
	// TODO Auto-generated constructor stub
}

public salaCine(Long id, String nombre, char estado) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.estado = estado;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public char getEstado() {
	return estado;
}

public void setEstado(char estado) {
	this.estado = estado;
}


 
 

	

}
