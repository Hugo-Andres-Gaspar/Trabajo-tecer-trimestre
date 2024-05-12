package registros;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import juego.Jugador;

public class Ranking {
	
	private List<Jugador> jugadores;
	private static String rutaFichero = "./Ficheros/Ranking.txt";

	public Ranking() {
		jugadores = new ArrayList<>();
	}

	static void crearFicheroRanking() {

		Path rutaFichero1 = Paths.get(rutaFichero);

		if (!Files.exists(rutaFichero1)) {
			System.out.println("No existe el fichero");
			try {
				Files.createFile(rutaFichero1);
				System.out.println("Fichero creado");

			} catch (IOException excepcion) {
				excepcion.printStackTrace();
			}

		}

	}
}
