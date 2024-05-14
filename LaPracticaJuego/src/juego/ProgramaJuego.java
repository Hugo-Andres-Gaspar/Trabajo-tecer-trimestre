package juego;

import java.io.IOException;
import java.util.Scanner;

import registros.Historico;
import util.Constantes;

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
				boolean hayJugadores = Partida.solicitarJugadores();
                if (hayJugadores) {
                	System.out.println("****************Entrando en partida****************");

                    int tiporondas = Partida.seleccionarRonda();
                    switch (tiporondas) {
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
                        	System.out.println("****************Tipo de partida no valida****************");
                            break;
                    }
                }else {
                    System.out.println("No se han podido elegir los jugadores, volviendo al menu principal.....");
                }
                break;
			case 2:
				break;
			case 3:
				try {
					Historico.comprobarHistorico();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Historico.guardarpartida();
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
						System.out.println("No has elegido ninguna de las opciones pedidas, por favor vuelva a introducir una nueva opción");
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
				System.out.println("No has elegido ninguna de las opciones pedidas, por favor vuelva a introducir una nueva opción");
				break;
			}

		}

		
		teclado.close();
	}

}