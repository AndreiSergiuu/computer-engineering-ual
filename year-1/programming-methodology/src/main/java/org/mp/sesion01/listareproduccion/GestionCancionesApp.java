package org.mp.sesion01.listareproduccion;

import java.text.ParseException;

/**
 * Aplicación principal para gestionar y probar la lista de reproducción.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class GestionCancionesApp {

    /**
     * Punto de entrada que carga, ordena y muestra las canciones de prueba.
     *
     * @param args Argumentos de la línea de comandos.
     * @throws ParseException Si ocurre un error al procesar la fuente de datos.
     */
    public static void main(String[] args) throws ParseException {

        ListaDeReproduccion misfavoritas = new ListaDeReproduccion("Favoritos", FuenteDeDatos.DATOS_CANCIONES.length);

        for (String cancion : FuenteDeDatos.DATOS_CANCIONES) {
            Cancion nuevaCancion = CancionParser.parse(cancion);
            misfavoritas.agregarCancion(nuevaCancion);
        }

        System.out.println("--- Lista Original ---");
        misfavoritas.mostrarCanciones();

        misfavoritas.ordenarCanciones();

        System.out.println("\n--- Lista Ordenada (Duración/Título) ---");
        misfavoritas.mostrarCanciones();
    }
}