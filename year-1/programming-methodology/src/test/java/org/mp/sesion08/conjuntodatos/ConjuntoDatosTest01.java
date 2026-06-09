package org.mp.sesion08.conjuntodatos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConjuntoDatosTest01 {

	String archivoTexto;
	String directorioEntrada;
	ConjuntoDatos cd;

	@BeforeEach
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "org" + File.separator + "mp" + File.separator + "sesion08" + File.separator
				+ "conjuntodatos" + File.separator;
		
		File dir = new File(directorioEntrada);
		if (!dir.exists()) dir.mkdirs();

		String ficheroPrueba = directorioEntrada + "archivoPrueba.txt";
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ficheroPrueba)))) {
    		pw.println("A;B;C");
    		pw.println("1.1;1.2;1.3");
    		pw.println("2.1;2.2;2.3");
    		pw.println("3.1;3.2;3.3");
		}

		archivoTexto = ficheroPrueba;
		File file = new File(archivoTexto);
		cd = new ConjuntoDatos(file, ";", new Locale("en", "US"));
	}

	@Test
	public void testBasico() throws Exception {
		assertEquals(archivoTexto, cd.getArchivoTexto().getAbsolutePath());
		assertEquals(3, cd.getNumeroColumnas());
		assertEquals(3, cd.getNumeroLineas());
		assertEquals(";", cd.getSeparador());
		assertEquals("US", cd.getLocale().getCountry());

		ArrayList<String> cabecera = cd.getCabecera();
		assertEquals(3, cabecera.size());
		assertEquals("A", cabecera.get(0));
		assertEquals("B", cabecera.get(1));
		assertEquals("C", cabecera.get(2));

		String[][] datos = cd.getDatosString();
		assertEquals("1.1", datos[0][0]);
		assertEquals("3.3", datos[2][2]);
	}

	@Test
	public void testGetColumnaIndice() {
		String[] columna0 = cd.getColumna(0);
		assertEquals("1.1", columna0[0]);
		assertEquals("2.1", columna0[1]);
		assertEquals("3.1", columna0[2]);

		String[] columna1 = cd.getColumna(1);
		assertEquals("1.2", columna1[0]);
		assertEquals("2.2", columna1[1]);
		assertEquals("3.2", columna1[2]);

		try {
			cd.getColumna(3);
			fail("Debería haber lanzado ArrayIndexOutOfBoundsException");
		} catch (ArrayIndexOutOfBoundsException e) {
			// Éxito
		}
	}

	@Test
	public void testGetColumnaString() {
		String[] columna0 = cd.getColumna("A");
		assertEquals("1.1", columna0[0]);
		assertEquals("2.1", columna0[1]);
		assertEquals("3.1", columna0[2]);

		String[] columnaD = cd.getColumna("D");
		assertNull(columnaD);
	}

	@Test
	public void testExportar() throws Exception {
		String archivoSalida = directorioEntrada + "archivoPruebaAB.txt";
		String[] cabeceraAB = { "A", "B" };
		cd.exportar(cabeceraAB, archivoSalida, ";");
		
		ConjuntoDatos cdAB = new ConjuntoDatos(new File(archivoSalida), ";", new Locale("en", "US"));
		ArrayList<String> cabecera = cdAB.getCabecera();

		assertEquals(2, cabecera.size());
		assertEquals("A", cabecera.get(0));
		assertEquals("B", cabecera.get(1));
		String[][] datos = cdAB.getDatosString();
		assertEquals("1.1", datos[0][0]);
		assertEquals("2.2", datos[1][1]);
	}
}
