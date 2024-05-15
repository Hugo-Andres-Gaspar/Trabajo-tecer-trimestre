package juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import util.Constantes;

public class PreguntasLetras extends Pregunta {

	Scanner teclado = new Scanner(System.in);
	Random aleatorio = new Random();
	private String palabraElegida;
	private String letrasOcultas;

	public PreguntasLetras() {

	}

	public PreguntasLetras(String enunciado) {
		super(enunciado);
	}

	public void generarPreguntaLetras() {
		mostrarPreguntaYOperacion();
		elegirPalabraAleatoria();
		ocultarLetras();
		mostrarPalabraOculta();
	}

	private void mostrarPreguntaYOperacion() {
		System.out.println("Pregunta: " + getEnunciado()); // Mostrar enunciado
	}

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

	private void mostrarPalabraOculta() {
		System.out.println("Palabra oculta: " + letrasOcultas);
	}

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

	public String getPalabraElegida() {
		return palabraElegida;
	}

	public String getPalabraOculta() {
		return letrasOcultas;
	}

	public String respuestaLetrasCpu() {
		return "zzzzzzzzzz";
	}

}
