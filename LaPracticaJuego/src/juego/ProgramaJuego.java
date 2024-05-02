package juego;

import java.util.Scanner;

public class ProgramaJuego {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Jugador jugador = new Jugador(null);
		
		System.out.println("Bienvenido a Atrapa un Millon");
		boolean continuar = true;
		while (continuar) {
			System.out.println("****************Menú****************");
			System.out.println("1. Jugar Partida.");
			System.out.println("2. Ranking mejores jugadores.");
			System.out.println("3. Histórico de partidas.");
			System.out.println("4. Gestión de jugadores.");
			System.out.println("5. Salir.");
			System.out.println("************************************");

			int opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("1");
				break;

			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			case 4:
				boolean continuarSubmenu = true;
				while (continuarSubmenu) {
					System.out.println("\n****************Submenú****************");
					System.out.println("1. Ver Jugadores registrados.");
					System.out.println("2. Añadir nuevo jugador.");
					System.out.println("3. Eliminar jugador.");
					System.out.println("4. Volver al menú principal.");
					System.out.println("*****************************************");

					int opcionSubmenu = teclado.nextInt();

					switch (opcionSubmenu) {
					case 1:
						jugador.mostrarJugadores();
						break;
					case 2:
						System.out.print("Ingrese el nombre del nuevo jugador: ");
						String nombreNuevo = teclado.next();
						jugador.anyadirJugador(new Jugador(nombreNuevo));
						break;
					case 3:
						System.out.print("Ingrese el nombre del jugador a eliminar: ");
	                    String nombreEliminar = teclado.next();
	                    jugador.eliminarJugador(new Jugador(nombreEliminar));
						break;
					case 4:
						System.out.println("****************Saliendo de submenú****************");
						System.out.println("");
						continuarSubmenu = false;
						break;
					default:
						break;
					}

				}
				break;
			case 5:
				System.out.println("****************Cerrando juego****************");
				System.out.println("Ha sido un placer jugar contigo");
				continuar = false;
				break;
			default:
				break;
			}

		}

		teclado.close();
	}

}
