package org.mp.sesion07.basicos;

/**
 * Calcula el n-ésimo número de la sucesión de Fibonacci de forma recursiva e iterativa.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Fibonacci {

    /**
     * n-ésimo número de Fibonacci de forma recursiva.
     *
     * @param n Posición en la sucesión (0-indexed).
     * @return F(n).
     */
    public static long fibonacciRec(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    /**
     * n-ésimo número de Fibonacci de forma iterativa.
     *
     * @param n Posición en la sucesión (0-indexed).
     * @return F(n).
     */
    public static long fibonacciIter(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}