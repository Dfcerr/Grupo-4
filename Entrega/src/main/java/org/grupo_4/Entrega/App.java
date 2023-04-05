package org.grupo_4.Entrega;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.grupo_4.Entrega.models.Equipo;
import org.grupo_4.Entrega.models.Participante;
import org.grupo_4.Entrega.models.Partido;
import org.grupo_4.Entrega.models.Ronda;


public class App {

	public static void main(String[] args) {
		
		
		//Parte a trabajar, RUTA DE LOS RESULTADOS
		String rutarelativa = "src\\main\\resources\\Pronóstico.csv";
		Path pathrelativo = Paths.get(rutarelativa);
		
		//acá lee las líneas
		try {
			for(String linea:Files.readAllLines(pathrelativo)) {
				System.out.println(linea);
				
			}

		}catch(IOException e) {
			e.printStackTrace();
			
		}


		Path ubi = pathrelativo.toAbsolutePath();
		
		
		
		//acá termina 
		Equipo equipos[] = lectorEquipos(ubi);
		Partido partidos[] = lectorPartidos(ubi);
		Ronda ronda = new Ronda(1, equipos, partidos);
		System.out.println("cargado correctamente");
		
		System.out.println("Ahora ingrese la ruta de los pronosticos:");
		Participante maria = new Participante (Paths.get(scn.nextLine()));
		
		System.out.println(ronda.ganador(maria));
		

	}
	
	public static Equipo[] lectorEquipos(Path ubicacion) {
		int A = 0;
		int F = 5;
		int contadorEspecial = 0;
		try {
			List<String> texto = Files.readAllLines(ubicacion);
			//calculamos el numero de equipos que hay y los depuramos
			String lista[] = new String[texto.size() * 2]; // maxima cantidad de equipos posible
			for(int fr = 1; fr < texto.size(); fr++) {
				String aux = texto.get(fr).split(";")[A];
				if(!Arrays.asList(lista).contains(aux)) {
					lista[contadorEspecial] = aux;
					contadorEspecial++;
				}				
			}
			for(int fr = 1; fr < texto.size(); fr++) {
				String aux = texto.get(fr).split(";")[F];
				if(!Arrays.asList(lista).contains(aux)) {
					lista[contadorEspecial] = aux;
					contadorEspecial++;
				}	
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
			
			int contadorSecundario = 0;
			for(int aux : listaInt) {
				for(int fr = 1; fr < texto.size(); fr++) {
					if(aux == Integer.parseInt(texto.get(fr).split(";")[A])) {
						equipos[contadorSecundario] = new Equipo(aux, texto.get(fr).split(";")[A+1]);
						fr = texto.size();
					}
					else if(aux == Integer.parseInt(texto.get(fr).split(";")[F])) {
						equipos[contadorSecundario] = new Equipo(aux, texto.get(fr).split(";")[F+1]);
						fr = texto.size();
					}
				}
				contadorSecundario++;
			}
			
			return equipos;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Partido[] lectorPartidos(Path ubicacion) {
		try {
			List<String> texto = Files.readAllLines(ubicacion);
			Partido partidos[] = new Partido[texto.size()];
			
			for(int fr = 1; fr < texto.size(); fr++) {
				partidos[fr - 1] = new Partido(Integer.parseInt(texto.get(fr).split(";")[0]), Integer.parseInt(texto.get(fr).split(";")[3]), Integer.parseInt(texto.get(fr).split(";")[4]), Integer.parseInt(texto.get(fr).split(";")[5]), fr);
			}
			return partidos;			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

