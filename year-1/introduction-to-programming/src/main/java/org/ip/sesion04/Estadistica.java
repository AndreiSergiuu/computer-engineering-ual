package org.ip.sesion04;

import java.util.Scanner;

public class Estadistica {

    public static void main(String[] args) {

        /*************************************************************************
         * Programa: Estadistica
         * Autor: Andrei Sergiu Creata
         *
         * Enunciado: Programa que gestiona un array de números decimales (double)
         * mediante un menú, permitiendo su carga (manual o aleatoria) y el
         * cálculo de parámetros estadísticos básicos.
         *
         * Funcionalidades:
         * - Cargar datos aleatorios (Enteros entre 0 y 20)
         * - Cargar datos manualmente
         * - Visualizar datos
         * - Calcular: Media, Varianza, Desviación Estándar y Moda
         *
         * Fórmulas utilizadas:
         * - Media = (Σ x_i) / n
         * - Varianza = Σ (x_i - Media)^2 / n
         * - Desviación Estándar = √Varianza
         * - Moda = Valor que aparece con mayor frecuencia
         *
         *************************************************************************/

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        double[] numbers = null;

        while (isRunning) {
            System.out.println("\nMenú:");
            System.out.println("1. Cargar datos aleatorios");
            System.out.println("2. Cargar datos manualmente");
            System.out.println("3. Visualizar datos");
            System.out.println("4. Operaciones a realizar");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nIntroduzca el tamaño del array para datos aleatorios: ");
                    int sizeRand = scanner.nextInt();

                    if (sizeRand <= 0) {
                        System.out.println("El tamaño introducido no es valido!");
                    } else {
                        numbers = new double[sizeRand];
                        for (int i = 0; i < sizeRand; i++) {
                            numbers[i] = (int) (Math.random() * 21);
                        }
                        System.out.println("Datos aleatorios generados correctamente.");
                    }
                    break;

                case 2:
                    System.out.print("\nIntroduzca el tamaño del array: ");
                    int arraySize = scanner.nextInt();

                    if (arraySize <= 0) {
                        System.out.println("El tamaño introducido no es valido!");
                    } else {
                        numbers = new double[arraySize];
                        for (int i = 0; i < arraySize; i++) {
                            System.out.print("Dato " + (i + 1) + ": ");
                            numbers[i] = scanner.nextDouble();
                        }
                        System.out.println("Datos introducidos correctamente");
                    }
                    break;

                case 3:
                    System.out.println("Datos actuales en el array: ");
                    if (numbers == null) {
                        System.out.println("El array se encuentra vacio!");
                    } else {
                        for (int i = 0; i < numbers.length; i++) {
                            System.out.println("Dato " + (i + 1) + ": " + numbers[i]);
                        }
                    }
                    break;

                case 4:
                    if (numbers == null) {
                        System.out.println("El array se encuentra vacio!");
                        break;
                    }

                    boolean operations = true;

                    while (operations) {
                        System.out.println("\nOperaciones a realizar:");
                        System.out.println("1. Calcular la media");
                        System.out.println("2. Calcular la varianza");
                        System.out.println("3. Calcular la desviación estándar");
                        System.out.println("4. Calcular la moda");
                        System.out.println("5. Volver al menú anterior");
                        System.out.print("Seleccione una opción: ");

                        if (!scanner.hasNextInt()) {
                            scanner.next();
                            continue;
                        }
                        int operationOption = scanner.nextInt();

                        switch (operationOption) {
                            case 1: {
                                double sum = 0;
                                for (int i = 0; i < numbers.length; i++) {
                                    sum += numbers[i];
                                }
                                double mean = sum / numbers.length;
                                System.out.printf("Media: %.1f%n", mean);
                                break;
                            }

                            case 2: {
                                double sum = 0;
                                for (int i = 0; i < numbers.length; i++) {
                                    sum += numbers[i];
                                }
                                double mean = sum / numbers.length;

                                double sumSq = 0;
                                for (int i = 0; i < numbers.length; i++) {
                                    sumSq += Math.pow((numbers[i] - mean), 2);
                                }
                                double variance = sumSq / numbers.length;
                                System.out.printf("Varianza: %.2f%n", variance);
                                break;
                            }

                            case 3: {
                                double sum = 0;
                                for (int i = 0; i < numbers.length; i++) {
                                    sum += numbers[i];
                                }
                                double mean = sum / numbers.length;

                                double sumSq = 0;
                                for (int i = 0; i < numbers.length; i++) {
                                    sumSq += Math.pow((numbers[i] - mean), 2);
                                }
                                double variance = sumSq / numbers.length;
                                double stdDev = Math.sqrt(variance);

                                System.out.println("Desviación Estándar: " + stdDev);
                                break;
                            }

                            case 4: {
                                double mode = numbers[0];
                                int maxCount = 0;

                                for (int i = 0; i < numbers.length; i++) {
                                    int count = 0;
                                    for (int j = 0; j < numbers.length; j++) {
                                        if (numbers[j] == numbers[i]) {
                                            count++;
                                        }
                                    }
                                    if (count > maxCount) {
                                        maxCount = count;
                                        mode = numbers[i];
                                    }
                                }
                                System.out.println("Moda: " + mode);
                                break;
                            }

                            case 5:
                                operations = false;
                                break;

                            default:
                                System.out.println("Opción no válida.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}