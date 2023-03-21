package org.grupo_4.Entrega.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Pronostico {
	private int partido;
	private int ganador;
// se cambiara para la siguiente entrega
	public Pronostico(int partido, Path ubicacion){
		try {
			List<String> texto = Files.readAllLines(ubicacion);
			
			if(texto.get(partido).split(";")[1].contains("X"))
				this.setGanador(Integer.parseInt(texto.get(partido).split(";")[0]));
			else if(texto.get(partido).split(";")[3].contains("X"))
				this.setGanador(Integer.parseInt(texto.get(partido).split(";")[4]));
			else
				this.setGanador(0);
			this.setPartido(partido);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPartido() {
		return partido;
	}
	private void setPartido(int ronda) {
		this.partido = ronda;
	}
	public int getGanador() {
		return ganador;
	}
	private void setGanador(int ganador) {
		this.ganador = ganador;
	}
	
	
}
