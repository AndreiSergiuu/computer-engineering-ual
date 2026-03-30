package org.mp.sesion03.matriz;

/**
 * Implementación de la matriz genérica para el tipo Double.
 * Proporciona la lógica específica para operar con números reales.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class MatrizDouble extends MatrizGenerica<Double> {

    /**
     * Constructor para crear una matriz de dobles con las dimensiones dadas.
     *
     * @param filas    Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     */
    public MatrizDouble(int filas, int columnas) {
        super(filas, columnas);
    }

    /**
     * Crea una nueva instancia de MatrizDouble.
     *
     * @param filas    Número de filas de la nueva matriz.
     * @param columnas Número de columnas de la nueva matriz.
     * @return Una nueva instancia de MatrizDouble con las dimensiones especificadas.
     */
    @Override
    protected MatrizGenerica<Double> crearMatriz(int filas, int columnas) {
        return new MatrizDouble(filas, columnas);
    }

    /**
     * Suma dos números de tipo Double.
     *
     * @param a Primer número real a sumar.
     * @param b Segundo número real a sumar.
     * @return El resultado de la suma (a + b).
     */
    @Override
    protected Double sumarElementos(Double a, Double b) {
        return a + b;
    }

    /**
     * Multiplica dos números de tipo Double.
     *
     * @param a Primer factor real.
     * @param b Segundo factor real.
     * @return El resultado del producto (a * b).
     */
    @Override
    protected Double multiplicarElementos(Double a, Double b) {
        return a * b;
    }

    /**
     * Devuelve el elemento neutro para la suma de números reales.
     *
     * @return El valor 0.0.
     */
    @Override
    protected Double ceroElemento() {
        return 0.0;
    }
}