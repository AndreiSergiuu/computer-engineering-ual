package org.ip.sesion04;

import java.util.Scanner;

public class ArrayUnidimensional {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: ArrayUnidimensional
         * Autor: Andrei Sergiu Creata
         *
         * Enunciado: Programa que gestiona un array de números enteros mediante
         * un menú con las siguientes opciones:
         * 1. Introducir array (validando orden ascendente).
         * 2. Visualizar array.
         * 3. Invertir array (de ascendente a descendente y viceversa).
         * 4. Mostrar mayor y menor.
         * 5. Salir.
         *************************************************************************/

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        int[] numbers = null;

        while (isRunning) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Introducir array (ascendente)");
            System.out.println("2. Visualizar el array");
            System.out.println("3. Invertir el array");
            System.out.println("4. Mostrar mayor y menor");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debes introducir un número.");
                scanner.next();
                continue;
            }

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nIntroduce la longitud del array: ");
                    int size = scanner.nextInt();

                    if (size <= 0) {
                        System.out.println("Error: La longitud debe ser mayor que 0.");
                        break;
                    }

                    numbers = new int[size];

                    for (int i = 0; i < size; i++) {
                        boolean isValid = false;

                        while (!isValid) {
                            System.out.print("Introduce el número " + (i + 1) + ": ");
                            int input = scanner.nextInt();

                            if (i == 0 || input >= numbers[i - 1]) {
                                numbers[i] = input;
                                isValid = true;
                            } else {
                                System.out.println("Error: El número debe ser mayor o igual que " + numbers[i - 1]);
                            }
                        }
                    }
                    System.out.println("Array guardado correctamente.");
                    break;

                case 2:
                    if (numbers == null) {
                        System.out.println("Error: El array está vacío. Usa la opción 1 primero.");
                    } else {
                        System.out.print("Contenido del array: ");
                        for (int i = 0; i < numbers.length; i++) {
                            System.out.print(numbers[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (numbers == null) {
                        System.out.println("Error: El array está vacío. Usa la opción 1 primero.");
                    } else {
                        int limit = numbers.length / 2;
                        int lastIndex = numbers.length - 1;

                        for (int i = 0; i < limit; i++) {
                            int temp = numbers[i];
                            numbers[i] = numbers[lastIndex - i];
                            numbers[lastIndex - i] = temp;
                        }
                        System.out.println("El array se ha invertido correctamente.");
                    }
                    break;

                case 4:
                    if (numbers == null) {
                        System.out.println("Error: El array está vacío. Usa la opción 1 primero.");
                    } else {
                        int max = numbers[0];
                        int min = numbers[0];

                        for (int i = 1; i < numbers.length; i++) {
                            if (numbers[i] > max) {
                                max = numbers[i];
                            }
                            if (numbers[i] < min) {
                                min = numbers[i];
                            }
                        }
                        System.out.println("Valor mayor: " + max);
                        System.out.println("Valor menor: " + min);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}