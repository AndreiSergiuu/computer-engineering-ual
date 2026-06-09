package org.mp.sesion09.audio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * DAO (Data Access Object) para archivos WAV PCM de 16 bits.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @see ArchivoWav
 * @see CabeceraWav
 * @since 09-06-2026
 */
public class ArchivoWavDAO {

    /**
     * Lee un archivo WAV desde disco y lo convierte en un {@link ArchivoWav}.
     *
     * @param ruta ruta al archivo {@code .wav}.
     * @return objeto {@link ArchivoWav} con la cabecera y los canales cargados.
     * @throws IOException si el archivo no existe, está truncado o no es WAV válido.
     */
    public static ArchivoWav leer(String ruta) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ruta))) {

            // 1. Leer cabecera
            CabeceraWav cabecera = new CabeceraWav();
            cabecera.leer(bis);

            // 2. Calcular número de muestras por canal
            int bytesPorMuestra = cabecera.bitsPorMuestra / 8;
            int totalMuestras = cabecera.subchunk2Size / (bytesPorMuestra * cabecera.numeroCanales);

            // 3. Crear el objeto WAV con canales pre-reservados
            ArchivoWav wav = new ArchivoWav(cabecera);
            for (int c = 0; c < cabecera.numeroCanales; c++) {
                // Reemplazamos con canales de capacidad correcta para evitar
                // reallocations innecesarias en listas grandes
                wav.getCanales().set(c, new CanalAudio(totalMuestras));
            }

            // 4. Leer muestras entrelazadas (canal 0, canal 1, canal 0, ...)
            byte[] par = new byte[bytesPorMuestra];
            ByteBuffer bb = ByteBuffer.wrap(par).order(ByteOrder.LITTLE_ENDIAN);

            for (int i = 0; i < totalMuestras; i++) {
                for (int c = 0; c < cabecera.numeroCanales; c++) {
                    int read = bis.read(par);
                    if (read < bytesPorMuestra) {
                        throw new IOException("Datos de audio truncados en muestra " + i + ", canal " + c);
                    }
                    bb.rewind();
                    wav.getCanal(c).addMuestra(bb.getShort());
                }
            }

            return wav;
        }
    }

    /**
     * Escribe un {@link ArchivoWav} en disco como archivo WAV estándar.
     *
     * @param wav  objeto {@link ArchivoWav} a persistir.
     * @param ruta ruta de destino del archivo {@code .wav}.
     * @throws IOException si no se puede crear o escribir el archivo.
     */
    public static void escribir(ArchivoWav wav, String ruta) throws IOException {
        // Recalcular cabecera con los datos actuales
        wav.updateHeader();

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(ruta))) {

            // 1. Escribir cabecera de 44 bytes
            wav.getCabecera().escribir(bos);

            // 2. Escribir muestras entrelazadas en little-endian
            int numMuestras = wav.getCanal(0).size();
            int numCanales = wav.getCanales().size();
            byte[] par = new byte[2];
            ByteBuffer bb = ByteBuffer.wrap(par).order(ByteOrder.LITTLE_ENDIAN);

            for (int i = 0; i < numMuestras; i++) {
                for (int c = 0; c < numCanales; c++) {
                    bb.rewind();
                    bb.putShort(wav.getCanal(c).getMuestras().get(i));
                    bos.write(par);
                }
            }
        }
    }
}