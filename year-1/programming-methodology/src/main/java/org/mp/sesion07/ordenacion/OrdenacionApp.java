package org.mp.sesion07.ordenacion;

import java.util.Arrays;
import java.util.Random;

/**
 * Aplicación de demostración de los algoritmos de ordenación.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class OrdenacionApp {

    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(200) - 100;
        }

        System.out.println("Original:              " + Arrays.toString(array));

        Integer[] copia = array.clone();
        Ordenacion.ordenacionPorInsercion(copia);
        System.out.println("Inserción:             " + Arrays.toString(copia));

        copia = array.clone();
        Ordenacion.mergeSort(copia);
        System.out.println("MergeSort:             " + Arrays.toString(copia));

        copia = array.clone();
        Ordenacion.sort(copia);
        System.out.println("Arrays.sort:           " + Arrays.toString(copia));
    }
}