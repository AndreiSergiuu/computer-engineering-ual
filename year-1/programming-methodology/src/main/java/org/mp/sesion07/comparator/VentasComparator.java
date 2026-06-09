package org.mp.sesion07.comparator;

import java.util.Comparator;

/**
 * Ordena álbumes por ventas de forma ascendente.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class VentasComparator implements Comparator<Album> {

    @Override
    public int compare(Album a1, Album a2) {
        return Long.compare(a1.getVentas(), a2.getVentas());
    }
}