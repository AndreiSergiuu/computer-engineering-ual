package org.mp.sesion06.orderedlist;

import java.util.LinkedList;

/**
 * Lista genérica que mantiene sus elementos en orden ascendente.
 * Actúa como envoltorio de una {@link LinkedList} de Java.
 *
 * @param <T> Tipo de los elementos; debe implementar {@link Comparable}.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class OrderedList<T extends Comparable<T>> {

    private LinkedList<T> list;

    /**
     * Inicializa una lista ordenada vacía.
     */
    public OrderedList() {
        this.list = new LinkedList<>();
    }

    /**
     * Inserta el elemento en la posición correcta para mantener el orden ascendente.
     *
     * @param element Elemento a insertar.
     */
    public void addElement(T element) {
        int index = 0;
        for (T current : list) {
            if (element.compareTo(current) <= 0) break;
            index++;
        }
        list.add(index, element);
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado.
     *
     * @param element Elemento a eliminar.
     * @return {@code true} si fue eliminado; {@code false} si no existía.
     */
    public boolean removeElement(T element) {
        return list.remove(element);
    }

    /**
     * Devuelve el elemento en la posición indicada.
     *
     * @param index Índice basado en cero.
     * @return Elemento en la posición {@code index}.
     */
    public T getElement(int index) {
        return list.get(index);
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
}