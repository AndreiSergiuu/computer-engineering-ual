package org.mp.sesion02;

/**
 * Representa una canción con un título y una duración determinada. Esta clase
 * se utiliza para gestionar información básica de pistas musicales.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class Cancion {

    private String titulo;
    private int duracion;

    /**
     * Constructor para crear una nueva canción con título y duración.
     *
     * @param titulo   El nombre de la canción.
     * @param duracion La duración en segundos.
     */
    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    /**
     * Obtiene el título de la canción.
     *
     * @return El título actual.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un nuevo título para la canción.
     *
     * @param titulo El nuevo título a asignar.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la duración de la canción.
     *
     * @return La duración en segundos.
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece una nueva duración para la canción.
     *
     * @param duracion La nueva duración en segundos.
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Devuelve una representación en formato de cadena de la canción.
     *
     * @return Una cadena con los datos de la canción.
     */
    @Override
    public String toString() {
        return this.titulo + " (" + this.duracion + "s)";
    }

}