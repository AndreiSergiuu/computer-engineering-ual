package org.mp.sesion03.pares;

/**
 * Clase genérica que representa un par de objetos.
 * Permite almacenar dos elementos de tipos distintos.
 *
 * @param <K> Tipo del primer elemento del par
 * @param <V> Tipo del segundo elemento del par
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class Par<K, V> {

    private K primero;
    private V segundo;

    /**
     * Constructor para inicializar el par con dos objetos.
     *
     * @param primero Primer elemento.
     * @param segundo Segundo elemento.
     */
    public Par(K primero, V segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    /**
     * @return El primer elemento del par.
     */
    public K getPrimero() {
        return primero;
    }

    /**
     * @return El segundo elemento del par.
     */
    public V getSegundo() {
        return segundo;
    }

    /**
     * Representación textual del par en formato (K, V)
     *
     * @return Cadena de caracteres formateada.
     */
    public String toString() {
        return "(" + this.primero + ", " + this.segundo + ")";
    }
}
