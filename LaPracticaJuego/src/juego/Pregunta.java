package juego;

/**
 * @author [Hugo Andrés Gaspar]
 * @version 1.0
 */
public class Pregunta {
	/** El enunciado de la pregunta. */
	protected String enunciado;

	/**
	 * Crea una nueva instancia de {@code Pregunta} con un enunciado vacío.
	 */
	public Pregunta() {

	}

	/**
	 * Crea una nueva instancia de {@code Pregunta} con el enunciado especificado.
	 * 
	 * @param enunciado El enunciado de la pregunta.
	 */
	public Pregunta(String enunciado) {
		super();
		this.enunciado = enunciado;
	}

	/**
	 * Obtiene el enunciado de la pregunta.
	 * 
	 * @return El enunciado de la pregunta.
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * Establece el enunciado de la pregunta.
	 * 
	 * @param enunciado El nuevo enunciado de la pregunta.
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

}
