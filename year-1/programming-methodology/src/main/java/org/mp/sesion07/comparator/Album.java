package org.mp.sesion07.comparator;

/**
 * Representa un álbum musical con artista, nombre, año y ventas.
 * El orden natural es por año de lanzamiento.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Album implements Comparable<Album> {

    private String nombre;
    private String artista;
    private int anyo;
    private long ventas;

    /**
     * @param nombre  Nombre del álbum.
     * @param artista Nombre del artista.
     * @param anyo    Año de lanzamiento.
     * @param ventas  Unidades vendidas.
     */
    public Album(String artista, String nombre, int anyo, long ventas) {
        this.nombre  = nombre;
        this.artista = artista;
        this.anyo    = anyo;
        this.ventas  = ventas;
    }

    /** @return Nombre del álbum. */
    public String getNombre()  { return nombre; }

    /** @return Nombre del artista. */
    public String getArtista() { return artista; }

    /** @return Año de lanzamiento. */
    public int getAnyo()       { return anyo; }

    /** @return Unidades vendidas. */
    public long getVentas()    { return ventas; }

    /** Orden natural por año. */
    @Override
    public int compareTo(Album otro) {
        return Integer.compare(this.anyo, otro.anyo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album a = (Album) o;
        return anyo == a.anyo && ventas == a.ventas &&
                nombre.equals(a.nombre) && artista.equals(a.artista);
    }

    @Override
    public String toString() {
        return artista + " - " + nombre + " (" + anyo + ") [" + ventas + "]";
    }
}