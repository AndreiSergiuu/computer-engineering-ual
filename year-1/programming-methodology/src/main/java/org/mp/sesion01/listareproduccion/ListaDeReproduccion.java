package org.mp.sesion01.listareproduccion;

/**
 * Gestiona una colección de canciones mediante un array de capacidad fija.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class ListaDeReproduccion {

    private String nombre;
    private Cancion[] canciones;
    private int numCanciones;

    /**
     * Constructor que reserva espacio para un número máximo de canciones.
     *
     * @param nombre          Etiqueta de la lista.
     * @param capacidadMaxima Tamaño del array de canciones.
     */
    public ListaDeReproduccion(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.canciones = new Cancion[capacidadMaxima];
        this.numCanciones = 0;
    }

    /**
     * @return El nombre de la lista de reproducción.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return El array completo de canciones.
     */
    public Cancion[] getCanciones() {
        return canciones;
    }

    /**
     * @return La cantidad de canciones añadidas actualmente.
     */
    public int getNumCanciones() {
        return numCanciones;
    }

    /**
     * Añade una canción al final de la lista si hay espacio disponible.
     *
     * @param c Objeto canción a insertar.
     */
    public void agregarCancion(Cancion c) {
        if (numCanciones < this.canciones.length) {
            canciones[numCanciones] = c;
            numCanciones++;
        }
    }

    /**
     * Imprime por consola todas las canciones almacenadas en la lista.
     */
    public void mostrarCanciones() {
        System.out.println("--- Canciones creadas ---");
        for (int i = 0; i < numCanciones; i++) {
            System.out.println(canciones[i].toString());
        }
    }

    /**
     * Ordena las canciones utilizando el algoritmo de la burbuja según
     * el criterio definido en la clase Cancion.
     */
    public void ordenarCanciones() {
        for (int i = 0; i < numCanciones - 1; i++) {
            for (int j = 0; j < numCanciones - i - 1; j++) {
                if (this.canciones[j].compareTo(this.canciones[j + 1]) > 0) {
                    Cancion temporal = this.canciones[j];
                    this.canciones[j] = this.canciones[j + 1];
                    this.canciones[j + 1] = temporal;
                }
            }
        }
    }
}