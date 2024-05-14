package juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import util.Constantes;

public class PreguntasIngles extends Pregunta {

	private Scanner teclado = new Scanner(System.in);
	private static Random aleatorio = new Random();
	String respuestaCorrecta;

	public PreguntasIngles(String enunciado, Random aleatorio, String respuestaCorrecta) {
		super(enunciado);
		this.aleatorio = aleatorio;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public void generarPreguntaIngles() {
		mostrarPregunta();
	}

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
//		try {
//            Path rutaFicheroIngles = Paths.get(Constantes.RUTA_FICHERO_PREGUNTAS_INGLLES);
//            List<String> preguntas = Files.readAllLines(rutaFicheroIngles);
//            int lineas = aleatorio.nextInt(preguntas.size() / 5);
//            
//            enunciado = preguntas.get(lineas * 5);
//            respuestaCorrecta = preguntas.get(lineas * 5 + 1);
//            List<String> opciones = new ArrayList<>();
//            opciones.addAll(preguntas.subList(lineas * 5 + 2, (lineas + 1) * 5));
//            opciones.add(respuestaCorrecta);
//            
//            Collections.shuffle(opciones);
//            
//            System.out.println(enunciado);
//            char letra = 'A';
//            for (String opcion : opciones) {
//            	if (respuestaCorrecta == opcion) {
//					respuestaCorrecta = letra + respuestaCorrecta;
//				}
//                System.out.println(letra + ") " + opcion);
//                letra++;
//				}
//        } catch (IOException excepcion) {
//            System.out.println("Error al cargar el fichero ingles.txt: " + excepcion.getMessage());
//        }
	}

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
