package org.mp.sesion07.comparator;

import java.util.Comparator;

/**
 * Ordena canciones por artista y, en caso de empate, por título.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class ArtistaCancionComparator implements Comparator<Cancion> {

    @Override
    public int compare(Cancion c1, Cancion c2) {
        int cmp = c1.getArtista().compareTo(c2.getArtista());
        if (cmp != 0) return cmp;
        return c1.getTitulo().compareTo(c2.getTitulo());
    }
}