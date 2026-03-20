package org.mp.sesion01.listareproduccion;

import java.text.ParseException;

public class GestionCancionesApp {

	public static void main(String[] args) throws ParseException {
		
		ListaDeReproduccion misfavoritas = new ListaDeReproduccion("Favoritos", FuenteDeDatos.DATOS_CANCIONES.length);
		
		for(String cancion : FuenteDeDatos.DATOS_CANCIONES) {
			
		Cancion nuevaCancion = CancionParser.parse(cancion);
		
		misfavoritas.agregarCancion(nuevaCancion);
			
			
		}
		
		misfavoritas.mostrarCanciones();
		
		misfavoritas.ordenarCanciones();
		
		misfavoritas.mostrarCanciones();
		
		
	}
	
}
