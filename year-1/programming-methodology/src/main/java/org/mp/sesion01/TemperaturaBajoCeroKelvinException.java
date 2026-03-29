package org.mp.sesion01;

/**
 * Excepción para gestionar errores relacionados con temperaturas que se encuentran
 * por debajo del cero absoluto (0 Kelvin).
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 29-03-2026
 */
public class TemperaturaBajoCeroKelvinException extends Exception {
    /**
     * Crea una excepción con el mensaje predefinido indicando
     * que la temperatura es inferior a 0 Kelvin.
     */
    public TemperaturaBajoCeroKelvinException() {
        super("¡La temperatura no puede estar por debajo de 0 K!");
    }
}