package org.mp.sesion01.listareproduccion;

import java.text.ParseException;

public class CancionParser {

	public static Cancion parse(String datosCancion) throws ParseException {
		
		
		String[] informacionSeparada = datosCancion.split(";");
		
		if(informacionSeparada.length < 5) {
			throw new ParseException("No se ha introducido todos los datos necesarios", 0);
		}
		
		if(!informacionSeparada[0].equalsIgnoreCase("CANCION")) {
			throw new ParseException("Se esperaba una ParseException al parsear datos invalidos.", 0);
		}
		
		String titulo = informacionSeparada[1];
		String artista = informacionSeparada[2];
		
		if(!informacionSeparada[3].matches("\\d+")) {
			throw new ParseException("Se esperaba una ParseException al parsear datos invalidos.", 0);
		}
		
		int duracion = Integer.parseInt(informacionSeparada[3]);
		String genero = informacionSeparada[4];
		
		Cancion song = new Cancion(titulo, artista, duracion, genero);
		
		return song;
	}
	
	
}
