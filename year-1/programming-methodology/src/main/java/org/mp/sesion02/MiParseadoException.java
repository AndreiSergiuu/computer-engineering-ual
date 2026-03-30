package org.mp.sesion02;

/**
 * Excepción personalizada para indicar errores durante el proceso de parseo de
 * datos de álbumes y canciones.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class MiParseadoException extends Exception {

    /**
     * Crea una nueva excepción con un mensaje de detalle.
     *
     * @param message El mensaje que describe el error de parseo.
     */
    public MiParseadoException(String message) {
        super(message);
    }

    /**
     * Crea una nueva excepción con un mensaje de detalle y la causa raíz.
     *
     * @param message El mensaje que describe el error de parseo.
     * @param cause   La causa original que provocó este error.
     */
    public MiParseadoException(String message, Throwable cause) {
        super(message, cause);
    }
}