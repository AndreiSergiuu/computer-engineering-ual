package org.mp.sesion09.audio;

import org.mp.sesion09.mp3.Biblioteca;
import org.mp.sesion09.mp3.Cancion;
import org.mp.sesion09.mp3.LectorMetadatosMP3;

import java.io.File;
import java.io.IOException;

public class GestorBiblioteca {

    /**
     * Escanea un directorio buscando .mp3 y construye la biblioteca.
     */
    public static Biblioteca escanearCarpeta(String rutaCarpeta) throws IOException {
        Biblioteca biblioteca = new Biblioteca();
        File carpeta = new File(rutaCarpeta);
        escanearRecursivo(carpeta, biblioteca);
        return biblioteca;
    }

    private static void escanearRecursivo(File archivo, Biblioteca biblioteca) {
        if (archivo.isDirectory()) {
            File[] subarchivos = archivo.listFiles();
            if (subarchivos != null) {
                for (int i = 0; i < subarchivos.length; i++) {
                    escanearRecursivo(subarchivos[i], biblioteca);
                }
            }
        } else if (archivo.getName().toLowerCase().endsWith(".mp3")) {
            try {
                Cancion cancion = LectorMetadatosMP3.leer(archivo.getAbsolutePath());
                biblioteca.anadirCancion(cancion);
            } catch (IOException e) {
                System.err.println("Error procesando: " + archivo.getPath() + " - " + e.getMessage());
            }
        }
    }
}
