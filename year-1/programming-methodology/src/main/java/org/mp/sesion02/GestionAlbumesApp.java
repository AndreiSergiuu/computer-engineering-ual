package org.mp.sesion02;

/**
 * Clase principal de la aplicación. Se encarga de coordinar la lectura de
 * datos, el parseo de los mismos y la visualización de los álbumes resultantes.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class GestionAlbumesApp {

    public static void main(String[] args) {
        runApp(FuenteDeDatos.DATOS_ALBUMES);
    }

    /**
     * Procesa un array de cadenas con datos de álbumes, instancia los objetos
     * correspondientes y los muestra por la salida estándar. Los errores de formato
     * se notifican a través de la salida de error.
     *
     * @param datos Array de cadenas de texto, donde cada línea representa un álbum y sus canciones.
     */
    public static void runApp(String[] datos) {
        Album[] albumes = new Album[datos.length];
        int albumesValidos = 0;
        for (int i = 0; i < datos.length; i++) {
            try {
                Album album = AlbumParser.parse(datos[i]);
                albumes[albumesValidos] = album;
                albumesValidos++;
            } catch (MiParseadoException e) {
                System.err.println("Error procesando línea " + (i + 1) + ": " + e.getMessage());
            }
        }
        System.out.println("--- Álbumes cargados ---");
        for (int i = 0; i < albumesValidos; i++) {
            System.out.println(albumes[i].toString());
        }
    }
}