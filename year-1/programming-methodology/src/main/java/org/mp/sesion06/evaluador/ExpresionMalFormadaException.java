package org.mp.sesion06.evaluador;

/**
 * Excepción lanzada cuando el evaluador detecta que una expresión
 * en notación postfija no es válida.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class ExpresionMalFormadaException extends Exception {

    /**
     * @param message Descripción del error detectado.
     */
    public ExpresionMalFormadaException(String message) {
        super(message);
    }
}