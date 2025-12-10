package org.ip.sesion01;

public class Circunferencia {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: Circunferencia
         * Autor: Andrei Sergiu Creata
         *
         * Enunciado: Dado el radio de una circunferencia, calcular:
         * - Longitud de la circunferencia
         * - Área del círculo
         * - Volumen de la esfera del mismo radio
         * - Área de la superficie de la esfera
         *
         * Fórmulas:
         * Longitud = 2 * π * r
         * Área del círculo = π * r^2
         * Volumen de la esfera = 4/3 * π * r^3
         * Área de la esfera = 4 * π * r^2
         *
         *************************************************************************/

        // Radio del círculo
        double radius = 4.57;

        // Cálculos de la circuferencia
        double diameter = radius * 2;
        double circumference = (2 * Math.PI * radius);
        double circleArea = Math.PI * Math.pow(radius, 2.0);

        // Cálculos de la esfera
        double shepereVolume = ((4.0 / 3.0) * Math.PI * Math.pow(radius, 3));
        double shepereArea = (4 * Math.PI * Math.pow(radius, 2.0));

        // Mostrar los resultados
        System.out.println("Radio = " + radius);
        System.out.println();
        System.out.printf("Diametro de la circuferencia = %.3f", diameter);
        System.out.println();
        System.out.printf("El perimetro de la circuferencia = %.3f", circumference);
        System.out.println();
        System.out.printf("El area de la circuferencia = %.3f", circleArea);
        System.out.println();
        System.out.printf("El volumen de la esfera =  %.3f", shepereVolume);
        System.out.println();
        System.out.printf("El area de la esfera es = %.3f\n", shepereArea);

    }

}
