package org.mp.sesion07.ordenacion;

import java.util.Arrays;

/**
 * Algoritmos de ordenación genéricos sobre arrays de {@link Comparable}.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Ordenacion {

    /**
     * Ordena el array usando el algoritmo de inserción.
     *
     * @param array Array a ordenar; se modifica in-place.
     */
    public static <T extends Comparable<T>> void ordenacionPorInsercion(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T clave = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(clave) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = clave;
        }
    }

    /**
     * Ordena el array usando MergeSort (divide y vencerás).
     *
     * @param array Array a ordenar; se modifica in-place.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length <= 1) return;
        int mid = array.length / 2;
        T[] left  = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    /**
     * Ordena el array usando {@link Arrays#sort}.
     *
     * @param array Array a ordenar; se modifica in-place.
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        Arrays.sort(array);
    }

    // -------------------------------------------------------------------------

    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) array[k++] = left[i++];
            else array[k++] = right[j++];
        }
        while (i < left.length)  array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
}