package juego;

import java.util.Random;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class PreguntasMates {
	Random aleatorio = new Random();
	StringBuilder operacion = new StringBuilder();

	private int resultado;
	private int cantidadNumerosOperacion;

	public PreguntasMates() {
	}

	public void generarPreguntaMates() {
		cantidadNumerosOperacion = aleatorio.nextInt(5) + 4;
		
		for (int contador = 0; contador < cantidadNumerosOperacion; contador++) {
			int numeroAleatorio = aleatorio.nextInt(11) + 2;
			operacion.append(numeroAleatorio);
			if (contador < cantidadNumerosOperacion - 1) {
				int operadorMatematico = aleatorio.nextInt(3);
				if (operadorMatematico == 0) {
					operacion.append(" * ");
				} else if (operadorMatematico == 1) {
					operacion.append(" + ");
				} else {
					operacion.append(" - ");
				}
			}
		}

		String expresionMatematica = operacion.toString();
		System.out.println("Operacion: " + expresionMatematica);
		try {
			Expression expresion = new ExpressionBuilder(expresionMatematica).build();
			resultado = (int) expresion.evaluate();
		} catch (Exception excepcion) {
			System.out.println("Error al evaluar la expresión: " + excepcion.getMessage());
		}
	}

	public boolean comprobarResultado(int resultadoUsuario) {
		if (resultado == resultadoUsuario) {
			System.out.println("El resultado es correcto");
			return true;
		} else {
			System.out.println("El resultado es incorrecto, el resultado correcto es: " + resultado);
			return false;
		}

	}

}
