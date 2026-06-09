package org.mp.sesion07.comparator;

import java.util.Comparator;

/**
 * Ordena álbumes por artista y, en caso de empate, por nombre del álbum.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class ArtistaTituloComparator implements Comparator<Album> {

    @Override
    public int compare(Album a1, Album a2) {
        int cmp = a1.getArtista().compareTo(a2.getArtista());
        if (cmp != 0) return cmp;
        return a1.getNombre().compareTo(a2.getNombre());
    }
}