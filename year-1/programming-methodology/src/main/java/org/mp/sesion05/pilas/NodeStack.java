package org.mp.sesion05.pilas;

import java.util.NoSuchElementException;

public class NodeStack<E> implements Stack<E> {

    private int size;
    private Node<E> head;

    public NodeStack() {
        this.head = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public E peek() {
        E data = null;
        if (this.isEmpty()) {
            throw new NoSuchElementException("El Array esta vacio");
        }
        data = head.getData();
        return data;

    }

    @Override
    public void push(E e) {
        head = new Node<>(e, head);
        size++;
    }

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
