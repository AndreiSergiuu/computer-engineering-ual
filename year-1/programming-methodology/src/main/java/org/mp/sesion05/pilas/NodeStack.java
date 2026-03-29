package org.mp.sesion05.pilas;

import java.util.NoSuchElementException;

/**
 * Implementación de una pila (LIFO) mediante una estructura de nodos enlazados.
 *
 * @param <E> Tipos de los elementos almacenados en la pila.
 * @author Andrei Sergiu Creata
 * @since 29-03-2026
 */
public class NodeStack<E> implements Stack<E> {

    private int size;
    private Node<E> head;

    /**
     * Constructor que inicializa una pila vacía sin nodos.
     */
    public NodeStack() {
        this.head = null;
        size = 0;
    }

    /**
     * @return El número de elementos actuales en la pila.
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * Recupera el dato del nodo situado en la cima.
     *
     * @return Elemento en el tope de la pila.
     * @throws NoSuchElementException Si la cabeza de la pila es null.
     */
    @Override
    public E peek() {
        E data = null;
        if (this.isEmpty()) {
            throw new NoSuchElementException("El Array esta vacio");
        }
        data = head.getData();
        return data;

    }

    /**
     * Inserta un nuevo nodo en la cima y actualiza la referencia de la cabeza.
     *
     * @param e Elemento a apilar.
     */
    @Override
    public void push(E e) {
        head = new Node<>(e, head);
        size++;
    }

    /**
     * Extrae el nodo superior y desplaza la referencia al siguiente nodo.
     *
     * @return Dato del nodo eliminado.
     * @throws NoSuchElementException Si no hay nodos que extraer.
     */
    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("La pila está vacía");
        }

        E data = head.getData();
        this.head = head.getNext();
        size--;

        return data;
    }

    /**
     * @return true si el nodo cabeza es null, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Clase privada que representa cada unidad (nodo) de la pila.
     *
     * @param <E> Tipo de dato almacenado en el nodo.
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public void setNextNode(Node<E> node) {
            this.next = node;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public E getData() {
            return this.data;
        }

        public void setData(E data) {
            this.data = data;
        }

    }

}
