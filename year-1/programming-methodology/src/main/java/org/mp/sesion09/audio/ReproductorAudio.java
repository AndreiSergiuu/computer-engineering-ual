package org.mp.sesion09.audio;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Utilidad para reproducir objetos ArchivoWav directamente.
 */
public class ReproductorAudio {

    public static void play(ArchivoWav wav) {
        try {
            CabeceraWav h = wav.getCabecera();
            AudioFormat format = new AudioFormat(
                    h.frecuenciaMuestreo,
                    h.bitsPorMuestra,
                    h.numeroCanales,
                    true, // signed
                    false // little-endian
            );

            int numMuestras = wav.getCanal(0).size();
            int bytesPorMuestra = h.bitsPorMuestra / 8;
            byte[] audioData = new byte[numMuestras * h.numeroCanales * bytesPorMuestra];

            ByteBuffer bb = ByteBuffer.wrap(audioData).order(ByteOrder.LITTLE_ENDIAN);
            for (int i = 0; i < numMuestras; i++) {
                for (int c = 0; c < h.numeroCanales; c++) {
                    bb.putShort(wav.getCanal(c).getMuestras().get(i));
                }
            }

            AudioInputStream ais = new AudioInputStream(
                    new ByteArrayInputStream(audioData),
                    format,
                    numMuestras
            );

            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();

            System.out.println("Reproduciendo... (" + (numMuestras / (float)h.frecuenciaMuestreo) + " segundos)");

            // Esperar a que termine la reproducción
            Thread.sleep(clip.getMicrosecondLength() / 1000 + 500);
            clip.close();

        } catch (LineUnavailableException | IOException | InterruptedException e) {
            System.err.println("Error al reproducir audio: " + e.getMessage());
        }
    }
}
