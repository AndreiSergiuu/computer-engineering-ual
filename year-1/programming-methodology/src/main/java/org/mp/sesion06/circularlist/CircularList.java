package org.mp.sesion06.circularlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lista genérica circular. El acceso por índice aplica módulo, de modo que
 * los índices fuera del rango natural "dan la vuelta" al inicio.
 *
 * @param <T> Tipo de los elementos almacenados.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class CircularList<T> {

    private List<T> list;
    private int current;

    /**
     * Inicializa una lista circular vacía.
     */
    public CircularList() {
        this.list = new ArrayList<>();
        this.current = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param element Elemento a agregar.
     */
    public void addElement(T element) {
        list.add(element);
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado.
     *
     * @param element Elemento a eliminar.
     * @return {@code true} si fue eliminado; {@code false} si no existía.
     */
    public boolean removeElement(T element) {
        int idx = list.indexOf(element);
        if (idx == -1) return false;
        list.remove(idx);
        if (idx < current) current--;
        if (current >= list.size() && !list.isEmpty()) current = 0;
        return true;
    }

    /**
     * Devuelve el elemento en la posición circular {@code index % size}.
     *
     * @param index Posición (puede superar el tamaño de la lista).
     * @return Elemento en la posición circular correspondiente.
     */
    public T getElement(int index) {
        return list.get(index % list.size());
    }

    /**
     * Devuelve la posición de la primera ocurrencia del elemento.
     *
     * @param element Elemento a buscar.
     * @return Índice del elemento, o {@code -1} si no se encuentra.
     */
    public int getIndex(T element) {
        return list.indexOf(element);
    }

    /**
     * @return Número de elementos en la lista.
     */
    public int getSize() {
        return list.size();
    }

    /**
     * @return {@code true} si la lista está vacía; {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Devuelve un iterador circular. Recorre todos los elementos una vez
     * ({@code hasNext()} pasa a {@code false} al completar la vuelta), pero
     * {@code next()} sigue funcionando circularmente tras eso.
     *
     * @return Iterador circular sobre esta lista.
     */
    public Iterator<T> iterator() {
        return new CircularIterator();
    }

    // -------------------------------------------------------------------------

    /**
     * Iterador circular para {@link CircularList}.
     * {@code hasNext()} devuelve {@code true} solo durante la primera vuelta completa;
     * una vez completada pasa a {@code false} permanentemente.
     * {@code next()} sigue funcionando circularmente aunque {@code hasNext()} sea {@code false}.
     */
    private class CircularIterator implements Iterator<T> {

        private int currentIndex;
        private int count;

        CircularIterator() {
            this.currentIndex = 0;
            this.count = 0;
        }

        /** @return {@code true} mientras no se haya completado la primera vuelta. */
        @Override
        public boolean hasNext() {
            return count < list.size();
        }

        /**
         * Devuelve el siguiente elemento de forma circular.
         * Tras completar la primera vuelta, {@code hasNext()} es {@code false} permanentemente,
         * pero este método sigue devolviendo elementos circularmente.
         *
         * @return Siguiente elemento en orden circular.
         */
        @Override
        public T next() {
            T element = list.get(currentIndex);
            currentIndex = (currentIndex + 1) % list.size();
            if (count < list.size()) count++;
            return element;
        }
    }
}