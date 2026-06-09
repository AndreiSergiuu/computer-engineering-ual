package org.mp.sesion07.basicos;

/**
 * Calcula la suma de los N primeros números naturales mediante tres enfoques.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Sumatoria {

    /**
     * Suma recursiva de los N primeros números naturales.
     *
     * @param n Número hasta el que sumar.
     * @return Suma de 1 + 2 + ... + n.
     */
    public static long sumaRec(int n) {
        if (n <= 0) return 0;
        return n + sumaRec(n - 1);
    }

    /**
     * Suma iterativa de los N primeros números naturales.
     *
     * @param n Número hasta el que sumar.
     * @return Suma de 1 + 2 + ... + n.
     */
    public static long sumaIter(int n) {
        long suma = 0;
        for (int i = 1; i <= n; i++) suma += i;
        return suma;
    }

    /**
     * Suma de los N primeros números naturales usando la fórmula de Gauss.
     *
     * @param n Número hasta el que sumar.
     * @return n * (n + 1) / 2.
     */
    public static long sumaGaus(int n) {
        return (long) n * (n + 1) / 2;
    }
}