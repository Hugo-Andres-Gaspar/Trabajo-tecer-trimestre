package juego;

import java.util.ArrayList;
import java.util.Objects;

public class Jugador {
	private String nombre;
	private int puntuacion;
	private static ArrayList<Jugador> listaJugadores = new ArrayList();

	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	public Jugador(String nombre, int puntuacion) {
		super();
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	public void comprobarJugador(Jugador jugador) {
		if (jugador.getListaJugadores().equals(jugador)) {
			System.out.println("Este jugador ya esta registrado");
		} else {
			System.out.println("Este jugador no esta registrado");
		}
	}

	public static void anyadirJugador(String nombre) {
		Jugador jugadorNuevo = new Jugador(nombre);
		if (listaJugadores.contains(jugadorNuevo)) {
			System.out.println("Este Jugador ya está registrado");
		} else {
			listaJugadores.add(jugadorNuevo);
			System.out.println("El Jugador " + "(" + nombre + ")" + " añadido correctamente");
		}
		System.out.println();
	}

	public static void eliminarJugador(String nombreBorrar) {
		boolean encontrado = false;
		for (Jugador jugador : listaJugadores) {
			if (jugador.getNombre().equals(nombreBorrar)) {
				encontrado = true;
				listaJugadores.remove(jugador);
				System.out.println("Se ha borrado con éxito al jugador " + "(" + nombreBorrar + ")");
				break;
			}
		}
		if (!encontrado) {
			System.out.println("El nombre " + "(" + nombreBorrar + ")" + " no esta registrado, no se puede borrar");
		}
		System.out.println();
	}

	public static void mostrarJugadores() {
		if (listaJugadores.isEmpty()) {
			System.out.println("No hay jugadores en la lista.");
		} else {
			System.out.println("Lista de jugadores:");
			for (Jugador jugador : listaJugadores) {
				System.out.println("Nombre: " + jugador.getNombre());
			}
		}
	}

	public static boolean elegirJugadorPorNombre(String nombre){
        boolean encontrado = false;
        for (Jugador jugador : listaJugadores) {
            if(jugador.getNombre().contains(nombre)){
                System.out.println(" " + jugador + " ");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se ha encontrado al jugador: " + nombre);
        }
        return encontrado;
    }

	public void anyadirPuntos() {
		puntuacion++;
	}

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
