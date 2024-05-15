package juego;

import java.util.Random;
import java.util.Scanner;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class PreguntasMates extends Pregunta {
	private Scanner teclado = new Scanner(System.in);
	private Random aleatorio = new Random();
	private StringBuilder operacion = new StringBuilder();
	private int resultado;
	private int cantidadNumerosOperacion;

	/**
	 * Crea una nueva instancia de {@code PreguntasMates} con enunciado vacío.
	 */
	public PreguntasMates() {
	}

	/**
	 * Crea una nueva instancia de {@code PreguntasMates} con el enunciado
	 * especificado.
	 * 
	 * @param enunciado El enunciado de la pregunta de matemáticas.
	 */
	public PreguntasMates(String enunciado) {
		super(enunciado);
	}

	/**
	 * Genera una pregunta de matemáticas aleatoria. Genera una operación matemática
	 * aleatoria y calcula su resultado. Muestra la pregunta y la operación generada
	 * por consola.
	 */
	public void generarPreguntaMates() {
		generarOperacion();
		calcularResultado();
		mostrarPreguntaYOperacion();
	}

	/**
	 * Genera una operación matemática aleatoria. La operación consiste en una
	 * secuencia de números y operadores matemáticos básicos.
	 */
	public void generarOperacion() {
		cantidadNumerosOperacion = aleatorio.nextInt(5) + 4;

		for (int contador = 0; contador < cantidadNumerosOperacion; contador++) {
			int numeroAleatorio = aleatorio.nextInt(11) + 2;
			operacion.append(numeroAleatorio);
			if (contador < cantidadNumerosOperacion - 1) {
				int operadorMatematico = aleatorio.nextInt(3);
				switch (operadorMatematico) {
				case 0:
					operacion.append(" * ");
					break;
				case 1:
					operacion.append(" + ");
					break;
				case 2:
					operacion.append(" - ");
					break;
				}
			}
		}
	}

	/**
	 * Calcula el resultado de la operación matemática. Utiliza la biblioteca
	 * "exp4j" para evaluar la expresión matemática y obtener el resultado. Si hay
	 * algún error durante la evaluación, se imprime un mensaje de error y se
	 * establece el resultado en 0.
	 */
	private void calcularResultado() {
		String expresionMatematica = operacion.toString();
		try {
			Expression expresion = new ExpressionBuilder(expresionMatematica).build();
			resultado = (int) expresion.evaluate();
		} catch (Exception excepcion) {
			System.out.println("Error al evaluar la expresión: " + excepcion.getMessage());
			resultado = 0; // Si hay un error, resultado 0
		}
	}

	/**
	 * Muestra la pregunta y la operación generada por consola.
	 */
	private void mostrarPreguntaYOperacion() {
		System.out.println("Pregunta: " + getEnunciado()); // Mostrar enunciado
		System.out.println("Operación: " + operacion.toString()); // Mostrar la operación
	}

	/**
	 * Comprueba si el resultado proporcionado por el usuario es correcto.
	 * 
	 * @param resultadoUsuario El resultado proporcionado por el usuario.
	 * @return {@code true} si el resultado es correcto, {@code false} si es
	 *         incorrecto.
	 */
	public boolean comprobarResultado(int resultadoUsuario) {
		if (resultado == resultadoUsuario) {
			System.out.println("El resultado es correcto");
			return true;
		} else {
			System.out.println("El resultado es incorrecto, el resultado correcto es: " + resultado);
			return false;
		}
	}
	/**
     * Devuelve el resultado de la operación matemática.
     * Este método puede ser utilizado por la CPU en el juego para obtener el resultado de la pregunta.
     * @return El resultado de la operación matemática.
     */
	public int respuestaMatesCPU() {
		return resultado;
	}
}
