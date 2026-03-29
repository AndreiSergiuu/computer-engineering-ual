package org.mp.sesion05.pilas;

import java.util.NoSuchElementException;

/**
 * Implementación de una pila (LIFO) utilizando un array dinámico.
 *
 * @param <E> Tipo de los elementos almacenados en la pila.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class ArrayStack<E> implements Stack<E> {

    private E[] data;
    private int top;

    /**
     * Constructor que inicializa la pila con una capacidad por defecto de 10.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.data = (E[]) new Object[10];
        this.top = -1;
    }

    /**
     * @return El número de elementos actuales en la pila.
     */
    @Override
    public int getSize() {
        return this.top + 1;
    }

    /**
     * Recupera el elemento en la cima sin extraerlo.
     *
     * @return Elemento en el tope de la pila.
     * @throws NoSuchElementException Si la pila está vacía.
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("El Array esta vacio");
        }
        return this.data[top];
    }

    /**
     * Inserta un elemento en la cima. Redimensiona el array si es necesario.
     *
     * @param e Elemento a añadir.
     */
    @Override
    public void push(E e) {
        if (this.top >= this.data.length - 1) {
            this.data = java.util.Arrays.copyOf(this.data, this.data.length * 2);
        }
        top++;
        this.data[top] = e;
    }

    /**
     * Extrae y devuelve el elemento situado en la cima de la pila.
     *
     * @return Elemento eliminado del tope.
     * @throws NoSuchElementException Si la pila está vacía.
     */
    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("El Array esta vacio");
        }
        E elemento = this.data[top];
        this.data[top] = null;
        this.top--;
        return elemento;
    }

    /**
     * @return true si la pila no contiene elementos, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

}
