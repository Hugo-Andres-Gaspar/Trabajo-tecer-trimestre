package registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import juego.Jugador;
import util.Constantes;

public class Historico {

    public static void comprobarHistorico() throws IOException {
        Path rutaFichero = Paths.get(Constantes.RUTA_HISTORICO);
        if (!Files.exists(rutaFichero)){
            System.out.println("No existe el fichero, procedo a crearlo....");
            Files.createFile(rutaFichero);
        }

    }
    public static void guardarpartida(){

        try(BufferedWriter bufer = new BufferedWriter(new FileWriter(Constantes.RUTA_HISTORICO, true))){

        	Jugador jugador = new Jugador(null, 0);
            ArrayList<Jugador> jugadores = jugador.getListaJugadores();
            for (Jugador jug : jugadores) {
                bufer.write(jug.getNombre() + " " + jug.getPuntuacion() + " ");
                bufer.newLine();
                System.out.println("Partida registrada en el archivo: " + Constantes.RUTA_HISTORICO);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al registrar la partida el archivo | "+e);
        }
    }
}
