package org.mp.sesion07.busqueda;

public class BusquedaApp {
    public static void main(String[] args) {
        Busqueda<Integer> busqueda = new Busqueda<>(10);
        System.out.println(busqueda);
        try {
            System.out.println("Búsqueda lineal: " + SolucionesBusqueda.busquedaLineal(busqueda));
            System.out.println("Búsqueda binaria iterativa: " + SolucionesBusqueda.busquedaBinariaIter(busqueda));
            System.out.println("Búsqueda binaria recursiva: " + SolucionesBusqueda.busquedaBinariaRec(busqueda));
            System.out.println("Búsqueda con Arrays.binarySearch: " + SolucionesBusqueda.busquedaArraysBinarySearch(busqueda));
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}


