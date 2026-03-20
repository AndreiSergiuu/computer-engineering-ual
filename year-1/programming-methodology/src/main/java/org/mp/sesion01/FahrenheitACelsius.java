package org.mp.sesion01;

/**
 * Clase de utilidad para realizar conversiones de medidas de temperatura.
 * @author Andrei Sergiu Creata
 * @since 27-02-2026
 * @version 1.0
 */
public class FahrenheitACelsius {

	/**
	 * Convierte una temperatura dada en grados Fahrenheit a su equivalente en grados Celsius
	 * @param fahrenheit La temperatura en grados Fahrenheit que se desea convertir.
	 * @return La temperatura equivalente en grados Celsius
	 * @throws TemperaturaBajoCeroKelvinException Si la atemperatura ingresada es inferior
	 * al cero absoluto.
	 */
	public static float convertir(float fahrenheit) throws TemperaturaBajoCeroKelvinException {
		
		if (fahrenheit < -459.67f) {
			throw new TemperaturaBajoCeroKelvinException();
		}
		
		float celsius = (fahrenheit - 32.0f) * (5.0f/9.0f);
				
		return Math.round(celsius * 100.0f) / 100.0f;
		
	}
	
}
