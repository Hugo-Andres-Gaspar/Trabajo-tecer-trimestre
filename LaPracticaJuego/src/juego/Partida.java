package juego;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import util.Constantes;

public class Partida {

    private static Scanner teclado = new Scanner(System.in);
    private static Random aleatorio = new Random();

    public static void iniciarPartida() {
        int numJugadoresHumanos = obtenerNumeroJugadores("humanos");
        int numJugadoresMaquina = obtenerNumeroJugadores("de la máquina");
        int totalJugadores = numJugadoresHumanos + numJugadoresMaquina;

        if (totalJugadores > 4 || numJugadoresHumanos < 0 || numJugadoresMaquina < 0) {
            System.out.println("Número de jugadores inválido.");
            return;
        }

        for (int i = 0; i < numJugadoresHumanos; i++) {
            System.out.print("Ingrese el nombre del jugador humano " + (i + 1) + ": ");
            String nombre = teclado.next();
            Jugador jugador = new Jugador(nombre);
            jugador.comprobarJugador(jugador);
        }

        // TODO: Logica para iniciar las rondas del juego
        System.out.println("Elige que tipo de partida vas a querer jugar: ");
        
    }

    private static int obtenerNumeroJugadores(String tipoJugadores) {
        int numJugadores = 0;
        boolean inputValido = false;

        do {
            try {
                System.out.print("Ingrese el número de jugadores " + tipoJugadores + " (1-4): ");
                numJugadores = teclado.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                teclado.nextLine(); // Limpiar el buffer del scanner
            }
        } while (!inputValido || numJugadores < 0 || numJugadores > 4);

        return numJugadores;
    }

    public static void hacerPregunta() {
        int tipoPregunta = aleatorio.nextInt(3) + 1;

        if (tipoPregunta == Constantes.ARCHIVO_PREGUNTAS_LETRAS) {
            PreguntasLetras preguntaLetras = new PreguntasLetras("Enunciado para preguntas de letras");
            preguntaLetras.generarPreguntaLetras();
        } else if (tipoPregunta == Constantes.ARCHIVO_PREGUNTAS_INGLES) {
            PreguntasIngles preguntaIngles = new PreguntasIngles(null, aleatorio, null);
            preguntaIngles.generarPreguntaIngles();
        } else if (tipoPregunta == Constantes.ARCHIVO_PREGUNTAS_MATES) {
            PreguntasMates preguntaMates = new PreguntasMates("Enunciado para preguntas de matemáticas");
            preguntaMates.generarPreguntaMates();
        }
    }
}
