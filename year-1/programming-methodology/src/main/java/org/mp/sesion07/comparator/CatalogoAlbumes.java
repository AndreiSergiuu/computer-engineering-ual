package org.mp.sesion07.comparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Catálogo de álbumes musicales respaldado por una {@link List}.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class CatalogoAlbumes {

    private List<Album> albumes;

    /** Inicializa un catálogo vacío. */
    public CatalogoAlbumes() {
        this.albumes = new ArrayList<>();
    }

    /**
     * Agrega un álbum al catálogo.
     *
     * @param album Álbum a agregar.
     */
    public void add(Album album) {
        albumes.add(album);
    }

    /** @return Lista de álbumes del catálogo. */
    public List<Album> getAlbumes() {
        return albumes;
    }
}