package org.mp.sesion05.colas;

import java.util.NoSuchElementException;

public class NodeQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public NodeQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

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

    @Override
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public E peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return this.head.data;
    }

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
