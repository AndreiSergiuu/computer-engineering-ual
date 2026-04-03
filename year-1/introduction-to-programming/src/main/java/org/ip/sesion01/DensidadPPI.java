package org.ip.sesion01;

/**
 * Programa para el cálculo de la densidad de píxeles por pulgada (PPI).
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 03-04-2026
 */
public class DensidadPPI {
    public static void main(String[] args) {
        // Variables que almacenan la resolución, tamaño diagonal y PPI.
        int resolutionWidth = -1;
        int resolutionHeight = -1;
        double diagonalSize = -1;
        double ppi = -1;

        // Monitor Full HD 27 Pulgadas.
        resolutionWidth = 1920;
        resolutionHeight = 1080;
        diagonalSize = 27;

        ppi = Math.sqrt(Math.pow(resolutionWidth, 2) + Math.pow(resolutionHeight, 2)) / diagonalSize;
        System.out.printf("La densidad de PPI del monitor Full HD de 27 pulgadas es: %.2f PPI\n", ppi);

        // Monitor 4K de 32 pulgadas.
        resolutionWidth = 3840;
        resolutionHeight = 2160;
        diagonalSize = 32;

        ppi = Math.sqrt(Math.pow(resolutionWidth, 2) + Math.pow(resolutionHeight, 2)) / diagonalSize;
        System.out.printf("La densidad de PPI del monitor 4K de 32 pulgadas es: %.2f PPI%n", ppi);

        // Dispositivo Movil 6.5 Pulgadas.
        resolutionWidth = 2340;
        resolutionHeight = 1080;
        diagonalSize = 6.5;

        ppi = Math.sqrt(Math.pow(resolutionWidth, 2) + Math.pow(resolutionHeight, 2)) / diagonalSize;
        System.out.printf("La densidad de PPI del dispositivo móvil de 6.5 pulgadas es: %.2f PPI%n", ppi);
    }
}
