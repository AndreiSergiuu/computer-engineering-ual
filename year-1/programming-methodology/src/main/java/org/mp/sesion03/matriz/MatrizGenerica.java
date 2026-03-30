package org.mp.sesion03.matriz;

/**
 * Clase abstracta que define el comportamiento genérico de una matriz numérica.
 * Implementa las operaciones de suma, multiplicación y transposición.
 *
 * @param <T> Tipo de los elementos de la matriz, debe extender de Number.
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public abstract class MatrizGenerica<T extends Number> {

    protected T[][] matriz;
    protected int filas;
    protected int columnas;

    /**
     * Constructor para inicializar las dimensiones y el espacio de la matriz.
     *
     * @param filas    Número de filas.
     * @param columnas Número de columnas.
     * @throws IllegalArgumentException si las dimensiones son menores o iguales a cero.
     */
    @SuppressWarnings("unchecked")
    protected MatrizGenerica(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben ser positivas.");
        }
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = (T[][]) new Number[filas][columnas];
    }

    /**
     * Método abstracto para crear una nueva instancia de la matriz concreta.
     *
     * @param filas    Número de filas.
     * @param columnas Número de columnas.
     * @return Nueva instancia de MatrizGenerica.
     */
    protected abstract MatrizGenerica<T> crearMatriz(int filas, int columnas);

    /**
     * Método abstracto para sumar dos elementos de tipo T.
     *
     * @param a Primer sumando.
     * @param b Segundo sumando.
     * @return Resultado de la suma.
     */
    protected abstract T sumarElementos(T a, T b);

    /**
     * Método abstracto para multiplicar dos elementos de tipo T.
     *
     * @param a Primer factor.
     * @param b Segundo factor.
     * @return Resultado del producto.
     */
    protected abstract T multiplicarElementos(T a, T b);

    /**
     * Método abstracto que devuelve el valor cero del tipo T.
     *
     * @return El elemento neutro de la suma.
     */
    protected abstract T ceroElemento();

    /**
     * Establece el valor en una posición específica.
     *
     * @param fila    Índice de la fila.
     * @param columna Índice de la columna.
     * @param valor   Valor a insertar.
     * @throws IndexOutOfBoundsException si los índices están fuera de rango.
     */
    public void setValor(int fila, int columna, T valor) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Índices fuera de rango.");
        }
        this.matriz[fila][columna] = valor;
    }

    /**
     * Obtiene el array bidimensional que representa la matriz.
     *
     * @return El array de elementos.
     */
    public T[][] getMatriz() {
        return matriz;
    }

    /**
     * Suma esta matriz con otra matriz compatible.
     *
     * @param otra Matriz a sumar.
     * @return Matriz con el resultado de la suma.
     * @throws IllegalArgumentException si las dimensiones no coinciden o hay nulos.
     */
    public MatrizGenerica<T> sumar(MatrizGenerica<T> otra) {
        if (this.filas != otra.filas || this.columnas != otra.columnas) {
            throw new IllegalArgumentException("Las dimensiones no coinciden para la suma.");
        }

        MatrizGenerica<T> resultado = crearMatriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (this.matriz[i][j] == null || otra.matriz[i][j] == null) {
                    throw new IllegalArgumentException("No se pueden sumar elementos nulos.");
                }
                resultado.setValor(i, j, sumarElementos(this.matriz[i][j], otra.matriz[i][j]));
            }
        }
        return resultado;
    }

    /**
     * Multiplica esta matriz por otra.
     *
     * @param otra Matriz por la cual multiplicar.
     * @return Matriz con el resultado de la multiplicación.
     * @throws IllegalArgumentException si las dimensiones son incompatibles o hay nulos.
     */
    public MatrizGenerica<T> multiplicar(MatrizGenerica<T> otra) {
        if (this.columnas != otra.filas) {
            throw new IllegalArgumentException("Dimensiones incompatibles para la multiplicación.");
        }

        MatrizGenerica<T> resultado = crearMatriz(this.filas, otra.columnas);
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < otra.columnas; j++) {
                T acumulador = ceroElemento();
                for (int k = 0; k < this.columnas; k++) {
                    if (this.matriz[i][k] == null || otra.matriz[k][j] == null) {
                        throw new IllegalArgumentException("No se pueden multiplicar elementos nulos.");
                    }
                    T producto = multiplicarElementos(this.matriz[i][k], otra.matriz[k][j]);
                    acumulador = sumarElementos(acumulador, producto);
                }
                resultado.setValor(i, j, acumulador);
            }
        }
        return resultado;
    }

    /**
     * Transpone la matriz actual intercambiando filas por columnas.
     *
     * @return Matriz transpuesta.
     */
    public MatrizGenerica<T> transponer() {
        MatrizGenerica<T> resultado = crearMatriz(columnas, filas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.setValor(j, i, this.matriz[i][j]);
            }
        }
        return resultado;
    }

    /**
     * Devuelve una representación textual de la matriz.
     *
     * @return String con la matriz formateada.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(matriz[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}