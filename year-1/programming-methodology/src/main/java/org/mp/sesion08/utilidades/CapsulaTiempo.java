package org.mp.sesion08.utilidades;

import org.mp.sesion07.comparator.Cancion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Serializa y deserializa una lista de {@link Cancion} en un archivo de texto.
 * Formato de cada línea: {@code artista;titulo;duracion}
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class CapsulaTiempo {

    private static final String SEP = ";";

    /**
     * Guarda la lista de canciones en el archivo indicado.
     *
     * @param playlist Lista de canciones a guardar.
     * @param ruta     Ruta del archivo de salida.
     * @throws IOException Si no se puede escribir el archivo.
     */
    public static void guardarPlaylist(List<Cancion> playlist, String ruta) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ruta)))) {
            for (Cancion c : playlist) {
                pw.println(c.getArtista() + SEP + c.getTitulo() + SEP + c.getDuracion());
            }
        }
    }

    /**
     * Carga la lista de canciones desde el archivo indicado.
     *
     * @param ruta Ruta del archivo de entrada.
     * @return Lista de canciones reconstruidas.
     * @throws IOException Si no se puede leer el archivo.
     */
    public static List<Cancion> cargarPlaylist(String ruta) throws IOException {
        List<Cancion> playlist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(SEP, -1);
                if (partes.length >= 3) {
                    String artista  = partes[0].trim();
                    String titulo   = partes[1].trim();
                    int duracion    = Integer.parseInt(partes[2].trim());
                    playlist.add(new Cancion(artista, titulo, duracion));
                }
            }
        }
        return playlist;
    }
}