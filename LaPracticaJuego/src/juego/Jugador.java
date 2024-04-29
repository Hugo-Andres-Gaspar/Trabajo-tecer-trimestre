package juego;

import java.util.ArrayList;
import java.util.Objects;

public class Jugador {
	private String nombre;
	private int puntuacion;
	private ArrayList<Jugador> listaJugadores;

	public Jugador(String nombre, int puntuacion) {
		super();
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.listaJugadores = new ArrayList();
	}

	public boolean anyadirJugador(Jugador jugador) {
		// Verifica si el jugador ya está en la lista
		if (listaJugadores.contains(jugador)) {
			System.out.println("El jugador ya existe en la lista.");
			return false; // No se puede añadir el jugador
		} else {
			// Agrega el jugador a la lista
			listaJugadores.add(jugador);
			System.out.println("Jugador añadido correctamente.");
			return true; // Jugador añadido con éxito
		}
	}

	public boolean eliminarJugador(Jugador jugador) {
		// Verifica si el jugador está en la lista
		if (listaJugadores.contains(jugador)) {
			// Elimina el jugador de la lista
			listaJugadores.remove(jugador);
			System.out.println("Jugador eliminado correctamente.");
			return true; // Jugador eliminado con éxito
		} else {
			System.out.println("El jugador no existe en la lista.");
			return false; // No se puede eliminar el jugador porque no está en la lista
		}
	}

	public void mostrarJugadores() {
		if (listaJugadores.isEmpty()) {
			System.out.println("No hay jugadores en la lista.");
		} else {
			System.out.println("Lista de jugadores:");
			for (Jugador jugador : listaJugadores) {
				System.out.println("Nombre: " + jugador.getNombre());
			}
		}
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
		return "Jugador:" + nombre + " tiene una puntuacion de:" + puntuacion + ".";
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
