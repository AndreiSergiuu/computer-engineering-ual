package org.mp.sesion07.comparator;

import java.util.Comparator;

/**
 * Ordena canciones por duración ascendente.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class DuracionCancionComparator implements Comparator<Cancion> {

    @Override
    public int compare(Cancion c1, Cancion c2) {
        return Integer.compare(c1.getDuracion(), c2.getDuracion());
    }
}