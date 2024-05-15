package juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import util.Constantes;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class PreguntasLetras extends Pregunta {

	Scanner teclado = new Scanner(System.in);
	Random aleatorio = new Random();
	private String palabraElegida;
	private String letrasOcultas;

	/**
	 * Crea una nueva instancia de {@code PreguntasLetras} con enunciado vacío.
	 */
	public PreguntasLetras() {

	}

	/**
	 * Crea una nueva instancia de {@code PreguntasLetras} con el enunciado
	 * especificado.
	 * 
	 * @param enunciado El enunciado de la pregunta de letras.
	 */
	public PreguntasLetras(String enunciado) {
		super(enunciado);
	}

	/**
	 * Genera una pregunta de letras. Elige una palabra aleatoria del diccionario y
	 * oculta algunas letras. Muestra la palabra oculta por consola.
	 */
	public void generarPreguntaLetras() {
		mostrarPreguntaYOperacion();
		elegirPalabraAleatoria();
		ocultarLetras();
		mostrarPalabraOculta();
	}

	/**
	 * Muestra la pregunta de letras por consola.
	 */
	private void mostrarPreguntaYOperacion() {
		System.out.println("Pregunta: " + getEnunciado()); // Mostrar enunciado
	}

	/**
	 * Elige una palabra aleatoria del diccionario de palabras. Si ocurre algún
	 * error al cargar el diccionario, se imprime un mensaje de error.
	 */
	private void elegirPalabraAleatoria() {
		try {
			Path rutaFicheroDiccionario = Paths.get(Constantes.RUTA_FICHERO_PREGUNTAS_LETRAS);
			List<String> palabras = Files.readAllLines(rutaFicheroDiccionario);
			if (!palabras.isEmpty()) {
				palabraElegida = palabras.get(aleatorio.nextInt(palabras.size()));
			} else {
				System.out.println("El diccionario está vacío.");
			}
		} catch (IOException excepcion) {
			System.out.println("Error al cargar el diccionario: " + excepcion.getMessage());
		}
	}

	/**
	 * Oculta algunas letras de la palabra elegida. La cantidad de letras ocultas es
	 * aproximadamente un tercio de la longitud total de la palabra.
	 */
	private void ocultarLetras() {
		StringBuilder letraOculta = new StringBuilder();
		int cantidadLetras = palabraElegida.length();
		int cantidadLetrasOcultas = (cantidadLetras >= 3) ? cantidadLetras / 3 : 0;

		for (int contador = 0; contador < cantidadLetras; contador++) {
			if (cantidadLetrasOcultas > 0 && (contador + 1) % 3 == 0) {
				letraOculta.append('_');
				cantidadLetrasOcultas--;
			} else {
				letraOculta.append(palabraElegida.charAt(contador));
			}
		}

		letrasOcultas = letraOculta.toString();
	}

	/**
	 * Muestra la palabra oculta por consola.
	 */
	private void mostrarPalabraOculta() {
		System.out.println("Palabra oculta: " + letrasOcultas);
	}

	/**
	 * Comprueba si la palabra proporcionada por el usuario es correcta.
	 * 
	 * @param palabra La palabra proporcionada por el usuario.
	 * @return {@code true} si la palabra es correcta, {@code false} si es
	 *         incorrecta.
	 */
	public boolean comprobarPalabra(String palabra) {
		if (palabra.equalsIgnoreCase(palabraElegida)) {
			System.out.println("Enhorabuena esa es la palabra correcta");
			return true;
		} else {
			System.out.println("La palabra es incorrecta");
			System.out.println("La palabra correcta es: " + palabraElegida);
			return false;
		}
	}

	/**
	 * Devuelve la palabra elegida aleatoriamente del diccionario.
	 * 
	 * @return La palabra elegida.
	 */
	public String getPalabraElegida() {
		return palabraElegida;
	}

	/**
	 * Devuelve la versión oculta de la palabra elegida.
	 * 
	 * @return La palabra oculta.
	 */
	public String getPalabraOculta() {
		return letrasOcultas;
	}

	/**
	 * Genera una respuesta ficticia para la CPU.
	 * 
	 * @return Una cadena ficticia que representa la respuesta de la CPU.
	 */
	public String respuestaLetrasCpu() {
		return "zzzzzzzzzz";
	}

}
