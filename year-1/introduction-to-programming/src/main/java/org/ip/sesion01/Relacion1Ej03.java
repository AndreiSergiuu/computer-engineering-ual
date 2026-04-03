package org.ip.sesion01;

/**
 * Resolución del ejercicio 3 de la Relación 1 sobre electromagnetismo.
 * Calcula la carga eléctrica total almacenada en un cilindro con densidad
 * de carga volumétrica homogénea.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 03-04-2026
 */
public class Relacion1Ej03 {
    public static void main(String[] args) {
        // Variables que almacenan los datos del cilindro.
        double cylinderHeight = 0.1;
        double cylinderRadius = 0.03;
        double volumeChargeDensity = 1e-6;

        // Variable que almacene el volumen del cilindro.
        double cylinderVolume = Math.PI * Math.pow(cylinderRadius, 2) * cylinderHeight;

        // Variable que almacena la carga total calculada.
        double totalCharge = (volumeChargeDensity * cylinderVolume);

        // Bloque de salida de información por consola.
        System.out.println("Solución al ejercicio 3 de la relación 1: Relación1Ej03");
        System.out.println("======================");
        System.out.println("ENUNCIADO:");
        System.out.println("Un cilindro de 10 cm de altura y radio de la base 3 cm tiene una densidad homogénea de\n"
                + "carga volumétrica de 1 μC m-3. Calcular la carga total que almacena");
        System.out.println("======================");
        System.out.println("DATOS:");
        System.out.printf("Altura = %.2f m%n", cylinderHeight);
        System.out.printf("Radio = %.2f m%n", cylinderRadius);
        System.out.printf("Densidad de carga = %.1E C/m^3%n", volumeChargeDensity);
        System.out.println("======================");
        System.out.println("SOLUCIÓN:");
        System.out.printf("La carga total almacenada es: %.15E C%n", totalCharge);
        System.out.println("======================");
    }
}
