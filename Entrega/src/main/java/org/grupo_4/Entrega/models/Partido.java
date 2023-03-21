package org.grupo_4.Entrega.models;

public class Partido {
	private int equipoId[];
	private int goles[];
	private int id;
	
	public Partido(int equipoId1, int golId1, int golId2,int equipoId2, int id) {
		int equipo [] = {equipoId1, equipoId2};
		this.setEquipoId(equipo);
		int goles[] = {golId1, golId2};
		this.setGoles(goles);
		this.setId(id);
	}

	public int resultado() {
		if(goles[0] < goles[1])
			return equipoId[1];
		else if(goles[0] > goles[1])
			return equipoId[0];
		else
			return 0;//indica nadie gano
			
	}
	
	private void setEquipoId(int equipoId[]) {
		this.equipoId = equipoId;
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
