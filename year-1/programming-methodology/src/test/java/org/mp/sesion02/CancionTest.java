package org.mp.sesion02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la clase Cancion.
 */
class CancionTest {

	/**
	 * Prueba el constructor y los getters de la clase Cancion.
	 */
	@Test
	void testCancionConstructorAndGetters() {
		Cancion cancion = new Cancion("Bohemian Rhapsody", 355);
		assertEquals("Bohemian Rhapsody", cancion.getTitulo());
		assertEquals(355, cancion.getDuracion());
	}

	/**
	 * Prueba el método toString de la clase Cancion.
	 */
	@Test
	void testCancionToString() {
		Cancion cancion = new Cancion("Stairway to Heaven", 482);
		assertEquals("Stairway to Heaven (482s)", cancion.toString());
	}

	/**
	 * Prueba con valores de duración cero.
	 */
	@Test
	void testCancionDuracionCero() {
		Cancion cancion = new Cancion("Cancion Corta", 0);
		assertEquals("Cancion Corta", cancion.getTitulo());
		assertEquals(0, cancion.getDuracion());
		assertEquals("Cancion Corta (0s)", cancion.toString());
	}

	/**
	 * Prueba con título vacío.
	 */
	@Test
	void testCancionTituloVacio() {
		Cancion cancion = new Cancion("", 120);
		assertEquals("", cancion.getTitulo());
		assertEquals(120, cancion.getDuracion());
		assertEquals(" (120s)", cancion.toString());
	}
}