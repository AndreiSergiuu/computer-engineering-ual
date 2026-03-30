package org.mp.sesion02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la aplicación principal GestionAlbumesApp. Captura la
 * salida de la consola para verificar el comportamiento del método main.
 */
class GestionAlbumesAppTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	/**
	 * Configura la captura de la salida estándar y de error antes de cada prueba.
	 */
	@BeforeEach
	void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	/**
	 * Restaura la salida estándar y de error después de cada prueba.
	 */
	@AfterEach
	void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	/**
	 * Prueba el método runApp para verificar que los álbumes se cargan y muestran
	 * correctamente. Se espera que la salida contenga información de los álbumes
	 * sin errores.
	 */
	@Test
	void testRunAppLoadsAndDisplaysAlbums() {
		// Ejecutar el método runApp con los datos predeterminados
		GestionAlbumesApp.runApp(FuenteDeDatos.DATOS_ALBUMES);

		// Verificar que no se impriman errores en la salida de error
		assertEquals("", errContent.toString(), "No se esperaban errores en System.err");

		// Verificar que la salida estándar contenga información de los álbumes
		String output = outContent.toString();
		assertTrue(output.contains("--- Álbumes cargados ---"));
		assertTrue(output.contains("ALBUM: El Mal Querer"));
		assertTrue(output.contains("ARTISTA: Rosalía"));
		assertTrue(output.contains("AÑO: 2018"));
		assertTrue(output.contains(" 1) Malamente (150s)"));
		assertTrue(output.contains("ALBUM: Un secreto al que gritar"));
		assertTrue(output.contains("ARTISTA: La La Love You"));
	}

	/**
	 * Prueba el método runApp con datos malformados para asegurar que se capturen
	 * las excepciones y se muestren mensajes de error apropiados.
	 */
	@Test
	void testRunAppHandlesParsingErrors() {
		String[] testAlbumData = { "ALBUM;Valido;Artista;2020", "INVALID_FORMAT", // Dato inválido
				"ALBUM;Otro Valido;Otro Artista;2021" };

		// Ejecutar el método runApp con los datos de prueba
		GestionAlbumesApp.runApp(testAlbumData);

		// Verificar que la salida de error contenga el mensaje de error de parseo
		String errorOutput = errContent.toString();
		assertTrue(errorOutput.contains("Error procesando línea 2: Formato de álbum inválido"));

		// Verificar que la salida estándar contenga los álbumes válidos pero no el
		// inválido
		String normalOutput = outContent.toString();
		assertTrue(normalOutput.contains("--- Álbumes cargados ---"));
		assertTrue(normalOutput.contains("ALBUM: Valido"));
		assertFalse(normalOutput.contains("INVALID_FORMAT")); // No debería aparecer como álbum cargado
		assertTrue(normalOutput.contains("ALBUM: Otro Valido"));
	}
}