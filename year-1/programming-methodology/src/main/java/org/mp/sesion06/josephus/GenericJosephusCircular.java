package org.mp.sesion06.josephus;

import org.mp.sesion06.circularlist.CircularList;

/**
 * Implementación del problema de Josephus usando {@link CircularList}.
 *
 * <p>En cada paso se avanza {@code k} posiciones sobre la lista (con módulo)
 * y se elimina el elemento resultante, hasta que la lista queda vacía.</p>
 *
 * @param <T> Tipo de los elementos en el círculo.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class GenericJosephusCircular<T> {

    private int k;
    private int n;
    private CircularList<T> lista;

    /**
     * Crea el problema de Josephus con los parámetros dados.
     *
     * <p>Si {@code elementos} es {@code null} o su único valor es {@code ""},
     * la lista se inicializa vacía.</p>
     *
     * @param k        Paso de eliminación.
     * @param n        Número total de personas.
     * @param elementos Identificadores de las personas.
     */
    public GenericJosephusCircular(int k, int n, T[] elementos) {
        this.k = k;
        this.n = n;
        this.lista = new CircularList<>();
        if (elementos != null) {
            for (T e : elementos) {
                if (e != null && !e.equals("")) lista.addElement(e);
            }
        }
    }

    /**
     * Simula el algoritmo de Josephus y devuelve el orden de eliminación.
     *
     * @return String con el orden de eliminación, o un mensaje si hay 0 o 1 personas.
     */
    public String ordenEliminar() {
        if (lista.isEmpty()) return "No hay ninguna persona";
        if (lista.getSize() == 1) return "Solo hay una persona";

        StringBuilder sb = new StringBuilder("Orden de eliminación:\n");
        int index = 0;

        while (lista.getSize() > 0) {
            index = (index + k - 1) % lista.getSize();
            T eliminado = lista.getElement(index);
            sb.append("Debe morir ").append(eliminado).append("\n");
            lista.removeElement(eliminado);
            if (lista.getSize() > 0) index = index % lista.getSize();
        }

        return sb.toString();
    }
}