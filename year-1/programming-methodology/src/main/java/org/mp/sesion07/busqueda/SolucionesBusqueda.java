package org.mp.sesion07.busqueda;

import java.util.Arrays;

/**
 * Métodos estáticos para realizar búsquedas sobre un array genérico ordenado.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class SolucionesBusqueda {

    /**
     * Búsqueda lineal: recorre el array de izquierda a derecha.
     *
     * @param busqueda Problema de búsqueda con datos y elemento buscado.
     * @return Índice del elemento encontrado.
     * @throws ElementoNoEncontradoException Si el elemento no está en el array.
     */
    public static <T extends Comparable<T>> int busquedaLineal(Busqueda<T> busqueda)
            throws ElementoNoEncontradoException {
        T[] datos = busqueda.getDatos();
        T buscado = busqueda.getNumBuscado();
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].compareTo(buscado) == 0) return i;
        }
        throw new ElementoNoEncontradoException("Elemento no encontrado: " + buscado);
    }

    /**
     * Búsqueda binaria iterativa sobre el array ordenado.
     *
     * @param busqueda Problema de búsqueda con datos y elemento buscado.
     * @return Índice del elemento encontrado.
     * @throws ElementoNoEncontradoException Si el elemento no está en el array.
     */
    public static <T extends Comparable<T>> int busquedaBinariaIter(Busqueda<T> busqueda)
            throws ElementoNoEncontradoException {
        T[] datos = busqueda.getDatos();
        T buscado = busqueda.getNumBuscado();
        int inicio = 0, fin = datos.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int cmp = datos[medio].compareTo(buscado);
            if (cmp == 0) return medio;
            if (cmp < 0) inicio = medio + 1;
            else fin = medio - 1;
        }
        throw new ElementoNoEncontradoException("Elemento no encontrado: " + buscado);
    }

    /**
     * Búsqueda binaria recursiva sobre el array ordenado.
     *
     * @param busqueda Problema de búsqueda con datos y elemento buscado.
     * @return Índice del elemento encontrado.
     * @throws ElementoNoEncontradoException Si el elemento no está en el array.
     */
    public static <T extends Comparable<T>> int busquedaBinariaRec(Busqueda<T> busqueda)
            throws ElementoNoEncontradoException {
        int resultado = busquedaBinariaRec(busqueda.getDatos(), busqueda.getNumBuscado(), 0, busqueda.getDatos().length - 1);
        if (resultado < 0) throw new ElementoNoEncontradoException("Elemento no encontrado: " + busqueda.getNumBuscado());
        return resultado;
    }

    /**
     * Búsqueda usando {@link Arrays#binarySearch}.
     *
     * @param busqueda Problema de búsqueda con datos y elemento buscado.
     * @return Índice del elemento, o valor negativo si no se encuentra.
     */
    public static <T extends Comparable<T>> int busquedaArraysBinarySearch(Busqueda<T> busqueda) {
        return Arrays.binarySearch(busqueda.getDatos(), busqueda.getNumBuscado());
    }

    // -------------------------------------------------------------------------

    private static <T extends Comparable<T>> int busquedaBinariaRec(T[] datos, T buscado, int inicio, int fin) {
        if (inicio > fin) return -1;
        int medio = (inicio + fin) / 2;
        int cmp = datos[medio].compareTo(buscado);
        if (cmp == 0) return medio;
        if (cmp < 0) return busquedaBinariaRec(datos, buscado, medio + 1, fin);
        return busquedaBinariaRec(datos, buscado, inicio, medio - 1);
    }
}