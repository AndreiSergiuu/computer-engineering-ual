package org.ip.sesion01;

public class Relacion1Ej06 {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: Relacion1Ej06
         * Autor: Andrei Sergiu Creata
         *
         * Enunciado: Un puntero láser de 1.0 mW de potencia emite fotones de
         * 660 nm de longitud de onda. Si emitimos un pulso de luz durante 1.0 s,
         * calcular cuántos fotones se han emitido.
         *
         * Fórmula:
         * E = h * c / λ
         * N = P * t / E
         *
         * Constantes:
         * h = 6.626e-34 J·s (constante de Planck)
         * c = 3e8 m/s (velocidad de la luz)
         *************************************************************************/

        // Variables que almacenan los datos del láser
        double laserPower = 1.0e-3;
        double pulseTime = 1.0;
        double waveLength = 660e-9;

        // Constantes fisicas
        final double PLANCK_CONSTANT = 6.626e-34;
        final double LIGHT_SPEED = 3e8;

        // Cálculo de la energía de un fotón
        double photonEnergy = PLANCK_CONSTANT * LIGHT_SPEED / waveLength; // E = h * c / λ

        // Cálculo del número de fotones emitidos
        double numberOfPhotons = laserPower * pulseTime / photonEnergy; // N = P * t / E

        // Mostrar resultados
        System.out.println("Solución al ejercicio del puntero láser: LaserPhotonCount");
        System.out.println("======================");
        System.out.println("ENUNCIADO:");
        System.out.println("Un puntero láser de 1.0 mW de potencia emite fotones de 660 nm de longitud de onda.\n"
                + "Si emitimos un pulso de luz durante 1.0 segundo, calcular cuántos fotones se han emitido.");
        System.out.println("======================");
        System.out.println("DATOS:");
        System.out.println("Potencia del láser = " + laserPower + " W");
        System.out.println("Duración del pulso = " + pulseTime + " s");
        System.out.println("Longitud de onda = " + (waveLength * 1e9) + " nm");
        System.out.println("======================");
        System.out.println("SOLUCIÓN:");
        System.out.printf("Energía de un fotón = %.3e J%n", photonEnergy);
        System.out.printf("Número de fotones emitidos = %.3e%n", numberOfPhotons);
        System.out.println("======================");

    }
}