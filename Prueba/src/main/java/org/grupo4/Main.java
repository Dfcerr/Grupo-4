package org.grupo4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//System.out.println(ResultadosEnum.ganador.getPuntos());
		Equipo equipos[] = lectorEquipos(Paths.get("C:\\__carpeta\\Argentina Programa\\Java\\Proyectos\\TP\\Prueba\\src\\main\\java\\Recursos\\csvprueba.csv"));
		
		System.out.println(equipos[1].getNombre());
		
		Equipo equi1 = new Equipo(1, "Argentina");
		Equipo equi2 = new Equipo(5, "Mexico");
		int goles[] = {1, 2};
		Partido prueba = new Partido(equi1, goles, equi2, 2);
		//System.out.println(prueba.resultado());

	}
	
	public static Equipo[] lectorEquipos(Path ubicacion) {
		int A = 0;
		int F = 5;
		try {
			List<String> texto = Files.readAllLines(ubicacion);
			//calculamos el numero de equipos que hay y los depuramos
			String lista[] = new String[texto.size() * 2]; // maxima cantidad de equipos posible
			for(int fr = 1; fr < texto.size(); fr++) {
				String aux = texto.get(fr).split(";")[A];
				if(!Arrays.asList(lista).contains(aux))
					lista[fr - 1] = aux;
				aux = texto.get(fr).split(";")[F];
				if(!Arrays.asList(lista).contains(aux))
					lista[fr - 1] = aux;
			}
			//limpia los null de la lista y los convierte en equipo
			int contador = 0;
			for (String aux : lista) {
				if(aux != null)
					contador++;
			}
			int listaInt[] = new int[contador];
			for(int aux = 0; aux < contador; aux++)
				listaInt[aux] = Integer.parseInt(lista[aux]);
			
			Equipo equipos[] = new Equipo[contador];
			for(int aux : listaInt) {
				for(int fr = 1; fr < texto.size(); fr++) {
					if(aux == Integer.parseInt(texto.get(fr).split(";")[A])) {
						equipos[fr - 1] = new Equipo(aux, texto.get(fr).split(";")[A+1]);
					}
					else if(aux == Integer.parseInt(texto.get(fr).split(";")[F])) {
						equipos[fr - 1] = new Equipo(aux, texto.get(fr).split(";")[F+1]);
					}
				}
			}
			
			return equipos;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
