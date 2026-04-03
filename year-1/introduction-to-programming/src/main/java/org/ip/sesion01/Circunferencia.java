package org.ip.sesion01;

import java.util.Scanner;

/**
 * Programa para el cálculo de propiedades geométricas de circunferencias y esferas.
 * Permite obtener el diámetro, perímetro, área y volumen a partir del radio.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 03-04-2026
 */
public class Circunferencia {

    public static void main(String[] args) {

        // Inicialización del flujo de entrada desde la consola.
        Scanner sc = new Scanner(System.in);

        System.out.print("Radio = ");
        double radius = sc.nextDouble();

        // Cálculos de la circunferencia.
        double diameter = 2 * radius;
        double perimeter = diameter * Math.PI;
        double area = Math.pow(radius, 2) * Math.PI;

        // Cálculos de la esfera.
        double sphereVolume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        double sphereArea = 4 * area;

        // Salida formateada.
        System.out.printf("Diámetro de la circunferencia = %.2f%n", diameter);
        System.out.printf("Perimetro de la circunferencia = %.3f%n", perimeter);
        System.out.printf("Area de la circunferencia = %.3f%n", area);
        System.out.printf("Volumen de la esfera = %.3f%n", sphereVolume);
        System.out.printf("Area de la esfera = %.3f%n", sphereArea);

        // Cierre del recurso Scanner para liberar el flujo de entrada.
        sc.close();


    }


}
