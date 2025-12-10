package org.ip.sesion01;

public class EnteroAleatorio {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: EnteroAleatorio
         * Autor: Andrei Sergiu Creata
         *
         *
         * Enunciado: Desarrolle un programa que muestre un número entero
         * pseudo-aleatorio comprendido entre -15 y 15. Pruebe distintas ejecuciones.
         *
         * Extra: He añadido que se muestren 5 numeros aleatorios por cada ejecución.
         *
         * Indicaciones:
         * - Utiliza el método random() de la clase Math.
         * - Tenga en cuenta que, dado un número aleatorio generado por random()
         * (0 <= aleatorio < 1.0), para conseguir un número entero entre M y N,
         * con M < N y ambos incluidos, se debe usar la siguiente fórmula:
         *
         * Valor Entero = ⎣ aleatorio * (N - M + 1) + M ⎦
         *
         *************************************************************************/

        // Valores mínimo y máximo del rango
        int minValue = -15;
        int maxValue = 15;

        System.out.println("Generando 5 números enteros aleatorios entre " + minValue + " y " + maxValue + "...\n");

        // Bucle que genera e imprime 5 enteros aleatorios en el rango [minValue,maxValue]
        for (int i = 0; i < 5; i++) {
            int randomInteger = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
            System.out.println((i + 1) + ") Número generado: " + randomInteger);
        }

    }

}