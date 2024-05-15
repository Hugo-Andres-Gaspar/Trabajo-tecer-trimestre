package juego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import registros.Historico;
import util.Constantes;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class Partida {

	private static Scanner teclado = new Scanner(System.in);
	private static Random aleatorio = new Random();

	/**
	 * Realiza una pregunta al jugador humano y gestiona la respuesta.
	 * 
	 * @param jugador el jugador humano al que se le realiza la pregunta
	 */
	public static void hacerPregunta(Jugador jugador) {
		try {
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
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Por favor, ingrese un valor válido.");
			teclado.next(); // Limpiar el buffer del scanner
		}
	}

	/**
	 * Muestra una pregunta para el jugador CPU y gestiona la respuesta.
	 * 
	 * @param cpu el jugador CPU al que se le muestra la pregunta
	 */
	public static void mostrarPreguntasCpu(Jugador cpu) {
		try {
			int pregunta = aleatorio.nextInt(3) + 1;

			switch (pregunta) {
			case Constantes.ARCHIVO_PREGUNTAS_MATES:
				PreguntasMates preguntaMates = new PreguntasMates("Enunciado para preguntas de matemáticas");
				preguntaMates.generarPreguntaMates();
				System.out.println("La respuesta de la CPU es: " + preguntaMates.respuestaMatesCPU());
				System.out.println("Correcto!!!");
				cpu.anyadirPuntos();
				break;
			case Constantes.ARCHIVO_PREGUNTAS_LETRAS:
				PreguntasLetras preguntaLetras = new PreguntasLetras("Enunciado para preguntas de letras");
				preguntaLetras.generarPreguntaLetras();
				System.out.println(preguntaLetras.getPalabraOculta());
				System.out.println("Respuesta de la cpu: " + preguntaLetras.respuestaLetrasCpu());
				System.out.println("La cpu no ha adivinado la palabra");
				break;
			case Constantes.ARCHIVO_PREGUNTAS_INGLES:
				PreguntasIngles preguntaIngles = new PreguntasIngles();
				preguntaIngles.generarPreguntaIngles();
				char respuestaCPU = preguntaIngles.comprobarRespuestaCPU();
				if (preguntaIngles.verificarRespuesta(respuestaCPU)) {
					System.out.println("La CPU ha acertado!!");
					cpu.anyadirPuntos();
				} else {
					System.out.println("La CPU ha fallado");
				}
				break;
			default:
				System.out.println("Opción de pregunta no válida.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realiza una partida rápida, que consta de un número fijo de rondas.
	 */
	public static void partidaRapida() {
		try {
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
			Historico.comprobarHistorico();
			Historico.guardarPartida();
		} catch (IOException e) {
			System.out.println("Error al manejar el historial: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realiza una partida rápida, que consta de un número fijo de rondas.
	 */
	public static void partidaCorta() {
		try {
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
			Historico.comprobarHistorico();
			Historico.guardarPartida();
		} catch (IOException e) {
			System.out.println("Error al manejar el historial: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realiza una partida rápida, que consta de un número fijo de rondas.
	 */
	public static void partidaNormal() {
		try {
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
			Historico.comprobarHistorico();
			Historico.guardarPartida();
		} catch (IOException e) {
			System.out.println("Error al manejar el historial: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Realiza una partida rápida, que consta de un número fijo de rondas.
	 */
	public static void partidaLarga() {
		try {
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
			Historico.comprobarHistorico();
			Historico.guardarPartida();
		} catch (IOException e) {
			System.out.println("Error al manejar el historial: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Solicita al usuario el número de jugadores humanos y CPU para la partida.
	 * 
	 * @return {@code true} si se seleccionan jugadores válidos, {@code false} de lo
	 *         contrario
	 */
	static boolean solicitarJugadores() {
		try {
			int numJugadores = 0;
			int numCPU = 0;
			while (true) {
				System.out.println("¿Número de jugadores humanos? (1-4) ");
				numJugadores = teclado.nextInt();
				System.out.println("¿Número de jugadores CPU? (1-4)");
				numCPU = teclado.nextInt();

				if ((numJugadores + numCPU) <= Constantes.MAXIMO_JUGADORES && (numJugadores > 0 || numCPU > 0)) {
					break;
				} else {
					System.out.println("Número de jugadores inválidos. Intente de nuevo");
				}
			}
			boolean jugadoresValidos = pedirJugadoresHumanos(numJugadores);
			if (jugadoresValidos) {
				agregarCPU(numCPU);
			}
			return jugadoresValidos;
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Por favor, ingrese un número entero válido.");
			teclado.next(); // Limpiar el buffer del scanner
			return false;
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Pide al usuario los nombres de los jugadores humanos.
	 * 
	 * @param numJugadores el número de jugadores humanos a solicitar
	 * @return {@code true} si se seleccionan jugadores válidos, {@code false} de lo
	 *         contrario
	 */
	public static boolean pedirJugadoresHumanos(int numJugadores) {
		try {
			for (int i = 0; i < numJugadores; i++) {
				boolean jugadorEncontrado = false;
				int intentos = 0;
				int intentosMaximos = 2;
				while (!jugadorEncontrado && intentos < intentosMaximos) {
					System.out.println("Nombre del jugador humano " + (i + 1) + ":");
					String nombre = teclado.next();
					if (Jugador.elegirJugadorPorNombre(nombre)) {
						jugadorEncontrado = true;
					} else {
						intentos++;
						if (intentos < intentosMaximos) {
							System.out.println("Jugador no encontrado, prueba otra vez.");
						} else {
							System.out.println("Número máximo de intentos alcanzado");
							return false;
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Agrega jugadores CPU a la partida.
	 * 
	 * @param numCPU el número de jugadores CPU a agregar
	 */
	public static void agregarCPU(int numCPU) {
		try {
			for (int i = 0; i < numCPU; i++) {
				String cpu = "CPU" + i;
				System.out.println("Va a jugar la CPU" + i);
				Jugador.anyadirJugador(cpu);
				Jugador.elegirJugadorPorNombre(cpu);
			}
		} catch (Exception e) {
			System.out.println("Se produjo un error al agregar la CPU: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Solicita al usuario que seleccione el tipo de partida que desea jugar.
	 * 
	 * @return el número de rondas de la partida seleccionada
	 */
	static int seleccionarRonda() {
		try {
			System.out.println("Elige el tipo de partida que quieres jugar: ");
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
				System.out.println("Opción no válida, se selecciona la Partida Corta por defecto...");
				return Constantes.PARTIDA_CORTA;
			}
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
			teclado.next(); // Limpiar el buffer del scanner
			return Constantes.PARTIDA_CORTA;
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
			return Constantes.PARTIDA_CORTA;
		}
	}
}
