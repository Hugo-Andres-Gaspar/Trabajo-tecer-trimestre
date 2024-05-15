package registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import juego.Jugador;
import util.Constantes;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class Historico {
	private static ArrayList<Jugador> listaJugadores = Jugador.obtenerJugadoresDeLaPartida();

	/**
	 * Comprueba la existencia del archivo histórico y lo crea si no existe.
	 * 
	 * @throws IOException si ocurre un error al crear el archivo histórico
	 */
	public static void comprobarHistorico() throws IOException {
		Path rutaFichero = Paths.get(Constantes.RUTA_HISTORICO);
		if (!Files.exists(rutaFichero)) {
			System.out.println("El archivo histórico no existe, se procederá a crearlo.");
			try {
				Files.createFile(rutaFichero);
			} catch (IOException e) {
				System.err.println("Error al crear el archivo histórico: " + e.getMessage());
				throw e;
			}
		}
	}

	/**
	 * Guarda los datos de la partida en el archivo histórico.
	 */
	public static void guardarPartida() {
		try (BufferedWriter bufer = new BufferedWriter(new FileWriter(Constantes.RUTA_HISTORICO, true))) {
			for (Jugador jugador : listaJugadores) {
				bufer.write(jugador.getNombre() + " " + jugador.getPuntuacion() + " ");
			}
			System.out.println("Partida registrada en el archivo: " + Constantes.RUTA_HISTORICO);
			bufer.newLine();
		} catch (IOException e) {
			System.err.println("Error al registrar la partida en el archivo: " + e.getMessage());
			throw new RuntimeException("Error al registrar la partida en el archivo.", e);
		}
	}

	/**
     * Muestra el histórico de la partida por consola.
     */
	public static void mostrarHistorico() {
		if (listaJugadores.isEmpty()) {
			System.out.println("No hay jugadores en el histórico.");
		} else {
			System.out.println("Mostrando Histórico de la partida...");
			for (Jugador jugador : listaJugadores) {
				System.out.println(jugador.toString());
			}
		}
	}
}
