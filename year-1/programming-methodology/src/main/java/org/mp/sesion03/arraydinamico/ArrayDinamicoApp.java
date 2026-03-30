package org.mp.sesion03.arraydinamico;

public class ArrayDinamicoApp {
    public static void main(String[] args) {
        // Uso de ArrayDinamicoEnteros
        ArrayDinamicoEnteros arrayEnteros = new ArrayDinamicoEnteros();
        arrayEnteros.agregar(1);
        arrayEnteros.agregar(2);
        arrayEnteros.agregar(3);
        System.out.println("ArrayDinamicoEnteros:");
        for (int i = 0; i < arrayEnteros.capacidad(); i++) {
            System.out.println(arrayEnteros.obtener(i));
        }

        // Uso de ArrayDinamico
        ArrayDinamico<String> arrayGenerico = new ArrayDinamico<>();
        arrayGenerico.agregar("uno");
        arrayGenerico.agregar("dos");
        arrayGenerico.agregar("tres");
        System.out.println("\nArrayDinamico:");
        for (int i = 0; i < arrayGenerico.capacidad(); i++) {
            System.out.println(arrayGenerico.obtener(i));
        }

        // Uso de ArrayDinamicoObjects
        ArrayDinamicoObjects arrayObjetos = new ArrayDinamicoObjects();
        arrayObjetos.agregar("uno");
        arrayObjetos.agregar(2);
        arrayObjetos.agregar(3.0);
        System.out.println("\nArrayDinamicoObjects:");
        for (int i = 0; i < arrayObjetos.capacidad(); i++) {
            System.out.println(arrayObjetos.obtener(i));
        }
    }
}