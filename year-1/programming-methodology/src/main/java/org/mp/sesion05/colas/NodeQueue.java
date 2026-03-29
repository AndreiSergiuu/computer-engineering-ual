package org.mp.sesion05.colas;

import java.util.NoSuchElementException;

/**
 * Implementación de una cola (FIFO) mediante una estructura de nodos enlazados.
 *
 * @param <E> Tipo de los elementos almacenados en la cola.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class NodeQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructor que inicializa una cola vacía.
     */
    public NodeQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Inserta un elemento al final de la cola (por la cola).
     *
     * @param e Elemento a encolar.
     */
    @Override
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        size++;
    }

    /**
     * Extrae y devuelve el elemento al frente de la cola (por la cabeza).
     *
     * @return Elemento desencolado.
     * @throws NoSuchElementException Si la cola no contiene elementos.
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        E data = this.head.data;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        size--;
        return data;
    }

    /**
     * @return true si la cola no tiene nodos, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * @return El número de nodos actualmente en la cola.
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * Recupera el dato del nodo situado al frente sin extraerlo.
     *
     * @return Elemento al frente de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    public E peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return this.head.data;
    }

    /**
     * Clase interna estática que representa un nodo de la cola.
     *
     * @param <E> Tipo de dato almacenado.
     */
    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData() {
            return this.data;
        }

        public void setElement(E data) {
            this.data = data;
        }
    }
}