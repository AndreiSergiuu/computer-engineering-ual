package org.mp.sesion04.list;

import org.mp.sesion04.list.arraylist.ArrayList;
import org.mp.sesion04.list.linkedlist.LinkedList;

import java.util.Random;

public class EvaluadorRendimientoListas {
    private static final int[] TAMANIOS_LISTA = {10000, 20000, 40000};
    private static final int NUMERO_OPERACIONES = 100;

    public static void main(String[] args) {
        evaluarRendimiento();
    }

    private static void evaluarRendimiento() {
        System.out.println("Evaluación de Rendimiento de ArrayList y LinkedList");
        System.out.println("org.mp.sesion04.list.arraylist.ArrayList");
        System.out.println("org.mp.sesion04.list.arraylist.LinkedList");
        System.out.println("===================================================");

        for (int tamanio : TAMANIOS_LISTA) {
            System.out.println("\nTamaño de la lista: " + tamanio);
            System.out.println("-------------------------------------------------------------------");

            double[] tiemposPromedioArrayList = new double[6];
            double[] tiemposPromedioLinkedList = new double[6];

            for (int i = 0; i < NUMERO_OPERACIONES; i++) {
                long[] tiemposArrayList = realizarOperaciones(new ArrayList<>(), tamanio);
                long[] tiemposLinkedList = realizarOperaciones(new LinkedList<>(), tamanio);

                for (int j = 0; j < tiemposArrayList.length; j++) {
                    tiemposPromedioArrayList[j] += tiemposArrayList[j];
                    tiemposPromedioLinkedList[j] += tiemposLinkedList[j];
                }
            }

            for (int j = 0; j < tiemposPromedioArrayList.length; j++) {
                tiemposPromedioArrayList[j] /= NUMERO_OPERACIONES;
                tiemposPromedioLinkedList[j] /= NUMERO_OPERACIONES;
                imprimirResultados(getNombreOperacion(j), tiemposPromedioArrayList[j], tiemposPromedioLinkedList[j]);
            }
        }
    }

    private static String getNombreOperacion(int indice) {
        switch (indice) {
            case 0:
                return "Agregar al principio";
            case 1:
                return "Agregar al final";
            case 2:
                return "Acceder aleatorio";
            case 3:
                return "Eliminar del principio";
            case 4:
                return "Eliminar del final";
            case 5:
                return "Eliminar aleatorio";
            default:
                return "";
        }
    }

    private static long[] realizarOperaciones(List<Integer> lista, int tamanio) {
        long[] tiempos = new long[6];
        Random random = new Random();

        // Llenar la lista con valores aleatorios
        for (int i = 0; i < tamanio; i++) {
            lista.add(random.nextInt());
        }

        for (int i = 0; i < NUMERO_OPERACIONES; i++) {
            tiempos[0] += agregarAlPrincipio(lista);
            tiempos[1] += agregarAlFinal(lista);
            tiempos[2] += accederAleatorio(lista, random);
            tiempos[3] += eliminarDelPrincipio(lista);
            tiempos[4] += eliminarDelFinal(lista);
            tiempos[5] += eliminarAleatorio(lista, random);
        }

        return tiempos;
    }

    private static long agregarAlPrincipio(List<Integer> lista) {
        long tiempoInicio = System.nanoTime();
        lista.add(0, 0);
        return System.nanoTime() - tiempoInicio;
    }

    private static long agregarAlFinal(List<Integer> lista) {
        long tiempoInicio = System.nanoTime();
        lista.add(lista.size(), 0);
        return System.nanoTime() - tiempoInicio;
    }

    private static long accederAleatorio(List<Integer> lista, Random random) {
        long tiempoInicio = System.nanoTime();
        int indice = random.nextInt(lista.size());
        lista.get(indice);
        return System.nanoTime() - tiempoInicio;
    }

    private static long eliminarDelPrincipio(List<Integer> lista) {
        long tiempoInicio = System.nanoTime();
        lista.remove(0);
        return System.nanoTime() - tiempoInicio;
    }

    private static long eliminarDelFinal(List<Integer> lista) {
        long tiempoInicio = System.nanoTime();
        lista.remove(lista.size() - 1);
        return System.nanoTime() - tiempoInicio;
    }

    private static long eliminarAleatorio(List<Integer> lista, Random random) {
        long tiempoInicio = System.nanoTime();
        int indice = random.nextInt(lista.size());
        lista.remove(indice);
        return System.nanoTime() - tiempoInicio;
    }

    private static void imprimirResultados(String operacion, double tAL, double tLL) {
        double max = Math.max(tAL, tLL);
        int anchoBarra = 30;

        System.out.println(operacion + ":");
        System.out.printf("  ArrayList:  %,15.0f ns [%s]%n", tAL, generarBarra(tAL, max, anchoBarra));
        System.out.printf("  LinkedList: %,15.0f ns [%s]%n", tLL, generarBarra(tLL, max, anchoBarra));
    }

    private static String generarBarra(double valor, double max, int ancho) {
        int numAsteriscos = (max == 0) ? 0 : (int) Math.round((valor / max) * ancho);
        if (valor > 0 && numAsteriscos == 0) numAsteriscos = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numAsteriscos; i++) {
            sb.append("*");
        }
        for (int i = numAsteriscos; i < ancho; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
