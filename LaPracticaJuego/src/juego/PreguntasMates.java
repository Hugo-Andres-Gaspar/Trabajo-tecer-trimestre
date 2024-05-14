package juego;

import java.util.Random;
import java.util.Scanner;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class PreguntasMates extends Pregunta{
	private Scanner teclado = new Scanner(System.in);
	private Random aleatorio = new Random();
    private StringBuilder operacion = new StringBuilder();
    private int resultado;
    private int cantidadNumerosOperacion;

    public PreguntasMates() {
    }
    
    public PreguntasMates(String enunciado) {
        super(enunciado);
    }

    public void generarPreguntaMates() {
        generarOperacion();
        calcularResultado();
        mostrarPreguntaYOperacion();
    }

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

    private void mostrarPreguntaYOperacion() {
        System.out.println("Pregunta: " + getEnunciado()); // Mostrar enunciado
        System.out.println("Operación: " + operacion.toString()); // Mostrar la operación
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
    
    public int respuestaMatesCPU(){
        return resultado;
    }
}
