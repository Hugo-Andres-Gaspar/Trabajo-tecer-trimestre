package registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import juego.Jugador;
import util.Constantes;

public class Ranking {

	private static ArrayList<Jugador> ranking = Jugador.obtenerJugadoresDeLaPartida();
	private static ArrayList<Jugador> listaRanking = new ArrayList<>();

	public static void mostarRanking() {
		for (Jugador jugadores : ranking) {
			if (!jugadores.getNombre().startsWith("CPU")) {
				listaRanking.add(jugadores);
			}
		}

		Collections.sort(listaRanking, Comparator.comparing(Jugador::getPuntuacion).reversed());

		for (Jugador ranking : listaRanking) {
			System.out.println(ranking);
		}
	}

	public static void comprobarRanking() throws IOException {
		Path rutaFichero = Paths.get(Constantes.RUTA_RANKING);
		if (!Files.exists(rutaFichero)) {
			System.out.println("No existe el fichero, procedo a crearlo....");
			Files.createFile(rutaFichero);
		}
	}

	public static void guardarRanking() {
		try (BufferedWriter bufer = new BufferedWriter(new FileWriter(Constantes.RUTA_RANKING, true))) {
			// Ordenar el ranking por puntuación en orden descendente
			Collections.sort(listaRanking, Comparator.comparing(Jugador::getPuntuacion).reversed());

			for (Jugador jug : listaRanking) {
				bufer.write(jug.getNombre() + " " + jug.getPuntuacion() + " ");
				bufer.newLine();
			}
			System.out.println("Partida registrada en el archivo: " + Constantes.RUTA_RANKING);

		} catch (IOException e) {
			throw new RuntimeException("Error al registrar la partida en el archivo | " + e);
		}
	}

}
