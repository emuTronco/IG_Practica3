package com.example.practica3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase modelo para la tabla del ejercicio 2
 *
 */
public class Producto {

	private final IntegerProperty id;	
	private final StringProperty descripcion;
	
	/**
	 * Constructor por defecto
	 */
	public Producto() {
		this(null, null);
	}

	/**
	 * Constructor con par�metros
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Producto(Integer id, String descripcion) {
		this.id = new SimpleIntegerProperty(id);
		this.descripcion = new SimpleStringProperty(descripcion);
	}

	public Integer getId() {
		return id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public String getDescripcion() {
		return descripcion.get();
	}

	public void setDescripcion(String descripcion) {
		this.descripcion.set(descripcion);
	}

	public StringProperty descripcionProperty() {
		return descripcion;
	}
}