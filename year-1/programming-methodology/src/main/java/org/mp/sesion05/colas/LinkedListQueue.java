package org.mp.sesion05.colas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementación de una cola (FIFO) utilizando una lista enlazada (LinkedList).
 *
 * @param <E> Tipo de los elementos almacenados en la cola.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class LinkedListQueue<E> implements Queue<E> {

    private final LinkedList<E> list;

    /**
     * Constructor que inicializa la lista interna para gestionar la cola.
     */
    public LinkedListQueue() {
        this.list = new LinkedList<E>();
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     *
     * @param e Elemento a añadir.
     */
    @Override
    public void enqueue(E e) {
        this.list.add(e);
    }

    /**
     * Extrae y devuelve el primer elemento de la lista.
     *
     * @return Elemento desencolado.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return this.list.removeFirst();
    }

    /**
     * @return El número de elementos actuales en la cola.
     */
    @Override
    public int getSize() {
        return this.list.size();
    }

    /**
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Recupera el primer elemento de la lista sin extraerlo.
     *
     * @return Elemento al frente de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    public E peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return this.list.getFirst();
    }
}