package org.ip.sesion01;

public class Relacion1Ej03 {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: Relacion1Ej03
         * Autor: Andrei Sergiu Creata
         *
         * Enunciado: Un cilindro de 10 cm de altura y radio de la base 3 cm
         * tiene una densidad homogénea de carga volumétrica de 1 μC/m³.
         * Calcular la carga total que almacena.
         *
         * Datos:
         * Altura del cilindro: h = 10 cm = 0.10 m
         * Radio de la base: r = 3 cm = 0.03 m
         * Densidad de carga volumétrica: ρ = 1 μC/m³ = 1e-6 C/m³
         *
         * Fórmulas:
         * Volumen del cilindro: V = π * r^2 * h
         * Carga total: Q = ρ * V
         *
         *************************************************************************/

        // Variables que almacenan los datos del cilindro
        double cylinderHeight = 0.1;
        double cylinderRadius = 0.03;
        double volumeChargeDensity = 1e-6;

        // Variable que almacene el volumen del cilindro
        double cylinderVolume = Math.PI * Math.pow(cylinderRadius, 2) * cylinderHeight;

        // Variable que almacena la carga total calculada
        double totalCharge = (volumeChargeDensity * cylinderVolume);

        System.out.println("Solución al ejercicio 3 de la relación 1: Relación1Ej03");
        System.out.println("======================");
        System.out.println("ENUNCIADO:");
        System.out.println("Un cilindro de 10 cm de altura y radio de la base 3 cm tiene una densidad homogénea de\n"
                + "carga volumétrica de 1 μC m-3. Calcular la carga total que almacena");
        System.out.println("======================");
        System.out.println("DATOS:");
        System.out.println("Altura = " + cylinderHeight + " cm");
        System.out.println("Radio = " + cylinderRadius + " cm");
        System.out.println("Densidad de carga = " + volumeChargeDensity);
        System.out.println("======================");
        System.out.println("SOLUCIÓN:");
        System.out.printf("La carga total almacenada es: %.15E C%n", totalCharge);
        System.out.println("======================");

    }

}