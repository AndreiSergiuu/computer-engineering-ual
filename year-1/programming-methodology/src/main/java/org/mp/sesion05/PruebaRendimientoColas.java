package org.mp.sesion05;

import org.mp.sesion05.colas.ArrayQueue;
import org.mp.sesion05.colas.LinkedListQueue;
import org.mp.sesion05.colas.NodeQueue;
import org.mp.sesion05.colas.Queue;

import java.util.Random;

public class PruebaRendimientoColas {
    public static void main(String[] args) {
        final int TAMANO_MAXIMO = 50000;
        final int TAMANO_PASO = 10000;

        System.out.println("Prueba de tiempo constante de operaciones en colas:");

        System.out.println("\nArrayQueue:");
        probarTiempoConstante(new ArrayQueue<>(), TAMANO_MAXIMO, TAMANO_PASO);

        System.out.println("\nNodeQueue:");
        probarTiempoConstante(new NodeQueue<>(), TAMANO_MAXIMO, TAMANO_PASO);

        System.out.println("\nCustomLinkedListQueue:");
        probarTiempoConstante(new LinkedListQueue<>(), TAMANO_MAXIMO, TAMANO_PASO);
    }

    private static void probarTiempoConstante(Queue<Integer> cola, int tamanoMaximo, int tamanoPaso) {
        Random random = new Random();

        System.out.println("Tamaño de operaciones | Tiempo enqueue (ns) | Tiempo dequeue (ns)");
        System.out.println("----------------------|---------------------|--------------------");

        for (int tamano = tamanoPaso; tamano <= tamanoMaximo; tamano += tamanoPaso) {
            long tiempoEncolar = medirTiempoEncolar(cola, tamano, random);
            long tiempoDesencolar = medirTiempoDesencolar(cola, tamano);

            System.out.printf("%-21d | %19d | %18d%n", tamano, tiempoEncolar, tiempoDesencolar);
            imprimirBarras(tiempoEncolar, tiempoDesencolar);
        }
    }

    private static void imprimirBarras(long tiempoEncolar, long tiempoDesencolar) {
        long max = Math.max(tiempoEncolar, tiempoDesencolar);
        int anchoBarra = 40;
        System.out.printf("  enqueue: [%s]%n", generarBarra(tiempoEncolar, max, anchoBarra));
        System.out.printf("  dequeue: [%s]%n", generarBarra(tiempoDesencolar, max, anchoBarra));
    }

    private static String generarBarra(long valor, long max, int ancho) {
        int numAsteriscos = (max == 0) ? 0 : (int) Math.round(((double) valor / max) * ancho);
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

    private static long medirTiempoEncolar(Queue<Integer> cola, int tamano, Random random) {
        long tiempoInicio = System.nanoTime();
        for (int i = 0; i < tamano; i++) {
            cola.enqueue(random.nextInt());
        }
        long tiempoFin = System.nanoTime();
        return tiempoFin - tiempoInicio;
    }

    private static long medirTiempoDesencolar(Queue<Integer> cola, int tamano) {
        // Vaciar la cola antes de medir el tiempo de desencolar
        while (cola.getSize() > 0) {
            cola.dequeue();
        }

        long tiempoInicio = System.nanoTime();
        for (int i = 0; i < tamano; i++) {
            cola.enqueue(i);
            cola.dequeue();
        }
        long tiempoFin = System.nanoTime();
        return tiempoFin - tiempoInicio;
    }
}