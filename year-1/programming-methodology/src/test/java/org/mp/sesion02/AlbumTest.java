package org.mp.sesion02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la clase Album.
 */
class AlbumTest {

	/**
	 * Prueba el constructor y el método toString de la clase Album.
	 */
	@Test
	void testAlbumConstructorAndToString() {
		Album album = new Album("El Mal Querer", "Rosalía", 2018, 2);
		album.agregarCancion(new Cancion("Malamente", 150));
		album.agregarCancion(new Cancion("Pienso en tu mirá", 193));

		String expected = "ALBUM: El Mal Querer\n" + "ARTISTA: Rosalía		AÑO: 2018\n" + " 1) Malamente (150s)\n"
				+ " 2) Pienso en tu mirá (193s)\n";
		assertEquals(expected, album.toString());
	}

	/**
	 * Prueba el método equals de la clase Album.
	 */
	@Test
	void testAlbumEquals() {
		Album album1 = new Album("El Mal Querer", "Rosalía", 2018, 5);
		Album album2 = new Album("El Mal Querer", "Rosalía", 2018, 3); // Mismo título, artista, año
		Album album3 = new Album("Con Altura", "Rosalía", 2019, 1); // Diferente título
		Album album4 = new Album("El Mal Querer", "C. Tangana", 2018, 2); // Diferente artista
		Album album5 = new Album("El Mal Querer", "Rosalía", 2019, 2); // Diferente año

		assertEquals(album1, album2); // Deben ser iguales
		assertNotEquals(album1, album3);
		assertNotEquals(album1, album4);
		assertNotEquals(album1, album5);
	}

	/**
	 * Prueba el método compareTo de la clase Album.
	 */
	@Test
	void testAlbumCompareTo() {
		Album album1 = new Album("El Mal Querer", "Rosalía", 2018, 5);
		Album album2 = new Album("Con Altura", "Rosalía", 2019, 1);
		Album album3 = new Album("Aute Cuture", "Rosalía", 2018, 1); // Mismo año, título diferente

		// album1 (2018) debería ser menor que album2 (2019)
		assertTrue(album1.compareTo(album2) < 0);
		// album2 (2019) debería ser mayor que album1 (2018)
		assertTrue(album2.compareTo(album1) > 0);

		// Mismo año, compara por título: album3 "Aute Cuture" < album1 "El Mal Querer"
		assertTrue(album3.compareTo(album1) < 0);
		assertTrue(album1.compareTo(album3) > 0);

		// Comparar álbumes iguales
		Album album1Duplicate = new Album("El Mal Querer", "Rosalía", 2018, 5);
		assertEquals(0, album1.compareTo(album1Duplicate));
	}

	/**
	 * Prueba el método agregarCancion de la clase Album.
	 */
	@Test
	void testAgregarCancion() {
		Album album = new Album("Un Álbum", "Un Artista", 2020, 2);
		Cancion cancion1 = new Cancion("Cancion A", 100);
		Cancion cancion2 = new Cancion("Cancion B", 200);
		Cancion cancion3 = new Cancion("Cancion C", 300); // Excede la capacidad

		album.agregarCancion(cancion1);
		album.agregarCancion(cancion2);

		String expected = "ALBUM: Un Álbum\n" + "ARTISTA: Un Artista		AÑO: 2020\n" + " 1) Cancion A (100s)\n"
				+ " 2) Cancion B (200s)\n";
		assertEquals(expected, album.toString());

		// Intentar agregar una canción más allá de la capacidad
		album.agregarCancion(cancion3);
		assertEquals(expected, album.toString()); // El toString no debería cambiar, la canción3 no se agrega
	}
}