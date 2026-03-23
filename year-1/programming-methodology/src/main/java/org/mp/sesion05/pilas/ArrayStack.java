package org.mp.sesion05.pilas;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {

	private E[] data;
	private int top;

	public ArrayStack() {
		this.data = (E[]) new Object[10];
		this.top = -1;
	}

	@Override
	public int getSize() {
		return this.top + 1;
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("El Array esta vacio");
		}
		return this.data[top];
	}

	@Override
	public void push(E e) {

		if (this.top >= this.data.length - 1) {
			throw new IllegalStateException("La pila se encuentra llena");
		}
		top++;
		this.data[top] = e;

	}

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

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

}
