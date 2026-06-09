package org.mp.sesion09.mp3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * Lee los metadatos ID3v1 de un archivo MP3.
 *
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class LectorMetadatosMP3 {

    /** Tamaño fijo de la etiqueta ID3v1 en bytes. */
    private static final int TAG_SIZE = 128;

    /** Bytes del identificador de etiqueta ID3v1. */
    private static final String TAG_HEADER = "TAG";

    /**
     * Lee los metadatos ID3v1 del archivo MP3 indicado y devuelve
     * una {@link Cancion} con sus campos rellenados.
     *
     * @param rutaArchivo ruta absoluta o relativa al archivo .mp3.
     * @return {@code Cancion} con título, artista, álbum, año y ruta.
     * @throws IOException si el archivo no existe o no puede leerse.
     */
    public static Cancion leer(String rutaArchivo) throws IOException {
        byte[] tag = new byte[TAG_SIZE];

        try (RandomAccessFile raf = new RandomAccessFile(rutaArchivo, "r")) {
            long fileLength = raf.length();

            // Si el archivo es demasiado pequeño para contener una etiqueta ID3v1
            if (fileLength < TAG_SIZE) {
                return cancionVacia(rutaArchivo);
            }

            // Posicionarse en los últimos 128 bytes
            raf.seek(fileLength - TAG_SIZE);
            raf.readFully(tag);
        }

        // Verificar el marcador "TAG"
        String header = new String(tag, 0, 3, StandardCharsets.ISO_8859_1);
        if (!TAG_HEADER.equals(header)) {
            return cancionVacia(rutaArchivo);
        }

        String titulo  = leerCampo(tag, 3,  30);
        String artista = leerCampo(tag, 33, 30);
        String album   = leerCampo(tag, 63, 30);
        String anio    = leerCampo(tag, 93,  4);

        return new Cancion(titulo, artista, album, anio, rutaArchivo);
    }

    /**
     * Extrae una cadena de texto de un bloque de bytes, eliminando los
     * bytes nulos de relleno ({@code \0}) que usa ID3v1 para rellenar
     * campos más cortos que su tamaño máximo.
     *
     * @param data   array de bytes de la etiqueta completa.
     * @param offset posición inicial del campo.
     * @param length longitud máxima del campo en bytes.
     * @return cadena limpia sin bytes nulos finales, o {@code ""} si está vacía.
     */
    private static String leerCampo(byte[] data, int offset, int length) {
        String raw = new String(data, offset, length, StandardCharsets.ISO_8859_1);
        // Recortar en el primer byte nulo (relleno ID3v1)
        int nullIndex = raw.indexOf('\0');
        return (nullIndex >= 0 ? raw.substring(0, nullIndex) : raw).trim();
    }

    /**
     * Crea una {@link Cancion} vacía (todos los campos de texto son
     * cadena vacía) para archivos sin etiqueta ID3v1 válida.
     *
     * @param rutaArchivo ruta del archivo, que se conserva aunque no
     *                    haya metadatos.
     * @return {@code Cancion} con campos de texto vacíos.
     */
    private static Cancion cancionVacia(String rutaArchivo) {
        return new Cancion("", "", "", "", rutaArchivo);
    }
}