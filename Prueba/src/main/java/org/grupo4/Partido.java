package org.grupo4;

public class Partido {
	private Equipo equipo[];
	private int goles[];
	private int id;
	
	public Partido(Equipo equipo1, int goles[],Equipo equipo2, int id) {
		Equipo equipo[] = {equipo1, equipo2}; 
		this.setEquipo(equipo);
		this.setGoles(goles);
		this.setId(id);
	}

	public int resultado() {
		if(goles[0] < goles[1])
			return equipo[1].getId();
		else if(goles[0] > goles[1])
			return equipo[0].getId();
		else
			return 0;//indica nadie gano
			
	}
	
	private void setEquipo(Equipo equipo[]) {
		this.equipo = equipo;
	}

	private void setGoles(int goles[]) {
		this.goles = goles;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	

}
