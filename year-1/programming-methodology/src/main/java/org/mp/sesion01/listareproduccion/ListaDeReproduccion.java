package org.mp.sesion01.listareproduccion;

public class ListaDeReproduccion {

	private String nombre;
	private Cancion[] canciones;
	private int numCanciones;
	
	public ListaDeReproduccion(String nombre, int capacidadMaxima) {
		this.nombre = nombre;
		this.canciones = new Cancion[capacidadMaxima];
		this.numCanciones = 0;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public Cancion[] getCanciones() {
		return canciones;
	}



	public int getNumCanciones() {
		return numCanciones;
	}



	public void agregarCancion(Cancion c) {
		
		if(numCanciones < this.canciones.length) {
			canciones[numCanciones] = c;
			numCanciones++;
		}
		
	}
	
	public void mostrarCanciones() {
		System.out.println("--- Canciones creadas ---");
		for(Cancion c : canciones) {
			System.out.println(c.toString());
		}
	}
	
	public void ordenarCanciones() {
		for(int i = 0; i < numCanciones - 1; i++) {
			for(int j = 0; j < numCanciones - i - 1; j++) {
				if(this.canciones[j].compareTo(this.canciones[j + 1]) > 0) {
					Cancion temporal = this.canciones[j];
					this.canciones[j] = this.canciones[j + 1];
					this.canciones[j + 1] = temporal;
				}
			}
		}
	}
	
	
}
