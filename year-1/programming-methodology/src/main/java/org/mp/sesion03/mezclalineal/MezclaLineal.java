package org.mp.sesion03.mezclalineal;

import java.lang.reflect.Array;

/**
 * Clase que proporciona métodos para realizar la mezcla lineal de arrays.
 * Implementa algoritmos tanto para tipos primitivos (int) como para tipos genéricos.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class MezclaLineal {

    /**
     * Mezcla dos arrays de enteros ordenados en un único array ordenado.
     *
     * @param arr1 Primer array de enteros ordenado.
     * @param arr2 Segundo array de enteros ordenado.
     * @return Un nuevo array con los elementos de ambos mezclados y ordenados.
     */
    public static int[] mezclaLinealInt(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    /**
     * Mezcla dos arrays genéricos de tipos comparables en un único array ordenado.
     * Utiliza programación genérica posterior a Java 5.
     *
     * @param <T>  Tipo de los elementos que debe implementar la interfaz Comparable.
     * @param arr1 Primer array ordenado de tipo T.
     * @param arr2 Segundo array ordenado de tipo T.
     * @return Un nuevo array genérico con los elementos mezclados y ordenados.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] mezclaLinealGenericos(T[] arr1, T[] arr2) {
        T[] result = (T[]) Array.newInstance(arr1.getClass().getComponentType(), arr1.length + arr2.length);

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) <= 0) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}