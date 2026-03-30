package org.mp.sesion03.arraydinamico;

/**
 * Representa una estructura de datos de array dinámico genérica.
 * Permite almacenar y gestionar cualquier tipo de objeto utilizando tipos genéricos de Java.
 *
 * @param <T> el tipo de elementos almacenados en este array dinámico.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class ArrayDinamico<T> {

    private T[] elementos;
    private int numElementos;

    /**
     * Constructor por defecto. Inicializa el array con una capacidad inicial de 10.
     * Se realiza un casting de Object[] a T[] para permitir la genericidad.
     */
    @SuppressWarnings("unchecked")
    public ArrayDinamico() {
        super();
        this.elementos = (T[]) new Object[10];
        this.numElementos = 0;
    }

    /**
     * Devuelve el elemento almacenado en la posición especificada por el índice.
     *
     * @param indice posición del elemento a obtener.
     * @return el elemento de tipo T en dicho índice.
     * @throws ArrayIndexOutOfBoundsException si el índice es menor que 0 o mayor o igual al número de elementos.
     */
    public T obtener(int indice) {
        if (indice < 0 || indice >= numElementos) {
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        }
        return elementos[indice];
    }

    /**
     * Establece o reemplaza el valor de un elemento en una posición determinada.
     *
     * @param indice   posición del elemento a modificar.
     * @param elemento nuevo objeto de tipo T que se desea almacenar.
     * @throws ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public void establecer(int indice, T elemento) {
        if (indice < 0 || indice >= numElementos) {
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        }
        elementos[indice] = elemento;
    }

    /**
     * Devuelve el número actual de elementos almacenados en el array dinámico.
     *
     * @return cantidad de elementos (numElementos).
     */
    public int capacidad() {
        return numElementos;
    }

    /**
     * Añade un nuevo elemento al final del array.
     * Si la capacidad interna se agota, el array dobla su tamaño automáticamente.
     *
     * @param elemento objeto de tipo T a añadir.
     */
    @SuppressWarnings("unchecked")
    public void agregar(T elemento) {
        if (numElementos == elementos.length) {
            T[] nuevosElementos = (T[]) new Object[2 * elementos.length];
            System.arraycopy(elementos, 0, nuevosElementos, 0, elementos.length);
            elementos = nuevosElementos;
        }
        elementos[numElementos] = elemento;
        numElementos++;
    }

    /**
     * Elimina el elemento en la posición indicada, desplazando los elementos restantes
     * una posición hacia la izquierda para evitar huecos.
     *
     * @param indice posición del elemento a eliminar.
     * @throws ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public void eliminar(int indice) {
        if (indice < 0 || indice >= numElementos) {
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        }

        for (int j = indice + 1; j < numElementos; j++) {
            elementos[j - 1] = elementos[j];
        }

        // Limpiamos la última referencia para el Garbage Collector
        elementos[numElementos - 1] = null;
        numElementos--;
    }
}