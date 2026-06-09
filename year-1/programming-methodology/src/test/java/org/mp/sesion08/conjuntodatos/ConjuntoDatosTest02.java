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

public class ConjuntoDatosTest02 {

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

		String ficheroPrueba = directorioEntrada + "archivoPruebaCanciones.txt";
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ficheroPrueba)))) {
    		pw.println("Artista;Cancion;Reproducciones;Duracion");
    		pw.println("The Beatles;Yesterday;1200.5;125");
    		pw.println("Queen;Bohemian Rhapsody;2500.0;354");
    		pw.println("Pink Floyd;Time;950.8;421");
    		pw.println("Led Zeppelin;Stairway to Heaven;2100.3;482");
    		pw.println("Nirvana;Smells Like Teen Spirit;1800.4;301");
    		pw.println("Radiohead;Creep;1100.2;238");
    		pw.println("Michael Jackson;Thriller;3000.1;357");
    		pw.println("AC/DC;Back in Black;2200.0;255");
    		pw.println("Eagles;Hotel California;1900.5;390");
    		pw.println("U2;With or Without You;1400.8;296");
		}

		archivoTexto = ficheroPrueba;
		File file = new File(archivoTexto);
		cd = new ConjuntoDatos(file, ";", new Locale("en", "US"));
	}

	@Test
	public void testBasico() throws Exception {
		assertEquals(archivoTexto, cd.getArchivoTexto().getAbsolutePath());
		assertEquals(4, cd.getNumeroColumnas());
		assertEquals(10, cd.getNumeroLineas());
		assertEquals(";", cd.getSeparador());

		ArrayList<String> cabecera = cd.getCabecera();
		assertEquals(4, cabecera.size());
		assertEquals("Artista", cabecera.get(0));
		assertEquals("Cancion", cabecera.get(1));
		assertEquals("Reproducciones", cabecera.get(2));
		assertEquals("Duracion", cabecera.get(3));

		String[][] datos = cd.getDatosString();
		assertEquals("The Beatles", datos[0][0]);
		assertEquals("Yesterday", datos[0][1]);
		assertEquals("U2", datos[9][0]);
		assertEquals("296", datos[9][3]);
	}

	@Test
	public void testGetColumnaIndice() {
		// Columna Artista (Indice 0)
		String[] artistas = cd.getColumna(0);
		assertEquals(10, artistas.length);
		assertEquals("The Beatles", artistas[0]);
		assertEquals("Queen", artistas[1]);
		assertEquals("U2", artistas[9]);

		// Columna Duracion (Indice 3)
		String[] duraciones = cd.getColumna(3);
		assertEquals("125", duraciones[0]);
		assertEquals("354", duraciones[1]);
		assertEquals("296", duraciones[9]);

		try {
			cd.getColumna(4);
			fail("Debería haber lanzado ArrayIndexOutOfBoundsException");
		} catch (ArrayIndexOutOfBoundsException e) {
			// Éxito
		}
	}

	@Test
	public void testGetColumnaString() {
		String[] canciones = cd.getColumna("Cancion");
		assertNotNull(canciones);
		assertEquals("Yesterday", canciones[0]);
		assertEquals("Bohemian Rhapsody", canciones[1]);
		assertEquals("With or Without You", canciones[9]);

		String[] inexistente = cd.getColumna("Precio");
		assertNull(inexistente);
	}

	@Test
	public void testExportar() throws Exception {
		String archivoSalida = directorioEntrada + "archivoPruebaCancionesReducido.txt";
		String[] cabeceraReducida = { "Artista", "Cancion" };
		cd.exportar(cabeceraReducida, archivoSalida, ";");
		
		ConjuntoDatos cdReducido = new ConjuntoDatos(new File(archivoSalida), ";", new Locale("en", "US"));
		assertEquals(2, cdReducido.getNumeroColumnas());
		assertEquals(10, cdReducido.getNumeroLineas());
		
		assertEquals("Artista", cdReducido.getCabecera().get(0));
		assertEquals("The Beatles", cdReducido.getColumna(0)[0]);
		assertEquals("Yesterday", cdReducido.getColumna(1)[0]);
	}
}
