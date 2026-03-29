package org.mp.sesion01.listareproduccion;

/**
 * Representa una canción con su información básica y permite su comparación.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class Cancion implements Comparable<Cancion> {

    private String titulo;
    private String artista;
    private int duracion;
    private String genero;

    /**
     * Constructor que inicializa los atributos de la canción
     *
     * @param titulo   Nombre de la canción.
     * @param artista  Nombre del autor o grupo.
     * @param duracion Tiempo en segundos.
     * @param genero   Estilo musical.
     */
    public Cancion(String titulo, String artista, int duracion, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.genero = genero;
    }


    /**
     * Representación detallada de la canción mediante StringBuilder.
     *
     * @return Cadena con los atributos de la canción y su duración en segundos.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cancion [titulo = ").append(this.titulo)
                .append(", artista=").append(this.artista)
                .append(", duracion=").append(this.duracion)
                .append("s, genero=").append(this.genero)
                .append("]");
        return sb.toString();
    }

    /**
     * Indica si dos canciones son iguales por título y artista.
     *
     * @param obj Objeto a comparar.
     * @return true si coinciden en título y artista, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cancion c = (Cancion) obj;
        return this.titulo.equalsIgnoreCase(c.titulo) && this.artista.equalsIgnoreCase(c.artista);
    }

    /**
     * Compara canciones por duración y, opcionalmente, por título.
     *
     * @param o Canción a comparar.
     * @return Valor negativo, cero o positivo según el criterio de ordenación.
     */
    @Override
    public int compareTo(Cancion o) {
        int resultado = Integer.compare(this.duracion, o.duracion);
        if (resultado == 0) {
            resultado = this.titulo.compareToIgnoreCase(o.titulo);
        }
        return resultado;
    }


}
