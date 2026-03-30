package org.mp.sesion04.list.linkedlist;

import org.mp.sesion04.list.AbstractList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación de una lista simplemente enlazada (LinkedList).
 * Extiende AbstractList e implementa la lógica de punteros entre nodos.
 *
 * @param <E> el tipo de elementos en esta lista.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class LinkedList<E> extends AbstractList<E> {
    
    private Node<E> head;
    private Node<E> tail;

    /**
     * Crea una lista enlazada vacía.
     */
    public LinkedList() {
        super();
    }

    /**
     * Crea una lista enlazada a partir de un array de objetos proporcionado.
     *
     * @param objects array de elementos iniciales con los que poblar la lista.
     */
    public LinkedList(E[] objects) {
        super(objects);
    }

    /**
     * Compara esta lista con otro objeto para determinar su igualdad.
     * Dos listas se consideran iguales si tienen el mismo tamaño y los mismos
     * elementos en el mismo orden exacto.
     *
     * @param obj el objeto a comparar con esta lista.
     * @return true si el objeto especificado es igual a esta lista, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        LinkedList<?> other = (LinkedList<?>) obj;
        if (this.size != other.size) return false;

        Node<E> currentThis = this.head;
        Node<?> currentOther = other.head;

        while (currentThis != null) {
            if (currentThis.element == null) {
                if (currentOther.element != null) return false;
            } else if (!currentThis.element.equals(currentOther.element)) {
                return false;
            }
            currentThis = currentThis.next;
            currentOther = currentOther.next;
        }
        return true;
    }

    /**
     * Devuelve el primer elemento de la lista (cabeza).
     *
     * @return el primer elemento, o null si la lista está vacía.
     */
    public E getFirst() {
        if (size == 0) return null;
        return head.element;
    }

    /**
     * Devuelve el último elemento de la lista (cola).
     *
     * @return el último elemento, o null si la lista está vacía.
     */
    public E getLast() {
        if (size == 0) return null;
        return tail.element;
    }

    /**
     * Añade un nuevo elemento al principio de la lista.
     *
     * @param e elemento a añadir en la primera posición.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Añade un nuevo elemento al final de la lista.
     *
     * @param e elemento a añadir en la última posición.
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserta un elemento en la posición especificada por el índice.
     * Si el índice es menor o igual a 0, se inserta al principio.
     * Si el índice es mayor o igual al tamaño actual, se inserta al final.
     *
     * @param index la posición en la que se desea insertar el elemento.
     * @param e     el elemento a insertar.
     */
    @Override
    public void add(int index, E e) {
        if (index <= 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            current.next.next = temp;
            size++;
        }
    }

    /**
     * Elimina el primer nodo de la lista y devuelve su elemento contenido.
     *
     * @return el elemento que ha sido eliminado, o null si la lista estaba vacía.
     */
    public E removeFirst() {
        if (size == 0) return null;

        Node<E> temp = head;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }
        return temp.element;
    }

    /**
     * Elimina el último nodo de la lista y devuelve su elemento contenido.
     *
     * @return el elemento que ha sido eliminado, o null si la lista estaba vacía.
     */
    public E removeLast() {
        if (size == 0) return null;
        if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }

        Node<E> current = head;
        for (int i = 1; i < size - 1; i++) {
            current = current.next;
        }

        Node<E> temp = tail;
        tail = current;
        tail.next = null;
        size--;
        return temp.element;
    }

    /**
     * Elimina el elemento en la posición especificada por el índice.
     *
     * @param index la posición del elemento a eliminar.
     * @return el elemento eliminado, o null si el índice está fuera de rango.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node<E> previous = head;
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }

        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
        return current.element;
    }

    /**
     * Devuelve una representación en formato de cadena de la lista.
     *
     * @return una cadena que representa los elementos de la lista en orden.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (size == 0) {
            result.append("]");
        } else {
            Iterator<E> iterador = this.iterator();
            while (iterador.hasNext()) {
                result.append(iterador.next());
                if (iterador.hasNext()) {
                    result.append(", ");
                }
            }
            result.append("]");
        }
        return result.toString();
    }

    /**
     * Vacía la lista eliminando todos los nodos y restableciendo el tamaño a cero.
     */
    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    /**
     * Comprueba si la lista contiene el elemento especificado.
     *
     * @param e el elemento cuya presencia en la lista se va a evaluar.
     * @return true si la lista contiene el elemento, false en caso contrario.
     */
    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    /**
     * Devuelve el elemento almacenado en el índice especificado.
     *
     * @param index el índice del elemento a recuperar.
     * @return el elemento situado en el índice indicado, o null si el índice está fuera de rango.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    /**
     * Busca la primera aparición de un elemento en la lista y devuelve su índice.
     *
     * @param e el elemento a buscar.
     * @return el índice de la primera aparición del elemento, o -1 si no se encuentra.
     */
    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e == null && current.element == null) return i;
            if (e != null && e.equals(current.element)) return i;
            current = current.next;
        }
        return -1;
    }

    /**
     * Busca la última aparición de un elemento en la lista y devuelve su índice.
     *
     * @param e el elemento a buscar.
     * @return el índice de la última aparición del elemento, o -1 si no se encuentra.
     */
    @Override
    public int lastIndexOf(E e) {
        int lastIndex = -1;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e == null && current.element == null) lastIndex = i;
            else if (e != null && e.equals(current.element)) lastIndex = i;
            current = current.next;
        }
        return lastIndex;
    }

    /**
     * Reemplaza el elemento en la posición especificada por un nuevo elemento.
     *
     * @param index el índice del elemento a reemplazar.
     * @param e     el nuevo elemento a almacenar.
     * @return el elemento que se encontraba previamente en esa posición, o null si el índice es inválido.
     */
    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E temp = current.element;
        current.element = e;
        return temp;
    }

    /**
     * Devuelve un iterador sobre los elementos de esta lista en la secuencia adecuada.
     *
     * @return un objeto Iterator para la lista enlazada.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Clase interna estática que representa un nodo en la lista enlazada.
     *
     * @param <E> el tipo de elemento almacenado en el nodo.
     */
    private static class Node<E> {
        /**
         * Elemento de datos almacenado en el nodo.
         */
        E element;

        /**
         * Referencia al siguiente nodo en la lista.
         */
        Node<E> next;

        /**
         * Construye un nuevo nodo con el elemento especificado.
         *
         * @param element el dato a almacenar en el nodo.
         */
        public Node(E element) {
            this.element = element;
        }
    }

    /**
     * Clase interna privada que proporciona la funcionalidad de iterador para la LinkedList.
     */
    private class LinkedListIterator implements Iterator<E> {
        /**
         * Nodo actual en la iteración.
         */
        private Node<E> current = head;

        /**
         * Nodo previo visitado en la iteración (usado para la eliminación).
         */
        private Node<E> previous = null;

        /**
         * Comprueba si existen más elementos en la iteración.
         *
         * @return true si la iteración tiene más elementos.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Devuelve el siguiente elemento en la iteración.
         *
         * @return el siguiente elemento.
         * @throws NoSuchElementException si no quedan elementos para iterar.
         */
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            E e = current.element;
            previous = current;
            current = current.next;
            return e;
        }

        /**
         * Elimina de la colección subyacente el último elemento devuelto por este iterador.
         *
         * @throws IllegalStateException si el método next no ha sido llamado aún,
         *                               o si remove ya ha sido llamado tras la última llamada a next.
         */
        @Override
        public void remove() {
            if (previous == null) {
                throw new IllegalStateException("No se ha llamado a next() antes de remove()");
            }
            int index = LinkedList.this.indexOf(previous.element);
            LinkedList.this.remove(index);
            previous = null;
        }
    }
}