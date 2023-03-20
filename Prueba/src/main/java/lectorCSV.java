

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class lectorCSV {
	public static void main(String[] args) {
		//String archivo[][] = lectorLista(Paths.get("Recursos/csvprueba.csv"));
		
		
		CSV arch = new CSV(Paths.get("Recursos/csvprueba.csv"));
		
		System.out.println(arch.espacio(1, 1));
		
		/*for(String aux : arch.leerFila(4))
			System.out.println(aux);*/
		/*for(String aux : arch.leerColumna(1))
			System.out.println(aux);*/
		
		//System.out.println(archivo[2][3]);
		
	}
	public static String[][] lectorLista(Path directorio) {
		try {
			List<String> texto = Files.readAllLines(directorio);

			int ancho = 0;
			int largo = texto.size();
			for(int fr = 0; fr < largo; fr++) {
				if(ancho < texto.get(fr).split(";").length) {
					ancho = texto.get(fr).split(";").length;
				}
			}
			String csv[][] = new String[ancho][largo];
			for(int fr = 0; fr < largo; fr++) {
				for(int fr2 = 0; fr2 < texto.get(fr).split(";").length; fr2++) {
					csv[fr2][fr] = texto.get(fr).split(";")[fr2];
				}
			}			
			return csv;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
