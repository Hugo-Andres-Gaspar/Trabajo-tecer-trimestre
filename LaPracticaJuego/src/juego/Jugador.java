package juego;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class Jugador {
	private String nombre;
	private int puntuacion;
	private static ArrayList<Jugador> listaJugadores = new ArrayList();

	/**
	 * Crea un nuevo jugador con el nombre especificado y una puntuación inicial de
	 * 0.
	 * 
	 * @param nombre el nombre del jugador
	 */
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	/**
	 * Crea un nuevo jugador con el nombre y la puntuación especificados.
	 * 
	 * @param nombre     el nombre del jugador
	 * @param puntuacion la puntuación del jugador
	 */
	public Jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}

	/**
	 * Comprueba si un jugador con el nombre especificado ya está registrado.
	 * 
	 * @param nombre el nombre del jugador a comprobar
	 * @return {@code true} si el jugador está registrado, {@code false} de lo
	 *         contrario
	 */
	public static boolean jugadorRegistrado(String nombre) {
		for (Jugador jugador : listaJugadores) {
			if (jugador.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Añade un nuevo jugador con el nombre especificado a la lista de jugadores.
	 * 
	 * @param nombre el nombre del jugador a añadir
	 */
	public static void anyadirJugador(String nombre) {
		if (jugadorRegistrado(nombre)) {
			System.out.println("Este jugador ya está registrado.");
		} else {
			listaJugadores.add(new Jugador(nombre));
			System.out.println("El jugador '" + nombre + "' ha sido añadido correctamente.");
		}
	}

	/**
	 * Elimina un jugador con el nombre especificado de la lista de jugadores.
	 * 
	 * @param nombreBorrar el nombre del jugador a eliminar
	 */
	public static void eliminarJugador(String nombreBorrar) {
		for (Jugador jugador : listaJugadores) {
			if (jugador.getNombre().equals(nombreBorrar)) {
				listaJugadores.remove(jugador);
				System.out.println("Se ha eliminado al jugador '" + nombreBorrar + "' correctamente.");
				return;
			}
		}
		System.out.println("El jugador '" + nombreBorrar + "' no está registrado, no se puede eliminar.");
	}

	/**
	 * Muestra la lista de jugadores registrados.
	 */
	public static void mostrarJugadores() {
		if (listaJugadores.isEmpty()) {
			System.out.println("No hay jugadores en la lista.");
		} else {
			System.out.println("Lista de jugadores:");
			for (Jugador jugador : listaJugadores) {
				System.out.println("- " + jugador.getNombre());
			}
		}
	}
	/**
     * Comprueba si hay un jugador registrado con el nombre especificado y lo muestra por consola si se encuentra.
     * 
     * @param nombre el nombre del jugador a buscar
     * @return {@code true} si se encuentra el jugador, {@code false} de lo contrario
     */
	public static boolean elegirJugadorPorNombre(String nombre) {
		boolean encontrado = false;
		for (Jugador jugador : listaJugadores) {
			if (jugador.getNombre().contains(nombre)) {
				System.out.println(" " + jugador + " ");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No se ha encontrado al jugador: " + nombre);
		}
		return encontrado;
	}
	/**
     * Añade un punto a la puntuación del jugador.
     */
	public void anyadirPuntos() {
		puntuacion++;
	}
	/**
     * Devuelve la lista de jugadores.
     * 
     * @return la lista de jugadores
     */
	public static ArrayList<Jugador> obtenerJugadoresDeLaPartida() {
		return listaJugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	@Override
	public String toString() {
		return "Jugador: " + nombre + " tiene una puntuacion de: " + puntuacion + ".";
	}

	public void imprimirJugador() {
		System.out.println(toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
