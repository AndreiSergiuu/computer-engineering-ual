package org.mp.sesion09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mp.sesion09.audio.ArchivoWav;
import org.mp.sesion09.audio.ArchivoWavDAO;

import java.io.IOException;

public class ArchivoWavDAOTest {

    @Test
    public void testLeerArchivoWav() {
        try {
            // Suponemos que existe un archivo de prueba en el directorio raíz
            ArchivoWav wav = ArchivoWavDAO.leer("popular_song_sample.wav");
            
            assertNotNull(wav, "El objeto ArchivoWav no debería ser nulo");
            assertNotNull(wav.getCabecera(), "La cabecera no debería ser nula");
            assertTrue(wav.getCanales().size() > 0, "Debería haber al menos un canal de audio");
            assertTrue(wav.getCanal(0).size() > 0, "El canal debería contener muestras");
            
        } catch (IOException e) {
            fail("La lectura del archivo falló: " + e.getMessage());
        }
    }
}
