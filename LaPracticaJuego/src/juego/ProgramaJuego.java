package juego;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import registros.Historico;
import registros.Ranking;
import util.Constantes;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class ProgramaJuego {
	/**
	 * Método principal que inicia la ejecución del programa.
	 * 
	 * @param args Los argumentos de la línea de comandos (no se utilizan).
	 */
	public static void main(String[] args) {
		iniciarPartida();
	}

	/**
	 * Método que gestiona la ejecución del juego.
	 */
	private static void iniciarPartida() {
		try (Scanner teclado = new Scanner(System.in)) {
			System.out.println("Bienvenido a Atrapa un Millon");
			boolean continuar = true;
			while (continuar) {
				mostrarMenu();
				int opcion;
				try {
					opcion = leerOpcion(teclado);
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
					teclado.next(); // Limpiar el buffer del scanner
					continue;
				}

				switch (opcion) {
				case 1:
					try {
						jugarPartida(teclado);
					} catch (Exception e) {
						System.out.println("Error al jugar la partida: " + e.getMessage());
						e.printStackTrace();
					}
					break;
				case 2:
					mostrarRanking();
					break;
				case 3:
					mostrarHistorico();
					break;
				case 4:
					try {
						gestionarJugadores(teclado);
					} catch (Exception e) {
						System.out.println("Error al gestionar jugadores: " + e.getMessage());
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("****************Cerrando juego****************");
					System.out.println("Ha sido un placer jugar contigo");
					continuar = false;
					break;
				default:
					System.out.println("Opción inválida, por favor selecciona una opción válida.");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Método que muestra el menú de opciones disponibles.
	 */
	private static void mostrarMenu() {
		System.out.println("****************Menú****************");
		System.out.println("1. Jugar Partida.");
		System.out.println("2. Ranking mejores jugadores.");
		System.out.println("3. Histórico de partidas.");
		System.out.println("4. Gestión de jugadores.");
		System.out.println("5. Salir.");
		System.out.println("************************************");
	}

	/**
	 * Método que lee la opción seleccionada por el usuario.
	 * 
	 * @param teclado El objeto Scanner para leer la entrada del usuario.
	 * @return La opción seleccionada por el usuario.
	 */
	private static int leerOpcion(Scanner teclado) {
		try {
			System.out.print("Selecciona una opción: ");
			return teclado.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
			teclado.next(); // Limpiar el buffer del scanner
			return leerOpcion(teclado); // Intentar nuevamente leer la opción
		} catch (Exception e) {
			System.out.println("Se produjo un error al leer la opción: " + e.getMessage());
			e.printStackTrace();
			return leerOpcion(teclado); // Intentar nuevamente leer la opción
		}
	}

	/**
	 * Método que inicia una partida del juego.
	 * 
	 * @param teclado El objeto Scanner para leer la entrada del usuario.
	 */
	private static void jugarPartida(Scanner teclado) {
		try {
			boolean hayJugadores = Partida.solicitarJugadores();
			if (hayJugadores) {
				System.out.println("****************Entrando en partida****************");
				int tipoRondas = Partida.seleccionarRonda();
				switch (tipoRondas) {
				case Constantes.PARTIDA_RAPIDA:
					Partida.partidaRapida();
					break;
				case Constantes.PARTIDA_CORTA:
					Partida.partidaCorta();
					break;
				case Constantes.PARTIDA_NORMAL:
					Partida.partidaNormal();
					break;
				case Constantes.PARTIDA_LARGA:
					Partida.partidaLarga();
					break;
				default:
					System.out.println("Tipo de partida no válida");
					break;
				}
			} else {
				System.out.println("No se han podido elegir los jugadores, volviendo al menú principal.....");
			}
		} catch (Exception e) {
			System.out.println("Se produjo un error al jugar la partida: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Método que muestra el ranking de los mejores jugadores.
	 */
	private static void mostrarRanking() {
		try {
			Ranking.comprobarRanking();
			Ranking.mostarRanking();
			Ranking.guardarRanking();
		} catch (IOException e) {
			System.err.println("Error al mostrar el ranking: " + e.getMessage());
		}
	}

	/**
	 * Método que muestra el histórico de partidas anteriores.
	 */
	private static void mostrarHistorico() {
		try {
			Historico.comprobarHistorico();
			Historico.guardarPartida();
		} catch (IOException e) {
			System.err.println("Error al mostrar el histórico: " + e.getMessage());
		}
	}

	/**
	 * Método que gestiona la administración de jugadores (añadir, eliminar,
	 * mostrar).
	 * 
	 * @param teclado El objeto Scanner para leer la entrada del usuario.
	 */

	private static void gestionarJugadores(Scanner teclado) {
		try {
			boolean continuarSubmenu = true;
			while (continuarSubmenu) {
				System.out.println("\n****************Submenú****************");
				System.out.println("1. Ver Jugadores registrados.");
				System.out.println("2. Añadir nuevo jugador.");
				System.out.println("3. Eliminar jugador.");
				System.out.println("4. Volver al menú principal.");
				System.out.println("*****************************************");

				int opcionSubmenu;
				try {
					opcionSubmenu = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
					teclado.next(); // Limpiar el buffer del scanner
					continue;
				}

				switch (opcionSubmenu) {
				case 1:
					Jugador.mostrarJugadores();
					break;
				case 2:
					System.out.print("Dime el nombre del jugador que quieres añadir: ");
					String nombreAnyadir = teclado.next();
					Jugador.anyadirJugador(nombreAnyadir);
					break;
				case 3:
					System.out.print("Dime el nombre del jugador que quieres borrar: ");
					String nombreBorrar = teclado.next();
					Jugador.eliminarJugador(nombreBorrar);
					break;
				case 4:
					System.out.println("****************Saliendo de submenú****************");
					System.out.println("");
					continuarSubmenu = false;
					break;
				default:
					System.out.println("Opción inválida, por favor selecciona una opción válida.");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Se produjo un error al gestionar jugadores: " + e.getMessage());
			e.printStackTrace();
		}
	}
}