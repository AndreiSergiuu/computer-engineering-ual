package org.ip.sesion01;

public class Distancia {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: Distancia
         * Autor: Andrei Sergiu Creata
         *
         * Enunciado: Desarrolle un programa que muestre la distancia de un punto
         * (x, y) al origen (0, 0), donde x e y son enteros. Compruebe con distintas
         * ejecuciones las distancias.
         *
         * Indicaciones:
         * - Utilice variables de tipo int para x e y.
         * - Use los métodos Math.sqrt() y Math.pow() para el cálculo.
         * - Fórmula de distancia al origen: distancia = √(x^2 + y^2)
         *
         *************************************************************************/

        // Define el punto de referencia (origen)
        final int[] ORIGIN = {0, 0};

        // Array de puntos destino a los que calcular la distancia
        int[][] destinations = {{3, 4}, {5, 12}, {2, 1}};

        // Itera sobre cada punto destino
        for (int[] destination : destinations) {
            // Calcula la distancia entre el origen y el destino actual
            double distance = Math
                    .sqrt(Math.pow(destination[0] - ORIGIN[0], 2) + Math.pow(destination[1] - ORIGIN[1], 2));
            System.out.println("La distancia del punto (" + destination[0] + ", " + destination[1] + ") al punto ("
                    + ORIGIN[0] + ", " + ORIGIN[1] + ") es " + distance);
        }

    }

}