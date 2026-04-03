package org.ip.sesion01;

/**
 * Programa para la generación y visualización de números enteros aleatorios.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 03-04-2026
 */
public class EnteroAleatorio {
    public static void main(String[] args) {

        // Valores mínimo y máximo del rango.
        int minValue = -15;
        int maxValue = 15;

        System.out.println("Generando 5 números enteros aleatorios entre " + minValue + " y " + maxValue + "...\n");

        // Bucle que genera e imprime 5 enteros aleatorios en el rango [minValue, maxValue].
        for (int i = 0; i < 5; i++) {
            int randomInteger = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
            System.out.printf("(%d) Número Generado: %d%n", (i + 1), randomInteger);
        }

    }
}
