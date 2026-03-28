package org.mp.sesion05;

import org.mp.sesion05.pilas.ArrayStack;
import org.mp.sesion05.pilas.LinkedListStack;
import org.mp.sesion05.pilas.NodeStack;
import org.mp.sesion05.pilas.Stack;

import java.util.Random;

public class PruebaRendimientoPilas {
    public static void main(String[] args) {
        final int MAX_SIZE = 50000;
        final int STEP_SIZE = 10000;

        System.out.println("Prueba de tiempo constante de operaciones en pilas:");

        System.out.println("\nArrayStack:");
        probarTiempoConstante(new ArrayStack<>(), MAX_SIZE, STEP_SIZE);

        System.out.println("\nNodeStack:");
        probarTiempoConstante(new NodeStack<>(), MAX_SIZE, STEP_SIZE);

        System.out.println("\nCustomLinkedListStack:");
        probarTiempoConstante(new LinkedListStack<>(), MAX_SIZE, STEP_SIZE);
    }

    private static void probarTiempoConstante(Stack<Integer> stack, int maxSize, int stepSize) {
        Random random = new Random();

        System.out.println("Tamaño de operaciones | Tiempo push (ns) | Tiempo pop (ns)");
        System.out.println("----------------------|------------------|----------------");

        for (int size = stepSize; size <= maxSize; size += stepSize) {
            long pushTime = medirTiempoPush(stack, size, random);
            long popTime = medirTiempoPop(stack, size);

            System.out.printf("%-21d | %16d | %14d%n", size, pushTime, popTime);
            imprimirBarras(pushTime, popTime);
        }
    }

    private static void imprimirBarras(long pushTime, long popTime) {
        long max = Math.max(pushTime, popTime);
        int anchoBarra = 40;
        System.out.printf("  push: [%s]%n", generarBarra(pushTime, max, anchoBarra));
        System.out.printf("  pop:  [%s]%n", generarBarra(popTime, max, anchoBarra));
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

    private static long medirTiempoPush(Stack<Integer> stack, int size, Random random) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            stack.push(random.nextInt());
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long medirTiempoPop(Stack<Integer> stack, int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}