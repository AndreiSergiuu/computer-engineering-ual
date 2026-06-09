package org.mp.sesion07.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

public class FonotecaTest {
    
    private Fonoteca fonoteca;
    private Cancion[] cancionesNP;

    @BeforeEach
    public void setUp() {
        Cancion[] canciones = new Cancion[5];
        canciones[0] = new Cancion("The Beatles", "Yesterday", 125);
        canciones[1] = new Cancion("Queen", "Bohemian Rhapsody", 354);
        canciones[2] = new Cancion("Pink Floyd", "Time", 421);
        canciones[3] = new Cancion("The Beatles", "Let It Be", 243);
        canciones[4] = new Cancion("Queen", "Don't Stop Me Now", 209);

        fonoteca = new Fonoteca("Mis Favoritas", canciones);

        // Orden esperado por Artista -> Titulo
        cancionesNP = new Cancion[5];
        cancionesNP[0] = new Cancion("Pink Floyd", "Time", 421);
        cancionesNP[1] = new Cancion("Queen", "Bohemian Rhapsody", 354);
        cancionesNP[2] = new Cancion("Queen", "Don't Stop Me Now", 209);
        cancionesNP[3] = new Cancion("The Beatles", "Let It Be", 243);
        cancionesNP[4] = new Cancion("The Beatles", "Yesterday", 125);
        // Nota: Queen D viene después de Queen B en orden alfabético
        // Re-ordenando manualmente para el test:
        cancionesNP[0] = new Cancion("Pink Floyd", "Time", 421);
        cancionesNP[1] = new Cancion("Queen", "Bohemian Rhapsody", 354);
        cancionesNP[2] = new Cancion("Queen", "Don't Stop Me Now", 209);
        cancionesNP[3] = new Cancion("The Beatles", "Let It Be", 243);
        cancionesNP[4] = new Cancion("The Beatles", "Yesterday", 125);
        
        Arrays.sort(cancionesNP, new ArtistaCancionComparator());
    }

    @Test
    public void testOrdenarFonotecaNatural() {
        Cancion[] canciones = fonoteca.getCanciones();
        Arrays.sort(canciones); // Por título

        for (int i = 0; i < canciones.length - 1; i++) {
            assertTrue(canciones[i].getTitulo().compareTo(canciones[i+1].getTitulo()) <= 0);
        }
    }

    @Test
    public void testOrdenarFonotecaArtistaCancionComparator() {
        Cancion[] canciones = fonoteca.getCanciones();
        Arrays.sort(canciones, new ArtistaCancionComparator());

        for (int i = 0; i < canciones.length; i++) {
            assertEquals(cancionesNP[i], canciones[i]);
        }
    }

    @Test
    public void testOrdenarFonotecaDuracionComparator() {
        Cancion[] canciones = fonoteca.getCanciones();
        Arrays.sort(canciones, new DuracionCancionComparator());

        for (int i = 0; i < canciones.length - 1; i++) {
            assertTrue(canciones[i].getDuracion() <= canciones[i+1].getDuracion());
        }
    }
}
