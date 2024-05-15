package juego;

import java.io.IOException;
import java.util.Scanner;

import registros.Historico;
import registros.Ranking;
import util.Constantes;

public class ProgramaJuego {

    public static void main(String[] args) {
        iniciarPartida();
    }
    
    private static void iniciarPartida() {
    	Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido a Atrapa un Millon");
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion(teclado);

            switch (opcion) {
                case 1:
                    jugarPartida(teclado);
                    break;
                case 2:
                    mostrarRanking();
                    break;
                case 3:
                    mostrarHistorico();
                    break;
                case 4:
                    gestionarJugadores(teclado);
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

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("****************Menú****************");
        System.out.println("1. Jugar Partida.");
        System.out.println("2. Ranking mejores jugadores.");
        System.out.println("3. Histórico de partidas.");
        System.out.println("4. Gestión de jugadores.");
        System.out.println("5. Salir.");
        System.out.println("************************************");
    }

    private static int leerOpcion(Scanner teclado) {
        System.out.print("Selecciona una opción: ");
        return teclado.nextInt();
    }

    private static void jugarPartida(Scanner teclado) {
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
    }

    private static void mostrarRanking() {
        try {
            Ranking.comprobarRanking();
            Ranking.mostarRanking();
            Ranking.guardarRanking();
        } catch (IOException e) {
            System.err.println("Error al mostrar el ranking: " + e.getMessage());
        }
    }

    private static void mostrarHistorico() {
        try {
            Historico.comprobarHistorico();
            Historico.guardarPartida();
        } catch (IOException e) {
            System.err.println("Error al mostrar el histórico: " + e.getMessage());
        }
    }

    private static void gestionarJugadores(Scanner teclado) {
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
                    System.out.println("Opción inválida, por favor selecciona una opción válida.");
                    break;
            }
        }
    }
}