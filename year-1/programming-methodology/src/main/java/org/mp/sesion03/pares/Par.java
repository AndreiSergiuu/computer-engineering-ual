package org.mp.sesion03.pares;

public class Par<K, V> {

	private K primero;
	private V segundo;

	public Par(K primero, V segundo) {
		this.primero = primero;
		this.segundo = segundo;
	}

	public K getPrimero() {
		return this.primero;
	}

	public V getSegundo() {
		return this.segundo;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", primero, segundo);
	}

}
