package juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import util.Constantes;

public class Log {
	public static void crearFicheroLog() {
		Path rutaFicheroLog = Paths.get(Constantes.RUTA_LOG);

		if (!Files.exists(rutaFicheroLog)) {
			System.out.println("No tienes el fichero te lo creo yo");
			try {
				Files.createFile(rutaFicheroLog);

			} catch (IOException excepcion) {
				excepcion.printStackTrace();
			}

		}

	}
}
