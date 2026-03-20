package org.mp.sesion01;


/**
 * * Clase de utilidad que proporciona métodos para operar con números enteros.
 * @author Andrei Sergiu Creata
 * @since 27-02-2026
 * @version 1.0
 */
public class Mayor {
	 
	/**
	 * Encuentra y devuleve el valor máximo dentro de un array de números enteros.
	 * @param a Array que se va a evaluar.
	 * @return El número entero con el valor máximo encontrado en el array.
	 * @throws RuntimeException Si el array proporcionado es nulo o tiene una longitud de cerp.
	 */
	public static int elEnteroMayor(int[] a) {
	
		if(a == null || a.length == 0) {
			throw new RuntimeException("Array vacio");
		}
		
		int max = a[0];
		
		for(int num : a) {
			max = Math.max(max, num);
		}
		
		return max;
		
	}
}