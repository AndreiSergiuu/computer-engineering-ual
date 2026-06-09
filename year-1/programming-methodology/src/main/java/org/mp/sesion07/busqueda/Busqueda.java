package org.mp.sesion07.busqueda;
import java.util.Arrays;
import java.util.Random;

public class Busqueda<T extends Comparable<T>> {
    private int numElementos;
    private T[] datos;
    private T numBuscado;

    public Busqueda(int numElementos) {
        this.numElementos = numElementos;
        datos = (T[]) new Comparable[numElementos];
        generarDatosAleatorios();
    }

    private void generarDatosAleatorios() {
        Random random = new Random();
        for (int i = 0; i < numElementos; i++) {
            datos[i] = (T) Integer.valueOf(random.nextInt(100)); // Genera números aleatorios entre 0 y 99
        }
        Arrays.sort(datos);
        numBuscado = datos[random.nextInt(numElementos)]; // Escoge un elemento aleatorio del arreglo para buscar
    }

    public int getNumElementos() {
        return numElementos;
    }

    public T[] getDatos() {
        return datos;
    }

    public void setDatos(T[] datosModelo) {
        this.datos = datosModelo;
    }

    public T getNumBuscado() {
        return numBuscado;
    }

    public void setNumBuscado(T buscar) {
        numBuscado = buscar;
    }

    @Override
    public String toString() {
        return "Problema búsqueda con " + numElementos + " elementos\n" +
                "Elemento buscado: " + numBuscado + "\n" +
                Arrays.toString(datos);
    }
}