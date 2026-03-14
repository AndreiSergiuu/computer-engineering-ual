package org.mp.sesion03.pares;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mp.sesion03.pares.Par;

/**
 * Clase de prueba para la clase genérica Par.
 */
class ParTest {

	@Test
	void testConstructorAndGetters() {
		Par<String, Integer> par1 = new Par<>("Edad", 30);
		assertEquals("Edad", par1.getPrimero());
		assertEquals(30, par1.getSegundo());

		Par<Double, Boolean> par2 = new Par<>(3.14, true);
		assertEquals(3.14, par2.getPrimero());
		assertTrue(par2.getSegundo());
	}

	@Test
	void testToString() {
		Par<String, String> par = new Par<>("Hola", "Mundo");
		assertEquals("(Hola, Mundo)", par.toString());

		Par<Integer, LocalDate> parFecha = new Par<>(1, LocalDate.of(2023, 1, 1));
		assertEquals("(1, 2023-01-01)", parFecha.toString());
	}

	@Test
	void testWithAcademicDomainExamples() {
		// Identificador de Alumno y Calificación
		Par<String, Double> calificacionAlumno = new Par<>("alu001", 8.75);
		assertEquals("alu001", calificacionAlumno.getPrimero());
		assertEquals(8.75, calificacionAlumno.getSegundo());

		// Asignatura y Créditos
		Par<String, Integer> asignaturaCreditos = new Par<>("Programación II", 6);
		assertEquals("Programación II", asignaturaCreditos.getPrimero());
		assertEquals(6, asignaturaCreditos.getSegundo());

		// Fecha y Asistencia
		Par<LocalDate, Integer> asistenciaClase = new Par<>(LocalDate.of(2026, 2, 10), 30);
		assertEquals(LocalDate.of(2026, 2, 10), asistenciaClase.getPrimero());
		assertEquals(30, asistenciaClase.getSegundo());
	}

	@Test
	void testNullValues() {
		Par<String, Integer> par = new Par<>(null, null);
		assertNull(par.getPrimero());
		assertNull(par.getSegundo());
		assertEquals("(null, null)", par.toString());
	}
}