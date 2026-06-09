package org.mp.sesion09.audio;

import org.mp.sesion09.audio.efectos.EfectoInverso;
import org.mp.sesion09.audio.efectos.EfectoVolumen;

public class AudioApp {

    public static void main(String[] args) {
        System.out.println("=== MP 2026: Aplicación de Procesamiento de Audio ===");

        // 1. Configuración del audio (Calidad CD)
        CabeceraWav cabecera = new CabeceraWav();
        cabecera.numeroCanales = 1;
        cabecera.frecuenciaMuestreo = 44100;
        cabecera.bitsPorMuestra = 16;

        ArchivoWav wav = new ArchivoWav(cabecera);
        int duracionSegundos = 2;
        int totalMuestras = cabecera.frecuenciaMuestreo * duracionSegundos;

        // 2. Generación de un sonido de "Sirena" (Frecuencia variable)
        System.out.println("Generando sonido de sirena...");
        CanalAudio canal = wav.getCanal(0);
        for (int i = 0; i < totalMuestras; i++) {
            double t = (double) i / cabecera.frecuenciaMuestreo;
            // Frecuencia que oscila entre 440Hz y 880Hz
            double freq = 440 + 220 * Math.sin(2 * Math.PI * 0.5 * t);
            short muestra = (short) (Math.sin(2 * Math.PI * freq * t) * 16000);
            canal.addMuestra(muestra);
        }

        // 3. Reproducción Original
        System.out.println("\n[1] Sonido Original:");
        ReproductorAudio.play(wav);

        // 4. Aplicar Efecto de Volumen (Bajar al 20%)
        System.out.println("\n[2] Aplicando EfectoVolumen (20%)...");
        new EfectoVolumen(0.2).aplicar(wav);
        ReproductorAudio.play(wav);

        // 5. Aplicar Efecto de Inversión (Al revés)
        System.out.println("\n[3] Aplicando EfectoInverso...");
        new EfectoInverso().aplicar(wav);
        // Volvemos a subir el volumen para oírlo bien tras la bajada anterior
        new EfectoVolumen(4.0).aplicar(wav);
        ReproductorAudio.play(wav);

        // 6. Persistencia
        try {
            String fileName = "sirena_procesada.wav";
            ArchivoWavDAO.escribir(wav, fileName);
            System.out.println("\nArchivo guardado como: " + fileName);
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }

        // 7. Reproducción de archivos externos
        System.out.println("\n--- Reproduciendo Archivos Externos ---");
        String[] archivosExternos = {
                "src/main/resources/audio/sample1.wav",
                "src/main/resources/audio/sample2.wav",
                "src/main/resources/audio/sample3.wav"
        };

        for (int i = 0; i < archivosExternos.length; i++) {
            try {
                System.out.println("\nReproduciendo archivo externo: " + archivosExternos[i]);
                ArchivoWav wavExterno = ArchivoWavDAO.leer(archivosExternos[i]);
                ReproductorAudio.play(wavExterno);
            } catch (Exception e) {
                System.err.println("Error al reproducir " + archivosExternos[i] + ": " + e.getMessage());
            }
        }

        System.out.println("\n=== Fin de la Demostración ===");
    }
}
