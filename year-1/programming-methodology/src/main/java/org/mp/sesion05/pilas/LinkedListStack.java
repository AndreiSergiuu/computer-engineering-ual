package org.mp.sesion05.pilas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E> {

	private LinkedList<E> list;

	public LinkedListStack() {
		this.list = new LinkedList<E>();
	}

	@Override
	public int getSize() {
		return this.list.size();
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("El Array esta vacio");
		}
		return this.list.getLast();
	}

	@Override
	public void push(E e) {
		this.list.add(e);
	}

	@Override
	public E pop() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("El Array esta vacio");
		}
		E elemento = this.list.getLast();
		this.list.removeLast();
		return elemento;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

}
