package org.mp.sesion02;

/**
 * Clase de utilidad encargada de procesar cadenas de texto para construir
 * objetos de tipo Album y sus Canciones.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class AlbumParser {

    /**
     * Procesa una cadena de texto y crea un objeto Album. El formato esperado es:
     *
     * @param datos La cadena de texto que contiene la información del álbum y sus
     *              canciones.
     * @return Un objeto Album instanciado y poblado con los datos de la cadena.
     * @throws MiParseadoException Si el formato general, el año o la duración de
     *                             las canciones son inválidos.
     */
    public static Album parse(String datos) throws MiParseadoException {
        String[] partes = datos.split(";");
        if (partes.length < 4 || !partes[0].trim().equals("ALBUM")) {
            throw new MiParseadoException("Formato de álbum inválido");
        }
        String tituloAlbum = partes[1].trim();
        String artista = partes[2].trim();
        int ano;
        try {
            ano = Integer.parseInt(partes[3].trim());
        } catch (NumberFormatException e) {
            throw new MiParseadoException("Año del álbum inválido: " + partes[3].trim(), e);
        }
        int maxCanciones = (partes.length - 4) / 3;
        Album album = new Album(tituloAlbum, artista, ano, maxCanciones);
        for (int i = 4; i < partes.length; i += 3) {
            if (!partes[i].trim().equals("CANCION")) {
                throw new MiParseadoException("Formato de canción inválido en el álbum: ");
            }
            if (i + 2 >= partes.length) {
                throw new MiParseadoException("Datos de canción incompletos");
            }
            String tituloCancion = partes[i + 1].trim();
            int duracion;
            try {
                duracion = Integer.parseInt(partes[i + 2].trim());
            } catch (NumberFormatException e) {
                throw new MiParseadoException("Duración de la canción inválida: " + partes[i + 2].trim(), e);
            }
            album.agregarCancion(new Cancion(tituloCancion, duracion));
        }
        return album;
    }
}