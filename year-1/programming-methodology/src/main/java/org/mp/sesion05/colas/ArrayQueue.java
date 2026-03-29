package org.mp.sesion05.colas;

public class ArrayQueue<E> implements Queue<E> {

    private E[] elements;
    private int size;
    private int capacity;
    private int front;
    private int rear;

    public ArrayQueue() {
        this.elements = (E[]) new Object[10];
        this.size = 0;
        this.capacity = elements.length;
        this.front = 0;
        this.rear = 0;
    }

    @Override
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

    @Override
    public E dequeue() {
        if (this.size == 0) {
            throw new IllegalStateException("La cola se vacia llena");
        }
        E data = this.elements[this.front];
        this.elements[this.front] = null;
        this.front = (this.front + 1) % this.capacity;
        size--;
        return data;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void peek() {
        if (this.size == 0) {
            throw new IllegalStateException("La cola se vacia llena");
        }
    }
}
