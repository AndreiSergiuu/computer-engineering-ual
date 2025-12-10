package org.ip.sesion01;

public class DensidadPPI {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: DensidadPPI
         * Autor: Andrei Sergiu Creata
         *
         * Enunciado: Desarrolle un programa que calcule y muestre la densidad
         * PPI (píxeles por pulgada) de varios dispositivos. La densidad PPI indica
         * cuántos píxeles hay en cada pulgada de pantalla.
         *
         * Fórmula:
         * PPI = √(ancho_resolucion^2 + alto_resolucion^2) / tamaño_diagonal
         *
         * Dispositivos a probar:
         * 1. Monitor Full HD de 27 pulgadas:
         * Resolución: 1920x1080 píxeles
         * Tamaño de la pantalla: 27 pulgadas
         *
         * 2. Monitor 4K de 32 pulgadas:
         * Resolución: 3840x2160 píxeles
         * Tamaño de la pantalla: 32 pulgadas
         *
         * 3. Dispositivo móvil de 6.5 pulgadas:
         * Resolución: 2340x1080 píxeles
         * Tamaño de la pantalla: 6.5 pulgadas
         *
         *************************************************************************/

        // Variables que almacenan la resolución, tamaño diagonal y PPI
        int resolutionWidth = -1;
        int resolutionHeight = -1;
        double diagonalSize = -1;
        double ppi = -1;

        // Monitor Full HD 27 Pulgadas
        resolutionWidth = 1920;
        resolutionHeight = 1080;
        diagonalSize = 27;

        ppi = Math.sqrt(Math.pow(resolutionWidth, 2) + Math.pow(resolutionHeight, 2)) / diagonalSize;
        System.out.printf("La densidad de PPI del monitor Full HD de 27 pulgadas es: %.2f PPI\n", ppi);

        // Monitor 4K de 32 pulgadas
        resolutionWidth = 3840;
        resolutionHeight = 2160;
        diagonalSize = 32;

        ppi = Math.sqrt(Math.pow(resolutionWidth, 2) + Math.pow(resolutionHeight, 2)) / diagonalSize;
        System.out.printf("La densidad de PPI del monitor Full HD de 27 pulgadas es: %.2f PPI\n", ppi);

        // Dispositivo Movil 6.5 Pulgadas
        resolutionWidth = 2340;
        resolutionHeight = 1080;
        diagonalSize = 6.5;

        ppi = Math.sqrt(Math.pow(resolutionWidth, 2) + Math.pow(resolutionHeight, 2)) / diagonalSize;
        System.out.printf("La densidad de PPI del monitor Full HD de 27 pulgadas es: %.2f PPI\n", ppi);

    }

}