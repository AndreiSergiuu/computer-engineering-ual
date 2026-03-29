package org.mp.sesion05.colas;

import java.util.NoSuchElementException;

/**
 * Implementación de una cola (FIFO) utilizando un array circular dinámico.
 *
 * @param <E> Tipo de los elementos almacenados en la cola.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class ArrayQueue<E> implements Queue<E> {

    private E[] elements;
    private int size;
    private int capacity;
    private int front;
    private int rear;

    /**
     * Constructor que inicializa la cola con una capacidad inicial de 10.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.elements = (E[]) new Object[10];
        this.size = 0;
        this.capacity = elements.length;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * Inserta un elemento al final de la cola. Si la capacidad es insuficiente,
     * se redimensiona el array manteniendo el orden circular.
     *
     * @param e Elemento a encolar.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void enqueue(E e) {
        if (this.size == this.capacity) {
            E[] aux = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                aux[i] = elements[(front + i) % capacity];
            }
            this.elements = java.util.Arrays.copyOf(aux, this.capacity * 2);
            this.front = 0;
            this.rear = size;
            this.capacity = elements.length;
        }
        this.elements[rear] = e;
        this.rear = (this.rear + 1) % this.capacity;
        this.size++;
    }

    /**
     * Extrae y devuelve el elemento situado al frente de la cola.
     *
     * @return Elemento desencolado.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        E data = this.elements[this.front];
        this.elements[this.front] = null; // Liberar referencia para el GC
        this.front = (this.front + 1) % this.capacity;
        size--;
        return data;
    }

    /**
     * @return true si la cola no contiene elementos, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * @return El número de elementos actuales en la cola.
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * Recupera el elemento al frente de la cola sin extraerlo.
     *
     * @return Elemento al frente de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    public E peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return this.elements[this.front];
    }
}