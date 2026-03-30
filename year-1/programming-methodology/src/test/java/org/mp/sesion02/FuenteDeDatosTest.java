package org.mp.sesion02;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la clase FuenteDeDatos.
 */
class FuenteDeDatosTest {

	/**
	 * Prueba que el array DATOS_ALBUMES no sea nulo y no esté vacío.
	 */
	@Test
	void testDatosAlbumesIsNotEmpty() {
		assertNotNull(FuenteDeDatos.DATOS_ALBUMES);
		assertTrue(FuenteDeDatos.DATOS_ALBUMES.length > 0);
	}

	/**
	 * Prueba el contenido de algunos elementos del array DATOS_ALBUMES.
	 */
	@Test
	void testDatosAlbumesContent() {
		// Verifica que al menos un elemento conocido esté presente y tenga el formato
		// esperado
		String firstAlbumData = FuenteDeDatos.DATOS_ALBUMES[0];
		assertTrue(firstAlbumData.startsWith("ALBUM;"));
		assertTrue(firstAlbumData.contains(";El Mal Querer;Rosalía;2018;"));
		assertTrue(firstAlbumData.contains(";CANCION;Malamente;150;CANCION;Pienso en tu mirá;193"));
	}
}