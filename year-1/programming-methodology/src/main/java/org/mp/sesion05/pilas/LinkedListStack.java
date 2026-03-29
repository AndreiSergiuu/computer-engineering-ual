package org.mp.sesion05.pilas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementación de una pila (LIFO) utilizando una lista enlazada (LinkedList).
 *
 * @param <E> Tipo de los elementos almacenados en la pila.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    /**
     * Constructor que inicializa la lista interna para gestionar la pila.
     */
    public LinkedListStack() {
        this.list = new LinkedList<E>();
    }

    /**
     * @return El número de elementos actuales en la pila.
     */
    @Override
    public int getSize() {
        return this.list.size();
    }

    /**
     * Recupera el último elemento añadido sin extraerlo.
     *
     * @return Elemento en el tope de la pila.
     * @throws NoSuchElementException Si la pila está vacía.
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("El Array esta vacio");
        }
        return this.list.getLast();
    }

    /**
     * Inserta un nuevo elemento al final de la lista (tope de la pila).
     *
     * @param e Elemento a añadir.
     */
    @Override
    public void push(E e) {
        this.list.add(e);
    }

    /**
     * Extrae y devuelve el último elemento de la lista.
     *
     * @return Elemento eliminado del tope.
     * @throws NoSuchElementException Si la pila está vacía.
     */
    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("El Array esta vacio");
        }
        E elemento = this.list.getLast();
        this.list.removeLast();
        return elemento;
    }

    /**
     * @return true si la lista está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

}
