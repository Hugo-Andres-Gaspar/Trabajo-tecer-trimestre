package juego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import registros.Historico;
import util.Constantes;

public class Partida {

	private static Scanner teclado = new Scanner(System.in);
	private static Random aleatorio = new Random();

	// TODO: VER LOGICA PARA QUE NO ME REPITA DOS VECES LAS PREGUNTAS
	public static void hacerPregunta(Jugador jugador) {
		int tipoPregunta = aleatorio.nextInt(3) + 1;

		if (tipoPregunta == Constantes.ARCHIVO_PREGUNTAS_LETRAS) {
			PreguntasLetras preguntaLetras = new PreguntasLetras("Enunciado para preguntas de letras");
			preguntaLetras.generarPreguntaLetras();
			String palabra = teclado.next();
			if (preguntaLetras.comprobarPalabra(palabra)) {
				jugador.anyadirPuntos();
			}
		} else if (tipoPregunta == Constantes.ARCHIVO_PREGUNTAS_INGLES) {
			PreguntasIngles preguntaIngles = new PreguntasIngles();
			preguntaIngles.generarPreguntaIngles();
			char letra = teclado.next().toUpperCase().charAt(0);
			if (preguntaIngles.verificarRespuesta(letra)) {
				jugador.anyadirPuntos();
			}
		} else if (tipoPregunta == Constantes.ARCHIVO_PREGUNTAS_MATES) {
			PreguntasMates preguntaMates = new PreguntasMates("Enunciado para preguntas de matemáticas");
			preguntaMates.generarPreguntaMates();
			int num = teclado.nextInt();
			if (preguntaMates.comprobarResultado(num)) {
				jugador.anyadirPuntos();
			}
		}
	}

	public static void mostrarPreguntasCpu(Jugador cpu) {
		int pregunta = aleatorio.nextInt(3) + 1;
		if (pregunta == Constantes.ARCHIVO_PREGUNTAS_MATES) {
			PreguntasMates preguntaMates = new PreguntasMates("Enunciado para preguntas de matemáticas");
			preguntaMates.generarPreguntaMates();
			preguntaMates.respuestaMatesCPU();
			System.out.println("La respuesta de la CPU es: " + preguntaMates.respuestaMatesCPU());
			System.out.println("Correcto!!!");
			cpu.anyadirPuntos();
		} else if (pregunta == Constantes.ARCHIVO_PREGUNTAS_LETRAS) {
			PreguntasLetras preguntaLetras = new PreguntasLetras("Enunciado para preguntas de letras");
			preguntaLetras.generarPreguntaLetras();
			System.out.println(preguntaLetras.getPalabraOculta());
			System.out.println("Respuesta de la cpu: " + preguntaLetras.respuestaLetrasCpu());
			System.out.println("La cpu no ha adivinado la palabra");
		} else if (pregunta == Constantes.ARCHIVO_PREGUNTAS_INGLES) {
			PreguntasIngles preguntaIngles = new PreguntasIngles();
			preguntaIngles.generarPreguntaIngles();
			preguntaIngles.comprobarRespuestaCPU();
			if (preguntaIngles.verificarRespuesta(preguntaIngles.comprobarRespuestaCPU())) {
				System.out.println("La CPU ha acertado!!");
				cpu.anyadirPuntos();
			} else {
				System.out.println("La CPU ha fallado");
			}
		}
	}

