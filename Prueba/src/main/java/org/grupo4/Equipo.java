package org.grupo4;

public class Equipo {
	private int id;
	private String nombre;
	private String descripcion;
	
	public Equipo(int id, String nombre) {
		this.setNombre(nombre);
		this.setId(id);
		this.setDescripcion("clasificado");
	}
	
	public Equipo(int id, String nombre, String descripcion) {
		this.setNombre(nombre);
		this.setId(id);
		this.setDescripcion(descripcion);
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
