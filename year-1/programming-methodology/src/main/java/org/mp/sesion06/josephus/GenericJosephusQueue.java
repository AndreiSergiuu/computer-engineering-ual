package org.mp.sesion06.josephus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementación del problema de Josephus usando una {@link Queue} respaldada
 * por una {@link LinkedList}.
 *
 *
 * @param <T> Tipo de los elementos en el círculo.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class GenericJosephusQueue<T> {

    private int k;
    private int n;
    private Queue<T> cola;

    /**
     * Crea el problema de Josephus con los parámetros dados.
     *
     * <p>Si {@code elementos} es {@code null} o su único valor es {@code ""},
     * la cola se inicializa vacía.</p>
     *
     * @param k        Paso de eliminación.
     * @param n        Número total de personas.
     * @param elementos Identificadores de las personas.
     */
    public GenericJosephusQueue(int k, int n, T[] elementos) {
        this.k = k;
        this.n = n;
        this.cola = new LinkedList<>();
        if (elementos != null) {
            for (T e : elementos) {
                if (e != null && !e.equals("")) cola.offer(e);
            }
        }
    }

    /**
     * @return Representación textual con los parámetros y el contenido de la cola.
     */
    @Override
    public String toString() {
        return "Problema de Josephus: k=" + k + ", n=" + n + "\nCola: " + cola.toString();
    }

    /**
     * Simula el algoritmo de Josephus y devuelve el orden de eliminación.
     *
     * @return String con el orden de eliminación, o un mensaje si hay 0 o 1 personas.
     */
    public String ordenEliminar() {
        if (cola.isEmpty()) return "No hay ninguna persona";
        if (cola.size() == 1) return "Solo hay una persona";

        StringBuilder sb = new StringBuilder("Orden de eliminación:\n");
        while (!cola.isEmpty()) {
            for (int i = 0; i < k - 1; i++) cola.offer(cola.poll());
            sb.append("Debe morir ").append(cola.poll()).append("\n");
        }
        return sb.toString();
    }
}