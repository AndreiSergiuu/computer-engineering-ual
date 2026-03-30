package org.mp.sesion04.list.arraylist;

import org.mp.sesion04.list.AbstractList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación de una lista basada en un array dinámico (ArrayList).
 * Extiende de AbstractList para aprovechar la lógica base de gestión de tamaño
 * e implementa operaciones de redimensionamiento automático.
 *
 * @param <E> el tipo de elementos en esta lista.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class ArrayList<E> extends AbstractList<E> {

    private static final int CAPACIDAD_INICIAL = 16;
    private E[] data;

    /**
     * Crea una lista vacía con la capacidad inicial por defecto.
     * Inicializa el array interno para evitar referencias nulas.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = (E[]) new Object[CAPACIDAD_INICIAL];
    }

    /**
     * Crea una lista a partir de un array de objetos proporcionado.
     * Inicializa la memoria base antes de añadir los elementos de forma segura.
     *
     * @param objects array de objetos para inicializar la lista.
     */
    @SuppressWarnings("unchecked")
    public ArrayList(E[] objects) {
        this.data = (E[]) new Object[CAPACIDAD_INICIAL];
        for (E object : objects) {
            add(object);
        }
    }

    /**
     * Compara esta lista con otro objeto para verificar si son iguales.
     * Dos listas son iguales si tienen el mismo tamaño y los mismos elementos en el mismo orden.
     *
     * @param obj objeto a comparar con esta lista.
     * @return true si el objeto especificado es igual a esta lista.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ArrayList<?> other = (ArrayList<?>) obj;
        if (this.size != other.size) return false;

        for (int i = 0; i < size; i++) {
            if (!this.data[i].equals(other.data[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Agrega un nuevo elemento en la posición especificada por el índice.
     * Desplaza los elementos existentes a la derecha para hacer hueco.
     *
     * @param index posición donde se insertará el elemento.
     * @param e     elemento a insertar.
     * @throws IndexOutOfBoundsException si el índice es menor que 0 o mayor que el tamaño de la lista.
     */
    @Override
    public void add(int index, E e) {
        ensureCapacity();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * Asegura que la capacidad de la lista sea suficiente.
     * Si el array está lleno, crea uno nuevo con el doble de tamaño más uno y copia los elementos.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == data.length) {
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    /**
     * Limpia la lista eliminando todos los elementos y restableciendo
     * su capacidad a la inicial por defecto.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        E[] newData = (E[]) new Object[CAPACIDAD_INICIAL];
        data = newData;
        size = 0;
    }

    /**
     * Comprueba si el elemento proporcionado existe dentro de la lista.
     *
     * @param e elemento cuya presencia se desea comprobar.
     * @return true si la lista contiene el elemento, false en caso contrario.
     */
    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    /**
     * Devuelve el elemento almacenado en la posición especificada.
     *
     * @param index posición del elemento a recuperar.
     * @return el elemento situado en el índice indicado.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * Valida si un índice dado está dentro del rango válido de elementos almacenados.
     *
     * @param index índice a validar.
     * @throws IndexOutOfBoundsException si el índice no es válido.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
        }
    }

    /**
     * Devuelve el índice de la primera aparición del elemento especificado.
     *
     * @param e elemento a buscar.
     * @return el índice de la primera aparición, o -1 si la lista no contiene el elemento.
     */
    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    /**
     * Devuelve el índice de la última aparición del elemento especificado.
     * Recorre la lista de atrás hacia adelante.
     *
     * @param e elemento a buscar.
     * @return el índice de la última aparición, o -1 si la lista no contiene el elemento.
     */
    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    /**
     * Elimina el elemento situado en la posición indicada, desplazando
     * cualquier elemento posterior hacia la izquierda.
     *
     * @param index el índice del elemento a eliminar.
     * @return el elemento que fue eliminado de la lista.
     * @throws IndexOutOfBoundsException si el índice está fuera de rango.
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        E e = data[index];

        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;

        return e;
    }

    /**
     * Sustituye el elemento en la posición especificada por el nuevo elemento proporcionado.
     *
     * @param index posición del elemento a reemplazar.
     * @param e     el nuevo elemento a almacenar.
     * @return el elemento que se encontraba previamente en esa posición.
     * @throws IndexOutOfBoundsException si el índice es inválido.
     */
    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E antiguo = data[index];
        data[index] = e;
        return antiguo;
    }

    /**
     * Ajusta la capacidad del array interno para que coincida exactamente con
     * el número actual de elementos, liberando memoria no utilizada.
     *
     * @throws RuntimeException si el tamaño actual ya coincide con la capacidad máxima.
     */
    @SuppressWarnings("unchecked")
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[]) new Object[size];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } else {
            throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
        }
    }

    /**
     * Devuelve una representación en formato de cadena de la lista.
     * El formato es "[elemento1, elemento2, ...] ".
     *
     * @return cadena que representa los elementos de la lista.
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("[");
        Iterator<E> iterador = this.iterator();
        while (iterador.hasNext()) {
            resultado.append(iterador.next());
            if (iterador.hasNext()) {
                resultado.append(", ");
            }
        }
        return resultado.append("]").toString();
    }

    /**
     * Devuelve un iterador sobre los elementos de esta lista en la secuencia adecuada.
     *
     * @return un iterador para la lista.
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Clase interna privada que implementa el patrón Iterator para el ArrayList.
     */
    private class ArrayListIterator implements Iterator<E> {

        private int current = 0;
        private boolean removePermitido = false;

        /**
         * Comprueba si quedan más elementos por iterar.
         *
         * @return true si la iteración tiene más elementos.
         */
        @Override
        public boolean hasNext() {
            return current < size;
        }

        /**
         * Devuelve el siguiente elemento en la iteración.
         *
         * @return el siguiente elemento.
         * @throws NoSuchElementException si no quedan elementos por iterar.
         */
        @Override
        public E next() {
            if (current == size) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            removePermitido = true;
            return data[current++];
        }

        /**
         * Elimina de la colección subyacente el último elemento devuelto por el iterador.
         * Solo puede llamarse una vez por cada llamada a next().
         *
         * @throws IllegalStateException si el método next no ha sido llamado previamente,
         *                               o si el método remove ya ha sido llamado después de la última llamada a next.
         */
        @Override
        public void remove() {
            if (!removePermitido) {
                throw new IllegalStateException("No se puede usar remove() sin hacer next()");
            }
            ArrayList.this.remove(current - 1);
            current--;
            removePermitido = false;
        }
    }
}