package org.mp.sesion05.colas;

import java.util.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private final LinkedList<E> list;

    public LinkedListQueue() {
        this.list = new LinkedList<E>();
    }

    @Override
    public void enqueue(E e) {
        this.list.add(e);
    }

    @Override
    public E dequeue() {
        if (this.getSize() == 0) {
            throw new IllegalStateException("La cola esta vacia");
        }
        return this.list.removeFirst();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public E peek() {
        if (this.getSize() == 0) {
            throw new IllegalStateException("La cola esta vacia");
        }
        return this.list.getFirst();
    }

}
