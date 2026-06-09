package org.mp.sesion07.comparator;

/**
 * Colección de canciones almacenadas en un array.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Fonoteca {

    private String nombre;
    private Cancion[] canciones;

    /**
     * @param nombre    Nombre de la fonoteca.
     * @param canciones Array de canciones.
     */
    public Fonoteca(String nombre, Cancion[] canciones) {
        this.nombre    = nombre;
        this.canciones = canciones.clone();
    }

    /** @return Nombre de la fonoteca. */
    public String getNombre() { return nombre; }

    /** @return Copia del array de canciones. */
    public Cancion[] getCanciones() { return canciones.clone(); }
}