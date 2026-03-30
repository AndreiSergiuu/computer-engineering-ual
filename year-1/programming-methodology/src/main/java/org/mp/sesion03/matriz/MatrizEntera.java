package org.mp.sesion03.matriz;

/**
 * Implementación de la matriz genérica para el tipo Integer.
 * Proporciona la lógica específica para operar con números enteros.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class MatrizEntera extends MatrizGenerica<Integer> {

    /**
     * Constructor para crear una matriz de enteros con las dimensiones dadas.
     *
     * @param filas    Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     */
    public MatrizEntera(int filas, int columnas) {
        super(filas, columnas);
    }

    /**
     * Crea una nueva instancia de MatrizEntera.
     *
     * @param filas    Número de filas.
     * @param columnas Número de columnas.
     * @return Una nueva MatrizEntera con las dimensiones especificadas.
     */
    @Override
    protected MatrizGenerica<Integer> crearMatriz(int filas, int columnas) {
        return new MatrizEntera(filas, columnas);
    }

    /**
     * Suma dos números enteros.
     *
     * @param a Primer entero a sumar.
     * @param b Segundo entero a sumar.
     * @return El resultado de la suma (a + b).
     */
    @Override
    protected Integer sumarElementos(Integer a, Integer b) {
        return a + b;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param a Primer factor.
     * @param b Segundo factor.
     * @return El resultado del producto (a * b).
     */
    @Override
    protected Integer multiplicarElementos(Integer a, Integer b) {
        return a * b;
    }

    /**
     * Devuelve el elemento neutro para la suma de enteros.
     *
     * @return El valor 0.
     */
    @Override
    protected Integer ceroElemento() {
        return 0;
    }
}