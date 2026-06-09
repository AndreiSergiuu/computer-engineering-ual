package org.mp.sesion09;

import org.junit.jupiter.api.Test;
import org.mp.sesion09.audio.ArchivoWav;
import org.mp.sesion09.audio.ArchivoWavDAO;
import org.mp.sesion09.audio.CabeceraWav;
import org.mp.sesion09.audio.CanalAudio;
import org.mp.sesion09.audio.efectos.EfectoInverso;
import org.mp.sesion09.audio.efectos.EfectoVolumen;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AudioProcessingTest {

    @Test
    void testCreateReadWriteWav() throws IOException {
        String testFile = "test_audio.wav";
        String outputFile = "test_audio_processed.wav";

        // 1. Crear un WAV sintético de 1 segundo (44100 muestras)
        CabeceraWav header = new CabeceraWav();
        header.numeroCanales = 1;
        header.frecuenciaMuestreo = 44100;
        header.bitsPorMuestra = 16;
        
        ArchivoWav wav = new ArchivoWav(header);
        CanalAudio channel = wav.getCanal(0);
        for (int i = 0; i < 44100; i++) {
            // Generar una onda seno simple
            short sample = (short) (Math.sin(2 * Math.PI * 440 * i / 44100) * 32767);
            channel.addMuestra(sample);
        }

        // 2. Escribir el archivo
        ArchivoWavDAO.escribir(wav, testFile);
        assertTrue(new File(testFile).exists());

        // 3. Leer el archivo
        ArchivoWav wavLeido = ArchivoWavDAO.leer(testFile);
        assertEquals(44100, wavLeido.getCanal(0).size());
        assertEquals(44100, wavLeido.getCabecera().frecuenciaMuestreo);

        // 4. Aplicar efectos
        new EfectoVolumen(0.5).aplicar(wavLeido);
        new EfectoInverso().aplicar(wavLeido);

        // 5. Guardar el procesado
        ArchivoWavDAO.escribir(wavLeido, outputFile);
        assertTrue(new File(outputFile).exists());

        // Limpieza (opcional)
        // new File(testFile).delete();
        // new File(outputFile).delete();
    }

    @Test
    void testEfectoInverso() {
        CabeceraWav cabecera = new CabeceraWav();
        cabecera.numeroCanales = 1;
        ArchivoWav wav = new ArchivoWav(cabecera);
        CanalAudio canal = wav.getCanal(0);
        canal.addMuestra((short) 100);
        canal.addMuestra((short) 200);
        canal.addMuestra((short) 300);

        new EfectoInverso().aplicar(wav);

        assertEquals((short) 300, canal.getMuestras().get(0));
        assertEquals((short) 200, canal.getMuestras().get(1));
        assertEquals((short) 100, canal.getMuestras().get(2));
    }

    @Test
    void testEfectoVolumen() {
        CabeceraWav cabecera = new CabeceraWav();
        cabecera.numeroCanales = 1;
        ArchivoWav wav = new ArchivoWav(cabecera);
        CanalAudio canal = wav.getCanal(0);
        canal.addMuestra((short) 100);
        canal.addMuestra((short) 200);

        new EfectoVolumen(0.5).aplicar(wav);

        assertEquals((short) 50, canal.getMuestras().get(0));
        assertEquals((short) 100, canal.getMuestras().get(1));
    }
}
