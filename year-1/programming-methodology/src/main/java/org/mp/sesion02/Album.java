package org.mp.sesion02;

import java.util.Objects;

/**
 * Clase que representa un álbum de música y gestiona sus canciones. Implementa
 * la interfaz Comparable.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class Album implements Comparable<Album> {

    private String titulo;
    private String artista;
    private int ano;
    private Cancion[] canciones;
    private int numCanciones;

    /**
     * Constructor para inicializar los atributos de un álbum.
     *
     * @param titulo       El título del álbum.
     * @param artista      El nombre del artista.
     * @param ano          El año de publicación del álbum.
     * @param maxCanciones El número máximo de canciones que puede contener el
     *                     álbum.
     */
    public Album(String titulo, String artista, int ano, int maxCanciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
        this.canciones = new Cancion[maxCanciones];
        this.numCanciones = 0;
    }

    /**
     * Devuelve una representación del objeto.
     *
     * @return Una cadena de texto con la información estructurada del álbum y sus
     * canciones.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ALBUM: ").append(this.titulo).append("\n");
        sb.append("ARTISTA: ").append(this.artista).append("\t\tAÑO: ").append(this.ano).append("\n");
        for (int i = 0; i < this.numCanciones; i++) {
            sb.append(" ").append(i + 1).append(") ").append(this.canciones[i].toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Compara este álbum con otro objeto para determinar si son iguales. Dos
     * álbumes son iguales si tienen el mismo título, artista y año.
     *
     * @param o El objeto con el que comparar.
     * @return true si los álbumes son idénticos en título, artista y año o false en
     * caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Album album = (Album) o;
        return ano == album.ano && Objects.equals(titulo, album.titulo) && Objects.equals(artista, album.artista);
    }

    /**
     * Compara este álbum con otro para establecer un orden. Ordena los álbumes
     * primero por año y, si los años son iguales, por
     * título alfabéticamente.
     *
     * @param otroAlbum El álbum con el que se va a comparar.
     * @return Un valor negativo, cero o positivo si este álbum es menor, igual o
     * mayor que el especificado.
     */
    @Override
    public int compareTo(Album otroAlbum) {
        if (this.ano != otroAlbum.ano) {
            return Integer.compare(this.ano, otroAlbum.ano);
        }
        return this.titulo.compareTo(otroAlbum.titulo);
    }

    /**
     * Muestra por consola las canciones del álbum.
     */
    public void mostrarCanciones() {
        for (int i = 0; i < numCanciones; i++) {
            System.out.println(canciones[i].toString());
        }
    }

    /**
     * Agrega una canción al álbum si no se ha alcanzado la capacidad máxima
     * definida.
     *
     * @param cancion La canción a agregar al álbum.
     */
    public void agregarCancion(Cancion cancion) {
        if (this.numCanciones < this.canciones.length) {
            this.canciones[this.numCanciones] = cancion;
            this.numCanciones++;
        }
    }
}