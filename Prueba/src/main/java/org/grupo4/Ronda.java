package org.grupo4;

public class Ronda {
	private Partido partidos[];
	private Equipo equipos[];
	private int numero;
	
	
	public Ronda(int numero, Equipo equipos[], Partido partidos[]){
		this.setEquipos(equipos);
		this.setPartidos(partidos);
		this.setNumero(numero);
	}
	
	public String ganador(Participante participante) {
		int puntuacion = 0, contador = 0;;
		for(Pronostico comparador : participante.getPronostico()) {
			if(comparador.getGanador() == partidos[contador].resultado())
				puntuacion++;
			contador++;
		}
		
		return "El participante " + participante.getNombre() + "hizo un total de " + puntuacion ; 
		
	}
	
	
	
	public Equipo[] getEquipos() {
		return equipos;
	}
	private void setEquipos(Equipo equipos[]) {
		this.equipos = equipos;
	}
	public Partido[] getPartidos() {
		return partidos;
	}
	private void setPartidos(Partido partidos[]) {
		this.partidos = partidos;
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
