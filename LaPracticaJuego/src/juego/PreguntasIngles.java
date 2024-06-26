package juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import util.Constantes;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class PreguntasIngles extends Pregunta {

	private static Random aleatorio = new Random();
	String respuestaCorrecta;

	/**
	 * Crea una nueva instancia de {@code PreguntasIngles}.
	 */
	public PreguntasIngles() {

	}

	/**
	 * Crea una nueva instancia de {@code PreguntasIngles} con el enunciado, el
	 * generador aleatorio y la respuesta correcta especificados.
	 * 
	 * @param enunciado         El enunciado de la pregunta de inglés.
	 * @param aleatorio         El generador aleatorio a utilizar.
	 * @param respuestaCorrecta La respuesta correcta de la pregunta de inglés.
	 */
	public PreguntasIngles(String enunciado, Random aleatorio, String respuestaCorrecta) {
		super(enunciado);
		PreguntasIngles.aleatorio = aleatorio;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	/**
	 * Genera una pregunta de inglés y muestra las opciones de respuesta.
	 */
	public void generarPreguntaIngles() {
		mostrarPregunta();
	}

	/**
	 * Muestra la pregunta de inglés y las opciones de respuesta por consola.
	 */
	public void mostrarPregunta() {
		try {
			Path rutaFicheroIngles = Paths.get(Constantes.RUTA_FICHERO_PREGUNTAS_INGLLES);
			List<String> preguntas = Files.readAllLines(rutaFicheroIngles);
			int lineas = aleatorio.nextInt(preguntas.size() / 5);

			enunciado = preguntas.get(lineas * 5);
			respuestaCorrecta = preguntas.get(lineas * 5 + 1);
			List<String> opciones = new ArrayList<>();
			opciones.addAll(preguntas.subList(lineas * 5 + 2, (lineas + 1) * 5));
			opciones.add(respuestaCorrecta);

			Collections.shuffle(opciones);

			System.out.println(enunciado);
			char letraOpcion = 'A';
			for (String opcion : opciones) {
				if (respuestaCorrecta == opcion) {
					respuestaCorrecta = ": " + respuestaCorrecta;
				}
				System.out.println(letraOpcion + ": " + opcion);
				letraOpcion++;
			}
		} catch (IOException excepcion) {
			System.out.println("Error al cargar el diccionario: " + excepcion.getMessage());
		}
	}

	/**
	 * Verifica si la respuesta proporcionada por el usuario es correcta.
	 * 
	 * @param opcionSeleccionada La opción de respuesta seleccionada por el usuario.
	 * @return {@code true} si la respuesta es correcta, {@code false} si es
	 *         incorrecta.
	 */
	public boolean verificarRespuesta(char opcionSeleccionada) {
		opcionSeleccionada = Character.toUpperCase(opcionSeleccionada);
		char letraCorrecta = Character.toUpperCase(respuestaCorrecta.charAt(0));
		if (opcionSeleccionada == letraCorrecta) {
			System.out.println("La opción es correcta");
			return true;
		} else {
			System.out.println("La opción es incorrecta, la opcion correcta es : " + letraCorrecta);
			return false;
		}
	}

	/**
	 * Genera una respuesta ficticia para la CPU.
	 * 
	 * @return La opción de respuesta generada aleatoriamente para la CPU.
	 */
	public char comprobarRespuestaCPU() {
		int numaleAtorio = aleatorio.nextInt();
		char respuesta = 0;
		if (numaleAtorio == 1) {
			respuesta = 'A';
		} else if (numaleAtorio == 2) {
			respuesta = 'B';
		} else {
			respuesta = 'C';
		}
		return respuesta;
	}

}
