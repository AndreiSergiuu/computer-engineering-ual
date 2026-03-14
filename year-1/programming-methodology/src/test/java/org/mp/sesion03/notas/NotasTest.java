package org.mp.sesion03.notas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la clase Notas.
 */
class NotasTest {

	@Test
	void testConstructorValidCapacity() {
		Notas notas = new Notas(5);
		assertNotNull(notas);
		assertEquals(0, notas.getNumeroNotas());
	}

	@Test
	void testConstructorInvalidCapacity() {
		try {
			new Notas(0);
			fail("Se esperaba IllegalArgumentException para capacidad 0");
		} catch (IllegalArgumentException e) {
			assertEquals("La capacidad mÃ¡xima debe ser un nÃºmero positivo.", e.getMessage());
		}
		try {
			new Notas(-1);
			fail("Se esperaba IllegalArgumentException para capacidad negativa");
		} catch (IllegalArgumentException e) {
			assertEquals("La capacidad mÃ¡xima debe ser un nÃºmero positivo.", e.getMessage());
		}
	}

	@Test
	void testAgregarNota_Success() {
		Notas notas = new Notas(2);
		assertTrue(notas.agregarNota("alu001", 7.5));
		assertEquals(1, notas.getNumeroNotas());
		assertTrue(notas.agregarNota("alu002", 9.0));
		assertEquals(2, notas.getNumeroNotas());
	}

	@Test
	void testAgregarNota_AlumnoExistente() {
		Notas notas = new Notas(2);
		notas.agregarNota("alu001", 7.5);
		assertFalse(notas.agregarNota("alu001", 8.0)); // No deberÃ­a aÃ±adirla
		assertEquals(1, notas.getNumeroNotas());
	}

	@Test
	void testAgregarNota_CapacidadLlena() {
		Notas notas = new Notas(1);
		notas.agregarNota("alu001", 7.5);
		assertFalse(notas.agregarNota("alu002", 8.0)); // No deberÃ­a aÃ±adirla
		assertEquals(1, notas.getNumeroNotas());
	}

	@Test
	void testAgregarNota_NotaFueraDeRango() {
		Notas notas = new Notas(1);
		assertFalse(notas.agregarNota("alu001", 11.0));
		assertFalse(notas.agregarNota("alu001", -1.0));
		assertEquals(0, notas.getNumeroNotas());
	}

	@Test
	void testAgregarNota_DatosInvalidos() {
		Notas notas = new Notas(1);
		assertFalse(notas.agregarNota(null, 7.0));
		assertFalse(notas.agregarNota("", 7.0));
		assertFalse(notas.agregarNota("alu001", null));
		assertEquals(0, notas.getNumeroNotas());
	}

	@Test
	void testObtenerNota_Existente() {
		Notas notas = new Notas(2);
		notas.agregarNota("alu001", 7.5);
		notas.agregarNota("alu002", 9.0);
		assertEquals(7.5, notas.obtenerNota("alu001"));
		assertEquals(9.0, notas.obtenerNota("alu002"));
	}

	@Test
	void testObtenerNota_NoExistente() {
		Notas notas = new Notas(1);
		notas.agregarNota("alu001", 7.5);
		assertNull(notas.obtenerNota("alu002"));
	}

	@Test
	void testObtenerNota_DatosInvalidos() {
		Notas notas = new Notas(1);
		notas.agregarNota("alu001", 7.5);
		assertNull(notas.obtenerNota(null));
		assertNull(notas.obtenerNota(""));
	}

	@Test
	void testCalcularMedia_ConNotas() {
		Notas notas = new Notas(3);
		notas.agregarNota("alu001", 7.0);
		notas.agregarNota("alu002", 8.0);
		notas.agregarNota("alu003", 9.0);
		assertEquals(8.0, notas.calcularMedia(), 0.001); // Delta para doubles
	}

	@Test
	void testCalcularMedia_SinNotas() {
		Notas notas = new Notas(1);
		assertEquals(0.0, notas.calcularMedia(), 0.001);
	}

	@Test
	void testListarNotas_ConNotas() {
		Notas notas = new Notas(2);
		notas.agregarNota("alu001", 7.5);
		notas.agregarNota("alu002", 9.0);
		String expected = "Alumno: alu001, Nota: 7.5\nAlumno: alu002, Nota: 9.0\n";
		assertEquals(expected, notas.listarNotas());
	}

	@Test
	void testListarNotas_SinNotas() {
		Notas notas = new Notas(1);
		assertEquals("No hay calificaciones registradas.", notas.listarNotas());
	}
}