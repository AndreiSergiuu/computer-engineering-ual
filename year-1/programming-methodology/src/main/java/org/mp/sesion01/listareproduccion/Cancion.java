package org.mp.sesion01.listareproduccion;

public class Cancion implements Comparable<Cancion> {

	private String titulo;
	private String artista;
	private int duracion;
	private String genero;
	
	public Cancion(String titulo, String artista, int duracion, String genero) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.genero = genero;
	}
	
	
	
	@Override
	public String toString() {
		return "Cancion [titulo = " + this.titulo + ", artista=" + this.artista + ", duracion=" + this.duracion + "s, genero=" + this.genero + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Cancion c = (Cancion) obj;
		
		return this.titulo.equalsIgnoreCase(c.titulo) && this.artista.equalsIgnoreCase(c.artista);
	}
	
	@Override
	public int compareTo(Cancion o) {
		
		int resultado = Integer.compare(this.duracion, o.duracion);
		
		if (resultado == 0) {
			resultado = this.titulo.compareToIgnoreCase(o.titulo);
		}
		
		return resultado;
		
	}
	
	

	
}
