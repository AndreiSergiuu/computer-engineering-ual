package org.mp.sesion07.comparator;

/**
 * Representa una canción con artista, título y duración en segundos.
 * El orden natural es por título (alfabéticamente).
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Cancion implements Comparable<Cancion> {

    private String artista;
    private String titulo;
    private int duracion;

    /**
     * @param artista  Nombre del artista.
     * @param titulo   Título de la canción.
     * @param duracion Duración en segundos.
     */
    public Cancion(String artista, String titulo, int duracion) {
        this.artista  = artista;
        this.titulo   = titulo;
        this.duracion = duracion;
    }

    /** @return Nombre del artista. */
    public String getArtista()  { return artista; }

    /** @return Título de la canción. */
    public String getTitulo()   { return titulo; }

    /** @return Duración en segundos. */
    public int getDuracion()    { return duracion; }

    /** Orden natural por título. */
    @Override
    public int compareTo(Cancion otra) {
        return this.titulo.compareTo(otra.titulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cancion)) return false;
        Cancion c = (Cancion) o;
        return duracion == c.duracion &&
                artista.equals(c.artista) &&
                titulo.equals(c.titulo);
    }

    @Override
    public String toString() {
        return artista + " - " + titulo + " (" + duracion + "s)";
    }
}