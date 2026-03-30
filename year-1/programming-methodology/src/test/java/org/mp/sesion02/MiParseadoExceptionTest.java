package org.mp.sesion02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la excepción personalizada MiParseadoException.
 */
class MiParseadoExceptionTest {

	/**
	 * Prueba que la excepción se lance con el mensaje correcto.
	 */
	@Test
	void testMiParseadoExceptionMessage() {
		String expectedMessage = "Error de parseo personalizado";
		try {
			throw new MiParseadoException(expectedMessage);
			// fail("Debería haber lanzado MiParseadoException"); // En este caso el throw
			// es directo, pero mantenemos la lógica
		} catch (MiParseadoException exception) {
			assertEquals(expectedMessage, exception.getMessage());
		}
	}

	/**
	 * Prueba que la excepción se lance sin mensaje.
	 */
	@Test
	void testMiParseadoExceptionNoMessage() {
		try {
			throw new MiParseadoException(null);
		} catch (MiParseadoException exception) {
			assertNull(exception.getMessage());
		}
	}
}