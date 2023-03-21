package org.grupo_4.Entrega.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Participante {
	private String nombre;
	private int numero;
	private Pronostico pronosticos[];
	
	public Participante(Path ubicacion) {
		this.setNombre("Maria");
		this.setNumero(1);
		this.setPronosticos(ubicacion);
	}

	private void setPronosticos(Path ubicacion) {
		try {
			List<String> texto = Files.readAllLines(ubicacion);
			Pronostico pronostics[] = new Pronostico[texto.size() - 1];
			for(int fr = 1; fr < texto.size(); fr++) {
				pronostics[fr - 1] =  new Pronostico(fr, ubicacion);
			}
			this.pronosticos = pronostics;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Pronostico[] getPronostico(){
		return this.pronosticos;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
