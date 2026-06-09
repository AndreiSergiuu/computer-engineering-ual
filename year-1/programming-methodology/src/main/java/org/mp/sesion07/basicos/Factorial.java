package org.mp.sesion07.basicos;

/**
 * Calcula el factorial de un número de forma recursiva e iterativa.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Factorial {

    /**
     * Factorial recursivo de n.
     *
     * @param n Número no negativo.
     * @return n!
     */
    public static long factorialRec(int n) {
        if (n <= 1) return 1;
        return n * factorialRec(n - 1);
    }

    /**
     * Factorial iterativo de n.
     *
     * @param n Número no negativo.
     * @return n!
     */
    public static long factorialIter(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) resultado *= i;
        return resultado;
    }
}