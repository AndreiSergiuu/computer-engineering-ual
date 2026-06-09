package org.mp.sesion08.estadistica;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mp.sesion08.conjuntodatos.ConjuntoDatos;

public class EstadisticaTest {
	String directorioEntrada;
	ConjuntoDatos cd; 
	Estadistica estadistica;

	@BeforeEach
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") 
        		+ File.separator + "src"
        		+ File.separator + "main"
        		+ File.separator + "java"
                + File.separator + "org" 
        		+ File.separator + "mp"
                + File.separator + "sesion08" 
                + File.separator + "estadistica" 
        		+ File.separator;

		String canciones = directorioEntrada + "canciones.txt";
		File file = new File(canciones);
		cd = new ConjuntoDatos(file, ";", new Locale("en", "US"));
	    estadistica = new Estadistica(cd);
	}

	@Test
	public void testEstadisticasMusicales() throws Exception {
		assertEquals(2100.3, estadistica.max("Reproducciones"), 0.01);
		assertEquals(800.2, estadistica.min("Reproducciones"), 0.01);
		assertEquals(8352.2, estadistica.suma("Reproducciones"), 0.01);
		assertEquals(1392.03, estadistica.media("Reproducciones"), 0.01);
		
		assertEquals(482.0, estadistica.max("Duracion"), 0.01);
		assertEquals(125.0, estadistica.min("Duracion"), 0.01);
		assertEquals(296.62, estadistica.media("Duracion"), 0.01);
	}

	@Test
	public void testUsoApacheCommonsMath() {
		boolean usaLibreria = false;
		
		// Comprobamos si alguno de los métodos (aunque sean privados) utiliza tipos de Apache Commons Math
		java.lang.reflect.Method[] metodos = Estadistica.class.getDeclaredMethods();
		for (java.lang.reflect.Method metodo : metodos) {
			if (metodo.getReturnType().getName().contains("org.apache.commons.math3")) {
				usaLibreria = true;
			}
		}

		// Comprobamos también los atributos de la clase
		java.lang.reflect.Field[] campos = Estadistica.class.getDeclaredFields();
		for (java.lang.reflect.Field campo : campos) {
			if (campo.getType().getName().contains("org.apache.commons.math3")) {
				usaLibreria = true;
			}
		}

		assertTrue(usaLibreria, "La clase Estadistica debe importar y utilizar clases de org.apache.commons.math3");
	}
}
