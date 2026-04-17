package org.mp.sesion06.orderedlist;

import org.mp.sesion04.list.linkedlist.LinkedList;

public class OrderedList <T extends Comparable<T>>{

    private LinkedList<T> list;

    public OrderedList(){
        this.list = new LinkedList<T>();
    }

    public void addElement(T element){
        if (element == null) {
            throw new IllegalArgumentException("No se pueden insertar elementos nulos");
        }
        int size = this.getSize();
        for(int i = 0; i < size; i++) {
            T current = list.get(i);
            if(element.compareTo(current) < 0) {
                list.add(i, element);
                return;
            }
        }
        list.add(size, element);
    }

    public boolean removeElement(T element){
        if (element == null) {
            throw new IllegalArgumentException("No se puede eliminar un elemento que no existe");
        }
        return this.list.remove(element);
    }

    public T getElement(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        return this.list.get(index);
    }

    public int getIndex(T element){
        return this.list.indexOf(element);
    }

    public int getSize(){
        return this.list.size();
    }

    public boolean isEmpty(){
        return this.list.isEmpty();
    }

}
