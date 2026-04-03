package org.ip.sesion01;

/**
 * Resolución del ejercicio 6 de la Relación 1 sobre física cuántica.
 * Calcula el número de fotones emitidos por un puntero láser basándose
 * en su potencia, duración del pulso y longitud de onda.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 03-04-2026
 */
public class Relacion1Ej06 {
    public static void main(String[] args) {

        // Variables que almacenan los datos del láser.
        double laserPower = 1.0e-3;
        double pulseTime = 1.0;
        double waveLength = 660e-9;

        // Constantes fisicas.
        final double PLANCK_CONSTANT = 6.626e-34;
        final double LIGHT_SPEED = 3e8;

        // Cálculo de la energía de un fotón.
        double photonEnergy = PLANCK_CONSTANT * LIGHT_SPEED / waveLength;  // E = h * c / λ

        // Cálculo del número de fotones emitidos.
        double numberOfPhotons = laserPower * pulseTime / photonEnergy;  // N = P * t / E

        // Bloque de salida de información por consola.
        System.out.println("Solución al ejercicio del puntero láser: LaserPhotonCount");
        System.out.println("======================");
        System.out.println("ENUNCIADO:");
        System.out.println("Un puntero láser de 1.0 mW de potencia emite fotones de 660 nm de longitud de onda.\n"
                + "Si emitimos un pulso de luz durante 1.0 segundo, calcular cuántos fotones se han emitido.");
        System.out.println("======================");
        System.out.println("DATOS:");
        System.out.printf("Potencia del láser = %.1e W%n", laserPower);
        System.out.printf("Duración del pulso = %.1f s%n", pulseTime);
        System.out.printf("Longitud de onda   = %.0f nm%n", (waveLength * 1e9));
        System.out.println("======================");
        System.out.println("SOLUCIÓN:");
        System.out.printf("Energía de un fotón = %.3e J%n", photonEnergy);
        System.out.printf("Número de fotones emitidos = %.3e%n", numberOfPhotons);
        System.out.println("======================");
    }
}
