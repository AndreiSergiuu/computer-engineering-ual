package org.mp.sesion03.mezclalineal;

import java.util.Arrays;

public class MezclaLinealApp {

    // Método main para probar los métodos
    public static void main(String[] args) {
        int[] arr1Int = {1, 3, 5, 7, 9};
        int[] arr2Int = {2, 4, 6, 8, 10};

        String[] arr1Genericos = {"a", "c", "e", "g", "i"};
        String[] arr2Genericos = {"b", "d", "f", "h", "j"};

        // Probando el método mezclaLinealInt
        int[] resultadoInt = MezclaLineal.mezclaLinealInt(arr1Int, arr2Int);
        System.out.println("Mezcla Lineal con enteros: " + Arrays.toString(resultadoInt));

        // Probando el método mezclaLinealGenericos
        //String[] resultadoGenericos = MezclaLineal.mezclaLinealGenericos(arr1Genericos, arr2Genericos);
        Comparable[] resultadoGenericos = MezclaLineal.mezclaLinealGenericos(arr1Genericos, arr2Genericos);

        //String[] resultadoGenericos = MezclaLineal.<String>mezclaLinealGenericos(arr1Genericos, arr2Genericos);

        System.out.println("Mezcla Lineal con objetos genéricos: " + Arrays.toString(resultadoGenericos));
    }

}