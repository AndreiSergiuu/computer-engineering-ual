package org.mp.sesion01.listareproduccion;

import java.text.ParseException;

/**
 * Clase de utilidad para convertir cadenas de texto en objetos de tipo Cancion.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class CancionParser {

    /**
     * Procesa una cadena con formato CSV (separado por ;) para crear una canción.
     *
     * @param datosCancion Línea de texto con los datos de la canción.
     * @return Objeto Cancion con la información extraída.
     * @throws ParseException Si el formato es incorrecto o faltan datos obligatorios.
     */
    public static Cancion parse(String datosCancion) throws ParseException {

        String[] informacionSeparada = datosCancion.split(";");

        if (informacionSeparada.length < 5) {
            throw new ParseException("No se han introducido todos los datos necesarios", 0);
        }

        if (!informacionSeparada[0].equalsIgnoreCase("CANCION")) {
            throw new ParseException("Formato de cabecera inválido: se esperaba 'CANCION'", 0);
        }

        String titulo = informacionSeparada[1];
        String artista = informacionSeparada[2];

        if (!informacionSeparada[3].matches("\\d+")) {
            throw new ParseException("La duración debe ser un valor numérico entero", 3);
        }

        int duracion = Integer.parseInt(informacionSeparada[3]);
        String genero = informacionSeparada[4];

        return new Cancion(titulo, artista, duracion, genero);
    }
}