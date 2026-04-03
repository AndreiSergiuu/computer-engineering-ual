package org.ip.sesion01;

/**
 * Programa para calcular la distancia euclídea entre un punto de origen y varios
 * puntos destino.
 *
 * @author Andrei Sergiu Creata
 * @since 03-04-2026
 * @since 1.0
 */
public class Distancia {
    public static void main(String[] args) {

        // Definición del punto de referencia (origen).
        final int[] ORIGIN = {0, 0};

        // Array de puntos destino a los que calcular la distancia.
        int[][] destinations = {{3, 4}, {5, 12}, {2, 1}};

        // Iteración sobre cada punto destino.
        for (int[] destination : destinations) {
            double distance = Math
                    .sqrt(Math.pow(destination[0] - ORIGIN[0], 2) + Math.pow(destination[1] - ORIGIN[1], 2));
            System.out.printf("La distancia del punto (" + destination[0] + ", " + destination[1] + ") al punto ("
                    + ORIGIN[0] + ", " + ORIGIN[1] + ") es %.2f%n", distance);
        }

    }
}
