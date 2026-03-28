package org.mp.sesion05.colas;

/**
 * Interfaz Queue que define las operaciones básicas de una cola.
 * Esta estructura de datos sigue el principio FIFO (First In, First Out).
 *
 * @param <E> el tipo de elementos que esta cola puede contener.
 */
public interface Queue<E> {

    /**
     * Añade un elemento al final de la cola.
     *
     * @param e el elemento a añadir.
     */
    void enqueue(E e);

    /**
     * Elimina y devuelve el primer elemento de la cola.
     * Si la cola está vacía, puede lanzar una excepción o devolver null.
     *
     * @return el primer elemento de la cola, o null si está vacía.
     */
    E dequeue();

    /**
     * Devuelve el número de elementos en la cola.
     *
     * @return el tamaño de la cola como un entero.
     */
    int getSize();

}