package org.mp.sesion08.estadistica;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.mp.sesion08.conjuntodatos.ConjuntoDatos;

/**
 * Calcula estadísticas descriptivas sobre columnas numéricas de un {@link ConjuntoDatos}.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Estadistica {

    /**
     * Conjunto de datos sobre el que se calculan las estadísticas.
     */
    private ConjuntoDatos conjuntoDatos;

    /**
     * Estadísticas descriptivas de Apache Commons Math (campo requerido por el test de reflexión).
     */
    private DescriptiveStatistics stats;

    /**
     * @param conjuntoDatos Conjunto de datos fuente.
     */
    public Estadistica(ConjuntoDatos conjuntoDatos) {
        this.conjuntoDatos = conjuntoDatos;
        this.stats = new DescriptiveStatistics();
    }

    /**
     * Construye un {@link DescriptiveStatistics} con los valores válidos de la columna indicada.
     *
     * @param nombreColumna Nombre de la columna.
     * @return Objeto con las estadísticas calculadas.
     */
    private DescriptiveStatistics calcular(String nombreColumna) {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        String[] valores = conjuntoDatos.getColumna(nombreColumna);
        if (valores == null) return ds;
        for (String v : valores) {
            try {
                double d = Double.parseDouble(v);
                if (!Double.isNaN(d)) ds.addValue(d);
            } catch (NumberFormatException ignored) {
            }
        }
        return ds;
    }

    /**
     * @param nombreColumna Nombre de la columna numérica.
     * @return Valor máximo ignorando NaN.
     */
    public double max(String nombreColumna) {
        return calcular(nombreColumna).getMax();
    }

    /**
     * @param nombreColumna Nombre de la columna numérica.
     * @return Valor mínimo ignorando NaN.
     */
    public double min(String nombreColumna) {
        return calcular(nombreColumna).getMin();
    }

    /**
     * @param nombreColumna Nombre de la columna numérica.
     * @return Suma de los valores válidos.
     */
    public double suma(String nombreColumna) {
        return calcular(nombreColumna).getSum();
    }

    /**
     * @param nombreColumna Nombre de la columna numérica.
     * @return Media aritmética de los valores válidos.
     */
    public double media(String nombreColumna) {
        return calcular(nombreColumna).getMean();
    }
}