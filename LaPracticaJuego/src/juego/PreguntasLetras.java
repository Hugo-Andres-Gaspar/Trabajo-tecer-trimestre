package juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class PreguntasLetras extends Pregunta{

    Random aleatorio = new Random();
    private String palabraElegida;
    private String letrasOcultas;

    public PreguntasLetras(String enunciado) {
        super(enunciado);
        generarPreguntaLetras();
    }

    public void generarPreguntaLetras() {
        palabraAleatoria();
        ocultarLetras();
        System.out.print("Palabra oculta: " + getPalabraOculta()); // Mostrar palabra oculta
    }

    public void palabraAleatoria() {
        try {
            Path rutaFicheroDiccionario = Paths.get(util.Constantes.RUTA_FICHERO_PREGUNTAS_LETRAS);
            List<String> palabras = Files.readAllLines(rutaFicheroDiccionario);
            if (!palabras.isEmpty()) {
                palabraElegida = palabras.get(aleatorio.nextInt(palabras.size()));
            } else {
                System.out.println("El diccionario está vacío.");
            }
        } catch (IOException excepcion) {
            System.out.println("Error al cargar el diccionario: " + excepcion.getMessage());
        }
    }

    public void ocultarLetras() {
        StringBuilder letraOculta = new StringBuilder();
        int cantidadLetras = palabraElegida.length();
        int cantidadLetrasOcultas;
        if (cantidadLetras >= 3) {
            cantidadLetrasOcultas = cantidadLetras / 3;
        } else {
            cantidadLetrasOcultas = 0;
        }
        for (int contador = 0; contador < cantidadLetras; contador++) {
            if (cantidadLetrasOcultas > 0 && (contador + 1) % 3 == 0) {
                letraOculta.append('_');
                cantidadLetrasOcultas--;
            } else {
                letraOculta.append(palabraElegida.charAt(contador));
            }
        }

        letrasOcultas = letraOculta.toString();
    }

    public boolean palabraCorrecta(String palabra) {
        if (palabra.equalsIgnoreCase(palabraElegida)) {
            System.out.println("Enhorabuena esa es la palabra correcta");
            return true;
        } else {
            System.out.println("La palabra es incorrecta");
            System.out.println("La palabra correcta es: " + palabraElegida);
            return false;
        }
    }

    public String getPalabraElegida() {
        return palabraElegida;
    }

    public String getPalabraOculta() {
        return letrasOcultas;
    }
//    Random aleatorio = new Random();
//    private String palabraElegida;
//    private String letrasOcultas;
//
//    public PreguntasLetras(String enunciado) {
//        super(enunciado);
//        palabraAleatoria();
//        ocultarLetras();
//    }
//
//    public void palabraAleatoria() {
//        try {
//            Path rutaFicheroDiccionario = Paths.get(util.Constantes.RUTA_FICHERO_PREGUNTAS_LETRAS);
//            List<String> palabras = Files.readAllLines(rutaFicheroDiccionario);
//            if (!palabras.isEmpty()) {
//                palabraElegida = palabras.get(aleatorio.nextInt(palabras.size()));
//            } else {
//                System.out.println("El diccionario está vacío.");
//            }
//        } catch (IOException excepcion) {
//            System.out.println("Error al cargar el diccionario: " + excepcion.getMessage());
//        }
//    }
//
//    public void ocultarLetras() {
//        if (palabraElegida != null) {
//            StringBuilder letraOculta = new StringBuilder();
//            int cantidadLetras = palabraElegida.length();
//            int cantidadLetrasOcultas;
//            if (cantidadLetras >= 3) {
//                cantidadLetrasOcultas = cantidadLetras / 3;
//            } else {
//                cantidadLetrasOcultas = 0;
//            }
//            for (int contador = 0; contador < cantidadLetras; contador++) {
//                if (cantidadLetrasOcultas > 0 && (contador + 1) % 3 == 0) {
//                    letraOculta.append('_');
//                    cantidadLetrasOcultas--;
//                } else {
//                    letraOculta.append(palabraElegida.charAt(contador));
//                }
//            }
//            letrasOcultas = letraOculta.toString();
//        } else {
//            System.out.println("No se pudo ocultar las letras porque la palabra elegida es nula.");
//        }
//    }
//
//    public boolean palabraCorrecta(String palabra) {
//        if (palabraElegida != null) {
//            if (palabra.equalsIgnoreCase(palabraElegida)) {
//                System.out.println("Enhorabuena esa es la palabra correcta");
//                return true;
//            } else {
//                System.out.println("La palabra es incorrecta");
//                System.out.println("La palabra correcta es: " + palabraElegida);
//                return false;
//            }
//        } else {
//            System.out.println("No se puede verificar la palabra correcta porque la palabra elegida es nula.");
//            return false;
//        }
//    }
//
//    public String getPalabraElegida() {
//        return palabraElegida;
//    }
//
//    public String getPalabraOculta() {
//        return letrasOcultas;
//    }

}
