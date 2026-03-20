package org.mp.sesion01;

public class TemperaturaBajoCeroKelvinException extends Exception {
    public TemperaturaBajoCeroKelvinException() {
        super("¡La temperatura no puede estar por debajo de 0 K!");
    }
}