	public static void partidaRapida() {
		ArrayList<Jugador> jugadores = Jugador.obtenerJugadoresDeLaPartida();
		Collections.shuffle(jugadores);
		for (int i = 0; i < Constantes.PARTIDA_RAPIDA; i++) {
			System.out.println("****************Ronda " + (i + 1) + "****************");

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().startsWith("CPU")) {
					System.out.println("Turno del " + jugador + " ");
					mostrarPreguntasCpu(jugador);

				} else {
					System.out.println("Turno del " + jugador + " ");
					hacerPregunta(jugador);
				}
			}
		}
		try {
			Historico.comprobarHistorico();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Historico.guardarPartida();
	}

	// Partida de 5 rondas
	public static void partidaCorta() {
		ArrayList<Jugador> jugadores = Jugador.obtenerJugadoresDeLaPartida();
		Collections.shuffle(jugadores);
		for (int i = 0; i < Constantes.PARTIDA_CORTA; i++) {
			System.out.println("****************Ronda " + (i + 1) + "****************");

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().startsWith("CPU")) {
					System.out.println("Turno del " + jugador + " ");
					mostrarPreguntasCpu(jugador);

				} else {
					System.out.println("Turno del " + jugador + " ");
					hacerPregunta(jugador);
				}
			}
		}
		try {
			Historico.comprobarHistorico();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Historico.guardarPartida();

	}

	// Partida de 10 rondas
	public static void partidaNormal() {
		ArrayList<Jugador> jugadores = Jugador.obtenerJugadoresDeLaPartida();
		Collections.shuffle(jugadores);
		for (int i = 0; i < Constantes.PARTIDA_NORMAL; i++) {
			System.out.println("****************Ronda " + (i + 1) + "****************");

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().startsWith("CPU")) {
					System.out.println("Turno del " + jugador + " ");
					mostrarPreguntasCpu(jugador);

				} else {
					System.out.println("Turno del " + jugador + " ");
					hacerPregunta(jugador);
				}
			}
		}
		try {
			Historico.comprobarHistorico();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Historico.guardarPartida();
	}

	// Partida de 20 rondas
	public static void partidaLarga() {
		ArrayList<Jugador> jugadores = Jugador.obtenerJugadoresDeLaPartida();
		Collections.shuffle(jugadores);
		for (int i = 0; i < Constantes.PARTIDA_LARGA; i++) {
			System.out.println("****************Ronda " + (i + 1) + "****************");

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().startsWith("CPU")) {
					System.out.println("Turno del " + jugador + " ");
					mostrarPreguntasCpu(jugador);

				} else {
					System.out.println("Turno del " + jugador + " ");
					hacerPregunta(jugador);
				}
			}
		}
		try {
			Historico.comprobarHistorico();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Historico.guardarPartida();
	}

	static boolean solicitarJugadores() {
		int numJugadores = 0;
		int numCPU = 0;
		while (true) {
			System.out.println("¿Numero de jugadores humanos? (1-4) ");
			numJugadores = teclado.nextInt();
			System.out.println("¿Numero de jugadores CPU? (1-4)");
			numCPU = teclado.nextInt();

			if ((numJugadores + numCPU) <= Constantes.MAXIMO_JUGADORES && (numJugadores > 0 || numCPU > 0)) {
				break;
			} else {
				System.out.println("Numero de jugadores inválidos. Intente de nuevo");
			}
		}
		boolean jugadoresValidos = pedirJugadoresHumanos(numJugadores);
		if (jugadoresValidos) {
			agregarCPU(numCPU);
		}
		return jugadoresValidos;
	}

	public static boolean pedirJugadoresHumanos(int numJugadores) {
		for (int i = 0; i < numJugadores; i++) {
			boolean jugadorEncontrado = false;
			int intentos = 0;
			int intetosMaximos = 2;
			while (!jugadorEncontrado && intentos < intetosMaximos) {
				System.out.println("Nombre del jugador humano " + (i + 1) + ":");
				String nombre = teclado.next();
				if (Jugador.elegirJugadorPorNombre(nombre)) {
					jugadorEncontrado = true;
				} else {
					intentos++;
					if (intentos < intetosMaximos) {
						System.out.println("Jugador no encontado, prueba otra vez.");
					} else {
						System.out.println("Numero máximo de intentos alcanzado");
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void agregarCPU(int numCPU) {
		for (int i = 0; i < numCPU; i++) {
			String cpu = "CPU" + i;
			System.out.println("Va a jugar la CPU" + i);
			Jugador.anyadirJugador(cpu);
			Jugador.elegirJugadorPorNombre(cpu);
		}
	}

	static int seleccionarRonda() {
		System.out.println("Elije el tipo de partida que quieres jugar: ");
		System.out.println("1. Partida rápida (3 rondas)");
		System.out.println("2. Partida corta (5 rondas)");
		System.out.println("3. Partida normal (10 rondas)");
		System.out.println("4. Partida larga (20 rondas)");
		int opcion = teclado.nextInt();

		switch (opcion) {
		case 1:
			return Constantes.PARTIDA_RAPIDA;
		case 2:
			return Constantes.PARTIDA_CORTA;
		case 3:
			return Constantes.PARTIDA_NORMAL;
		case 4:
			return Constantes.PARTIDA_LARGA;
		default:
			System.out.println("Esa opción no es válida, te selecciono la PARTIDA CORTA por defecto....");
			return Constantes.PARTIDA_CORTA;
		}
	}
}
