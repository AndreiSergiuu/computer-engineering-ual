package org.mp.sesion09.mp3.dao;

import org.mp.sesion09.mp3.Album;
import org.mp.sesion09.mp3.Artista;
import org.mp.sesion09.mp3.Biblioteca;
import org.mp.sesion09.mp3.Cancion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Implementación de {@link BibliotecaDAO} que persiste la biblioteca
 * en formato JSON sin dependencias externas.
 *
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 * @see BibliotecaDAO
 * @see BibliotecaXMLDAO
 */
public class BibliotecaJSONDAO implements BibliotecaDAO {

    // -------------------------------------------------------------------------
    // ESCRITURA
    // -------------------------------------------------------------------------

    /**
     * Serializa la {@link Biblioteca} en un archivo JSON con
     * indentación de 2 espacios.
     *
     * @param biblioteca objeto a persistir.
     * @param ruta       ruta del archivo de destino.
     * @throws IOException si no se puede crear o escribir el archivo.
     */
    @Override
    public void guardar(Biblioteca biblioteca, String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("{\n");
            bw.write("  \"artistas\": [\n");

            List<Artista> artistas = biblioteca.getArtistas();
            for (int a = 0; a < artistas.size(); a++) {
                Artista artista = artistas.get(a);
                bw.write("    {\n");
                bw.write("      \"nombre\": " + jsonString(artista.getNombre()) + ",\n");
                bw.write("      \"albums\": [\n");

                List<Album> albums = artista.getAlbums();
                for (int al = 0; al < albums.size(); al++) {
                    Album album = albums.get(al);
                    bw.write("        {\n");
                    bw.write("          \"titulo\": " + jsonString(album.getTitulo()) + ",\n");
                    bw.write("          \"canciones\": [\n");

                    List<Cancion> canciones = album.getCanciones();
                    for (int s = 0; s < canciones.size(); s++) {
                        Cancion c = canciones.get(s);
                        bw.write("            {\n");
                        bw.write("              \"titulo\":      " + jsonString(c.getTitulo())       + ",\n");
                        bw.write("              \"artista\":     " + jsonString(c.getArtista())      + ",\n");
                        bw.write("              \"album\":       " + jsonString(c.getAlbum())        + ",\n");
                        bw.write("              \"anio\":        " + jsonString(c.getAnio())         + ",\n");
                        bw.write("              \"rutaArchivo\": " + jsonString(c.getRutaArchivo())  + "\n");
                        bw.write("            }" + (s < canciones.size() - 1 ? "," : "") + "\n");
                    }

                    bw.write("          ]\n");
                    bw.write("        }" + (al < albums.size() - 1 ? "," : "") + "\n");
                }

                bw.write("      ]\n");
                bw.write("    }" + (a < artistas.size() - 1 ? "," : "") + "\n");
            }

            bw.write("  ]\n");
            bw.write("}\n");
        }
    }

    // -------------------------------------------------------------------------
    // LECTURA
    // -------------------------------------------------------------------------

    /**
     * Deserializa una {@link Biblioteca} desde un archivo JSON generado
     * por {@link #guardar}.
     *
     * <p>El parser avanza por el contenido extrayendo valores de cadena
     * mediante {@link #leerValorString}. Asume el formato exacto producido
     * por este DAO (campos en orden fijo).</p>
     *
     * @param ruta ruta del archivo JSON a leer.
     * @return biblioteca reconstruida.
     * @throws IOException si el archivo no existe o no puede leerse.
     */
    @Override
    public Biblioteca cargar(String ruta) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append('\n');
            }
        }

        Biblioteca biblioteca = new Biblioteca();
        String json = sb.toString();
        int[] pos = {0};

        // Avanzar hasta el array "artistas"
        avanzarHasta(json, pos, "\"artistas\"");

        while (true) {
            // ¿Hay otro objeto artista?
            int nextBrace  = json.indexOf('{', pos[0]);
            int closingArr = json.indexOf(']', pos[0]);
            if (nextBrace < 0 || closingArr < nextBrace) break;
            pos[0] = nextBrace + 1;

            String nombreArtista = leerValorString(json, pos, "\"nombre\"");

            // Albums de este artista
            avanzarHasta(json, pos, "\"albums\"");

            while (true) {
                int nextAlbumBrace  = json.indexOf('{', pos[0]);
                int closingAlbumArr = json.indexOf(']', pos[0]);
                if (nextAlbumBrace < 0 || closingAlbumArr < nextAlbumBrace) break;
                pos[0] = nextAlbumBrace + 1;

                String tituloAlbum = leerValorString(json, pos, "\"titulo\"");

                // Canciones de este álbum
                avanzarHasta(json, pos, "\"canciones\"");

                while (true) {
                    int nextSongBrace  = json.indexOf('{', pos[0]);
                    int closingSongArr = json.indexOf(']', pos[0]);
                    if (nextSongBrace < 0 || closingSongArr < nextSongBrace) break;
                    pos[0] = nextSongBrace + 1;

                    String titulo      = leerValorString(json, pos, "\"titulo\"");
                    String artista     = leerValorString(json, pos, "\"artista\"");
                    String album       = leerValorString(json, pos, "\"album\"");
                    String anio        = leerValorString(json, pos, "\"anio\"");
                    String rutaArchivo = leerValorString(json, pos, "\"rutaArchivo\"");

                    biblioteca.anadirCancion(new Cancion(titulo, artista, album, anio, rutaArchivo));
                }
            }
        }

        return biblioteca;
    }

    // -------------------------------------------------------------------------
    // UTILIDADES PRIVADAS
    // -------------------------------------------------------------------------

    /**
     * Envuelve un valor en comillas dobles y escapa las comillas internas.
     *
     * @param valor texto a serializar como cadena JSON.
     * @return representación JSON de la cadena, p. ej. {@code "Bohemian Rhapsody"}.
     */
    private static String jsonString(String valor) {
        if (valor == null) return "\"\"";
        return "\"" + valor.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    /**
     * Avanza el índice {@code pos[0]} hasta encontrar la clave dada,
     * dejando el índice justo después de ella.
     *
     * @param json  texto JSON completo.
     * @param pos   array de un elemento usado como puntero mutable.
     * @param clave cadena a buscar (con comillas, p. ej. {@code "\"titulo\""}).
     */
    private static void avanzarHasta(String json, int[] pos, String clave) {
        int idx = json.indexOf(clave, pos[0]);
        if (idx >= 0) {
            pos[0] = idx + clave.length();
        }
    }

    /**
     * Lee el valor de cadena JSON asociado a la primera ocurrencia de
     * {@code clave} a partir de {@code pos[0]}, actualizando el puntero.
     *
     * <p>Asume el formato {@code "clave": "valor"} generado por este DAO.</p>
     *
     * @param json  texto JSON completo.
     * @param pos   puntero mutable de lectura.
     * @param clave nombre del campo JSON (con comillas).
     * @return valor decodificado de la cadena, o {@code ""} si no se encuentra.
     */
    private static String leerValorString(String json, int[] pos, String clave) {
        int keyIdx = json.indexOf(clave, pos[0]);
        if (keyIdx < 0) return "";

        // Localizar la apertura de comillas del valor
        int openQuote = json.indexOf('"', keyIdx + clave.length() + 1);
        if (openQuote < 0) return "";

        // Localizar el cierre de comillas (respetando escapes)
        int closeQuote = openQuote + 1;
        while (closeQuote < json.length()) {
            char ch = json.charAt(closeQuote);
            if (ch == '\\') {
                closeQuote += 2; // saltar carácter escapado
            } else if (ch == '"') {
                break;
            } else {
                closeQuote++;
            }
        }

        pos[0] = closeQuote + 1;
        String raw = json.substring(openQuote + 1, closeQuote);
        return raw.replace("\\\"", "\"").replace("\\\\", "\\");
    }
}