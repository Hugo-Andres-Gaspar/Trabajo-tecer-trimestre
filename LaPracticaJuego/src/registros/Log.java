package registros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import util.Constantes;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class Log {
	/**
	 * Crea el archivo de registro si no existe en la ruta especificada en
	 * Constantes.
	 */
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
