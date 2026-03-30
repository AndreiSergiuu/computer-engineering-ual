package org.mp.sesion03.arraydinamico;

/**
 * Representa una lista de objetos que puede crecer y disminuir dinámicamente.
 * Esta implementación utiliza características disponibles hasta Java 5 (uso de Object).
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class ArrayDinamicoObjects {

    private Object[] elementos;
    private int numElementos;

    /**
     * Constructor por defecto. Inicializa el array con una capacidad de 10.
     */
    public ArrayDinamicoObjects() {
        super();
        elementos = new Object[10];
        numElementos = 0;
    }

    /**
     * Devuelve el elemento en un índice dado en el array.
     *
     * @param indice Posición del elemento a obtener.
     * @return El objeto en la posición indicada.
     * @throws ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public Object obtener(int indice) {
        if (indice < 0 || indice >= numElementos) {
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        }
        return elementos[indice];
    }

    /**
     * Establece el valor del elemento del array en un índice dado.
     *
     * @param indice   Posición donde se establecerá el elemento.
     * @param elemento El objeto a guardar.
     * @throws ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public void establecer(int indice, Object elemento) {
        if (indice < 0 || indice >= numElementos) {
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        }
        elementos[indice] = elemento;
    }

    /**
     * Devuelve la cantidad de elementos actualmente almacenados en el array.
     *
     * @return Número de elementos actuales.
     */
    public int capacidad() {
        return numElementos;
    }

    /**
     * Agrega un nuevo elemento al final del array. Si el array interno está lleno,
     * duplica su capacidad.
     *
     * @param elemento El objeto a agregar al final.
     */
    public void agregar(Object elemento) {
        if (numElementos == elementos.length) {
            Object[] nuevosElementos = new Object[2 * elementos.length];
            System.arraycopy(elementos, 0, nuevosElementos, 0, elementos.length);
            elementos = nuevosElementos;
        }
        elementos[numElementos] = elemento;
        numElementos++;
    }

    /**
     * Elimina el elemento en un índice dado. Desplaza los elementos siguientes
     * una posición hacia la izquierda.
     *
     * @param indice Posición del elemento a eliminar.
     * @throws ArrayIndexOutOfBoundsException si el índice no es válido.
     */
    public void eliminar(int indice) {
        if (indice < 0 || indice >= numElementos) {
            throw new ArrayIndexOutOfBoundsException("Índice no válido, " + indice);
        }

        for (int j = indice + 1; j < numElementos; j++) {
            elementos[j - 1] = elementos[j];
        }

        elementos[numElementos - 1] = null;
        numElementos--;
    }
}